package tp3;

import java.util.concurrent.Semaphore;

/**
 * Vestiaire object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Vestiaire {

    /**
     * Default constructor
     */
    public Vestiaire() {
    	this.sem = new Semaphore(20);
    }
    
    /**
     * Semaphore qui permet de verrouiller le vestiaire
     * quand le nombre de client >= capacité du vestiaire 
     */
    private Semaphore sem;
    
    /**
     * Acceder au vestiaire
     * @param client Le client qui accède au vestiaire
     */
    public void entrerVestiaire(Client client) {
    	try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Sortir du vestiaire
     * @param client Le client qui sort du vestiaire
     */
    public void quitterVestiaire(Client client) {
    	this.sem.release();
    }
}