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
    	this.caissierLibre = 0;
    }
    
    /**
     * Nombre de caissire libre
     */
    private int caissierLibre;

    /**
     * Nombre de client dans le comptoir
     */
    //TODO: Ne pas oublier de tuer les 2 caissier quand il n'y a plus de clients
    
    /**
     * achat d'un ticket
     */
    public synchronized void acheterTicket(Client c) {//acheterTicket à juste besoin d'un simple verrou: 1 personne par guichet
    	if(this.caissierLibre <= 0) {
    		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	
    	this.caissierLibre--;
    	notifyAll();
    }
    
    /**
     * vente d'un ticket
     */
    public synchronized void vendreTicket(Caissier c) {
    	System.out.println("Coucou");
    	while(this.caissierLibre >= 2) {
    		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	
    	this.caissierLibre++;
    	notifyAll();
    }
    
    /**
     * Setter
     * @param caissierLibre Le nombre de caissier qui sont libres
     */
    public void setCaissierLibre(int caissierLibre) {
    	this.caissierLibre = caissierLibre;
    }
    
    /**
     * Getter
     * @return Le nombre de caissier qui sont libres
     */
    public int getCaissierLibre() {
    	return this.caissierLibre;
    }
}