package com.egnesse.sckullappsuperadmin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.egnesse.sckullappsuperadmin.adapters.SchoolListAdapter;
import com.egnesse.sckullappsuperadmin.constants.NetworkContants;
import com.egnesse.sckullappsuperadmin.dto.SchoolDTO;
import com.egnesse.sckullappsuperadmin.global.AppController;
import com.egnesse.sckullappsuperadmin.ui.Dialog;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements AbsListView.OnScrollListener, NetworkContants {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listSchools)
    ListView listSchools;
    SchoolListAdapter schoolListAdapter;
    public List<SchoolDTO> schoolDTOs = new ArrayList<>();
    private int preLast, skip = 0;
    private boolean isDataLoaded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Toast.makeText(DashboardActivity.this, sharedPreferences.getString("session", "Aditya"), Toast.LENGTH_SHORT).show();
        populate();
    }


    private void populate() {
        listSchools.setOnScrollListener(this);
        schoolListAdapter = new SchoolListAdapter(this, schoolDTOs);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Activate Schools");
        loadData();
    }


    private void loadData() {
        String url = IP + GET_SCHOOL;
        url = url.replaceFirst("FROM", String.valueOf(skip));
        url = url.replaceFirst("TO", String.valueOf(skip + 10));
        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {
                if (response != null) {
                    if (!isDataLoaded) {
                        listSchools.setAdapter(schoolListAdapter);
                        parseJSONFeed(response);
                    } else {
                        parseJSONFeed(response);
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (!isDataLoaded) {
                    error.printStackTrace();
                    Dialog.showSimpleDialog(DashboardActivity.this, error.toString());
                } else {
                    loadData();
                }
            }
        }
        ) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        AppController.getInstance().addToRequestQueue(jsonReq);
    }


    private void parseJSONFeed(JSONObject response) {
        try {
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(response.getString("response"));
            JSONArray jsonArray = new JSONArray(jsonObject.getString("data"));

            if (jsonArray.length() == 0) {
                schoolListAdapter.notifyDataSetChanged();
                if (!isDataLoaded) {
                    Dialog.showSimpleDialog(DashboardActivity.this, "No data found !!!");
                }
            } else {
                SchoolDTO schoolDTO = null;

                for (int i = 0; i < jsonArray.length(); i++) {
                    schoolDTO = gson.fromJson(jsonArray.getJSONObject(i).toString(), SchoolDTO.class);
                    schoolDTOs.add(schoolDTO);
                }

                schoolListAdapter.notifyDataSetChanged();
                listSchools.requestLayout();
                skip = skip + jsonArray.length();
            }

            isDataLoaded = true;

        } catch (Exception e) {
            if (!isDataLoaded) {
                Dialog.showSimpleDialog(DashboardActivity.this, e.toString());

            }
            e.printStackTrace();
        }
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        final int lastItem = firstVisibleItem + visibleItemCount;
        if (lastItem == totalItemCount) {
            if (preLast != lastItem) {
                loadData();
                preLast = lastItem;
            }
        }
    }
}
