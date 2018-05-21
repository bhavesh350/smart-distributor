package com.smartdistributor.adapter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DummyFSSRSupplyData {

    private static final String[] ItemName = {"Single Maggi","Tomato Ketchup","Tomato Ketchup","Nescafe 200 gm","Nescafe 200 gm"};
    private static final String[] MRP = {"12","145","145","450","450"};
    private static final String[] BilledAmount = {"480","1200","1200","2000","2000"};











    public static List<DummyFSSRItem> getListData() {
        List<DummyFSSRItem> data = new ArrayList<>();


            for (int x = 0; x < ItemName.length; x++) {
                DummyFSSRItem item = new DummyFSSRItem();
                item.setItemName(ItemName[x]);
                item.setMRP(MRP[x]);
                item.setBilledAmount(BilledAmount[x]);





                data.add(item);
            }

        return (data);
    }

    public static DummyFSSRItem getRandomListItem() {
        int rand = new Random().nextInt(5);

        DummyFSSRItem item = new DummyFSSRItem();

        item.setItemName(ItemName[rand]);
        item.setMRP(MRP[rand]);
        item.setBilledAmount(BilledAmount[rand]);


        return item;
    }
}
