package com.lhy.douban.provider.services;

import com.lhy.douban.provider.ActionType;

import android.app.IntentService;
import android.content.Intent;

public class DBMgrService extends IntentService {

	public DBMgrService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// Intent service = new Intent(getContext(), DBMgrService.class);
		// service.setAction(ActionType.INSERT_SHOWING_SERVICE.toString());
		// service.putExtra("uri", uri);
		// service.putExtra("values", values);
		// getContext().startService(service);
		ActionType actionType = ActionType.valueOf(intent.getAction());
		switch (actionType) {
		case INSERT_SHOWING_SERVICE:
			
			break;

		default:
			break;
		}

	}

}
