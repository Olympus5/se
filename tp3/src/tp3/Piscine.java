package tp3;

import java.util.*;

/**
 * Piscine object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Piscine {

    /**
     * Default constructor
     */
    public Piscine(Comptoir comptoir, Vestiaire vestiaire, Bassin bassin) {
    	this.bassin = bassin;
    	this.comptoir = comptoir;
    	this.vestiaire = vestiaire;
    }

    /**
     * 
     */
    private Bassin bassin;

    /**
     * 
     */
    private Comptoir comptoir;

    /**
     * 
     */
    private Vestiaire vestiaire;

    /**
     * 
     */
    private Set<Client> clients;

    /**
     * 
     */
    public synchronized void gestionComptoir(Client client) {
    	if(this.comptoir.getTicket()) {
    		try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }

    /**
     * 
     */
    //TODO: Délocaliser le code dans les classes Comptoir, Vestiaire, Bassin (sémaphores dans Vestaire et Bassin)
    public synchronized void gestionVestiaire(Client client) {
        if(this.vestiaire.NB_PLACES < this.vestiaire.getNbClient()) {
        	try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        this.vestiaire.setNbClient(1);
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        this.vestiaire.setNbClient(-1);
    }

    /**
     * 
     */
    public synchronized void gestionBassin(Client client) {
        if(this.bassin.NB_PLACES < this.bassin.getNbClient()) {
        	try {
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        this.bassin.setNbClient(1);
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        this.bassin.setNbClient(-1);
    }

}