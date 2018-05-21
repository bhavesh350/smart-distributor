package com.smartdistributor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.smartdistributor.Main2Activity;
import com.smartdistributor.R;
import com.smartdistributor.RetailerDetailActivity;
import com.smartdistributor.application.SingleInstance;
import com.smartdistributor.model.Bill;
import com.smartdistributor.model.CurrentBills;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ-PC on 7/6/2017.
 */

public class CustomSupplyAdapter extends RecyclerView.Adapter<CustomSupplyAdapter.DataHolder> {

    private List<CurrentBills> listdata;
    private LayoutInflater inflater;
    private Context context;
    private Integer Position;

    public CustomSupplyAdapter(List<CurrentBills> listdata, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listdata = listdata;
        this.context = c;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.current_supply_item, parent, false);
        return new DataHolder(view);

    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        CurrentBills item = listdata.get(position);
        holder.tv_bill_no.setText(/*Html.fromHtml("<font color=\"#999999\">" + "Bill no. - " + "</font>"
                + */item.getBillNo());

        holder.tv_sr_no.setText(String.valueOf(position + 1) + ".");
//        holder.tv_bill_no.setText("Bill no. - " + item.getBillNo());
        holder.tv_ret_name.setText(/*Html.fromHtml("<font color=\"#999999\">" + "Retailer Name\n" + "</font>"
                + */item.getRetailerName());
        holder.tv_net_amt.setText(context.getString(R.string.rupee) + " " + item.getNetAmount());
        holder.tv_remarks.setText(Html.fromHtml("<font color=\"#999999\">" + "Remark :" + "</font>"
                + " P"));

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class DataHolder extends RecyclerView.ViewHolder {
        TextView tv_sr_no, tv_bill_no, tv_ret_name, tv_net_amt, tv_remarks;
        RelativeLayout lnr_current_supply_item;

        public DataHolder(final View itemView) {
            super(itemView);

            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            tv_bill_no = itemView.findViewById(R.id.tv_bill_no);
            tv_ret_name = itemView.findViewById(R.id.tv_ret_name);
            tv_net_amt = itemView.findViewById(R.id.tv_net_amt);
            tv_remarks = itemView.findViewById(R.id.tv_remarks);

            lnr_current_supply_item = itemView.findViewById(R.id.lnr_current_supply_item);

            lnr_current_supply_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((Main2Activity)context).immediateAppointment( getLayoutPosition());
                    // Toast.makeText(context, "Position:"+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Position = getLayoutPosition();
                    SingleInstance.getInstance().setCurrentSelectedBill(listdata.get(getLayoutPosition()));
                    Intent intent = new Intent(context, RetailerDetailActivity.class);
                    intent.putExtra("position", Position);
                    intent.putExtra("category", "Current Supply Bills");
                    context.startActivity(intent);
                }
            });
        }


    }

}
