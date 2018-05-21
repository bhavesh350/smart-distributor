package com.smartdistributor;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.smartdistributor.application.MyApp;
import com.smartdistributor.application.SingleInstance;
import com.smartdistributor.custome.CustomActivity;
import com.smartdistributor.model.CurrentBills;
import com.smartdistributor.model.FSRDetail;
import com.smartdistributor.utills.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class RetailerDetailActivity extends CustomActivity implements CustomActivity.ResponseCallback {
    private Toolbar toolbar;
    private TextView tv_bill_no, tv_payout_bill;
    private TextView tv_retailer_name, tv_restricted_outlet;
    private TextView tv_net_amt, tv_noncash_outlet;
    private TextView tv_category;

    private Button btn_sr_fsr, btn_resend;
    private Button btn_bill, btn_cash, btn_cheque;
//    private Integer position;
    private String category;
    private String cash;
    EditText edt_amt_cash, edt_amt_cheque;
    private CurrentBills currentBill;

    //  final EditText edt_amt_cheque
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_detail);
        currentBill = SingleInstance.getInstance().getCurrentSelectedBill();
        setResponseListener(this);
        Intent intent = getIntent();
//        position = intent.getIntExtra("position", 0);
        category = intent.getStringExtra("category");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Retailer Details");
        actionBar.setTitle("");

        setupUiElement();
    }

    private void setupUiElement() {

        setTouchNClick(R.id.btn_sr_fsr);
        setTouchNClick(R.id.btn_resend);
        setTouchNClick(R.id.btn_bill);
        setTouchNClick(R.id.btn_cash);
        setTouchNClick(R.id.btn_cheque);


        tv_bill_no = findViewById(R.id.tv_bill_no);
        tv_payout_bill = findViewById(R.id.tv_payout_bill);
        tv_retailer_name = findViewById(R.id.tv_retailer_name);
        tv_restricted_outlet = findViewById(R.id.tv_restricted_outlet);
        tv_net_amt = findViewById(R.id.tv_net_amt);
        tv_noncash_outlet = findViewById(R.id.tv_noncash_outlet);
        tv_category = findViewById(R.id.tv_category);

        btn_sr_fsr = findViewById(R.id.btn_sr_fsr);
        btn_resend = findViewById(R.id.btn_resend);

        btn_bill = findViewById(R.id.btn_bill);
        btn_cash = findViewById(R.id.btn_cash);
        btn_cheque = findViewById(R.id.btn_cheque);


//        tv_bill_no.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getBillNo());
        tv_bill_no.setText("NS181912");
        tv_retailer_name.setText("Retailer 1");
//        tv_retailer_name.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getRetailerName());
        tv_net_amt.setText("1524");
//        tv_net_amt.setText(MyApp.getApplication().readBill().getCurrent_bills().get(position).getNetAmount());
        tv_category.setText(category);
    }


    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_sr_fsr) {
            fsrDetail();
        } else if (v.getId() == R.id.btn_resend) {
            Toast.makeText(this, "Under Testing", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_add_bill) {
            startActivity(new Intent(RetailerDetailActivity.this, AddBillActivity.class));
        } else if (v.getId() == R.id.btn_cash) {
            cashDialog();
        } else if (v.getId() == R.id.btn_cheque) {
            chequeDialog();
        }
    }

    private void chequeDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cheque_dialog);
        edt_amt_cheque = dialog.findViewById(R.id.edt_amt_cheque);

        edt_amt_cheque.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                edt_amt_cheque.post(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager) dialog.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(edt_amt_cheque, InputMethodManager.SHOW_IMPLICIT);
                    }
                });
            }
        });
        edt_amt_cheque.requestFocus();

        edt_amt_cheque.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (edt_amt_cheque.getText().toString().isEmpty()) {
                        return false;
                    } else {
                        chequeCollection();
                        dialog.dismiss();
                        return true;
                    }

                }
                // Return true if you have consumed the action, else false.
                return false;
            }
        });
        final ImageButton img_cheque_btn_cancel = dialog.findViewById(R.id.img_cheque_btn_cancel);

        TextView tv_btn_submit = dialog.findViewById(R.id.tv_btn_submit);
        tv_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edt_amt_cheque.getText().toString())) {
                    edt_amt_cheque.setError("Enter Amount");
                    return;
                }
                chequeCollection();
                dialog.dismiss();
            }
        });

        img_cheque_btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    private void cashDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cash_dialog);
        edt_amt_cash = dialog.findViewById(R.id.edt_amt_cash);

        edt_amt_cash.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                edt_amt_cash.post(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager) dialog.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(edt_amt_cash, InputMethodManager.SHOW_IMPLICIT);
                    }
                });
            }
        });
        edt_amt_cash.requestFocus();

