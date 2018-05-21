package com.smartdistributor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdistributor.adapter.CustomSupplyAdapter;
import com.smartdistributor.adapter.PendingBillsAdapter;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;

public class EmployeeProfileActivity extends CustomActivity {
    private Toolbar toolbar;
    private TextView tv_name,tv_email, tv_father_name, tv_mb_no, tv_address, tv_join_date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Employee Profile");
        actionBar.setTitle("");
        setupUiElement();
    }


    private void setupUiElement() {

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_father_name = (TextView) findViewById(R.id.tv_father_name);

        tv_mb_no = (TextView) findViewById(R.id.tv_mb_no);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_join_date = (TextView) findViewById(R.id.tv_join_date);

        tv_name.setText("Name : "+MyApp.getApplication().readUser().get(0).getName());
        tv_email.setText("Email : "+MyApp.getApplication().readUser().get(0).getEmail());
        tv_father_name.setText("Father Name : "+MyApp.getApplication().readUser().get(0).getFatherName());
        tv_mb_no.setText("Mobile No : "+MyApp.getApplication().readUser().get(0).getMobileNo());
        tv_address.setText("Address : "+MyApp.getApplication().readUser().get(0).getLocalAddress());
        tv_join_date.setText("Joining Date : "+MyApp.getApplication().readUser().get(0).getDateOfJoining());

    }

    private Context getContext() {return EmployeeProfileActivity.this;}

}
