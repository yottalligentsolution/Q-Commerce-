package com.yotta.qcommerce.activity.model;

public class OrdersClass {

    String productName,orderID,orderTimeAndDate;

    public OrdersClass() {
    }

    public OrdersClass(String productName, String orderID, String orderTimeAndDate) {
        this.productName = productName;
        this.orderID = orderID;
        this.orderTimeAndDate = orderTimeAndDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderTimeAndDate() {
        return orderTimeAndDate;
    }

    public void setOrderTimeAndDate(String orderTimeAndDate) {
        this.orderTimeAndDate = orderTimeAndDate;
    }
}
