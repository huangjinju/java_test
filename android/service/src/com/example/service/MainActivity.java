package com.example.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button mBtnStartMyService,mBtnStopMyService,mBtnBindMyService,mBtnUnbindMyService,mBtnCallMyServiceMethod;
	private MyService mMyServ = null;
	private final String LOG_TAG = "service demo";
	
	private ServiceConnection mServConn = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d(LOG_TAG,"onServiceConnected()"+name.getClassName());
			mMyServ = ((MyService.LocalBinder)service).getService();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d(LOG_TAG,"onServiceDisConnected()"+name.getClassName());
		}
		
	};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStartMyService=(Button)findViewById(R.id.btnStartMyService);
        mBtnStopMyService=(Button)findViewById(R.id.btnStopMyService);
        mBtnBindMyService=(Button)findViewById(R.id.btnBindMyService);
        mBtnUnbindMyService=(Button)findViewById(R.id.btnUnbindMyService);
        mBtnCallMyServiceMethod=(Button)findViewById(R.id.btnCallMyServiceMethod);
        
        mBtnStartMyService.setOnClickListener(btnStartMyServiceOnClick);
        mBtnStopMyService.setOnClickListener(btnStopMyServiceOnClick);
        mBtnBindMyService.setOnClickListener(btnBindMyServiceOnClick);
        mBtnUnbindMyService.setOnClickListener(btnUnBindMyServiceOnClick);
        mBtnCallMyServiceMethod.setOnClickListener(btnCallMyServiceMethodOnClick);
    }

    private View.OnClickListener btnStartMyServiceOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMyServ = null;
			Intent it = new Intent(MainActivity.this,MyService.class);
			startService(it);
		}
	};
    
    private View.OnClickListener btnStopMyServiceOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMyServ = null;
			Intent it = new Intent(MainActivity.this,MyService.class);
			stopService(it);
		}
	};
	
    private View.OnClickListener btnBindMyServiceOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMyServ = null;
			Intent it = new Intent(MainActivity.this,MyService.class);
			bindService(it,mServConn,BIND_AUTO_CREATE);
		}
	};
	
    private View.OnClickListener btnUnBindMyServiceOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mMyServ = null;
			Intent it = new Intent(MainActivity.this,MyService.class);
			unbindService(mServConn);
		}
	};
	
    private View.OnClickListener btnCallMyServiceMethodOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mMyServ != null){
				mMyServ.myMethod();
			}
		
		}
	};
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
