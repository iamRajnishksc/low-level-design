package com.foodkart.service;

import com.foodkart.model.Address;

import java.util.Map;

public interface IOrderService {

    public void makeOrder(Map<Integer,Integer> orderMap, Integer userId, Integer restaurantId, Address address);
}