//        InputMethodManager imm = (InputMethodManager) dialog.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(edt_amt_cash, InputMethodManager.SHOW_IMPLICIT);

        edt_amt_cash.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (edt_amt_cash.getText().toString().isEmpty()) {
                        return false;
                    } else {
                        cashCollection();
                        dialog.dismiss();
                        return true;
                    }

                }
                // Return true if you have consumed the action, else false.
                return false;
            }
        });

        final ImageButton img_btn_cancel = dialog.findViewById(R.id.img_btn_cancel);
        TextView tv_btn_submit_cash = dialog.findViewById(R.id.tv_btn_submit_cash);
        cash = edt_amt_cash.getText().toString();
        tv_btn_submit_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edt_amt_cash.getText().toString())) {
                    edt_amt_cash.setError("Enter Amount");
                    return;
                }
                cashCollection();
                dialog.dismiss();
            }
        });
        img_btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void chequeCollection() {
        finish();
//        RequestParams p = new RequestParams();
//        p.put("user_id", MyApp.getApplication().readUser().get(0).getId());
//        p.put("bill_id", MyApp.getApplication().readBill().getCurrent_bills().get(position).getId());
//        p.put("retailer_name", MyApp.getApplication().readBill().getCurrent_bills().get(position).getRetailerName());
//        p.put("billno", MyApp.getApplication().readBill().getCurrent_bills().get(position).getBillNo());
//        p.put("allocationNo", MyApp.getApplication().readBill().getCurrent_bills().get(position).getAllocationNo());
//        p.put("amount", edt_amt_cheque.getText().toString());
//        MyApp.showMassage(getContext(), "Cheque collected");
//        postCall(getContext(), AppConstant.BASE_URL + "check-register", p, "", 3);

    }


    private void cashCollection() {

        finish();
//        RequestParams p = new RequestParams();
//        p.put("bill_id", MyApp.getApplication().readBill().getCurrent_bills().get(position).getId());
//        p.put("user_id", MyApp.getApplication().readUser().get(0).getId());
//        p.put("amount", edt_amt_cash.getText().toString());
//        MyApp.showMassage(getContext(), "Cash Collected");
//        postCall(getContext(), AppConstant.BASE_URL + "cash-collection", p, "", 2);

    }


    public void fsrDetail() {
        Intent intent = new Intent(getContext(), FSRActivity.class);
//                intent.putExtra("position", position);
        intent.putExtra("category", category);
        startActivity(intent);
//        RequestParams p = new RequestParams();
//        p.put("billno", MyApp.getApplication().readBill().getCurrent_bills().get(position).getBillNo());
//        postCall(getContext(), AppConstant.BASE_URL + "bill-product", p, "Fetching Detail...", 1);
    }


    @Override
    public void onJsonObjectResponseReceived(JSONObject o, int callNumber) {
        if (callNumber == 1) {

            if (o.optString("status").equals("1")) {
                Type listType = new TypeToken<List<FSRDetail.Info>>() {
                }.getType();

                try {
                    List<FSRDetail.Info> u = new Gson().fromJson(o.getJSONArray("info").toString(), listType);
                    MyApp.getApplication().writeFSR(u);
                } catch (JSONException e) {
                    e.printStackTrace();
                    MyApp.popMessage("Alert!", "Parsing error.", getContext());
                } catch (JsonSyntaxException ee) {

                }

                Intent intent = new Intent(getContext(), FSRActivity.class);
//                intent.putExtra("position", position);
                intent.putExtra("category", category);
                startActivity(intent);

            } else {
                MyApp.popMessage("Error", o.optString("message"), getContext());
            }
        } else if (callNumber == 2) {
            if (o.optString("status").equals("1")) {
                MyApp.popMessage("Success", o.optString("message"), getContext());
            } else {
                MyApp.popMessage("Success", o.optString("message"), getContext());
            }
        } else if (callNumber == 3) {
            if (o.optString("status").equals("1")) {
                MyApp.popMessage("Success", o.optString("message"), getContext());
            } else {
                MyApp.popMessage("Success", o.optString("message"), getContext());
            }
        }
    }

    @Override
    public void onJsonArrayResponseReceived(JSONArray a, int callNumber) {

    }

    @Override
    public void onErrorReceived(String error) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }

    private Context getContext() {
        return RetailerDetailActivity.this;
    }
}
