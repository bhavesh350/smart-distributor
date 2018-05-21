package com.smartdistributor.adapter;

/**
 * Created by DJ-PC on 5/6/2017.
 */

public class DummyFSSRItem {


    private String ItemName;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getMRP() {
        return MRP;
    }

    public void setMRP(String MRP) {
        this.MRP = MRP;
    }

    public String getBilledAmount() {
        return BilledAmount;
    }

    public void setBilledAmount(String billedAmount) {
        BilledAmount = billedAmount;
    }

    private String MRP;
    private String BilledAmount;


}
