package com.example.intent_39;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyImageActivity extends Activity {
	private TextView mTxtResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_image);
		mTxtResult=(TextView)findViewById(R.id.txtResult);
		showResult();
	}

	private void showResult()
	{
		Intent it=getIntent();
		String sAct=it.getAction();
		String sScheme=it.getScheme();
		if(sScheme.equals("http")){
			String s = "���յ���Itent����Ҫ��\"����ҳ\""+it.getData().toString();
			mTxtResult.setText(s);
		}else if(sScheme.equals("tel")){
			String s = "���յ���Itent����Ҫ��\"����绰\""+it.getData().toString();
			mTxtResult.setText(s);
		}else if(sScheme.equals("file")){
			if(sAct.equals("android.intent.action.VIEW")){
				String s = "���յ���Itent����Ҫ��\"�鿴\""+it.getData().toString();
				mTxtResult.setText(s);
			}else if(sAct.equals("android.intent.action.EDIT")){
				String s = "���յ���Itent����Ҫ��\"�༭\""+it.getData().toString();
				mTxtResult.setText(s);
			}
		}
		
	}
	
	
}
