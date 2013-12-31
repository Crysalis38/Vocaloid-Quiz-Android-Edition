package com.animeandmangalabs.quiz_engine;

import android.content.Context;
import android.content.SharedPreferences;

public class quiz_data_manager {

	public static String PREFS_NAME = "com.animeandmangalabs.vocaloid-quiz.settings";

	public void getString(quiz_question_engine p0, String qnumPREF, String p2)
	{
		// TODO: Implement this method
	}

	public static void putString(Context ctx, String key, String value) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getString(Context ctx, String key, String defaultValue) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(key, defaultValue);
	}

	public static void putInt(Context ctx, String key, int value) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static int getInt(Context ctx, String key, int defaultValue) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getInt(key, defaultValue);
	}

	public static void putBoolean(Context ctx, String key, boolean value) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean getBoolean(Context ctx, String key,
									 boolean defaultValue) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getBoolean(key, defaultValue);
	}

}
