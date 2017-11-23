package tp3;

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
    	this.nbClient = 0;
    }

    /**
     * Nombre maximum de client autorisé dans le vestiaire
     */
    public static final int MAX_CLIENT = 20;
    
    /**
     * Nombre de client présent dans le vestiaire
     */
    private static int nbClient = 0;
    
    /**
     * Acceder au vestiaire
     * @param client Le client qui accède au vestiaire
     */
    public synchronized void entrerVestiaire() {
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
     * Sortir du vestiaire
     * @param client Le client qui sort du vestiaire
     */
    public synchronized void quitterVestiaire() {
    	this.nbClient--;
    	notify();//Pour consommer moins de ressources proc !
    }
    
    
    /**
     * Setter
     * @param nbClient Le nombre de client
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