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

public class ParentRegis extends Activity {
	
	private TextView textView;
	private Button buttonCancelP,buttonSubmit;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p_regis);
		
		context = this;
		
		textView = (TextView) findViewById(R.id.textRegis);
		buttonCancelP = (Button) findViewById(R.id.cancel_regis_parent);
		buttonSubmit = (Button) findViewById(R.id.submit_regis_parent);
		
		buttonCancelP.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(ParentRegis.this, PageRegis.class);
				    startActivity(intent);
			}
		});
		
		buttonSubmit.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(ParentRegis.this, Login.class);
				    startActivity(intent);
				    Toast.makeText(context, "Successful!", Toast.LENGTH_LONG).show();
			}
		});
	}
	
	
}
