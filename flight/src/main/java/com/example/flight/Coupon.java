package com.example.flight;
import java.util.HashMap;

public class Coupon {
    private final long ID;
    private double Discount;
    static private HashMap<Integer, Integer> Discounts = new HashMap<Integer, Integer>();

    public Coupon(long id) {
        Discounts.put(1,10);
        Discounts.put(2,50);
        Discounts.put(3,60);
        this.ID = id;
        this.Discount = (double)Discounts.get(getRandomNumber(1,3))/100;
    }

    public double getDiscount(){
        return Discount;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
