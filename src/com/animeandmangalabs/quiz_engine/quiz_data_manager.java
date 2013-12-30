package com.animeandmangalabs.quiz_engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class quiz_data_manager {
	public static String string_01;
	
	public static void loadPrefs(String key,Context context){
	
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		string_01 = sp.getString(key, "ERROR NO DATA");
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
