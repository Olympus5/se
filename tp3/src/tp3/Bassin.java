package tp3;

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
    	this.nbClient = 0;
    }

    /**
     * Nombre maximum de client autorisé dans le vestiaire
     */
    public static final int MAX_CLIENT = 50;
    
    /**
     * Nombre de client présent dans le vestiaire
     */
    private static int nbClient = 0;
    
    /**
     * Accéder au bassin
     * @param client le clien qui accède dans le bassin
     */
    public synchronized void entrerBassin() {
    	while(this.nbClient >= MAX_CLIENT) {
    		try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    	this.nbClient++;
    }
    
    /**
     * Sortir du bassin
     * @param client Le client qui sort du bassin 
     */
    public synchronized void quitterBassin() {
    	this.nbClient--;
    	notify();// Pour consommer moins de ressources
    }
    
    
    
    /**
     * Setter
     * @param vendTicket Le nombre de client
     */
    public void setNbClient(int nbClient) {
    	this.nbClient = nbClient;
    }
    
    /**
     * Getter
     * @return Le nombre de client
     */
    public int getNbClient() {
    	return this.nbClient;
    }
    	
}