package com.thevarunshah.swotanalysistool;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.swotanalysistool.R;

public class TabsPagerAdapter extends PagerAdapter {
	
    String tabs[] = {"S", "W", "O", "T"};
    Activity activity;
    
    public TabsPagerAdapter(Activity activity){
        this.activity=activity;
    }
    
    @Override
    public int getCount() {
        return tabs.length;
    }
    
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }
 
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
 
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Inflate a new layout from our resources
        View view=null;
        switch(position){
        	case 0: 
        		view = activity.getLayoutInflater().inflate(R.layout.strengths_screen,container, false);
        		break;
        	case 1:
        		view = activity.getLayoutInflater().inflate(R.layout.weaknesses_screen,container, false);
        		break;
        	case 2:
        		view = activity.getLayoutInflater().inflate(R.layout.opportunities_screen,container, false);
        		break;
        	case 3:
        		view = activity.getLayoutInflater().inflate(R.layout.threats_screen,container, false);
        		break;
        }
        // Add the newly created View to the ViewPager
        container.addView(view);
 
        // Return the View
        return view;
    }
    
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
 
}
