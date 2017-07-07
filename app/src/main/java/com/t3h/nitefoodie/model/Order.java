package com.t3h.nitefoodie.model;

import java.util.HashMap;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Order {
    private String id;
    private String storeId;
    private String userId;
    private String state;
    private HashMap<String, FoodOrder> foodOrders;
    private long orderTime;

    public Order() {

    }

    public HashMap<String, FoodOrder> getFoodIds() {
        return foodOrders;
    }

    public void setFoodIds(HashMap<String, FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
