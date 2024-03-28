package com.foodkart.service;

import com.foodkart.model.Restaurant;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleRestaurantService implements IRestaurantService {

    private static SimpleRestaurantService simpleRestaurantService;

    private Map<Integer,Restaurant> restaurantMap;

    private SimpleRestaurantService(Map<Integer, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public static void init(Map<Integer, Restaurant> restaurantMap){
        if(simpleRestaurantService!=null)throw new RuntimeException("Already created");
            syninit(restaurantMap);

    }
    public static SimpleRestaurantService getInstance(){
        if(simpleRestaurantService == null) throw new RuntimeException("Not implemented");
        return simpleRestaurantService;
    }

    private synchronized static void  syninit(Map<Integer, Restaurant> restaurantMap) {
        simpleRestaurantService = new SimpleRestaurantService(restaurantMap);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
    if(restaurantMap.containsKey(restaurant.getId()))throw new RuntimeException("Already exists");
    restaurantMap.put(restaurant.getId(),restaurant);
    }

    @Override
    public List<Restaurant> searchByFood(String foodName) {
            return restaurantMap.values().stream().filter(restaurant ->restaurant.getMenu().getDishMap().values()
                    .stream().filter(x->x.getName().contains(foodName)).collect(Collectors.toList()).size()>0).collect(Collectors.toList());


    }

    @Override
    public List<Restaurant> searchByRestaurantName(String restaurantName) {
        return restaurantMap.values().stream().filter(restaurant -> restaurant.getName().contains(restaurantName))
                .collect(Collectors.toList());
    }

    @Override
    public Restaurant getRestaurant(Integer id) {
        return restaurantMap.get(id);
    }


}
