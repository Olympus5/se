package tp3;

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
     * achat d'un ticket
     * @param le client qui achète un ticket
     */
    public synchronized void acheterTicket() {
    	if(this.vendTicket) {
    		try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    	notify();
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