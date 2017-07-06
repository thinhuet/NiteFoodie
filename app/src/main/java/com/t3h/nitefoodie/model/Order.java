package com.t3h.nitefoodie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Order {
    private String id;
    private String storeId;
    private String userId;
    private String state;
    private List<String> foodIds = new ArrayList<>();
    private Date orderTime;

    public Order() {

    }

    public Order(String id, String storeId, String userId, String state, List<String> foodIds, Date orderTime) {
        this.id = id;
        this.orderTime = orderTime;
        this.storeId = storeId;
        this.userId = userId;
        this.state = state;
        this.foodIds = foodIds;
    }

    public List<String> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<String> foodIds) {
        this.foodIds = foodIds;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
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
