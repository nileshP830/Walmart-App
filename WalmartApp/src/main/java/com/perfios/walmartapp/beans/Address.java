package com.perfios.walmartapp.beans;

public class Address {
    private String customerName;
    private String mobileNumber;
    private int pincode;
    private String State;
    private String city;
    private String buildingName;
    private String area;

    public Address() {
    }

    public Address(String customerName, String mobileNumber, int pincode, String state, String city, String buildingName, String area) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.pincode = pincode;
        State = state;
        this.city = city;
        this.buildingName = buildingName;
        this.area = area;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
