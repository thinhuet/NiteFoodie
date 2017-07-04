package com.t3h.nitefoodie.ui.model;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Food {
    private String storeId;
    private String name;
    private String orderId;

    public Food(){

    }

    public Food(String storeId, String name, String orderId) {
        this.storeId = storeId;
        this.name = name;
        this.orderId = orderId;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
