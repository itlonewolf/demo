package com.lhy.douban.utils;

public class DBUtils {
	public static final String DB_NAME  = "douban.db" ;
	
	public static final int DB_VERSION = 1;
	public static final String TABLE_DDL_TEMPLATE = "CREATE TABLE IF NOT EXISTS s% ( s% )" ;
	
	
	/*
	 * "CREATE TABLE IF NOT EXISTS "
			+ NEWS_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ " image_source TEXT, " + "title TEXT, " + "url TEXT, "
			+ "image TEXT, " + "share_url TEXT, " + "thumbnail TEXT, "
			+ "ga_prefix TEXT, id INTEGER UNIQUE, date TEXT)";
	 * 
	 * */

}
