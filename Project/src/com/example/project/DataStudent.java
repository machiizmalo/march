package com.example.project;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.project.OnResponseListener;
import com.example.project.ConnectServer;
import com.example.project.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DataStudent extends Activity implements OnResponseListener {

	private TextView textView, textView1, textView2;
	private Button buttonSubject, buttonSearch, buttonProfile;
	private ListView listView;

	private SimpleAdapter arrayAdapter;
	private ConnectServer connectServer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_list);

		Bundle extras = getIntent().getExtras();
		String week = extras.getString("week");
		String sub = extras.getString("sub");

		// textView = (TextView) findViewById(R.id.textData);
		// textView1 = (TextView) findViewById(R.id.text_data_list);

		buttonSubject = (Button) findViewById(R.id.t_pro_subject_tab);
		buttonSearch = (Button) findViewById(R.id.t_pro_search_tab);
		buttonProfile = (Button) findViewById(R.id.t_pro_profile_tab);

		listView = (ListView) findViewById(R.id.listviewData);

		// 拭橐У亚嗒阻土佃汀押 Server 浠氛�URL 氛琛铀勾
		connectServer = new ConnectServer(this, "http://10.0.2.2/jsontest.php",
				this);
		connectServer.addValue("week", week);
		connectServer.addValue("sub", sub);
		// 嗒阻土佃汀押 Server
		connectServer.execute();

		buttonSubject.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(DataStudent.this,
						Teacher_Subject.class);
				startActivity(intent);
			}
		});

		buttonSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(DataStudent.this,
						Teacher_Search.class);
				startActivity(intent);
			}
		});

		buttonProfile.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(DataStudent.this,
						TeacherProfile.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onResponse(ArrayList<HashMap<String, String>> list) {

		String[] from = { "id", "name", "score", "midterm", "final" };
		int[] to = { R.id.textID, R.id.textName, R.id.textScore, R.id.textMid,
				R.id.textFinal };

		arrayAdapter = new SimpleAdapter(this, list, R.layout.data_list_item,
				from, to);
		listView.setAdapter(arrayAdapter);

	}
}
