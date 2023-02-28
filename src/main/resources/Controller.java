package main.resources;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.core.Lottery;
import main.core.Ticket;
import main.core.Wine;

public class Controller {

    @FXML
    private TextField ticketName;
    @FXML
    private TextField ticketNumber;
    @FXML
    private Button addTicket;
    @FXML
    private TextField feedback;
    @FXML
    private TextField wineName;
    @FXML
    private TextField winePrice;
    @FXML
    private Button addWine;
    @FXML
    private Button getWinner;

    private Lottery lott;

    public Controller() {
        lott = new Lottery();
    }

    // Må legge inn feilhåndtering (feks for tall)
    // Ingen god måte å lagre personer med tanke på at man lager en ny person hver gang en billett blir lagt til

    /**
     * 
     */
    @FXML
    public void addTicket() {
        try {
            String name = ticketName.getText();
            int number = Integer.parseInt(ticketNumber.getText()); // Feilhåndtering!
            lott.addTicket(name, number);
            feedback.setText("Ticket added for " + name + " with number " + number);
        } catch (Exception e){
            feedback.setText(e.getMessage());
        }
    }

    @FXML
    public void addWine() {
        try {
            String name = wineName.getText();
            int price = Integer.parseInt(winePrice.getText());
            lott.addWine(new Wine(name, price));
            feedback.setText(name + " was added as a prize!");
        } catch (Exception e) {
            feedback.setText(e.getMessage());
        }
    }

    @FXML
    public void raffle() {
        try {
            Ticket ticket = lott.raffle();
            Wine wine = lott.getPrize();
            feedback.setText("The winner is ticketnumber: " + ticket.getNumber() + "and " + ticket.getOwner() + " is the winner of " + wine.getName() + " \n Congratulations!!");
        } catch (Exception e) {
            feedback.setText(e.getMessage());
        }
    }
    
}
