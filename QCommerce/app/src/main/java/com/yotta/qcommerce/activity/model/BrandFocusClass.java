package com.yotta.qcommerce.activity.model;

public class BrandFocusClass {

    int companyLogo,companyProduct;
    String off;

    public BrandFocusClass(int companyLogo, int companyProduct, String off) {
        this.companyLogo = companyLogo;
        this.companyProduct = companyProduct;
        this.off = off;
    }

    public BrandFocusClass() {
    }

    public int getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(int companyLogo) {
        this.companyLogo = companyLogo;
    }

    public int getCompanyProduct() {
        return companyProduct;
    }

    public void setCompanyProduct(int companyProduct) {
        this.companyProduct = companyProduct;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }
}
