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
    //2. Ένας τεχνικός (Technician) έχει ένα όνομα και μια συγκεκριμένη εξειδίκευση,
    //η οποία μπορεί να είναι μόνο μια εκ των "HARDWARE, SOFTWARE, NETWORK, COMMUNICATIONS"
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
    //Για κάθε τεχνικό θα καλεί μέθοδο randomProcessTickets
    //η οποία θα προσομοιώνει την επίλυση ενός αιτήματος από τον τεχνικό ακολουθώντας
    //την προβλεπόμενη διαδικασία, όπου όμως το πλήθος των ενεργειών θα είναι τυχαίο
    public void randomProcessTickets(Technician t) {
        for (Ticket ticket:tickets) {
            //Εκκίνηση της βλάβης εφόσον βρίσκεται σε κατάσταση ASSIGNED
            if (ticket.getStatus() == Ticket.Status.ASSIGNED) {
                //έναρξη εξυπηρέτησης του αιτήματος (μέθοδος startTicket),
                startTicket(ticket);
                //Η πρόοδος της κάθε ενέργειας προστίθεται κάθε φορά στη συνολική ένδειξη
                //προόδου του αιτήματος με την μέθοδος addAction
                addAction(ticket);
                //ΟΛοκλήρωση αιτήματος
                stopTicket(ticket);
            }
            t.tickets.clear();
        }
    }
    
    private void startTicket(Ticket ticket) {
        //εκκίνηση επιδιόρθωσης
        TicketAction ticketAction = new TicketAction("Starting Ticket", 0);
        ticket.addAction(ticketAction);
        ticket.setStatus(Ticket.Status.IN_PROGRESS);
    }
    
    private void addAction(Ticket ticket) {
        int random = 1;
        int max = 90;
        //όσο η ramdom είναι μικρότερη απο την msx θα προσθέτει
        //νεα action
        while (random<max) {
            //οριζουμε τυχαίο αριθμό
            random = r.nextInt(max - random)+random+5;
            TicketAction ticketAction = new TicketAction("Simulating Fix", random);
            ticket.addAction(ticketAction);
            ticket.setProgress(random);
        }
    }
    
    private void stopTicket(Ticket ticket) {
        //Τερματισμός επιδιόρθωσης
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
