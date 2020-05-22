/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpsal
 */
public class Ticket {
    private int ticketID;
    //Μετρητης για τα ticketID
    private static int counter = 0;
    private User user;
    // Τεχνικος του κάθε ticket 
    private Technician technician;
    //Περιγραφή iicket
    private String perigrafi;
    //Ticket progress
    private int progress;
    // Η Category μπορεί να έχει μόνο τις τιμές "COMPUTER, PRINTER, OS, APPLICATION, INTERNET, PHONE"
    //αντικατοπρίζει τις κατηγορίες των αιτημάτων που μπορει να αντιμετωπίσει ο χρήστης
    public enum Category {COMPUTER, PRINTER, OS, APPLICATION, INTERNET, PHONE};
    // Η Status μπορεί να έχει μόνο τις τιμές "WAITING, ASSIGNED, IN_PROGRESS, COMPLETE"
    public enum Status {WAITING, ASSIGNED, IN_PROGRESS, COMPLETE};
    private Status status;
    private Category category;
    // Λίστα με όλες τις διαιδκάσιες που θα ακολουθήσει ο τεχνικός για την επιδιόρθωση της βλάβης
    private List<TicketAction> ticketActions;
    //Constructor
    public Ticket(User user, String desc, Category category) {
        this.ticketID = counter++;
        this.user = user;
        this.perigrafi = desc;
        this.technician = technician;
        //Λίστα που αποθηλεύονται οι ενέργείες αποκατάστασης της βλάβης
        ticketActions = new ArrayList<>();
        this.category = category;
        //Ένα αίτημα βρίσκεται σε κατάσταση WAITING μόλις δηλωθεί από το χρήστη
        this.status = Status.WAITING;
    }   
    //getters - setters
    public int getTicketID() {
        return ticketID;
    }

    public static int getCounter() {
        return counter;
    }

    public User getUser() {
        return user;
    }

    public Technician getTechnician() {
        return technician;
    }

    public String getPerigrafi() {
        return perigrafi;
    }

    public int getProgress() {
        return progress;
    }

    public Status getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public List<TicketAction> getTicketActions() {
        return ticketActions;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // Aναθέτει τα αιτήματα στους τεχνικούς
    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public void setPerigrafi(String perigrafi) {
        this.perigrafi = perigrafi;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTicketActions(List<TicketAction> ticketActions) {
        this.ticketActions = ticketActions;
    }
    
    public void addAction (TicketAction ticketAction) {
        ticketActions.add(ticketAction);
    }    
}
