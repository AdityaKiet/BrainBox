package com.brainbox.student.dashboard_fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.brainbox.student.R;
import com.brainbox.student.ui.button.ButtonPlus;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Admin-PC on 2/19/2016.
 */
public class AbsentNoteFragment extends Fragment
{
	private View parentView;
	@Bind(R.id.spinnerAbsentReason)
	MaterialSpinner materialSpinner;
	@Bind(R.id.btnSubmitAbsent)
	ButtonPlus btnSubmitAbsent;
	private String[] reasons;




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		parentView = inflater.inflate(R.layout.fragment_absent_note, container, false);

		populate();
		return parentView;
	}

	private void populate(){
		ButterKnife.bind(this, parentView);
		reasons = getActivity().getResources().getStringArray(R.array.reasons_absent);
		if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			btnSubmitAbsent.setBackgroundResource(R.drawable.abc_alpha_btn_background_ripple);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, reasons);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		materialSpinner.setAdapter(adapter);
	}
}
