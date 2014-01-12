package com.lhy.douban.provider;

import android.net.Uri;

public class DoubanContract {

	private static final String TAG = "DoubanContract";

	static final String AUTHORITIES = "com.lhy.douban.provider";
	static final Uri CONTENT_BASE_URI = Uri.parse("content://" + AUTHORITIES);

	// 插入showing
	// addURI(String authority, String path, int code)
	static final String INSERT_SHOWING_PATH = "insert";
	// code在urimatcher时用到
	static final int CODE_INSERT_SHOWING = 0;
	static final Uri URI_INSERT_SHOWING = Uri.withAppendedPath(
			CONTENT_BASE_URI, INSERT_SHOWING_PATH);

	// 查询showing表
	static final String QUERY_SHOWING_PATH = "query";
	static final int CODE_QUERY_SHOWING = 1;
	static final Uri URI_QUERY_SHOWING = Uri.withAppendedPath(CONTENT_BASE_URI,
			QUERY_SHOWING_PATH);

}
