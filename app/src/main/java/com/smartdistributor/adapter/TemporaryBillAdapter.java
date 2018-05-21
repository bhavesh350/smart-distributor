package com.smartdistributor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartdistributor.R;
import com.smartdistributor.RetailerDetailActivity;
import com.smartdistributor.model.CurrentBills;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ-PC on 7/6/2017.
 */

public class TemporaryBillAdapter extends RecyclerView.Adapter<TemporaryBillAdapter.DataHolder> {

    private List<CurrentBills> listdata;//tu h to gandu
    private LayoutInflater inflater;
    private ItemClickCallback itemclickcallback;
    private int count = 0;
    private Context context;

    public interface ItemClickCallback {
        void onItemClick(int p);

        void onSecondaryIconClick(int p);

    }

    public void SetItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemclickcallback = itemClickCallback;
    }


    public TemporaryBillAdapter(List<CurrentBills> listdata, Context c) {
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
        holder.tv_sr_no.setText(String.valueOf(position + 1) + ".");
        holder.tv_bill_no.setText(item.getBillNo());
        holder.tv_ret_name.setText(item.getRetailerName());
        holder.tv_net_amt.setText(item.getNetAmount());
        holder.tv_remarks.setText("Good");

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class DataHolder extends RecyclerView.ViewHolder {
        TextView tv_sr_no, tv_bill_no, tv_ret_name, tv_net_amt, tv_remarks;
        LinearLayout lnr_current_supply_item;

        public DataHolder(final View itemView) {
            super(itemView);


            tv_sr_no = (TextView) itemView.findViewById(R.id.tv_sr_no);
            tv_bill_no = (TextView) itemView.findViewById(R.id.tv_bill_no);
            tv_ret_name = (TextView) itemView.findViewById(R.id.tv_ret_name);
            tv_net_amt = (TextView) itemView.findViewById(R.id.tv_net_amt);
            tv_remarks = (TextView) itemView.findViewById(R.id.tv_remarks);

            lnr_current_supply_item = (LinearLayout) itemView.findViewById(R.id.lnr_current_supply_item);

            lnr_current_supply_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, RetailerDetailActivity.class));
                }
            });
        }


    }

    public void setListData(ArrayList<CurrentBills> exerciseList) {
        this.listdata.clear();
        this.listdata.addAll(exerciseList);

    }
}
