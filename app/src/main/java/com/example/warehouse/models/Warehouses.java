package com.example.warehouse.models;

public class Warehouses {

    String warehouse_name, owner, lng, lat, owner_phone, owner_email;

    public Warehouses() {
    }

    public Warehouses(String warehouse_name, String owner, String lng, String lat, String owner_phone, String owner_email) {
        this.warehouse_name = warehouse_name;
        this.owner = owner;
        this.lng = lng;
        this.lat = lat;
        this.owner_phone = owner_phone;
        this.owner_email = owner_email;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }
}
