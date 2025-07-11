package org.example.chapter10.practice02.entity;

public class Electroneics extends Item{
    private String brand;
    private int warranty; //보증 기간(개월)

    public Electroneics(String id, String name, int price, int quantity, String brand, int warranty) {
        super(id, name, price, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {return brand;}
    public int getWarranty() {return warranty;}

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() + " // Brand: " + brand + ", Warranty: " + warranty;
    }
}
