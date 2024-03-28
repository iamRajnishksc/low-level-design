package com.foodkart.model;

import com.foodkart.enums.FoodType;

public class Dish {
    public final Integer id;
    String name;
    FoodType foodType;
    String desc;

    public Dish(Integer id, String name, FoodType foodType, String desc) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
