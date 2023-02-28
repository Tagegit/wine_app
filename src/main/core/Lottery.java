package main.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    // Denne må legges inn manuelt
    List<Wine> prizes;
    List<Ticket> tickets;
    int money;

    public Lottery() {
        money = 1000;
        prizes = new ArrayList<Wine>();
        tickets = new ArrayList<Ticket>();
    }
    
    /**
     * Function for adding a ticket to the raffle
     * 
     * @param person The owner of the ticket. Leads to problems if there are persons with same name
     * @param number The number of the ticket
     */
    public void addTicket(String person, int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException("Number must be between 1 and 100!");
        }
        // Gjøres med hashmap of O(1) tid, men adder space complexity isåfall, er så få elementer at det gjør lite nå
        for (Ticket ticket : tickets) {
            if (ticket.getNumber() == number) {
                throw new IllegalArgumentException("This number is already taken!");
            }
        }
        Ticket current = new Ticket(person, number);
        tickets.add(current);
    }

    public void addWine(Wine wine) {
        if (wine.getPrice() > money) {
            throw new IllegalArgumentException("This wine is too expensive for the raffle!");
        } else {
            addWineToList(wine);
            money -= wine.getPrice();
        }
    }

    /**
     * Function to add a wine to prizes
     * Makes sure it is in ascending order
     * 
     * @param wine The wine to be added.
     */
    private void addWineToList(Wine wine) {
        if (prizes.isEmpty()) {
            prizes.add(wine);
            return;
        }

        int index = 0;
        while ((index < prizes.size()) && (wine.getPrice()>=prizes.get(index).getPrice())) {
            index++;
        }
        prizes.add(index, wine);

    }

    /**
     * Funksjon for å trekke en vinner
     * Kan vurderes å sende tilbake vinner og hvilken vin som ble vunnet isteden for å gjøre det i controller
     */
    public Ticket raffle() {
        if (prizes.isEmpty()) {
            throw new IllegalStateException("There are noe current prizes to win!");
        }
        if (tickets.isEmpty()) {
            throw new IllegalStateException("No one can win the current prize");
        }
        // Velger en random person fra ticketsene og finner så vinneren gjennom ticket-klassen
        Random random = new Random();
        Ticket winner = tickets.get(random.nextInt(tickets.size()));
        tickets.remove(winner);
        return winner; 
    }
    /**
     * Gets the 0'th index of the prizes
     * @return The corresponding wine.
     */
    public Wine getPrize() {
        // Strengt tatt unødvendig fordi denne kjøres etter raffle hvor samme sjekken blir gjort
        if (prizes.isEmpty()) {
            throw new IllegalArgumentException("There are no prizes left");
        }
        return prizes.remove(0);
    }
}
