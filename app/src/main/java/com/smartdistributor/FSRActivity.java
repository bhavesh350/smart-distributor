package com.smartdistributor;

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
import com.smartdistributor.adapter.DummyCustomSupplyData;
import com.smartdistributor.adapter.DummyFSSRSupplyData;
import com.smartdistributor.adapter.FS_SR_Adapter;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.model.Bill;
import com.smartdistributor.model.FSRDetail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FSRActivity extends CustomActivity {
    private Toolbar toolbar;
    private TextView tv_bill_no, tv_payout_bill;
    private TextView tv_retailer_name, tv_restricted_outlet;
    private TextView tv_net_amt, tv_noncash_outlet;
    private TextView tv_category;

    private Button btn_fsr, btn_ssr;

    private RecyclerView recy_sale_return;
    private ArrayList arrayList;
    private FS_SR_Adapter adapter;
    private Integer position;
    private String category;
    private Method method;
    private List<FSRDetail.Info> fsrlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fsr);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        category = intent.getStringExtra("category");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("SR / FSR");
        actionBar.setTitle("");
        setupUiElement();
    }

    private void setupUiElement() {

        setTouchNClick(R.id.btn_fsr);
        setTouchNClick(R.id.btn_ssr);


        tv_bill_no = findViewById(R.id.tv_bill_no);
        tv_payout_bill = findViewById(R.id.tv_payout_bill);
        tv_retailer_name = findViewById(R.id.tv_retailer_name);
        tv_restricted_outlet = findViewById(R.id.tv_restricted_outlet);
        tv_net_amt = findViewById(R.id.tv_net_amt);
        tv_noncash_outlet = findViewById(R.id.tv_noncash_outlet);
        tv_category = findViewById(R.id.tv_category);

        recy_sale_return = findViewById(R.id.recy_sale_return);
        fsrlist = MyApp.getApplication().readFSR();
        recy_sale_return.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FS_SR_Adapter(fsrlist, this);
        recy_sale_return.setAdapter(adapter);
        recy_sale_return.setNestedScrollingEnabled(false);
        tv_bill_no.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getBillNo());
        tv_retailer_name.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getRetailerName());
        tv_net_amt.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getNetAmount());
        tv_category.setText(category);
        btn_fsr =  findViewById(R.id.btn_fsr);
        btn_ssr = findViewById(R.id.btn_ssr);

       /* recycler_list_view.setLayoutManager(new LinearLayoutManager(this));
        userlist = MyApp.getApplication().readUserList();
        adapter = new HotelListAdapter(userlist, this);
        recycler_list_view.setAdapter(adapter);*/

    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_fsr) {
            Toast.makeText(this, "Under Progress", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_ssr) {
            Toast.makeText(this, "Under Progress", Toast.LENGTH_SHORT).show();
        }
    }
}
