package com.animeandmangalabs.quiz_engine;

import android.provider.BaseColumns;

import static java.security.AccessController.getContext;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public final class FeedReaderContract {
    public FeedReaderContract() {}

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = " ,";
        private static final String SQL_CREATE_ENTRIES =
        "CREATE_TABLE "  + FeedEntry.TABLE_NAME + " (" +
                FeedEntry._ID + " INTEGER PRIMARY KEY," +
                FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                // Any other options for the CREATE command
                " )";

        private  static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }
}

