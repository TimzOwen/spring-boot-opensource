package com.timzowen.helloworld;

public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public Product(String name, String location){
        super();
        this.name=name;
        this.location=location;
    }


}
