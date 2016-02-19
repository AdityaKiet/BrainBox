package com.egnesse.sckullappsuperadmin.ui;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by adityaagrawal on 10/02/16.
 */
public class Dialog {
    public static void showSimpleDialog(Context context, String message) {
        new MaterialDialog.Builder(context)
                .content(message)
                .positiveText("OK")
                .show();
    }
}
