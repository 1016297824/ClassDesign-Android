package com.example.classdesign.entity;

public class Food {
    public int id;
    public String name;
    public int price;
    public String content;
    public Food(int i, String name, int price, String content){
        id = i;
        this.name = name;
        this.price = price;
        this.content = content;
    }
}
