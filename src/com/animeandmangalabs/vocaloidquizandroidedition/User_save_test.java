package com.animeandmangalabs.vocaloidquizandroidedition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent.*;
import android.content.*;
import android.preference.*;
import android.content.SharedPreferences.*;
public class User_save_test extends Activity {

	public static EditText p_name_input;
	public static Button btn_submit;
	public static String p_name;
	public static TextView user_name;
	public static String sInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_save_test);
		btn_submit = (Button) findViewById(R.id.user_save_submit_btn);
		p_name_input = (EditText) findViewById(R.id.user_save_text_input);
		user_name = (TextView) findViewById(R.id.user_save_label);
		restoreUserSession();
		btn_submit.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				p_name = p_name_input.getText().toString();
				saveUserSession();
			}
		});
	}


	public void saveUserSession(){
		p_name = p_name_input.getText().toString();
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sp.edit();
		editor.putString("name",p_name);
		editor.commit();
		restoreUserSession();
	}
	
	public void restoreUserSession(){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		String user_name_string = sp.getString("name", "NULL");
		user_name.setText(user_name_string);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_save_test, menu);
		return true;
	}
			
	
}
