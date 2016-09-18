package com.example.imageswitcher_gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private Integer[] miImgArr;
	
	public ImageAdapter(Context context,Integer[] imgArr){
		mContext = context;
		miImgArr = imgArr;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return miImgArr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//return null;
		ImageView v;
		if(convertView==null){
			v = new ImageView(mContext);
			v.setLayoutParams(new GridView.LayoutParams(90,90));
			v.setScaleType(ImageView.ScaleType.CENTER_CROP);
			v.setPadding(10, 10, 10, 10);
		}
		else{
			v = (ImageView)convertView;
		}
		v.setImageResource(miImgArr[position]);
		return v;
	}

}
