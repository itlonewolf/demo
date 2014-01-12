package com.lhy.douban.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.lhy.douban.R;
import com.lhy.douban.ui.fragmnt.AllFragmnt;
import com.lhy.douban.ui.fragmnt.FragmentAdapterYee;

public class ActivityMain extends SherlockFragmentActivity implements
		TabListener {
	private ViewPager vpContainerRoot;
	private FragmentAdapterYee fragmentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar actionBar = getSupportActionBar();
		// Specify that the Home/Up button should not be enabled, since there is
		// no hierarchical parent.
		actionBar.setHomeButtonEnabled(true);

		// Specify that we will be displaying tabs in the action bar.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		vpContainerRoot = (ViewPager) findViewById(R.id.vpContainerRootId);
		fragmentAdapter = new FragmentAdapterYee(getSupportFragmentManager(),
				AllFragmnt.CINEMA);
		vpContainerRoot.setAdapter(fragmentAdapter);

		vpContainerRoot
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});
		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < fragmentAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter.
			// Also specify this Activity object, which implements the
			// TabListener interface, as the
			// listener for when this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(fragmentAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		vpContainerRoot.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

}
