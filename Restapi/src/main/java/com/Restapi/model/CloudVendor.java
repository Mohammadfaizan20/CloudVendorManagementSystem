package com.Restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cloud_vendor_info")
public class CloudVendor {


    @Id
    private String vendorId;
    private String vendorName;
    private String vendorAdress;
    private String vendorPhoneNumber;

    public CloudVendor(String vendorId, String vendorName, String vendorAdress, String vendorPhoneNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAdress = vendorAdress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public CloudVendor() {
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAdress() {
        return vendorAdress;
    }

    public void setVendorAdress(String vendorAdress) {
        this.vendorAdress = vendorAdress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

//    @Override
//    public String toString() {
//        return "CloudVendor{" +
//                "vendorId='" + vendorId + '\'' +
//                ", vendorName='" + vendorName + '\'' +
//                ", vendorAdress='" + vendorAdress + '\'' +
//                ", vendorPhoneNumber='" + vendorPhoneNumber + '\'' +
//                '}';
//    }

}
