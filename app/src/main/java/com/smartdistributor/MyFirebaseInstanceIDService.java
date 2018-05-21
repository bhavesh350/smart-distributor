package com.smartdistributor;

import android.util.Log;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.utills.AppConstant;

import static android.content.ContentValues.TAG;

/**
 * Created by Aquad on 21-07-2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        MyApp.setSharedPrefString(AppConstant.DEVICE_TOKEN, refreshedToken);
    }
}
