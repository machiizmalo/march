package com.example.project;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<JSONObject>
{
	
	private int resource;

	@Override
	public JSONObject getItem(int position) {
		return super.getItem(position);
	}

	public Adapter(Context context, int resource, JSONArray array) 
	{
		super(context, resource, new ArrayList<JSONObject>());
		// TODO Auto-generated constructor stub
		
		this.resource = resource;
		
		int length = array.length();
		for (int i = 0; i < length; i++)
		{
			JSONObject obj = array.optJSONObject(i);
			add(obj);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		View v = convertView;
		if(v == null)
			v = LayoutInflater.from(getContext()).inflate(resource, parent, false);
		
		JSONObject object = getItem(position);
		String sub = object.optString("SUB");
//		String name = object.optString("NAME");
//		float score = (float) object.optDouble("SCORE");
//		float midterm_score = (float) object.optDouble("MIDTERM");
//		float final_score = (float) object.optDouble("FINAL");
//
		TextView tv1 = (TextView)v.findViewById(R.id.textSublist_item);
//		TextView tv2 = (TextView)v.findViewById(R.id.textView2);
//		TextView tv3 = (TextView)v.findViewById(R.id.textView3);
//		TextView tv4 = (TextView)v.findViewById(R.id.textView4);
//		TextView tv5 = (TextView)v.findViewById(R.id.textView5);
//
		tv1.setText(sub);
//		tv2.setText("Name: "+name);
//		tv3.setText("Score: "+score);
//		tv4.setText("Midterm: "+midterm_score);
//		tv5.setText("Final: "+final_score);
		
		return v;
	}

}
