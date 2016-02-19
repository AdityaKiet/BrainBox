package com.egnesse.sckullappsuperadmin.ui;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by adityaagrawal on 10/02/16.
 */
public class GetProgressBar {

    public static MaterialDialog.Builder get(Context context) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .content("Please Wait").cancelable(false).progress(true, 0);
        return builder;
    }
}
