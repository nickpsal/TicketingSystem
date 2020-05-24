/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

/**
 *
 * @author nickpsal
 */
public class TechnicianManager extends Technician{
        
    public TechnicianManager(String name, TechnicianSpec technicianSpec) {
        super(name,technicianSpec);
    }

    public void assignTicketsToTechnicians(Technician t) {
        for (Ticket ticket:tickets) {
            switch (ticket.getCategory()) {
                //Aιτήματα που αφορούν COMPUTER ή PRINTER τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο HARDWARE.
                case COMPUTER:
                   if (t.getTechSpec() == TechnicianSpec.HARDWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                
                case PRINTER:
                   if (t.getTechSpec() == TechnicianSpec.HARDWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν OS ή APPLICATION τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο SOFTWARE.    
                case OS:
                    if (t.getTechSpec() == TechnicianSpec.SOFTWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                   
                case APPLICATION:
                    if (t.getTechSpec() == TechnicianSpec.SOFTWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν INTERNET τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο NETWORK.
                case INTERNET:
                    if (t.getTechSpec() == TechnicianSpec.NETWORK){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν PHONE τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο COMMUNICATIONS.
                case PHONE:
                    if (t.getTechSpec() == TechnicianSpec.COMMUNICATIONS){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
            }
        }
    }

    public void printTickets() {
        for (Ticket ticket:tickets){
            //εκτύπωση των αιτημάτων πριν ανατεθούν
            System.out.println("TicketID : " + ticket.getTicketID() + " | ΠΕΡΙΓΡΑΦΗ : " + ticket.getPerigrafi() + " | ΚΑΤΗΓΟΡΙΑ : " + ticket.getCategory() + " | ΚΑΤΑΣΤΑΣΗ : " + ticket.getStatus() + " | ΟΝΟΜΑ ΤΕΧΝΙΚΟΥ : " + ticket.getTechnician().getName() + " | ΠΡΟΟΔΟΣ ΑΙΤΗΜΑΤΟΣ : " + ticket.getProgress());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
