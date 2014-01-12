package com.lhy.douban.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private static final String TAG = "DbHelper";

	private static final String DB_NAME = "demo.db";
	private static final int DB_VERSION = 1;

	static final String TABLE_DDL_TEMPLATE = " CREATE TABLE IF NOT EXISTS %s ( %s ) ";

	// images表
	public static final String TABLE_IMAGE = " images ";
	/**
	 * id是用来对应subject的
	 */
	static final String TABLE_IAMGE_COLUMN = "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "id INTEGER UNIQUE,small text,large text,medium text ";
	// rating表
	public static final String TABLE_RATING = " rating ";
	static final String TABLE_RATING_COLUMN = "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "id INTEGER,max INTEGER, "
			+ "average TEXT,stars TEXT,min INTEGER ";
	// subject表
	public static final String TABLE_SUBJECT = " subject ";
	static final String TABLE_SUBJECT_COLUMN = "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "id INTEGER, title TEXT,mainland_pubdate TEXT,collect_count INTEGER,original_title TEXT, "
			+ "subtype TEXT,year TEXT,pubdates TEXT, alt TEXT";

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String image_ddl = String.format(TABLE_DDL_TEMPLATE, TABLE_IMAGE,
				TABLE_IAMGE_COLUMN);
		String rating_ddl = String.format(TABLE_DDL_TEMPLATE, TABLE_RATING,
				TABLE_RATING_COLUMN);
		String subject_ddl = String.format(TABLE_DDL_TEMPLATE, TABLE_SUBJECT,
				TABLE_SUBJECT_COLUMN);
		Log.d(TAG, "image_ddl:" + image_ddl + "\r\nrating_ddl:" + rating_ddl
				+ "\r\nsubject_ddl" + subject_ddl);
		db.execSQL(image_ddl);
		db.execSQL(rating_ddl);
		db.execSQL(subject_ddl);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}


}
