package com.animeandmangalabs.quiz_engine;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
public class quiz_sql_data_handler extends SQLiteOpenHelper
{

	//All Static's
	//Database Version
	private static  int DATABASE_VERSION = 1;
	
	//Databae Name
	private static final String DATABASE_NAME = "VocaloidQuiz"
	
	//Names Table
	private static final String TABLE_NAMES = "names";
	
	//Names collumns
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	//Table creation
	@Override
	public void onCreate(SQLiteDatabase db) {
	String CREATE_NAMES_TABLE = "CREATE TABLE " + " ("
		+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
		+ " )";
		db.execSQL(CREATE_NAMES_TABLE);
		
		}
		
		//Upgrading Database
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//Drop older table if existed
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMES);
			
			//Create tables again
			onCreate(db);
			
		}
		
		//Adding new name
		public void Add_Name(Stringname) {
			SQLiteDatabase db = this.getWritableDatabase();
			
		}
    
