package com.t3h.nitefoodie.model;

/**
 * Created by thinhquan on 7/7/17.
 */

public class FoodOrder extends Food {
    private int numberOfFood;

    public FoodOrder() {
    }

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }
}
