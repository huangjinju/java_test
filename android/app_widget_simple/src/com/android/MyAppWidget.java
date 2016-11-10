package com.android;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyAppWidget extends AppWidgetProvider {

	private final String LOG_TAG="my app widget";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"~~~~onReceive~~~~~~~~~~~");
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"~~~~~~~~~~~onUpdate~~~~~~~~~~~");
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"~~~~~~~~~~~onDeleted~~~~~~~~~~~");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"~~~~~~~~~~~onEnabled~~~~~~~~~~~");
		super.onEnabled(context);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"~~~~~~~~~~~onDisabled~~~~~~~~~~~");
		super.onDisabled(context);
	}

}
