package com.animeandmangalabs.quiz_engine;

import android.provider.BaseColumns;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public class quiz_sql_data_base_test {

    public quiz_sql_data_base_test(){}


    public static abstract  class  FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = " ,";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + " INTEGER PRIMARY KEY," + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry._ID + " INTEGER PRIMARY KEY," +
                        FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                        //Anny other options for the CREATE command
                        " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }
}
