package com.example.customlistviewemploymentapp;

public class Product {
    private String prodName;
    private int price;
    private int image;
    private String decs;

    public Product(String prodName, int price, int image, String decs) {
        this.prodName = prodName;
        this.price = price;
        this.image = image;
        this.decs = decs;
    }

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getDecs() {
        return decs;
    }
}