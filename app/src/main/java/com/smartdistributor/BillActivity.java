package com.smartdistributor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smartdistributor.custome.CustomActivity;

public class BillActivity extends CustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }
}
