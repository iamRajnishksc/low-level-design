package com.foodkart.service;

import com.foodkart.model.Address;
import com.foodkart.model.Order;
import com.foodkart.model.Restaurant;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService implements IOrderService{

    private static OrderService orderService;

    private IRestaurantService restaurantService;
    private Map<Integer, Integer> orderMap;
    private static AtomicInteger orderIdSequence = new AtomicInteger(1);

    private OrderService(Map<Integer, Integer> orderMap, IRestaurantService restaurantService) {
        this.orderMap = orderMap;
        this.restaurantService = restaurantService;
    }

    public static void init(Map<Integer, Integer> orderMap, IRestaurantService restaurantService){
        if(orderService!=null)throw new RuntimeException("Already created");
        syninit(orderMap,restaurantService);

    }
    public static OrderService getInstance(){
        if(orderService == null) throw new RuntimeException("Not implemented");
        return orderService;
    }

    private synchronized static void  syninit(Map<Integer, Integer> orderMap, IRestaurantService restaurantService) {
        orderService = new OrderService(orderMap,restaurantService);
    }


    @Override
    public void makeOrder(Map<Integer, Integer> orderMap, Integer userId, Integer restaurantId, Address address) {
        Integer id = orderIdSequence.getAndIncrement();
        Order order = new Order(id,userId,orderMap,address, LocalDateTime.now(),restaurantId);
        Restaurant restaurant = restaurantService.getRestaurant(id);
        restaurant.takeOrder(order);
    }
}
