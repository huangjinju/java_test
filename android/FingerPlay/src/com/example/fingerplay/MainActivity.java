package com.example.fingerplay;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	private TextView mTxtComPlay,mTxtResult;
	private Button mBtnScissors,mBtnStone,mBtnPaper;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);
        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    private Button.OnClickListener btnScissorsOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--������2-ʯͷ��3--��*/
    		   if(iComPlay==1){
    			   mTxtComPlay.setText(R.string.play_scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    		   }
    		   else if(iComPlay==2){
    			   mTxtComPlay.setText(R.string.play_stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose)); 
    		   }
    		   else{
      			   mTxtComPlay.setText(R.string.play_paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));    
    		   }
    	   }
    };
    	
    private Button.OnClickListener btnStoneOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--������2-ʯͷ��3--��*/
    		   if(iComPlay==1){
    			   mTxtComPlay.setText(R.string.play_scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));
    		   }
    		   else if(iComPlay==2){
    			   mTxtComPlay.setText(R.string.play_stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw)); 
    		   }
    		   else{
      			   mTxtComPlay.setText(R.string.play_paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));    
    		   }
    	   }
    };
    

    private Button.OnClickListener btnPaperOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--������2-ʯͷ��3--��*/
    		   if(iComPlay==1){
    			   mTxtComPlay.setText(R.string.play_scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));
    		   }
    		   else if(iComPlay==2){
    			   mTxtComPlay.setText(R.string.play_stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win)); 
    		   }
    		   else{
      			   mTxtComPlay.setText(R.string.play_paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));    
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
