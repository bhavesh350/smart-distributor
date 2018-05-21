package com.smartdistributor.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SONI on 8/28/2017.
 */

public class FSRDetail implements Serializable {
    private static final long serialVersionUID = 12456541L;
    private String status;
    private String message;
    private List<Info> info;

    public class Info implements Serializable {
        private static final long serialVersionUID = 1234556541L;
        private String id;
        private String salesMan;
        private String retailerHierarchy;
        private String retailerCode;
        private String  retailerName;
        private String  Address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getRetailerName() {
            return retailerName;
        }

        public void setRetailerName(String retailerName) {
            this.retailerName = retailerName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String getSalesInvoiceNumber() {
            return salesInvoiceNumber;
        }

        public void setSalesInvoiceNumber(String salesInvoiceNumber) {
            this.salesInvoiceNumber = salesInvoiceNumber;
        }

        public String getSalesInvoiceDate() {
            return salesInvoiceDate;
        }

        public void setSalesInvoiceDate(String salesInvoiceDate) {
            this.salesInvoiceDate = salesInvoiceDate;
        }

        public String getActualDeliveryDate() {
            return actualDeliveryDate;
        }

        public void setActualDeliveryDate(String actualDeliveryDate) {
            this.actualDeliveryDate = actualDeliveryDate;
        }

        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

        public String getBrandCaption() {
            return brandCaption;
        }

        public void setBrandCaption(String brandCaption) {
            this.brandCaption = brandCaption;
        }

        public String getDistProductCode() {
            return distProductCode;
        }

        public void setDistProductCode(String distProductCode) {
            this.distProductCode = distProductCode;
        }

        public String getMotherPackName() {
            return motherPackName;
        }

        public void setMotherPackName(String motherPackName) {
            this.motherPackName = motherPackName;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getBatch() {
            return Batch;
        }

        public void setBatch(String batch) {
            Batch = batch;
        }

        public String getMRP() {
            return MRP;
        }

        public void setMRP(String MRP) {
            this.MRP = MRP;
        }

        public String getSellingRate() {
            return sellingRate;
        }

        public void setSellingRate(String sellingRate) {
            this.sellingRate = sellingRate;
        }

        public String getQuantityBilled() {
            return quantityBilled;
        }

        public void setQuantityBilled(String quantityBilled) {
            this.quantityBilled = quantityBilled;
        }

        public String getGrossAmount() {
            return grossAmount;
        }

        public void setGrossAmount(String grossAmount) {
            this.grossAmount = grossAmount;
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

        private String  salesInvoiceNumber;
        private String  salesInvoiceDate;
        private String actualDeliveryDate;
        private String deliveryStatus;
        private String brandCaption;
        private String  distProductCode;
        private String motherPackName;
        private String  productName;
        private String Batch;
        private String  MRP;
        private String sellingRate;
        private String  quantityBilled;
        private String grossAmount;
        private String  netAmount;
        private String  created_at;
        private String updated_at;
    }


}
