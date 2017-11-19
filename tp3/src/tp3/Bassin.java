package tp3;

import java.util.concurrent.Semaphore;

/**
 * Bassin object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Bassin {

    /**
     * Default constructor
     */
    public Bassin() {
    	this.sem = new Semaphore(50);
    }

    /**
     * Semaphore qui permet de verrouiller le bassin
     * quand le nombre de client >= capacité du bassin 
     */
    private Semaphore sem;
    
    /**
     * Accéder au bassin
     * @param client le clien qui accède dans le bassin
     */
    public void entrerBassin(Client client) {
    	try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Sortir du bassin
     * @param client Le client qui sort du bassin 
     */
    public void quitterBassin(Client client) {
    	this.sem.release();
    }
}