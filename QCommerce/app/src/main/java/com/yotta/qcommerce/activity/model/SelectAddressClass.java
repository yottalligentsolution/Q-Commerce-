package com.yotta.qcommerce.activity.model;

public class SelectAddressClass {

    String userName,userLocation,userPhone;


    public SelectAddressClass() {
    }

    public SelectAddressClass(String userName, String userLocation, String userPhone) {
        this.userName = userName;
        this.userLocation = userLocation;
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
