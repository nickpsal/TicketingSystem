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
 * @author alexandridis
 */
public class Technician extends User{
    //2. Ένας τεχνικός (Technician) έχει ένα όνομα και μια συγκεκριμένη εξειδίκευση,
    //η οποία μπορεί να είναι μόνο μια εκ των "HARDWARE, SOFTWARE, NETWORK, COMMUNICATIONS"
    public enum TechnicianSpec {HARDWARE, SOFTWARE, NETWORK, COMMUNICATIONS};
    private TechnicianSpec techSpec;     
    Random r = new Random();
    List<Ticket> tickets;
    //Constructor
    public Technician(String name, TechnicianSpec techSpec) {
        super(name);
        this.techSpec = techSpec;
        this.tickets = new ArrayList<>();
    }
    // getters - setters
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
    
    public TechnicianSpec getTechSpec() {
        return techSpec;
    }

    public void setTechSpec(TechnicianSpec techSpec) {
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
            }
        }
        t.tickets.clear();
    }
    
    private void startTicket(Ticket ticket) {
        //εκκίνηση επιδιόρθωσης
        TicketAction ticketAction = new TicketAction("ΕΚΚΙΝΗΣΗ ΑΠΟΚΑΤΑΣΤΑΣΗΣ ΑΙΤΗΜΑΤΟΣ", 0);
        ticket.addAction(ticketAction);
        ticket.setStatus(Ticket.Status.IN_PROGRESS);
        //Η πρόοδος της κάθε ενέργειας προστίθεται κάθε φορά στη συνολική ένδειξη
        //προόδου του αιτήματος με την μέθοδος addAction
        addAction(ticket);
    }
    
    private void addAction(Ticket ticket) {
        int random = 1;
        int max = 90;
        //μετρητης βημάτων αποκατάστασης
        int counter = 1;
        //όσο η ramdom είναι μικρότερη απο την msx θα προσθέτει
        //νεα action
        while (random<max) {
            //οριζουμε τυχαίο αριθμό
            random = r.nextInt(max - random)+random+5;
            String ActionTicket = "ΒΗΜΑ ΑΠΟΚΑΤΑΣΤΑΣΗΣ " + counter;
            TicketAction ticketAction = new TicketAction(ActionTicket, random);
            ticket.addAction(ticketAction);
            ticket.setProgress(random);
            counter++;
        }
        //ΟΛοκλήρωση αιτήματος
        stopTicket(ticket);
    }
    
    private void stopTicket(Ticket ticket) {
        //Τερματισμός επιδιόρθωσης
        TicketAction ticketAction = new TicketAction("ΤΕΡΜΑΤΙΣΜΟΣ ΑΠΟΚΑΤΑΣΤΑΣΗΣ ΑΙΤΗΜΑΤΟΣ", 100);
        ticket.addAction(ticketAction);
        ticket.setStatus(Ticket.Status.COMPLETE);
        ticket.setProgress(100);
    }
    
    public void printActionTickets() {
        for (Ticket ticket:tickets){
            System.out.println("TicketID : " + ticket.getTicketID() + " | ΠΕΡΙΓΡΑΦΗ : " + ticket.getPerigrafi() + " | ΚΑΤΗΓΟΡΙΑ : " + ticket.getCategory() + " | ΚΑΤΑΣΤΑΣΗ : " + ticket.getStatus() + " | ΟΝΟΜΑ ΤΕΧΝΙΚΟΥ : " + ticket.getTechnician().getName() + " | ΠΡΟΟΔΟΣ ΑΙΤΗΜΑΤΟΣ : " + ticket.getProgress());
            for (int i = 0; i<ticket.getTicketActions().size(); i++) {
                System.out.println("ΟΝΟΜΑ ΤΕΧΝΙΚΟΣ : " + ticket.getTechnician().getName() + " | ΠΡΟΟΔΟΣ ΑΙΤΗΜΑΤΟΣ : " + ticket.getTicketActions().get(i).getProgressAction() + " | ΕΝΕΡΓΕΙΕΣ ΓΙΑ ΑΠΟΚΑΤΑΣΤΑΣΗ : " + ticket.getTicketActions().get(i).getAction());
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
        } 
    }
}
