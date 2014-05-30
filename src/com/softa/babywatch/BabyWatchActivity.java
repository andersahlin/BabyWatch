package com.softa.babywatch;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.softa.babywatch.actions.WakeUpAction;
import com.softa.babywatch.detectors.BabyDetector;

public class BabyWatchActivity extends FragmentActivity {

	public BabyDetector currentlySelectedDetector;
	public WakeUpAction currentlySelectedAction;

	/** maintains the pager adapter*/
	private BabyPagerAdapter babyPagerAdapter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.baby_watch); 

		this.initialisePaging();
	}

	/**
	 * Initialise the fragments to be paged
	 */
	private void initialisePaging() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(new StartFragment());
		fragments.add(new ConfigurationFragment());
		this.babyPagerAdapter  = new BabyPagerAdapter(super.getSupportFragmentManager(), fragments);
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		pager.setAdapter(this.babyPagerAdapter);
	}

}

