package com.foodkart;

import com.foodkart.model.Order;
import com.foodkart.service.IOrderService;
import com.foodkart.service.IRestaurantService;
import com.foodkart.service.OrderService;
import com.foodkart.service.SimpleRestaurantService;

import java.util.HashMap;

public class Driver {

    public static void main(String[] args) {
        SimpleRestaurantService.init(new HashMap<>());
        IRestaurantService restaurantService = SimpleRestaurantService.getInstance();
        OrderService.init(new HashMap<>(), restaurantService);

        IOrderService orderService = OrderService.getInstance();
        System.out.println("--------------");


    }
}
