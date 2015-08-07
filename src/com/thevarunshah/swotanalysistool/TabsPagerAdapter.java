package com.thevarunshah.swotanalysistool;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.swotanalysistool.R;
import com.thevarunshah.swotanalysistool.backend.Database;
import com.thevarunshah.swotanalysistool.backend.SWOTObject;

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
        SWOTObject so = Database.getCurrentSWOT();
        EditText et;
        switch(position){
        	case 0: 
        		view = activity.getLayoutInflater().inflate(R.layout.strengths_screen,container, false);
        		et = (EditText) view.findViewById(R.id.specific_screen);
        		et.setText(so.getStrengths());
        		break;
        	case 1:
        		view = activity.getLayoutInflater().inflate(R.layout.weaknesses_screen,container, false);
        		et = (EditText) view.findViewById(R.id.specific_screen);
        		et.setText(so.getWeaknesses());
        		break;
        	case 2:
        		view = activity.getLayoutInflater().inflate(R.layout.opportunities_screen,container, false);
        		et = (EditText) view.findViewById(R.id.specific_screen);
        		et.setText(so.getOpportunities());
        		break;
        	case 3:
        		view = activity.getLayoutInflater().inflate(R.layout.threats_screen,container, false);
        		et = (EditText) view.findViewById(R.id.specific_screen);
        		et.setText(so.getThreats());
        		break;
        }
        // Add the newly created View to the ViewPager
        container.addView(view);
 
        // Return the View
        return view;
    }
    
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	View v = (View) object;
    	EditText et = (EditText) v.findViewById(R.id.specific_screen);
    	SWOTObject so = Database.getCurrentSWOT();
    	switch(position){
    		case 0:
    			so.setStrengths(et.getText().toString());
    			break;
    		case 1:
    			so.setWeaknesses(et.getText().toString());
    			break;
    		case 2:
    			so.setOpportunities(et.getText().toString());
    			break;
    		case 3:
    			so.setThreats(et.getText().toString());
    			break;
    	}
        container.removeView(v);
    }
 
}
