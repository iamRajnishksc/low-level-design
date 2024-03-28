package com.foodkart.service;

import com.foodkart.model.Restaurant;

import java.util.List;

public interface IRestaurantService {

    public void addRestaurant(Restaurant restaurant);
    public List<Restaurant> searchByFood(String foodName);
    public List<Restaurant> searchByRestaurantName(String restaurantName);

    public Restaurant getRestaurant(Integer id);

}
