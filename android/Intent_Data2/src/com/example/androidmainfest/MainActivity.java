package com.example.androidmainfest;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;



public class MainActivity extends Activity {
	final private int LAUNCH_GAME=0;
	private TextView mTxtResult;
    private Button mBtnLaunchGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    	mBtnLaunchGame = (Button) findViewById(R.id.btnLaunchGame);
    	mBtnLaunchGame.setOnClickListener(btnLaunchGameOnClick); 
    	mTxtResult=(TextView)findViewById(R.id.txtResult);
    }


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
    //btnLaunchGame
    private View.OnClickListener btnLaunchGameOnClick =new View.OnClickListener(){
    	 public void onClick(View v){
    		 Intent it = new Intent();
    		 it.setClass(MainActivity.this,GameActivity.class);
    		 startActivityForResult(it,LAUNCH_GAME);
    	 }
    };
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode != LAUNCH_GAME)
			return ;
		switch(resultCode){
		case RESULT_OK:
			Bundle bundle=data.getExtras();
				int iCountSet = bundle.getInt("KEY_COUNT_SET");
				int iCountPlayerWin=bundle.getInt("KEY_COUNT_PLAYER_WIN");
				int iCountComWin = bundle.getInt("KEY_COUNT_COM_WIN");
				int iCountDraw = bundle.getInt("KEY_COUNT_DRAW");
				
				String s = "��Ϸ��������ܹ�����" + iCountSet + "��,Ӯ��" +iCountPlayerWin+
						   "�֣�����"+iCountComWin + 
						   "��,ƽ��" + iCountDraw + "��";
				mTxtResult.setText(s);
				break;
		case RESULT_CANCELED:
			mTxtResult.setText("��ѡ��ȡ����Ϸ ");
				
			}
	
		
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}
    

    
}
