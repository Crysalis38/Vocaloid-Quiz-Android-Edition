package com.animeandmangalabs.data_base_test;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public class database_storage extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DICTIONARY_TABLE_NAME = "test";
    private static final String DICTIONARY_TABLE_CREATE =
                "CREATE TABLE " + DICITONARY_TABLE_NAME + " (" +
                        KEY_WORD + " TEXT," +
                        KEY_DEFINITION + " TEXT);";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
