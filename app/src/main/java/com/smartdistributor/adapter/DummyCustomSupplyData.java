package com.smartdistributor.adapter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DummyCustomSupplyData {
    private static final String[] SrNo = {"01","02","03","04","05"};
    private static final String[] BillNo = {"116513","116513","116513","116513","116513"};
    private static final String[] RetailerName = {"Karan","Avanish","Ansh","Pankaj","Bhavesh"};
    private static final String[] NetAmmount = {"Rs. 5000","Rs. 5000","Rs. 5000","Rs. 5000","Rs. 5000"};
    private static final String[] Remarks = {"Good","Good","Good","Good","Good"};










    public static List<DummyCustomSupplyItem> getListData() {
        List<DummyCustomSupplyItem> data = new ArrayList<>();


            for (int x = 0; x < SrNo.length; x++) {
                DummyCustomSupplyItem item = new DummyCustomSupplyItem();
                item.setSrNo(SrNo[x]);
                item.setBillNo(BillNo[x]);
                item.setRetailerName(RetailerName[x]);
                item.setNetAmmount(NetAmmount[x]);
                item.setRemarks(Remarks[x]);




                data.add(item);
            }

        return (data);
    }

    public static DummyCustomSupplyItem getRandomListItem() {
        int rand = new Random().nextInt(5);

        DummyCustomSupplyItem item = new DummyCustomSupplyItem();

        item.setSrNo(SrNo[rand]);
        item.setBillNo(BillNo[rand]);
        item.setRetailerName(RetailerName[rand]);
        item.setNetAmmount(NetAmmount[rand]);
        item.setRemarks(Remarks[rand]);


        return item;
    }
}
