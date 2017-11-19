package tp3;

import java.util.*;

/**
 * Comptoir object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Comptoir {

    /**
     * Default constructor
     */
    public Comptoir() {
    }

    /**
     * 
     */
    private boolean vendTicket;
    
    /**
     * 
     */
    public synchronized void gestionComptoir(Client client) {
    	if(this.vendTicket) {
    		try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * Setter
     * @param vendTicket l'état de la vente
     */
    public void setTicket(boolean vendTicket) {
    	this.vendTicket = vendTicket;
    }
    
    /**
     * Getter
     * @return l'état de la vente
     */
    public boolean getTicket() {
    	return this.vendTicket;
    }
}