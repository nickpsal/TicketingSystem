/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import ticketingsystem.Ticket.Category;
import ticketingsystem.Technician.TechnicianSpec;

/**
 *
 * @author nickpsal
 */
public class TicketingSystem {
        public static void main(String[] args) {
        //Δημιουργεία νεας ταιρείας
        Company company = new Company("ALEXANDRIDIS SUPPORT CENTER");
        // και 3 χρηστες
        User xristis1 = new User ("USER 1");
        User xristis2 = new User ("USER 2");
        User xristis3 = new User ("USER 3");
        //Προσθήκη των χρηστών στην εταιρεία        
        company.addUser(xristis1);
        company.addUser(xristis2);
        company.addUser(xristis3);
        
        //Προσθήκη 3 Τεχνιών και 1 τεχνικου υπέυθυννου        
        Technician texnikos1 = new Technician("Τεχνικός NETWORK", TechnicianSpec.NETWORK);
        Technician texnikos2 = new Technician("Τεχνικός SOFTWARE", TechnicianSpec.SOFTWARE);
        Technician texnikos3 = new Technician("Τεχνικός HARDWARE", TechnicianSpec.HARDWARE);
        TechnicianManager technicianManager = new TechnicianManager("Τεχνικός Υπεύθυνος", TechnicianSpec.COMMUNICATIONS);
        //Δημιουργεία 9 ticket
        Ticket supportTicket1 = xristis1.createTicket("Δεν λαμβάνω email ", Category.INTERNET);
        Ticket supportTicket2 = xristis1.createTicket("Δεν ανοίγει ο Chrome ", Category.APPLICATION);
        Ticket supportTicket3 = xristis1.createTicket("Τα Windows κρασαρουν ", Category.OS);
        Ticket supportTicket4 = xristis2.createTicket("Δεν αναγνωρίζει το πληκτρολόγιο ", Category.COMPUTER);
        Ticket supportTicket5 = xristis2.createTicket("Δεν αναγνωρίζιε τα μελάνια ", Category.PRINTER);
        Ticket supportTicket6 = xristis2.createTicket("Μασαει το χαρτι ο Εκτυπωτής ", Category.PRINTER);
        Ticket supportTicket7 = xristis3.createTicket("Δεν μπορω να συνδεθω στο ασυρματο ", Category.INTERNET);
        Ticket supportTicket8 = xristis3.createTicket("Δεν ανοίγει το Notepad ", Category.APPLICATION);
        Ticket supportTicket9 = xristis3.createTicket("Τα WIndows δεν φορτώνουν ", Category.OS);
       
        // Ο τενικός υπεύθυνος προσθετει τα ticket
        technicianManager.addTicket(supportTicket1);
        technicianManager.addTicket(supportTicket2);
        technicianManager.addTicket(supportTicket3);
        technicianManager.addTicket(supportTicket4);
        technicianManager.addTicket(supportTicket5);
        technicianManager.addTicket(supportTicket6);
        technicianManager.addTicket(supportTicket7);
        technicianManager.addTicket(supportTicket8);
        technicianManager.addTicket(supportTicket9);  
        
        //Προσθήκη 3 τεχνικών στην εταιρία
        company.addTechnician(texnikos1);
        company.addTechnician(texnikos2);
        company.addTechnician(texnikos3);   
        //Μοιράζει τα αιτήματα στους τεχνικο΄υς
        technicianManager.assignTicketsToTechnicians(texnikos1);
        technicianManager.assignTicketsToTechnicians(texnikos2);
        technicianManager.assignTicketsToTechnicians(texnikos3);
        //Εκτύπωση αιτημάτων
        System.out.println(company.getName());
        System.out.println("---------------------------");
        technicianManager.printTickets();
        //Οι τεχνικοί αναλαμβάνουν τα αιτήματα
        //δέχεται σνα όρισμα μόνο τον πρώτο τεχνικό αλλά
        //αναλάμβάνει όλα τα ticket
        technicianManager.randomProcessTickets(texnikos1);
        System.out.println("");
        //Εκτυπωση μυνημάτων επιδιόρθωσης
        technicianManager.printActionTickets();
        
        System.out.println("Kατάταξη Aξιολόγησης Tεχνικών");
        System.out.println("-----------------------------");
        TicketingController TicketingController1 = new TicketingController();
        ///καλούμε την printTechniciansRanking με όρισμα των τεχνικό υπεύθυνο
        TicketingController1.printTechniciansRanking(technicianManager); 
    }
}
