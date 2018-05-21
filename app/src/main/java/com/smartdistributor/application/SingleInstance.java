package com.smartdistributor.application;

import com.smartdistributor.model.CurrentBills;

public class SingleInstance {
    private static final SingleInstance ourInstance = new SingleInstance();

    public static SingleInstance getInstance() {
        return ourInstance;
    }

    private SingleInstance() {
    }

    private CurrentBills currentSelectedBill;

    public CurrentBills getCurrentSelectedBill() {
        return currentSelectedBill;
    }

    public void setCurrentSelectedBill(CurrentBills currentSelectedBill) {
        this.currentSelectedBill = currentSelectedBill;
    }
}
