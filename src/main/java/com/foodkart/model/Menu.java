package com.foodkart.model;

import java.util.Map;

public class Menu {
    Integer id;
    Map<Integer, Dish> dishMap;
    Integer specialDishId;

    public Menu(Integer id, Map<Integer, Dish> dishMap, Integer specialDishId) {
        this.id = id;
        this.dishMap = dishMap;
        this.specialDishId = specialDishId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, Dish> getDishMap() {
        return dishMap;
    }

    public void setDishMap(Map<Integer, Dish> dishMap) {
        this.dishMap = dishMap;
    }

    public Integer getSpecialDishId() {
        return specialDishId;
    }

    public void setSpecialDishId(Integer specialDishId) {
        this.specialDishId = specialDishId;
    }
}
