package tp3;

import java.util.*;

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
    }

    /**
     * 
     */
    public static final int NB_PLACES = 50;

    /**
     * 
     */
    private int nbClient;
    
    /**
     * 
     * @param client
     */
    public synchronized void gestionBassin(Client client) {
        if(NB_PLACES < this.nbClient) {
        	try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        this.nbClient++;
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        this.nbClient--;
    }
    
    /**
     * Getter
     * @return
     */
    public int getNbClient() {
    	return this.nbClient;
    }
    
    /**
     * Setter
     * @param nbClient
     */
    public void setNbClient(int nbClient) {
    	this.nbClient = nbClient;
    }

}