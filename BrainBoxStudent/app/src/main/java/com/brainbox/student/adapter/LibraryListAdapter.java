package com.brainbox.student.adapter;

/**
 * Created by adityaagrawal on 17/02/16.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainbox.student.R;
import com.brainbox.student.activities.PDFDisplayActivity;
import com.brainbox.student.dto.LibraryItemDTO;
import com.brainbox.student.ui.CustomTypeFace;
import com.google.gson.Gson;

import java.util.List;

public class LibraryListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<LibraryItemDTO> feedItems;
    private Typeface typeface;

    public LibraryListAdapter(Context context, List<LibraryItemDTO> feedItems) {
        this.context = context;
        this.feedItems = feedItems;
        typeface = CustomTypeFace.getTypeface(context);
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.single_row_library_list, null);


        TextView bookName = (TextView) convertView.findViewById(R.id.txtBookName);
        bookName.setTypeface(typeface);
        ImageView imgBook = (ImageView) convertView.findViewById(R.id.imgLibrary);


        final LibraryItemDTO item = feedItems.get(position);
        bookName.setText(item.getName());
        imgBook.setImageResource(item.getImageLink());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PDFDisplayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("item", new Gson().toJson(item));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}