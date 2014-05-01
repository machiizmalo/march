package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	private RelativeLayout Relat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Relat = (RelativeLayout) findViewById(R.id.Relative);
		
		Relat.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				  Intent intent = new Intent(MainActivity.this, Login.class);
				    startActivity(intent);
			}
		});
	}

}
