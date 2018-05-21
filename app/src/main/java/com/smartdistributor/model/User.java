package com.smartdistributor.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SONI on 8/28/2017.
 */

public class User implements Serializable {
    private static final long serialVersionUID = 12456541L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    private String status;
    private String message;
    private List<Info> info;

    public class Info implements Serializable {
        private static final long serialVersionUID = 12456541L;
        private String id;
        private String name;
        private String image;
        private String email;
        private String fatherName;
        private String mobileNo;
        private String localAddress;
        private String permanentAddress;
        private String idProofName;
        private String idProofNo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getLocalAddress() {
            return localAddress;
        }

        public void setLocalAddress(String localAddress) {
            this.localAddress = localAddress;
        }

        public String getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        public String getIdProofName() {
            return idProofName;
        }

        public void setIdProofName(String idProofName) {
            this.idProofName = idProofName;
        }

        public String getIdProofNo() {
            return idProofNo;
        }

        public void setIdProofNo(String idProofNo) {
            this.idProofNo = idProofNo;
        }

        public String getIdProofImage() {
            return idProofImage;
        }

        public void setIdProofImage(String idProofImage) {
            this.idProofImage = idProofImage;
        }

        public String getAddressProofName() {
            return addressProofName;
        }

        public void setAddressProofName(String addressProofName) {
            this.addressProofName = addressProofName;
        }

        public String getAddressProofNo() {
            return addressProofNo;
        }

        public void setAddressProofNo(String addressProofNo) {
            this.addressProofNo = addressProofNo;
        }

        public String getAddressProofImage() {
            return addressProofImage;
        }

        public void setAddressProofImage(String addressProofImage) {
            this.addressProofImage = addressProofImage;
        }

        public String getDateOfJoining() {
            return dateOfJoining;
        }

        public void setDateOfJoining(String dateOfJoining) {
            this.dateOfJoining = dateOfJoining;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getOtherPerk() {
            return otherPerk;
        }

        public void setOtherPerk(String otherPerk) {
            this.otherPerk = otherPerk;
        }

        public String getPoliceVerification() {
            return policeVerification;
        }

        public void setPoliceVerification(String policeVerification) {
            this.policeVerification = policeVerification;
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

        public String getDevice_token() {
            return device_token;
        }

        public void setDevice_token(String device_token) {
            this.device_token = device_token;
        }

        private String idProofImage;
        private String addressProofName;
        private String addressProofNo;
        private String addressProofImage;
        private String dateOfJoining;
        private String salary;
        private String otherPerk;
        private String policeVerification;
        private String created_at;
        private String updated_at;
        private String device_token;
    }


}
