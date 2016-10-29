package com.example.fragment_base;


//import com.example.fingerplay.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

public class MainFragment extends Fragment {
	private TextView mTxtResult;
	private ImageView mImgViewComPlay;
	private ImageButton mImgBtnScissors,mImgBtnStone,mImgBtnPaper;
	private TextView mEdtCountSet,mEdtCountPlayerWin,mEdtCountComWin,mEdtCountDraw;
	private int miCountSet=0,miCountPlayerWin=0,miCountComWin=0,miCountDraw=0;
	
	
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
    	return inflater.inflate(R.layout.fragment_main, container,false);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	
    
        mTxtResult = (TextView)getView().findViewById(R.id.txtResult);
        mImgBtnScissors = (ImageButton)getView().findViewById(R.id.imgBtnScissors);
        mImgBtnStone = (ImageButton)getView().findViewById(R.id.imgBtnStone);
        mImgBtnPaper = (ImageButton)getView().findViewById(R.id.imgBtnPaper);
        mImgViewComPlay = (ImageView)getView().findViewById(R.id.imgViewComPlay);
        mEdtCountSet = (EditText) getActivity().findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin =  (EditText) getActivity().findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText) getActivity().findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText) getActivity().findViewById(R.id.edtCountDraw);
       
        mImgBtnScissors.setOnClickListener(imgBtnScissorsOnClick);
        mImgBtnStone.setOnClickListener(imgBtnStoneOnClick);
        mImgBtnPaper.setOnClickListener(imgBtnPaperOnClick);
	}


	private Button.OnClickListener imgBtnScissorsOnClick = 
    		new Button.OnClickListener(){
    	   public void onClick(View v){
    		   int iComPlay = (int)(Math.random()*3+1);
    		   /*1--剪刀，2-石头，3--布*/
    		   if(iComPlay==1){
    			   mImgViewComPlay.setImageResource(R.drawable.scissors);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    			   miCountDraw++;
    			   mEdtCountDraw.setText(String.valueOf(miCountDraw));
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose)); 
    			   miCountComWin++;
    			   mEdtCountComWin.setText(String.valueOf(miCountComWin));
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win));    
    			   miCountPlayerWin++;
    			   mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin)); 
    		   }
    		   miCountSet++;
    		   mEdtCountSet.setText(String.valueOf(miCountSet));
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
    			   miCountPlayerWin++;
    			   mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin)); 
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));
    			   miCountDraw++;
    			   mEdtCountDraw.setText(String.valueOf(miCountDraw));
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_lose));
    			   miCountComWin++;
    			   mEdtCountComWin.setText(String.valueOf(miCountComWin));
    		   }
    		   miCountSet++;
    		   mEdtCountSet.setText(String.valueOf(miCountSet));
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
    			   miCountComWin++;
    			   mEdtCountComWin.setText(String.valueOf(miCountComWin));
    		   }
    		   else if(iComPlay==2){
    			   mImgViewComPlay.setImageResource(R.drawable.stone);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_win)); 
    			   miCountPlayerWin++;
    			   mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin)); 
    		   }
    		   else{
    			   mImgViewComPlay.setImageResource(R.drawable.paper);
    			   mTxtResult.setText(getString(R.string.result)+getString(R.string.player_draw));   
    			   miCountDraw++;
    			   mEdtCountDraw.setText(String.valueOf(miCountDraw));
    		   }
    		   miCountSet++;
    		   mEdtCountSet.setText(String.valueOf(miCountSet));

    	   }
    };
    
	
}
