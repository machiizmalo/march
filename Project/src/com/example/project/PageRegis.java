package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PageRegis extends Activity {
	
	private TextView textView;
	private Button buttonParent,buttonStudent;
	private ImageView imageBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regis);
		
		textView = (TextView) findViewById(R.id.textRegis);
		buttonParent = (Button) findViewById(R.id.button_parent_regis);
		buttonStudent = (Button) findViewById(R.id.button_student_regis);
		imageBack = (ImageView) findViewById(R.id.imBack);
		
		buttonParent.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(PageRegis.this, ParentRegis.class);
				    startActivity(intent);
			}
		});
		
		buttonStudent.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(PageRegis.this, StudentRegis.class);
				    startActivity(intent);
			}
		});
		
		imageBack.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(PageRegis.this, Login.class);
				    startActivity(intent);
			}
		});
	}
	
	
}
