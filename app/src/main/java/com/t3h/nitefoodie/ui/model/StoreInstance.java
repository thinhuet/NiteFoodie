package com.t3h.nitefoodie.ui.model;

/**
 * Created by dungtx on 04/07/2017.
 */

public class StoreInstance {
    private String name;
    private String address;
    private String phone;

    private static StoreInstance instance = new StoreInstance();

    public static StoreInstance getInstance(){
        return instance;
    }


    public StoreInstance(){

    }

    public StoreInstance(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName(String name) {
        return StoreInstance.getInstance().getName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(String address) {
        return StoreInstance.getInstance().getAddress(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone(String phone) {
        return StoreInstance.getInstance().getPhone(phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
