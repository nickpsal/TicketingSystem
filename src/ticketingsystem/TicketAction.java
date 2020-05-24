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
public class TicketAction {
    private String action;
    private int progressAction;
    //Constructor
    public TicketAction(String action, int progressAction) {
        this.action = action;
        this.progressAction = progressAction;
    }
    // getters - setters
    public String getAction() {
        return action;
    }

    public int getProgressAction() {
        return progressAction;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setProgressAction(int progressAction) {
        this.progressAction = progressAction;
    }
}
