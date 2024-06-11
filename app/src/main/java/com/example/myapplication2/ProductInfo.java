package com.example.myapplication2;

import java.io.Serializable;

public class ProductInfo implements Serializable{
    private String name;
    private int quantity;
    private int imgID;
    private double price;


    private String details;
    private String imageUrl;
    public ProductInfo() {

    }
    public ProductInfo(String name, int imgID,int quantity, double price, String details, String imageUrl) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.details = details;
        this.imageUrl = imageUrl;
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
