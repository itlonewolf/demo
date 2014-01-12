package com.lhy.douban.ui.fragmnt;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lhy.douban.R;

public class Showing extends ListFragment {

	ArrayList<String> demos = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		for (int i = 0; i < 50; i++) {
			demos.add("item<" + i + ">");
		}
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		if (isResumed()) {
			setListShown(true) ;
		}
		else {
			
			setListShownNoAnimation(false) ;
		}
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, demos) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				try {
					Thread.sleep(500) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				TextView tv = (TextView) super.getView(position, convertView,
						parent);
				tv.setTextColor(Color.BLACK);
				tv.setTextSize(23);
				return tv;
			}

		});
		
//		else {
//			setListShownNoAnimation(true);
//		}
	}

}