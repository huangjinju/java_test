package com.example.fingerplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

	private TextView mTxtResult;
	private ImageView mImgViewComPlay;
	private ImageButton mImgBtnScissors,mImgBtnStone,mImgBtnPaper;
	
	private int miCountSet=0,miCountPlayerWin=0,miCountComWin=0,miCountDraw=0;
	private Button mBtnShowResult;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mImgViewComPlay = (ImageView)findViewById(R.id.imgViewComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);

        
        mImgBtnScissors = (ImageButton)findViewById(R.id.imgBtnScissors);
        mImgBtnStone = (ImageButton)findViewById(R.id.imgBtnStone);
        mImgBtnPaper = (ImageButton)findViewById(R.id.imgBtnPaper);
        mImgBtnScissors.setOnClickListener(imgBtnScissorsOnClick);
        mImgBtnStone.setOnClickListener(imgBtnStoneOnClick);
        mImgBtnPaper.setOnClickListener(imgBtnPaperOnClick);
        
        mBtnShowResult=(Button)findViewById(R.id.btnShowResult);
        mBtnShowResult.setOnClickListener(btnShowResultOnClick);
    }

    private View.OnClickListener btnShowResultOnClick = 
    	new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it= new Intent();
				it.setClass(MainActivity.this,GameResultActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt("KEY_COUNT_SET", miCountSet);
				bundle.putInt("KEY_COUNT_PLAYER_WIN", miCountPlayerWin);
				bundle.putInt("KEY_COUNT_COM_WIN", miCountComWin);
				bundle.putInt("KEY_COUNT_DRAW", miCountDraw);
				it.putExtras(bundle);
				startActivity(it);
			}
		};	
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    private Button.OnClickListener imgBtnScissorsOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   miCountSet++;
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    			   miCountDraw++;
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose)); 
    			   miCountComWin++;
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));  
    			   miCountPlayerWin++;
    		   }
    	   }
    };
    	
    private Button.OnClickListener imgBtnStoneOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   miCountSet++;
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));
    			   miCountPlayerWin++;
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw)); 
    			   miCountDraw++;
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));  
    			   miCountComWin++;
    		   }
    	   }
    };
    

    private Button.OnClickListener imgBtnPaperOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   miCountSet++;
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));
    			   miCountComWin++;
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win)); 
    			   miCountPlayerWin++;
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    			   miCountDraw++;
    		   }
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
}
