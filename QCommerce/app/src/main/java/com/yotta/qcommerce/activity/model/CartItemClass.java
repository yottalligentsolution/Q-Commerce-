package com.yotta.qcommerce.activity.model;

public class CartItemClass {

    int productImage;
    String productName,productModel,productPrice,productQuantity;

    public CartItemClass(int productImage, String productName, String productModel, String productPrice, String productQuantity) {
        this.productImage = productImage;
        this.productName = productName;
        this.productModel = productModel;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public CartItemClass() {
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
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
