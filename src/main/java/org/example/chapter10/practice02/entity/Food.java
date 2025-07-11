package org.example.chapter10.practice02.entity;


import java.time.LocalDate;

public class Food extends Item{
    private String foodName;
    private LocalDate endDate;

    public Food(String id, String name, int price, int quantity, String foodName, LocalDate endDate){
        super(id, name, price, quantity);
        this.foodName = foodName;
        this.endDate = endDate;
    }

    public String getFoodName() {return foodName;}
    public LocalDate getEndDate() {return endDate;}

    @Override
    public String getCategory() {
        return "Food";
    }

    @Override
    public String toString() {
        return super.toString() + "//FoodName: " + foodName + ", endDate: " + endDate;
    }
}
