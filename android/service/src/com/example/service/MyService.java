package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private final String LOG_TAG="service demo";
	
	public class LocalBinder extends Binder{
		MyService getService(){
			return MyService.this;
		}
	}
	
	private LocalBinder mLocBin = new LocalBinder();
	
	public void myMethod(){
		Log.d(LOG_TAG,"myMethod()");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(LOG_TAG,"onBind()");
		return mLocBin;
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"onCreate()");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(LOG_TAG,"onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d(LOG_TAG,"onDestroy()");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(LOG_TAG,"onUnbind()");
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

	
	
}
