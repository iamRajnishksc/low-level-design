package com.foodkart.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    final Integer id;
    final Integer userId;
    final Map<Integer,Integer> orderMap;
    final Address address;
    final LocalDateTime timeOfOrder;

    final Integer restaurentId;

    public Order(Integer id, Integer userId, Map<Integer, Integer> orderMap, Address address, LocalDateTime timeOfOrder, Integer restaurentId) {
        this.id = id;
        this.userId = userId;
        this.orderMap = orderMap;
        this.address = address;
        this.timeOfOrder = timeOfOrder;
        this.restaurentId = restaurentId;
    }
}
