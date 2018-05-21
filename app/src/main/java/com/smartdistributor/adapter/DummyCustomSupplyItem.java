package com.smartdistributor.adapter;

/**
 * Created by DJ-PC on 5/6/2017.
 */

public class DummyCustomSupplyItem {

    private String SrNo;

    public String getSrNo() {
        return SrNo;
    }

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public String getBillNo() {
        return BillNo;
    }

    public void setBillNo(String billNo) {
        BillNo = billNo;
    }

    public String getRetailerName() {
        return RetailerName;
    }

    public void setRetailerName(String retailerName) {
        RetailerName = retailerName;
    }

    public String getNetAmmount() {
        return NetAmmount;
    }

    public void setNetAmmount(String netAmmount) {
        NetAmmount = netAmmount;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    private String BillNo;
    private String RetailerName;
    private String NetAmmount;
    private String Remarks;


}
