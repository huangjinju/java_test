package com.example.myfirstandroidapp;




import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.util.*;
public class MainActivity extends Activity {
	private EditText /*mEdtSex,*/mEdtAge;
	private Button mBtnOK;
	private TextView mTxtR;
	private Spinner mSpnSex;
	private String msSex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	//	mEdtSex = (EditText) findViewById(R.id.edtSex);
		mEdtAge = (EditText) findViewById(R.id.edtAge);
		mBtnOK = (Button) findViewById(R.id.btnOK);
		mTxtR = (TextView) findViewById(R.id.txtR);
		mBtnOK.setOnClickListener(btnOKOnClick);
		
		mSpnSex = (Spinner)findViewById(R.id.spnSex);
		mSpnSex.setOnItemSelectedListener(spnSexOnItemSelected);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
	private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		/*	String strSex = mEdtSex.getText().toString();*/

			int iAge = Integer.parseInt(mEdtAge.getText().toString());
			String strSug = getString(R.string.result);
			
			
			//if(strSex.equals(getString(R.string.sex_male)))
			if(msSex.equals(getString(R.string.sex_male)))
			{
				Log.d("~~~~man123","i am man");
				if(iAge<28)
					strSug +=getString(R.string.sug_not_hurry);
				else if(iAge > 33)
					strSug +=getString(R.string.sug_get_married);
				else
					strSug +=getString(R.string.sug_find_couple);
			}
			else
			{
				Log.d("~~woman123","i am woman");
				if(iAge<25)
					strSug +=getString(R.string.sug_not_hurry);
				else if(iAge > 33)
					strSug +=getString(R.string.sug_get_married);
				else
					strSug +=getString(R.string.sug_find_couple);
			}
			mTxtR.setText(strSug);
			
		}
	};
	
	
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
	
	private AdapterView.OnItemSelectedListener spnSexOnItemSelected =
			new AdapterView.OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView  parent, View v,
						int position, long id) {
					// TODO Auto-generated method stub
					msSex=parent.getSelectedItem().toString();
				}

				@Override
				public void onNothingSelected(AdapterView parent) {
					// TODO Auto-generated method stub
					
				}
		
		
			};
		
	
	
	
	
	
	
}
