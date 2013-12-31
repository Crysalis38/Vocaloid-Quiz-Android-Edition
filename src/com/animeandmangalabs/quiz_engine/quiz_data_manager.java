package com.animeandmangalabs.quiz_engine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class quiz_data_manager extends Activity{
	
	
	public static void loadPrefs(String key,Context context){
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		String string_result = sp.getString(key, "NULL");
		
		
	}
	
	public static void savePrefs(String key,String value,Context context){
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
			Editor edit = sp.edit();
			edit.putString(key, value);
			edit.commit();
	}
	
	public static void savePrefs(String key,int value,Context context){
			
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
			Editor edit = sp.edit();
			edit.putInt(key, value);
			edit.commit();
	}
	
public static void savePrefs(String key,boolean value,Context context){
	
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
			Editor edit = sp.edit();
			edit.putBoolean(key, value);
			edit.commit();
}
}
