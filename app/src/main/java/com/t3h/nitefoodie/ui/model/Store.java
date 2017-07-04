package com.t3h.nitefoodie.ui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dungtx on 03/07/2017.
 */

public class Store {
    private String sId;
    public String name;
    private String address;
    private String phone;
    private String rate;
    private double numberRating;
    private String openTime;
    private String closeTime;
    private List<Food> menu = new ArrayList<Food>();
    private List<Order> listOrders = new ArrayList<Order>();

    public Store(){

    }

    public Store( String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Store(String sId, String name, String address, String phone){
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

//    public Store(String sId, String name, String address, String phone, String rate,
//                 double numberRating, String openTime, String closeTime, List<Food> menu, List<Order> listOrders) {
//        this.sId = sId;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.rate = rate;
//        this.numberRating = numberRating;
//        this.openTime = openTime;
//        this.closeTime = closeTime;
//        this.menu = menu;
//        this.listOrders = listOrders;
//    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getNumberRating() {
        return numberRating;
    }

    public void setNumberRating(double numberRating) {
        this.numberRating = numberRating;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

    public List<Order> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<Order> listOrders) {
        this.listOrders = listOrders;
    }
}
