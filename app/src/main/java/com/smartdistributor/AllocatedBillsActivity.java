package com.smartdistributor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.smartdistributor.adapter.CustomSupplyAdapter;
import com.smartdistributor.adapter.PendingBillsAdapter;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.model.CurrentBills;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AllocatedBillsActivity extends CustomActivity {
    private Toolbar toolbar;
    private RecyclerView recy_current_supply, recy_bounced_cheque, recy_pending_bills, recy_temp_bills;
    private TextView tv_total_bill, beat_label, login_label;
    private TextView tv_alloc_bill, tv_credit, tv_cash;
    private TextView tv_cheque, tv_sf_fsr, tv_resend;
    private Button btn_add_bill, btn_finalize;

    private CustomSupplyAdapter customSupplyAdapter;
    private List<CurrentBills> currentBills = new ArrayList<>();

    private PendingBillsAdapter pendingBillsAdapter;
    private List<CurrentBills> pastBills = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocated_bills);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView mTitle =  toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Allocated Bills");
        actionBar.setTitle("");
        setupUiElement();
    }

    private void setupUiElement() {

        setTouchNClick(R.id.btn_add_bill);
        setTouchNClick(R.id.btn_finalize);

        recy_current_supply = findViewById(R.id.recy_current_supply);
        currentBills.addAll(loadData());
        currentBills = MyApp.getApplication().readBill().getCurrent_bills();
//        JsonArray arr = new JsonArray();
//        for (int i = 0; i <currentBills.size() ; i++) {
//            arr.add(currentBills.get(i));
//        }
        recy_current_supply.setLayoutManager(new LinearLayoutManager(this));
        recy_current_supply.setNestedScrollingEnabled(false);
        customSupplyAdapter = new CustomSupplyAdapter(currentBills, this);
        recy_current_supply.setAdapter(customSupplyAdapter);

        recy_bounced_cheque = findViewById(R.id.recy_bounced_cheque);

        recy_pending_bills = findViewById(R.id.recy_pending_bills);
        pastBills = MyApp.getApplication().readBill().getPast_bills();
        recy_pending_bills.setLayoutManager(new LinearLayoutManager(this));
        recy_pending_bills.setNestedScrollingEnabled(false);
        pendingBillsAdapter = new PendingBillsAdapter(pastBills, this);
        recy_pending_bills.setAdapter(pendingBillsAdapter);


        recy_temp_bills = findViewById(R.id.recy_temp_bills);


        tv_total_bill =  findViewById(R.id.tv_total_bill);

//        beat_label =  findViewById(R.id.beat_label);
//        login_label =  findViewById(R.id.login_label);

        tv_alloc_bill =  findViewById(R.id.tv_alloc_bill);
        tv_credit =  findViewById(R.id.tv_credit);
        tv_cash =  findViewById(R.id.tv_cash);

        tv_cheque =  findViewById(R.id.tv_cheque);
        tv_sf_fsr =  findViewById(R.id.tv_sf_fsr);
        tv_resend =  findViewById(R.id.tv_resend);


        btn_add_bill = findViewById(R.id.btn_add_bill);
        btn_finalize = findViewById(R.id.btn_finalize);

//        login_label.setText("Logged in As " + MyApp.getApplication().readUser().get(0).getName().toString());

    }

    private List<CurrentBills> loadData() {
        List<CurrentBills> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            CurrentBills c = new CurrentBills();
            c.setBillNo("NS181912"+(i+1));
            c.setRetailerName("Store name "+(i+1));
            c.setNetAmount("150"+(i*7));
            list.add(c);
        }
        return list;
    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_add_bill) {
            startActivity(new Intent(getContext(), AddBillActivity.class));
        } else if (v.getId() == R.id.btn_finalize) {
            startActivity(new Intent(getContext(), FinalizeSyncActivity.class));
        }
    }

    private Context getContext() {
        return AllocatedBillsActivity.this;
    }
}
