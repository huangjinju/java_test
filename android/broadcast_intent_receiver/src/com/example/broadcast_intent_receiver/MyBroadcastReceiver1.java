package com.example.broadcast_intent_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		String  sender = intent.getStringExtra("sender_name");
		Toast.makeText(context, "BroadcastReceiver1�յ�"+sender + "���͵�Broadcast��Ϣ", Toast.LENGTH_LONG).show();
	}

}
