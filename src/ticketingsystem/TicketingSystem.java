/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import ticketingsystem.Ticket.Category;
import ticketingsystem.Technician.TechSpec;

/**
 *
 * @author nickpsal
 */
public class TicketingSystem {
        public static void main(String[] args) {
        Company company = new Company("ΕΑΠ ΙΤ");
        
        User user1 = new User ("Χρήστης 1");
        User user2 = new User ("Χρήστης 2");
        User user3 = new User ("Χρήστης 3");
                
        company.addUser(user1);
        company.addUser(user2);
        company.addUser(user3);
        
                
        Technician technician1 = new Technician("Τεχνικός Hardware", TechSpec.HARDWARE);
        Technician technician2 = new Technician("Τεχνικός Software", TechSpec.SOFTWARE);
        Technician technician3 = new Technician("Τεχνικός Network", TechSpec.NETWORK);
        TechnicianManager techManager = new TechnicianManager("Τεχνικός Υπεύθυνος", TechSpec.COMMUNICATIONS);
        
        Ticket ticket1 = user1.createTicket("Δεν μου ανοίγει το google.gr ", Category.INTERNET);
        Ticket ticket2 = user1.createTicket("Προβλημα Ενεργοποίησεις τo Office ", Category.APPLICATION);
        Ticket ticket3 = user1.createTicket("Προβλημα Ενεργοποίησεις των Windows ", Category.OS);
        Ticket ticket4 = user2.createTicket("Δεν ανάβει η οθόνη ", Category.COMPUTER);
        Ticket ticket5 = user2.createTicket("Δεν τυπώνει ο Εκτυπωτής ", Category.PRINTER);
        Ticket ticket6 = user2.createTicket("Δεν βρίσκει το Wifi ", Category.PRINTER);
        Ticket ticket7 = user3.createTicket("Το Ρουτερ κανει επανεκινήσεις ", Category.INTERNET);
        Ticket ticket8 = user3.createTicket("Κολλάει τα Windows ", Category.APPLICATION);
        Ticket ticket9 = user3.createTicket("Τα windows μου βγάζουν μπλε οθόνη ", Category.OS);
                
        techManager.addTicket(ticket1);
        techManager.addTicket(ticket2);
        techManager.addTicket(ticket3);
        techManager.addTicket(ticket4);
        techManager.addTicket(ticket5);
        techManager.addTicket(ticket6);
        techManager.addTicket(ticket7);
        techManager.addTicket(ticket8);
        techManager.addTicket(ticket9);  
        
        
        company.addTechnician(technician1);
        company.addTechnician(technician2);
        company.addTechnician(technician3);   
        
        techManager.assignTicketsToTechnicians(technician1);
        techManager.assignTicketsToTechnicians(technician2);
        techManager.assignTicketsToTechnicians(technician3);
        
        techManager.printTickets();

        techManager.randomProcessTickets(technician1);
        techManager.randomProcessTickets(technician2);
        techManager.randomProcessTickets(technician3);
        System.out.println("");
        techManager.printActionTickets();

        System.out.println("Kατάταξη Aξιολόγησης Tεχνικών");
        TicketingController TicketingController1 = new TicketingController();
        TicketingController1.printTechniciansRanking(techManager);  
    }
}
