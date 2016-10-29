package com.example.broadcast_intent_receiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	private Button mBtnRegReceiver,mBtnUnRegReceiver,mBtnSendBroadcast1,mBtnSendBroadcast2;
	private MyBroadcastReceiver2 mMyReceiver2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mBtnRegReceiver = (Button)findViewById(R.id.btnRegReceiver);
        mBtnUnRegReceiver =(Button)findViewById(R.id.btnUnRegReceiver);
        mBtnSendBroadcast1 =(Button)findViewById(R.id.btnSendBroadcast1);
        mBtnSendBroadcast2 =(Button)findViewById(R.id.btnSendBroadcast2);
        
        mBtnRegReceiver.setOnClickListener(btnRegReceiverOnClick);
        mBtnUnRegReceiver.setOnClickListener(btnUnRegReceiverOnClick);
        mBtnSendBroadcast1.setOnClickListener(btnSendBroadcast1OnClick);
        mBtnSendBroadcast2.setOnClickListener(btnSendBroadcast2OnClick);
    }

    private View.OnClickListener btnRegReceiverOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			IntentFilter itFilter = new IntentFilter("com.android.MY_BROADCAST2");
			mMyReceiver2 = new MyBroadcastReceiver2();
			registerReceiver(mMyReceiver2,itFilter);
		}
	};
    
	private View.OnClickListener btnUnRegReceiverOnClick =
			new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					unregisterReceiver(mMyReceiver2);
				}
			};
	
    private View.OnClickListener btnSendBroadcast1OnClick =
    		new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent it =new Intent("com.android.MY_BROADCAST1");
					it.putExtra("sender_name", "主程序1");
					sendBroadcast(it);
				}
			};
			
		    private View.OnClickListener btnSendBroadcast2OnClick =
		    		new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent it =new Intent("com.android.MY_BROADCAST2");
							it.putExtra("sender_name", "主程序2");
							sendBroadcast(it);
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
