package com.example.warehouse.models;

public class Warehouses {

    String warehouse_name, owner, location, owner_phone, owner_email;

    public Warehouses() {
    }

    public Warehouses(String warehouse_name, String owner, String location, String owner_phone, String owner_email) {
        this.warehouse_name = warehouse_name;
        this.owner = owner;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner_phone(String phone) {
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
