package com.example.project;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.project.DataStudent;
import com.example.project.Week;
import com.example.project.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Week extends Activity /* implements OnResponseListener */{

	private TextView textView, textView1, textView2;
	private Button buttonSubject, buttonSearch, buttonProfile;
	private ListView listView;

	// private SimpleAdapter arrayAdapter;
	// private ConnectServer connectServer;

	public String[] week = { "Week 1", "Week 2", "Week 3", "Week 4", "Week 5" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.week_list);

		Bundle extras = getIntent().getExtras();
		final String sub = extras.getString("sub");

		textView = (TextView) findViewById(R.id.textWeek);
		// textView1 = (TextView) findViewById(R.id.text_week_list);

		buttonSubject = (Button) findViewById(R.id.t_pro_subject_tab);
		buttonSearch = (Button) findViewById(R.id.t_pro_search_tab);
		buttonProfile = (Button) findViewById(R.id.t_pro_profile_tab);

		listView = (ListView) findViewById(R.id.listviewweek);

		textView.setText(sub);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.week_list_item, week);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			// @SuppressWarnings("unchecked")
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				Intent intent = new Intent(Week.this, DataStudent.class);

				intent.putExtra("week", "week" + (position + 1));
				intent.putExtra("sub", sub);

				startActivity(intent);

			}

		});

		buttonSubject.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(Week.this, Teacher_Subject.class);
				startActivity(intent);
			}
		});

		buttonSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(Week.this, Teacher_Search.class);
				startActivity(intent);
			}
		});

		buttonProfile.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(Week.this, TeacherProfile.class);
				startActivity(intent);
			}
		});
	}

}
