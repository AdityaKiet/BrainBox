package com.egnesse.sckullappsuperadmin.network;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.egnesse.sckullappsuperadmin.DashboardActivity;
import com.egnesse.sckullappsuperadmin.constants.NetworkContants;
import com.egnesse.sckullappsuperadmin.dto.ErrorDTO;
import com.egnesse.sckullappsuperadmin.dto.LoginDTO;
import com.egnesse.sckullappsuperadmin.dto.SessionDTO;
import com.egnesse.sckullappsuperadmin.global.AppController;
import com.egnesse.sckullappsuperadmin.ui.Dialog;
import com.egnesse.sckullappsuperadmin.ui.GetProgressBar;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Login implements NetworkContants {

    private MaterialDialog.Builder builder;
    private MaterialDialog dialog;

    public void login(final Context context, LoginDTO loginDTO) throws Exception {
        builder = GetProgressBar.get(context);
        String url = IP + LOGIN;
        builder.content("Loading...");
        dialog = builder.show();
        final Gson gson = new Gson();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(gson.toJson(loginDTO)), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                dialog.dismiss();

                try {
                    JSONObject jsonObject = response.getJSONObject("response");

                    SessionDTO sessionDTO = gson.fromJson(jsonObject.getString("data"), SessionDTO.class);
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("session", gson.toJson(sessionDTO));
                    editor.commit();


                    Intent intent = new Intent(context, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Dialog.showSimpleDialog(context, e.toString());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();

                if (error instanceof TimeoutError || error instanceof NoConnectionError || error instanceof NetworkError) {
                    Dialog.showSimpleDialog(context, error.toString());
                    return;
                }

                try {
                    String errorString = new String(error.networkResponse.data);
                    JSONObject jsonObject = new JSONObject(errorString);
                    ErrorDTO errorDTO = gson.fromJson(jsonObject.getString("error"), ErrorDTO.class);
                    Dialog.showSimpleDialog(context, errorDTO.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    Dialog.showSimpleDialog(context, e.getMessage());
                }

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjReq, AppController.JSON_OBJECT_REQUEST);
    }
}
