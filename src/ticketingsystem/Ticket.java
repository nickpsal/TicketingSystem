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
    private static int counter = 1;
    private User user;
    private Technician technician;
    private String desc;
    private int progress;
    public enum Category {COMPUTER, PRINTER, OS, APPLICATION, INTERNET, PHONE};
    public enum Status {WAITING, ASSIGNED, IN_PROGRESS, COMPLETE};
    private Status status;
    private Category category;
    private List<TicketAction> ticketActions;
    
    public Ticket(User user, String desc, Category category) {
        this.ticketID = counter++;
        this.user = user;
        this.desc = desc;
        this.technician = technician;
        ticketActions = new ArrayList<>();
        this.category = category;
        this.status = Status.WAITING;
    }   

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

    public String getDesc() {
        return desc;
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

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
