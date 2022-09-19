package com.example.sqlcontroller;

public class Good {
    private String name;
    private String artikul;
    private int quantity;
    private float beginPrice;
    private float currentPrice;

    public Good() {
    }

    public Good(String name, String artikul, int quantity, float beginPrice, float currentPrice) {
        this.name = name;
        this.artikul = artikul;
        this.quantity = quantity;
        this.beginPrice = beginPrice;
        this.currentPrice = currentPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtikul(String artikul) {
        this.artikul = artikul;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBeginPrice(float beginPrice) {
        this.beginPrice = beginPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", artikul='" + artikul + '\'' +
                ", quantity=" + quantity +
                ", beginPrice=" + beginPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
