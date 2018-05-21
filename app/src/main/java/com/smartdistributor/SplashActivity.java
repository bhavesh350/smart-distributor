package com.smartdistributor;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.Base64;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.utills.AppConstant;

public class SplashActivity extends CustomActivity {
    private static final int SPLASH_DURATION_MS = 500;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

/*
    String device= MyApp.getSharedPrefString(AppConstant.DEVICE_TOKEN);

        Toast.makeText(this, "Token: "+device, Toast.LENGTH_SHORT).show();*/
        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                if(MyApp.getStatus(AppConstant.IS_LOGIN)){
                    startActivity(new Intent(getContext(), Main2Activity.class));
                    finish();
                }else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    finish();
                }
            }
        }, SPLASH_DURATION_MS);
    }
    private Context getContext(){return SplashActivity.this;}
}
