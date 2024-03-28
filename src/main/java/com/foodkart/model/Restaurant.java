package com.foodkart.model;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Restaurant {

    final Integer id;
    private String name;
    private String desc;
    private Address address;
    private Menu menu;
    private Rating rating;

    private ReentrantReadWriteLock lock;

    private Map<Integer, Integer> availibilityMap;

    public Restaurant(Integer id, String name, String desc, Address address, Menu menu, Rating rating, ReentrantReadWriteLock lock, Map<Integer, Integer> availibilityMap) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.address = address;
        this.menu = menu;
        this.rating = rating;
        this.lock = lock;
        this.availibilityMap = availibilityMap;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public ReentrantReadWriteLock getLock() {
        return lock;
    }

    public void setLock(ReentrantReadWriteLock lock) {
        this.lock = lock;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Map<Integer, Integer> getAvailibilityMap() {
        return availibilityMap;
    }

    public void setAvailibilityMap(Map<Integer, Integer> availibilityMap) {
        this.availibilityMap = availibilityMap;
    }

    public synchronized void takeOrder(Order order){
        try{
            lock.writeLock().lock();
            for(Map.Entry<Integer,Integer> entry: availibilityMap.entrySet()){
                if(!availibilityMap.containsKey(entry.getKey())||availibilityMap.get(entry.getKey())<entry.getValue())
                    throw new RuntimeException("Stock Not available");
            }

            for(Map.Entry<Integer,Integer> entry: availibilityMap.entrySet()){
                availibilityMap.put(entry.getKey(), availibilityMap.get(entry.getKey())-entry.getValue());
            }
        }
        finally {
            lock.writeLock().unlock();
        }

    }
}
