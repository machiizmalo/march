package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class ConnectServer extends AsyncTask<String, Integer, String> {
	private HttpPost httppost;
	private HttpClient httpclient;
	private List<NameValuePair> nameValuePairs;
	private ProgressDialog dialogConnect;
	private Context context;

	private OnResponseListener onResponseListener;

	ConnectServer(Context context, String URL,
			OnResponseListener onResponseListener) {
		this.context = context;
		this.onResponseListener = onResponseListener;

		// สร้างส่วนประกอบที่จำเป็นในการเชื่อมกับ Server
		this.httpclient = new DefaultHttpClient();
		this.httppost = new HttpPost(URL);
		this.nameValuePairs = new ArrayList<NameValuePair>();

		// สร้าง Dialog ตอนเชื่อมต่อกับ Server
		// มีการส่ง ConnectServer ให้กับ Dialog เพื่อใช้ในการยกเลิก
		dialogConnect = new ProgressDialog(this.context);
		dialogConnect.setTitle(this.context.getString(R.string.app_name));
		dialogConnect.setMessage("กรุณารอสักครู่");
	}

	// Function สำหรับเพิ่มตัวแปรในการส่งค่าแบบ Post
	public void addValue(String key, String value) {
		nameValuePairs.add(new BasicNameValuePair(key, value));
	}

	// ก่อนที่จะทำ doInBackground จะทำงานที่ Function นี้ก่อน
	protected void onPreExecute() {
		dialogConnect.show();
	}

	// เริ่มทำงานแบบ Background
	protected String doInBackground(String... params) {
		InputStream is = null;
		String result = null;

		// เริ่มการเชื่อมต่กับ Server
		try {
			// ทำการส่งตัวแปรต่างๆ ในรูปแบบของ UTF-8
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,
					HTTP.UTF_8));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

			// อ่านผลลัพธ์ในรูปแบบของ UTF-8
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			is.close();
			result = sb.toString();

			// ถ้าขณะเชื่อมต่อกับ Server มีปัญหา จะแสดง Log Error
		} catch (ClientProtocolException e) {
			Log.e("ConnectServer", e.toString());
		} catch (IOException e) {
			Log.e("ConnectServer", e.toString());
		}

		return result;
	}

	// ถ้าทำงานที่ doInBackground เสร็จแล้ว จะมาทำงานที่ Function นี้
	@SuppressWarnings("unchecked")
	protected void onPostExecute(String result) {

		// list ที่ใช้เก็บข้อมูล3333
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		// ถ้า result เป็น null คือ ไม่สามารถเชื่อมต่อกับ server ได้
		// ถ้าเชื่อมต่กับ server ได้ จะทำงานต่อไปนี้
		if (result != null) {
			// เริ่มการแปลง JSON เป็นข้อมูล
			try {

				JSONArray jsonArray = new JSONArray(result);

				// looping through All Contacts
				for (int i = 0; i < jsonArray.length(); i++) {
					// á»Å§¼ÅÅÑ¾¸ì·Õèä´éÁÒà»ç¹ JSON Object
					JSONObject c = jsonArray.getJSONObject(i);
					HashMap<String, String> contact = new HashMap<String, String>();

					Iterator<String> keys = c.keys();
					while (keys.hasNext()) {
						String key = keys.next();
						contact.put(key, c.getString(key));
					}

					list.add(contact);
				}
				// ถ้าขณะแปลงข้อมูล JSON มีปัญหาจะมาทำงานส่วนนี้
			} catch (JSONException e) {

			}

			// ถ้าเชื่อมต่อกับ server ไม่ได้จะทำงานต่อไปนี้
		} else {

		}

		dialogConnect.dismiss();
		onResponseListener.onResponse(list);
		
	}
	

}