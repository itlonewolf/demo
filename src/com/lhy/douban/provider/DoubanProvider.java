package com.lhy.douban.provider;

import com.lhy.douban.provider.services.DBMgrService;
import com.lhy.douban.utils.ArrayListYee;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public class DoubanProvider extends ContentProvider implements
		LoaderCallbacks<Cursor> {
	private DBHelper dbHelper;
	public static final UriMatcher URI_MATCHER;
	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		Uri.Builder builder = new Uri.Builder() ;
//		builder.authority(authority)
		// 向showing插入数据
		URI_MATCHER.addURI(DoubanContract.AUTHORITIES,
				DoubanContract.INSERT_SHOWING_PATH,
				DoubanContract.CODE_INSERT_SHOWING);
		// 从showing中查询数据
		URI_MATCHER.addURI(DoubanContract.AUTHORITIES,
				DoubanContract.QUERY_SHOWING_PATH,
				DoubanContract.CODE_QUERY_SHOWING);
	}

	@Override
	public boolean onCreate() {
		dbHelper = new DBHelper(getContext());
		return false;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		switch (URI_MATCHER.match(uri)) {
		case DoubanContract.CODE_INSERT_SHOWING:
			// images表
			ContentValues valuesImage = new ContentValues();
			valuesImage.put("id", 4915857);
			valuesImage
					.put("small",
							"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2164225595.jpg");
			valuesImage
					.put("medium",
							"http://img3.douban.com/view/movie_poster_cover/spst/public/p2164225595.jpg");
			valuesImage
					.put("large",
							"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2164225595.jpg");
			// rating表
			ContentValues valuesRating = new ContentValues();
			valuesRating.put("id", 4915857);
			valuesRating.put("max", 10);
			valuesRating.put("average", "8.1");
			valuesRating.put("stars", "40");
			valuesRating.put("min", 0);
			// subject表
			ContentValues valuesSubject = new ContentValues();
			valuesSubject.put("id", 4915857);
			valuesSubject.put("title", "神偷奶爸2");
			valuesSubject.put("mainland_pubdate", "2014-01-10");
			valuesSubject.put("collect_count", 103393);
			valuesSubject.put("original_title", "Despicable Me 2");
			valuesSubject.put("subtype", "movie");
			valuesSubject.put("year", "2013");
			ArrayListYee<String> pubdates = new ArrayListYee<String>();
			pubdates.add("2014-01-02(香港)");
			pubdates.add("2014-01-03(中国大陆)");
			// Log.w(TAG, ">>>>>>>>"+pubdates.toString()) ;
			valuesSubject.put("pubdates", pubdates.toString());
			valuesSubject
					.put("alt", "http://movie.douban.com/subject/4915857/");

			// 准备开始利用事务插入操作
			db.beginTransaction();
			try {
				db.insert(DBHelper.TABLE_IMAGE, null, valuesImage);
				db.insert(DBHelper.TABLE_RATING, null, valuesRating);
				db.insert(DBHelper.TABLE_SUBJECT, null, valuesSubject);
				// Marks the current transaction as successful.
				db.setTransactionSuccessful();
			} finally {
				// 结束插入操作
				db.endTransaction();
				// 查询subject类所有成员变量的sql语句
				/*
				 * select rating.max, rating.average, rating.stars, rating.min,
				 * subject.title, subject.mainland_pubdate, images.small,
				 * images.large, images.medium, subject.collect_count,
				 * subject.original_title, subject.subtype, subject.year,
				 * subject.pubdates, subject.alt, subject.id from subject,
				 * images, rating where subject.id=images.id and
				 * subject.id=rating.id
				 */
			}
			break;

		default:
			break;
		}
		return Uri.withAppendedPath(DoubanContract.CONTENT_BASE_URI,
				DoubanContract.QUERY_SHOWING_PATH);
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		switch (URI_MATCHER.match(uri)) {
		case DoubanContract.CODE_QUERY_SHOWING:
			// TODO执行插入操作
			break;

		default:
			break;
		}
		return null;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {

	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {

	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}

}