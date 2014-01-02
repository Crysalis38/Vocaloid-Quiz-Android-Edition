package com.animeandmangalabs.quiz_engine;

import android.provider.BaseColumns;

/**
 * Created by jeroenmathon on 1/2/14.
 */
public final class FeedReaderContract {
    public FeedReaderContract() {}

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENRT_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
    }
}
