package com.example.classdesign.entity;

public class Order {
    public String name;
    public int count;
    public int price;
    public Order(String name, int price, int count){
        this.count = count;
        this.name = name;
        this.price = price;
    }

}
