package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity{
	
	private EditText editText2,editText3;
	private TextView textView,textView1,textView2;
	private Button buttonRegis,buttonLogin;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);

		textView = (TextView) findViewById(R.id.textView);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		
		buttonRegis = (Button) findViewById(R.id.button1);
		buttonLogin = (Button) findViewById(R.id.button2);
		
		
		buttonRegis.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(Login.this, PageRegis.class);
				    startActivity(intent);
			}
		});
		
		buttonLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(Login.this, TeacherProfile.class);
				    startActivity(intent);
			}
		});
	}

	
}
