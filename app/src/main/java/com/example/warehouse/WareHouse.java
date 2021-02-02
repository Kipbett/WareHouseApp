package com.example.warehouse;

public class WareHouse {

    private int imageResource;
    private String name, location;

    public WareHouse(int imageResource, String name, String location){
        this.imageResource = imageResource;
        this.name = name;
        this.location = location;
    }

    public int getImageResource(){
        return imageResource;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }
}
