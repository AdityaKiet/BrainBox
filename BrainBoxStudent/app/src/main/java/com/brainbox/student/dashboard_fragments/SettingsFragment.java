package com.brainbox.student.dashboard_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainbox.student.R;
import com.brainbox.student.global.BrainBox;

import butterknife.ButterKnife;

/**
 * Created by adityaagrawal on 19/02/16.
 */
public class SettingsFragment extends Fragment {

    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView =  inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, parentView);
        BrainBox.currentFragment = this;

        populate();
        return parentView;
    }

    private void populate(){

    }
}
