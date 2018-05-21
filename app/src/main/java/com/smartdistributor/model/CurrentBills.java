package com.smartdistributor.model;

import java.io.Serializable;

/**
 * Created by dpand on 28-12-2017.
 */

public class CurrentBills implements Serializable {
    private static final long serialVersionUID = 12456541L;
    private String id;
    private String allocationNo;
    private String billNo;
    private String isAllocated;
    private String isPast;
    private String retailerName;
    private String billAmount;
    private String saleReturn;
    private String pastCollection;
    private String status_id;
    private String todayCollection;
    private String delivaryStatus;
    private String salesMan;
    private String retailerHierarchy;
    private String retailerCode;
    private String grossAmount;
    private String schemeDiscount;
    private String replacement;
    private String distributerDiscount;
    private String cashDiscount;
    private String windowDisplay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllocationNo() {
        return allocationNo;
    }

    public void setAllocationNo(String allocationNo) {
        this.allocationNo = allocationNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getIsAllocated() {
        return isAllocated;
    }

    public void setIsAllocated(String isAllocated) {
        this.isAllocated = isAllocated;
    }

    public String getIsPast() {
        return isPast;
    }

    public void setIsPast(String isPast) {
        this.isPast = isPast;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getSaleReturn() {
        return saleReturn;
    }

    public void setSaleReturn(String saleReturn) {
        this.saleReturn = saleReturn;
    }

    public String getPastCollection() {
        return pastCollection;
    }

    public void setPastCollection(String pastCollection) {
        this.pastCollection = pastCollection;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getTodayCollection() {
        return todayCollection;
    }

    public void setTodayCollection(String todayCollection) {
        this.todayCollection = todayCollection;
    }

    public String getDelivaryStatus() {
        return delivaryStatus;
    }

    public void setDelivaryStatus(String delivaryStatus) {
        this.delivaryStatus = delivaryStatus;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getRetailerHierarchy() {
        return retailerHierarchy;
    }

    public void setRetailerHierarchy(String retailerHierarchy) {
        this.retailerHierarchy = retailerHierarchy;
    }

    public String getRetailerCode() {
        return retailerCode;
    }

    public void setRetailerCode(String retailerCode) {
        this.retailerCode = retailerCode;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getSchemeDiscount() {
        return schemeDiscount;
    }

    public void setSchemeDiscount(String schemeDiscount) {
        this.schemeDiscount = schemeDiscount;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getDistributerDiscount() {
        return distributerDiscount;
    }

    public void setDistributerDiscount(String distributerDiscount) {
        this.distributerDiscount = distributerDiscount;
    }

    public String getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(String cashDiscount) {
        this.cashDiscount = cashDiscount;
    }

    public String getWindowDisplay() {
        return windowDisplay;
    }

    public void setWindowDisplay(String windowDisplay) {
        this.windowDisplay = windowDisplay;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getDebitAdjust() {
        return debitAdjust;
    }

    public void setDebitAdjust(String debitAdjust) {
        this.debitAdjust = debitAdjust;
    }

    public String getTaxAdjust() {
        return taxAdjust;
    }

    public void setTaxAdjust(String taxAdjust) {
        this.taxAdjust = taxAdjust;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }





    private String taxAmount;
    private String debitAdjust;
    private String taxAdjust;
    private String netAmount;
    private String created_at;
    private String updated_at;



}
