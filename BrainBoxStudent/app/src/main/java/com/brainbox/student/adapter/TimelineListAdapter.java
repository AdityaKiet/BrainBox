package com.brainbox.student.adapter;

/**
 * Created by adityaagrawal on 17/02/16.
 */

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.brainbox.student.R;
import com.brainbox.student.dto.FeedItem;
import com.brainbox.student.dto.TimelineItemDTO;
import com.brainbox.student.global.AppController;
import com.brainbox.student.ui.volley.FeedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TimelineListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<TimelineItemDTO> timelineItemDTOs;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public TimelineListAdapter(Context context, List<TimelineItemDTO> timelineItemDTOs) {
        this.context = context;
        this.timelineItemDTOs = timelineItemDTOs;
    }

    @Override
    public int getCount() {
        return timelineItemDTOs.size();
    }

    @Override
    public Object getItem(int location) {
        return timelineItemDTOs.get(location);
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
            convertView = inflater.inflate(R.layout.timeline_feed_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView statusMsg = (TextView) convertView.findViewById(R.id.txtStatusMsg);
        ImageView profilePic = (ImageView) convertView.findViewById(R.id.profilePic);
        ImageView feedImageView = (ImageView) convertView.findViewById(R.id.feedImage1);

        TimelineItemDTO item = timelineItemDTOs.get(position);

        name.setText(item.getName());
        statusMsg.setText(item.getDisc());

        Picasso.with(context).load(item.getImage()).error(R.drawable.ic_launcher).into(feedImageView);
        Picasso.with(context).load(item.getProfilePic()).error(R.drawable.ic_launcher).into(profilePic);
       return convertView;
    }

}