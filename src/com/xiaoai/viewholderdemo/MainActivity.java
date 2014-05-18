package com.xiaoai.viewholderdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private LayoutInflater mInflater = null;
	private ListView lv = null;
	private List<String> items = null;
	private final int ITEM_COUNT = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		System.out.println("into herer");
		lv.setAdapter(new Adapter());
		
	}

	/**
	 * 初始化相关参数
	 * */
	private void init(){
		mInflater = getLayoutInflater();
		
		lv = (ListView) findViewById(R.id.lv);
		items = new ArrayList();
		
		for(int i=0;i<ITEM_COUNT;i++){
			items.add("测试条目："+i);
		}
		
		
		
	}
	
	/**
	 * ListView的适配器
	 * */
	class Adapter implements ListAdapter{

		@Override
		public void registerDataSetObserver(DataSetObserver observer) {
			
		}

		@Override
		public void unregisterDataSetObserver(DataSetObserver observer) {
			
		}

		@Override
		public int getCount() {
			return items.size();
		}

		@Override
		public Object getItem(int position) {
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder vh =null;
			if(convertView==null){
				vh = new ViewHolder();
				convertView = mInflater.inflate(R.layout.item, null);
				vh.tv = (TextView) convertView.findViewById(R.id.tvShow);
				
				convertView.setTag(vh);
			}else{
				vh = (ViewHolder) convertView.getTag();
			}
			
			vh.tv.setText(items.get(position));
			
			return convertView;
		}

		@Override
		public int getItemViewType(int position) {
			return 1;
		}

		@Override
		public int getViewTypeCount() {
			return 1;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean areAllItemsEnabled() {
			return false;
		}

		@Override
		public boolean isEnabled(int position) {
			return true;
		}
		
	}	
	
	static final class ViewHolder{
		TextView tv;
	}
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
