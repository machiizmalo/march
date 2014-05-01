package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TeacherProfile extends Activity {
	
	private TextView textView;
	private Button buttonLogout,buttonSubject,buttonSearch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.t_profile);
		
		textView = (TextView) findViewById(R.id.textt_pro);
		buttonLogout = (Button) findViewById(R.id.teacher_log_out);
		buttonSubject = (Button) findViewById(R.id.t_pro_subject_tab);
		buttonSearch = (Button) findViewById(R.id.t_pro_search_tab);
		
		buttonLogout.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(TeacherProfile.this, Login.class);
				    startActivity(intent);
			}
		});
		
		buttonSubject.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(TeacherProfile.this, Teacher_Subject.class);
				    startActivity(intent);
			}
		});
		
		buttonSearch.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(TeacherProfile.this, Teacher_Search.class);
				    startActivity(intent);
			}
		});
	}
	
	
}
