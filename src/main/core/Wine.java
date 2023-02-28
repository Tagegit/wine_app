package main.core;

public class Wine {
    
    private String name;
    private int price;

    public Wine(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


}
