package com.example.fingerplay;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameResultActivity extends Activity {
	private EditText mEdtCountSet,mEdtCountPlayerWin,mEdtCountComWin,mEdtCountDraw;
	private Button mBtnBackToGame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_result);
		mEdtCountSet=(EditText)findViewById(R.id.edtCountSet);
		mEdtCountPlayerWin=(EditText)findViewById(R.id.edtCountPlayerWin);
		mEdtCountComWin=(EditText)findViewById(R.id.edtCountComWin);
		mEdtCountDraw=(EditText)findViewById(R.id.edtCountDraw);
		mBtnBackToGame=(Button)findViewById(R.id.btnBackToGame);
		
		mBtnBackToGame.setOnClickListener(btnBackToGameOnClick);
		showResult();
	}

	private View.OnClickListener btnBackToGameOnClick = 
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			};
	
			
	private void 	showResult(){
		Bundle bundle = getIntent().getExtras();
		int iCountSet = bundle.getInt("KEY_COUNT_SET");
		int iCountPlayerWin = bundle.getInt("KEY_COUNT_PLAYER_WIN");
		int iCountComWin = bundle.getInt("KEY_COUNT_COM_WIN");
		int iCountDraw = bundle.getInt("KEY_COUNT_DRAW");
		
		mEdtCountSet.setText(Integer.toString(iCountSet));
		mEdtCountPlayerWin.setText(Integer.toString(iCountPlayerWin));
		mEdtCountComWin.setText(Integer.toString(iCountComWin));
		mEdtCountDraw.setText(Integer.toString(iCountDraw));
		
	}
			
}
