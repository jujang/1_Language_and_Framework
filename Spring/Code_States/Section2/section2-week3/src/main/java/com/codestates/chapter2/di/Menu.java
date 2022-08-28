package com.codestates.chapter2.di;

public class Menu {
    private long id;
    private String name;
    private int price;

    public Menu(long id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
