package com.yotta.qcommerce.activity.model;

public class ExploreByCategoriesClass {

    String categoriesName;
    int categoriesImages;

    public ExploreByCategoriesClass(String categoriesName, int categoriesImages) {
        this.categoriesName = categoriesName;
        this.categoriesImages = categoriesImages;
    }

    public ExploreByCategoriesClass() {
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public int getCategoriesImages() {
        return categoriesImages;
    }

    public void setCategoriesImages(int categoriesImages) {
        this.categoriesImages = categoriesImages;
    }
}
