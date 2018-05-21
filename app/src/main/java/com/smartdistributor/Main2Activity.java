package com.smartdistributor;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.model.Bill;
import com.smartdistributor.model.User;
import com.smartdistributor.utills.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Main2Activity extends CustomActivity
        implements NavigationView.OnNavigationItemSelectedListener, CustomActivity.ResponseCallback {
    private Toolbar toolbar;
    private TextView Allocated_bills, Resend_bills, Emp_profile;
    private Button logout;
    private TextView label;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Device Token:", MyApp.getSharedPrefString(AppConstant.DEVICE_TOKEN));
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Smart Distributor");
        actionBar.setTitle("");
        setResponseListener(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupuiElement();
    }


    private void setupuiElement() {
        setTouchNClick(R.id.tv_alloc_bills);
        setTouchNClick(R.id.tv_resend_bill);
        setTouchNClick(R.id.tv_emp_profile);
        setTouchNClick(R.id.btn_logout);


        Allocated_bills = findViewById(R.id.tv_alloc_bills);
        Resend_bills = findViewById(R.id.tv_resend_bill);
        Emp_profile = findViewById(R.id.tv_emp_profile);
        label = findViewById(R.id.label);
        label.setText("LOGGED IN AS Test user" /*+ MyApp.getApplication().readUser().get(0).getName().toString()*/);
        logout = findViewById(R.id.btn_logout);

        audioManager =
                (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    }

    public void onClick(View v) {

        super.onClick(v);
        if (v.getId() == R.id.tv_alloc_bills) {
            audioManager.playSoundEffect(SoundEffectConstants.CLICK);
            getBills();
        } else if (v.getId() == R.id.tv_resend_bill) {
            audioManager.playSoundEffect(SoundEffectConstants.CLICK);
            Toast.makeText(this, "Design Under Process", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.tv_emp_profile) {
            audioManager.playSoundEffect(SoundEffectConstants.CLICK);
            startActivity(new Intent(getContext(), EmployeeProfileActivity.class));
        } else if (v.getId() == R.id.btn_logout) {
            MyApp.setStatus(AppConstant.IS_LOGIN, false);
            finishAffinity();
        }

    }

    private boolean isScreenPassed = false;

    private void getBills() {
//        startActivity(new Intent(getContext(), AllocatedBillsActivity.class));
        if (MyApp.getApplication().readBill().getCurrent_bills().size() > 0) {
            startActivity(new Intent(getContext(), AllocatedBillsActivity.class));
            isScreenPassed = true;
            RequestParams p = new RequestParams();
            p.put("staff_id", MyApp.getApplication().readUser().get(0).getId());
            postCall(getContext(), AppConstant.BASE_URL + "current-allocation-by-date", p, "", 1);
        } else {
            RequestParams p = new RequestParams();
            p.put("staff_id", MyApp.getApplication().readUser().get(0).getId());
            postCall(getContext(), AppConstant.BASE_URL + "current-allocation-by-date", p, "Fetching Data....", 1);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onJsonObjectResponseReceived(JSONObject o, int callNumber) {
        if (callNumber == 1) {
            if (o.optString("status").equals("1")) {
                Bill u = null;
                try {//arrey wo staff id ka confirm karna tha avanish se ki email id send hogi ya ya sirf id kyon k login
                    //response me staff-id jaisa kuch nahi hai
                    u = new Gson().fromJson(o.getJSONObject("info").toString(), Bill.class);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyApp.getApplication().writeBill(u);
                if (!isScreenPassed)
                    startActivity(new Intent(getContext(), AllocatedBillsActivity.class));
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
        MyApp.popMessage("Error", "Parsing Error", getContext());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private Context getContext() {
        return Main2Activity.this;
    }
}
