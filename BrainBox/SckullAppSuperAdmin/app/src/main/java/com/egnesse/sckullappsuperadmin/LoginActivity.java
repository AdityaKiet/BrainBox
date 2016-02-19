package com.egnesse.sckullappsuperadmin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.egnesse.sckullappsuperadmin.dto.LoginDTO;
import com.egnesse.sckullappsuperadmin.network.Login;
import com.egnesse.sckullappsuperadmin.ui.Dialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.etUserName)
    EditText etLogin;
    @Bind(R.id.etPassword)
    EditText etPassword;

    @OnClick(R.id.btnLogin)
    void login() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(etLogin.getText().toString());
        loginDTO.setPassword(etPassword.getText().toString());
        try {
            Login login = new Login();
            login.login(this, loginDTO);
        } catch (Exception e) {
            Dialog.showSimpleDialog(this, e.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (null != sharedPreferences.getString("session", null)) {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);
        }
    }
}
