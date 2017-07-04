package com.t3h.nitefoodie.ui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Order {
    private String id;
    private String storeId;
    private String userId;
    private String state;
    private List<Food> foods = new ArrayList<Food>();

    public Order(){

    }

    public Order(String id, String storeId, String userId, String state, List<Food> foods) {
        this.id = id;
        this.storeId = storeId;
        this.userId = userId;
        this.state = state;
        this.foods = foods;
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

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
