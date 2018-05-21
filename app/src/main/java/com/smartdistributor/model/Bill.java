package com.smartdistributor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONI on 8/28/2017.
 */

public class Bill implements Serializable {
    private static final long serialVersionUID = 1245644541L; // ye keys hamesha alag rakho


    private List<CurrentBills> current_bills = new ArrayList<>();
    private List<CurrentBills> past_bills = new ArrayList<>();

    public List<CurrentBills> getCurrent_bills() {
        return current_bills;
    }

    public void setCurrent_bills(List<CurrentBills> current_bills) {
        this.current_bills = current_bills;
    }

    public List<CurrentBills> getPast_bills() {
        return past_bills;
    }

    public void setPast_bills(List<CurrentBills> past_bills) {
        this.past_bills = past_bills;
    }

}
