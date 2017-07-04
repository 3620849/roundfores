package com.roundforest.model;

/**
 * Created by UA C on 03.07.2017.
 */
public class Food {
    private String productId;

    public Food() {
    }

    @Override
    public String toString() {
        return "Food{" +
                "productId='" + productId + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
