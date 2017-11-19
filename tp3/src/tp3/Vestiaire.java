package tp3;

import java.util.*;

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
    }

    /**
     * 
     */
    public static final int NB_PLACES = 20;

    /**
     * 
     */
    private int nbClient;
    
    /**
     * 
     * @param client
     */
    public synchronized void gestionVestiaire(Client client) {
        if(NB_PLACES < this.nbClient){
        	try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        this.nbClient++;
        
        //TODO: Délocaliser dans une autre méthode
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        this.nbClient--;
    }

    /**
     * Getter
     * @return nombre de clients achetant un ticket
     */
    public int getNbClient() {
    	return this.nbClient;
    }
    
    /**
     * Setter
     * @param nbClient nombre de clients achetant un ticket
     */
    public void setNbClient(int nbClient) {
    	this.nbClient += nbClient;
    }
}