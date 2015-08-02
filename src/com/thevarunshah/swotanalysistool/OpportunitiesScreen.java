package com.thevarunshah.swotanalysistool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swotanalysistool.R;

public class OpportunitiesScreen extends Fragment{
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.opportunities_screen, container, false);
         
        return rootView;
    }

}
