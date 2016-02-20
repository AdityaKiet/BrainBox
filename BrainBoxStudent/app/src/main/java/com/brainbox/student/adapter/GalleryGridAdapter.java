package com.brainbox.student.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brainbox.student.R;
import com.brainbox.student.ui.CustomTypeFace;
import com.brainbox.student.ui.SquareImageView;

/**
 * Created by adityaagrawal on 20/02/16.
 */
public class GalleryGridAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;
    private Typeface typeface;

    public GalleryGridAdapter(Context c, String[] web, int[] Imageid) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
        typeface = CustomTypeFace.getTypeface(c);
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.grid_album_single_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            SquareImageView imageView = (SquareImageView) grid.findViewById(R.id.grid_image);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
            textView.setTypeface(typeface);
        } else {
            grid =  convertView;
        }

        return grid;
    }
}