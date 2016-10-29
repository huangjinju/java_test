package com.example.fingerplay;

import android.app.Activity;
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
    }


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
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose)); 
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));    
    		   }
    	   }
    };
    	
    private Button.OnClickListener imgBtnStoneOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw)); 
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));    
    		   }
    	   }
    };
    

    private Button.OnClickListener imgBtnPaperOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win)); 
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
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
