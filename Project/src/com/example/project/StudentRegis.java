package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StudentRegis extends Activity {
	
	private TextView textView;
	private Button buttonCancelS,buttonSubmit;
	private Context context;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.s_regis);
		
		context = this;
		
		textView = (TextView) findViewById(R.id.textRegis);
		buttonCancelS = (Button) findViewById(R.id.cancel_regis_student);
		buttonSubmit = (Button) findViewById(R.id.submit_regis_student);
		
		buttonCancelS.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(StudentRegis.this, PageRegis.class);
				    startActivity(intent);
			}
		});
		
		buttonSubmit.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(StudentRegis.this, Login.class);
				    startActivity(intent);
				    Toast.makeText(context, "Successful!", Toast.LENGTH_LONG).show();
			}
		});
	}
	
	
}
