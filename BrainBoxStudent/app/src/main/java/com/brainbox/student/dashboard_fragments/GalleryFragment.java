package com.brainbox.student.dashboard_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainbox.student.R;
import com.brainbox.student.provider.ExtraArgumentKeys;

import butterknife.ButterKnife;

/**
 * Created by Admin-PC on 2/20/2016.
 */
public class GalleryFragment extends Fragment
{
	private View parentView;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_gallery, container, false);
		ButterKnife.bind(this, parentView);


		populate();
		return parentView;
	}



	private void populate(){
		ButterKnife.bind(this, parentView);
	//	mScrollConfig = getResources().getIntArray(R.attr.scrollFaster);
	}


}
