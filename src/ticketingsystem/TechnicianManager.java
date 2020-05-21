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
        
    public TechnicianManager(String name, TechSpec techSpec) {
        super(name,techSpec);
    }

    void assignTicketsToTechnicians(Technician t) {
        for (Ticket ticket:tickets) {
            switch (ticket.getCategory()) {
                //Aιτήματα που αφορούν COMPUTER ή PRINTER τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο HARDWARE.
                case COMPUTER:
                   if (t.getTechSpec() == TechSpec.HARDWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                
                case PRINTER:
                   if (t.getTechSpec() == TechSpec.HARDWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν OS ή APPLICATION τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο SOFTWARE.    
                case OS:
                    if (t.getTechSpec() == TechSpec.SOFTWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                   
                case APPLICATION:
                    if (t.getTechSpec() == TechSpec.SOFTWARE){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν INTERNET τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο NETWORK.
                case INTERNET:
                    if (t.getTechSpec() == TechSpec.NETWORK){
                       ticket.setTechnician(t);
                       ticket.setStatus(Ticket.Status.ASSIGNED);
                       t.tickets.add(ticket);
                   }
                   break;
                //Aιτήματα που αφορούν PHONE τα αναθέτει
                //στον τεχνικό με εξειδίκευση στο COMMUNICATIONS.
                case PHONE:
                    if (t.getTechSpec() == TechSpec.COMMUNICATIONS){
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
            System.out.println("TicketID : " + ticket.getTicketID() + " | Description : " + ticket.getDesc() + " | Category : " + ticket.getCategory() + " | Status : " + ticket.getStatus() + " | Technician : " + ticket.getTechnician().getName() + " | Progress : " + ticket.getProgress());
        }   
    }
}
