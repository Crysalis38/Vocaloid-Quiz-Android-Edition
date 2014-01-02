package com.animeandmangalabs.quiz_engine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public class quiz_data_base_helper extends SQLiteOpenHelper {

    quiz_data_base_helper quizDbHelper
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "VocaloidQuiz.db";

    public quiz_data_base_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteOpenHelper db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
