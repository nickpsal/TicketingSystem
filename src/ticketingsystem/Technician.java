/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nickpsal
 */
public class Technician extends User{
    public enum TechSpec {HARDWARE, SOFTWARE, NETWORK, COMMUNICATIONS};
    private TechSpec techSpec;     
    Random r = new Random();
    List<Ticket> tickets;
    public Technician(String name, TechSpec techSpec) {
        super(name);
        this.techSpec = techSpec;
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }
    
    public TechSpec getTechSpec() {
        return techSpec;
    }

    public void setTechSpec(TechSpec techSpec) {
        this.techSpec = techSpec;
    }

    public void randomProcessTickets(Technician t) {
        for (Ticket ticket:tickets) {
            if (ticket.getStatus() == Ticket.Status.ASSIGNED) {
                startTicket(ticket);
                addAction(ticket);
                stopTicket(ticket);
            }
            t.tickets.clear();
        }
    }
    
    private void startTicket(Ticket ticket) {
        TicketAction ticketAction = new TicketAction("Starting Ticket", 0);
        ticket.addAction(ticketAction);
        ticket.setStatus(Ticket.Status.IN_PROGRESS);
    }
    
    private void addAction(Ticket ticket) {
        int random = 1;
        int max = 90;
        while (random<max) {
            random = r.nextInt(max - random)+random+5;
            TicketAction ticketAction = new TicketAction("Simulating Fix", random);
            ticket.addAction(ticketAction);
            ticket.setProgress(random);
        }
    }
    
    private void stopTicket(Ticket ticket) {
        TicketAction ticketAction = new TicketAction("Ticket Complete", 100);
        ticket.addAction(ticketAction);
        ticket.setStatus(Ticket.Status.COMPLETE);
        ticket.setProgress(100);
    }
    
    public void printActionTickets() {
        for (Ticket ticket:tickets){
            System.out.println("TicketID:" + ticket.getTicketID() + " | Description:" + ticket.getDesc() + " | Category:" + ticket.getCategory() + " | Status:" + ticket.getStatus() + " | Technician:" + ticket.getTechnician().getName() + " | Progress=" + ticket.getProgress());
            for (int i = 0; i<ticket.getTicketActions().size(); i++) {
                System.out.println("Technician : " + ticket.getTechnician().getName() + " | Progress : " + ticket.getTicketActions().get(i).getProgressAction() + "| Action :" + ticket.getTicketActions().get(i).getAction());
            }
            System.out.println("");
        } 
    }
}
