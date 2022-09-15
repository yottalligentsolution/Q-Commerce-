package com.yotta.qcommerce.activity.model;

public class RiceAndShineClass {

    Integer productImage;
    String productName,productStrikePrice,productPrice,productQuantity;

    public RiceAndShineClass(Integer productImage, String productName, String productStrikePrice, String productPrice, String productQuantity) {
        this.productImage = productImage;
        this.productName = productName;
        this.productStrikePrice = productStrikePrice;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public RiceAndShineClass() {
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStrikePrice() {
        return productStrikePrice;
    }

    public void setProductStrikePrice(String productStrikePrice) {
        this.productStrikePrice = productStrikePrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
