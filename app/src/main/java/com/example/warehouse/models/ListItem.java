package com.example.warehouse.models;

public class ListItem {

    private int imageResource;
    private String warehouseName, waregouseDetails;

    public ListItem(int imageResource, String warehouseName, String waregouseDetails) {
        this.imageResource = imageResource;
        this.warehouseName = warehouseName;
        this.waregouseDetails = waregouseDetails;
    }

    public int getImageResource() {
        return imageResource;
    }

    public CharSequence getWarehouseName() {
        return warehouseName;
    }

    public CharSequence getWaregouseDetails() {
        return waregouseDetails;
    }
}
