package com.smartdistributor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.smartdistributor.custome.CustomActivity;

public class AddBillActivity extends CustomActivity {
    private Toolbar toolbar;

    private EditText edt_bill_no;
    private RadioButton rd_btn_current_supply, rd_btn_temporary_bill, rd_btn_pending_bill, rd_btn_bounced_check;
    private Button btn_add_bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Add Bills");
        actionBar.setTitle("");
        setupUiElement();
    }

    private void setupUiElement() {
        setTouchNClick(R.id.btn_add_bill);

        edt_bill_no = findViewById(R.id.edt_bill_no);

        rd_btn_current_supply = findViewById(R.id.rd_btn_current_supply_bill);
        rd_btn_temporary_bill = findViewById(R.id.rd_btn_temporary_bill);
        rd_btn_pending_bill = findViewById(R.id.rd_btn_pending_bill);
        rd_btn_bounced_check = findViewById(R.id.rd_btn_bounced_check);

        btn_add_bill = findViewById(R.id.btn_add_bill);


    }
}
