package com.example.quotationmaker;

public class Item {
    String Name;
    float Quantity;
    float Price;

    public Item() {
    }
    public void setName(String name) {
        Name = name;
    }

    public void setQuantity(float quantity) {
        Quantity = quantity;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public float getQuantity() {
        return Quantity;
    }

    public float getPrice() {
        return Price;
    }
}
