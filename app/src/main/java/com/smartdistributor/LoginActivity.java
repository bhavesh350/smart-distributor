package com.smartdistributor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hbb20.CountryCodePicker;
import com.loopj.android.http.RequestParams;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.model.User;
import com.smartdistributor.utills.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class LoginActivity extends CustomActivity implements CustomActivity.ResponseCallback {
    private Toolbar toolbar;
    private EditText user_id, password;
    private TextView forgot_passwd;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Login");
        actionBar.setTitle("");
        setResponseListener(this);
        setupuiElement();
    }


    private void setupuiElement() {

        setTouchNClick(R.id.btn_login);
        setTouchNClick(R.id.tv_forgot_pass);


        user_id = (EditText) findViewById(R.id.edt_user_id);
        password = (EditText) findViewById(R.id.edt_password);
        Login = (Button) findViewById(R.id.btn_login);


        forgot_passwd = (TextView) findViewById(R.id.tv_forgot_pass);

        String htmlString = "<u>FORGOT PASSWORD ?</u>";
        forgot_passwd.setText(Html.fromHtml(htmlString));


    }


    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.tv_forgot_pass) {
            Toast.makeText(this, "Forgot_password", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_login) {
            if (TextUtils.isEmpty(user_id.getText().toString())) {
                user_id.setError("Enter Email Id");
                return;
            } else if (TextUtils.isEmpty(password.getText().toString())) {
                password.setError("Please Enter valid password");
            }
            employeeLogin();
        }

    }


    public void employeeLogin() {
        RequestParams p = new RequestParams();
        p.put("email",user_id.getText().toString());
        p.put("password",password.getText().toString());
        p.put("device_token", MyApp.getSharedPrefString(AppConstant.DEVICE_TOKEN).toString());
//        startActivity(new Intent(getContext(), Main2Activity.class));
        postCall(getContext(), AppConstant.BASE_URL+"fieldlogin",p, "Logging in...",1);
    }

    @Override
    public void onJsonObjectResponseReceived(JSONObject o, int callNumber) {
        if (callNumber == 1) {

            if (o.optString("status").equals("1")) {
                Type listType = new TypeToken<List<User.Info>>() {
                }.getType();

                try {
                    List<User.Info> u = new Gson().fromJson(o.getJSONArray("info").toString(), listType);
                    MyApp.getApplication().writeUser(u);
                    MyApp.setStatus(AppConstant.IS_LOGIN,true);
//                    finishAffinity();


                } catch (JSONException e) {
                    e.printStackTrace();
                    MyApp.popMessage("Alert!", "Parsing error.", getContext());
                } catch (JsonSyntaxException ee) {

                }


                startActivity(new Intent(getContext(), Main2Activity.class));
                finish();

            } else {
                MyApp.popMessage("Error", o.optString("message"), getContext());
            }
        }
    }

    @Override
    public void onJsonArrayResponseReceived(JSONArray a, int callNumber) {

    }

    @Override
    public void onErrorReceived(String error) {
        MyApp.popMessage("Error","Error ", getContext());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private Context getContext(){return LoginActivity.this;}
}
