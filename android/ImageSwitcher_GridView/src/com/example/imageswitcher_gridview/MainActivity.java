package com.example.imageswitcher_gridview;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

//import com.example.imageswitcher_gridview.ImageAdapter;

public class MainActivity extends Activity implements ViewFactory {
	private GridView mGridView;
	private ImageSwitcher mImgSwitcher;
	private Integer[] miImgArr = {
		R.drawable.img01,R.drawable.img02,R.drawable.img03,
		R.drawable.img04,R.drawable.img05,R.drawable.img06,
		R.drawable.img07,R.drawable.img08,
	};
	
	private Integer[] miThumbImgArr = {
			R.drawable.img01th,R.drawable.img02th,R.drawable.img03th,
			R.drawable.img04th,R.drawable.img05th,R.drawable.img06th,
			R.drawable.img07th,R.drawable.img08th,
		};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgSwitcher = (ImageSwitcher)findViewById(R.id.imgSwitcher);
        mImgSwitcher.setFactory(this);
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        ImageAdapter imgAdap =new ImageAdapter(this,miThumbImgArr);
        mGridView =  (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);
        mGridView.setOnItemClickListener(gridViewOnItemClick);
        
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


	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView  v = new ImageView(this);
		v.setBackgroundColor(0xff000000);
		v.setScaleType(ImageView.ScaleType.FIT_CENTER);
		v.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		v.setBackgroundColor(Color.WHITE);
		return v;
	}
	
	private AdapterView.OnItemClickListener gridViewOnItemClick = new
			 AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					// TODO Auto-generated method stub
					mImgSwitcher.setImageResource(miImgArr[position]);
					
				}
		
		
			};
}
