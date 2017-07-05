package com.t3h.nitefoodie.ui.model;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Food {
    private String storeId;
    private String name;
    private String foodId;
    private String price;

    public Food() {

    }

    public Food(String storeId, String name, String foodId, String price) {
        this.storeId = storeId;
        this.name = name;
        this.foodId = foodId;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
