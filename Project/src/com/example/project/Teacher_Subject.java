package com.example.project;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.project.ConnectServer;
import com.example.project.OnResponseListener;
import com.example.project.Adapter;
import com.example.project.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Teacher_Subject extends Activity implements OnResponseListener {

	private TextView textView, textView1, textView2;
	private Button buttonSubject, buttonSearch, buttonProfile;
	private ListView listView;

	private SimpleAdapter arrayAdapter;
	private ConnectServer connectServer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subject_subject_list);

		textView = (TextView) findViewById(R.id.textSubject);
		textView1 = (TextView) findViewById(R.id.text_sub_list);

		buttonSubject = (Button) findViewById(R.id.t_pro_subject_tab);
		buttonSearch = (Button) findViewById(R.id.t_pro_search_tab);
		buttonProfile = (Button) findViewById(R.id.t_pro_profile_tab);

		listView = (ListView) findViewById(R.id.listviewsubject);

		// 拭橐У亚嗒阻土佃汀押 Server 浠氛�URL 氛琛铀勾
		connectServer = new ConnectServer(this,
				"http://10.0.2.2/get_jsontest.php", this);

		// 嗒阻土佃汀押 Server
		connectServer.execute();

		listView.setOnItemClickListener(new OnItemClickListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				HashMap<String, String> object = (HashMap<String, String>) adapter
						.getItemAtPosition(position);
				Intent intent = new Intent(Teacher_Subject.this, Week.class);

				intent.putExtra("sub", object.get("sub"));

				startActivity(intent);
			}

		});

		buttonSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(Teacher_Subject.this,
						Teacher_Search.class);
				startActivity(intent);
			}
		});

		buttonProfile.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(Teacher_Subject.this,
						TeacherProfile.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onResponse(ArrayList<HashMap<String, String>> list) {

		String[] from = { "sub" };
		int[] to = { R.id.textSublist_item };

		arrayAdapter = new SimpleAdapter(this, list,
				R.layout.subject_list_item, from, to);
		listView.setAdapter(arrayAdapter);

	}

}
