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
			String s = "接收到的Itent对象要求\"打开网页\""+it.getData().toString();
			mTxtResult.setText(s);
		}else if(sScheme.equals("tel")){
			String s = "接收到的Itent对象要求\"拨打电话\""+it.getData().toString();
			mTxtResult.setText(s);
		}else if(sScheme.equals("file")){
			if(sAct.equals("android.intent.action.VIEW")){
				String s = "接收到的Itent对象要求\"查看\""+it.getData().toString();
				mTxtResult.setText(s);
			}else if(sAct.equals("android.intent.action.EDIT")){
				String s = "接收到的Itent对象要求\"编辑\""+it.getData().toString();
				mTxtResult.setText(s);
			}
		}
		
	}
	
	
}
