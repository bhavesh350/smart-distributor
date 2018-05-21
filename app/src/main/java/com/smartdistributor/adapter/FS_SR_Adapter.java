package com.smartdistributor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdistributor.R;
import com.smartdistributor.RetailerDetailActivity;
import com.smartdistributor.model.CurrentBills;
import com.smartdistributor.model.FSRDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ-PC on 7/6/2017.
 */

public class FS_SR_Adapter extends RecyclerView.Adapter<FS_SR_Adapter.DataHolder> {

    private List<FSRDetail.Info> listdata;
    private LayoutInflater inflater;
    private ItemClickCallback itemclickcallback;
    private int count = 0;
    private Context context;
    private Integer Position;

    public interface ItemClickCallback {
        void onItemClick(int p);

        void onSecondaryIconClick(int p);

    }

    public void SetItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemclickcallback = itemClickCallback;
    }


    public FS_SR_Adapter(List<FSRDetail.Info> listdata, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listdata = listdata;
        this.context = c;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.fsr_sr_item, parent, false);
        return new DataHolder(view);

    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        FSRDetail.Info item = listdata.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1) + ".");
        holder.tv_item.setText(item.getProductName());
        holder.tv_mrp.setText(item.getMRP());
        holder.tv_billed_amt.setText(item.getQuantityBilled());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class DataHolder extends RecyclerView.ViewHolder {
        TextView tv_sr_no, tv_item, tv_mrp, tv_billed_amt;
        EditText edt_sr_quantity;
        LinearLayout lnr_fsr_item;

        public DataHolder(final View itemView) {
            super(itemView);

            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            tv_item = itemView.findViewById(R.id.tv_item);
            tv_mrp = itemView.findViewById(R.id.tv_mrp);
            tv_billed_amt = itemView.findViewById(R.id.tv_billed_amt);
            edt_sr_quantity = itemView.findViewById(R.id.edt_sr_quantity);

            lnr_fsr_item = itemView.findViewById(R.id.lnr_fsr_item);

            lnr_fsr_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Position:" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
