package com.egnesse.sckullappsuperadmin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.egnesse.sckullappsuperadmin.R;
import com.egnesse.sckullappsuperadmin.dto.SchoolDTO;

import java.util.List;

/**
 * Created by adityaagrawal on 17/01/16.
 */
public class SchoolListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<SchoolDTO> schoolDTOs;

    public SchoolListAdapter(Context context, List<SchoolDTO> schoolDTOs) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.schoolDTOs = schoolDTOs;
    }

    @Override
    public int getCount() {
        return schoolDTOs.size();
    }

    @Override
    public Object getItem(int position) {
        return schoolDTOs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.single_row_school_list, null);
        ((TextView) view.findViewById(R.id.txtSchoolName)).setText(schoolDTOs.get(position).getName());

        Switch mSwitch = (Switch) view.findViewById(R.id.switchActivate);
        if(schoolDTOs.get(position).getActivated())
            mSwitch.setChecked(true);
        else
            mSwitch.setChecked(false);

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
            }
        });
        return view;
    }
}
