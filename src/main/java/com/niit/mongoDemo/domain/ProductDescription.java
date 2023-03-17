package com.niit.mongoDemo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductDescription {
    private int quantity;
    private int price;
    private String material;

    public ProductDescription() {
    }

    public ProductDescription(int quantity, int price, String material) {
        this.quantity = quantity;
        this.price = price;
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", material='" + material + '\'' +
                '}';
    }
}
