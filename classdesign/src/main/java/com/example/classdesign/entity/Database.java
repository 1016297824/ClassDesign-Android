package com.example.classdesign.entity;


import java.util.ArrayList;
import java.util.List;

public class Database {
    public static String tableName;
    public static int sum=0;
    public static String content;
    public static List<Order> lists = new ArrayList<>();

    public static void orderLists(String name1,int price){
        sum+=price;
        Order orderList = new Order(name1,price,1);
        lists.add(orderList);
    }
}
