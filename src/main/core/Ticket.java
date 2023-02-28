package main.core;

public class Ticket {

    private int number;
    private String owner;

    // Feilmelding ved feil nummer? --> Tenker å gjøre det i Lottery.java
    public Ticket(String owner, int number) {
        this.owner = owner;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }
    
}
