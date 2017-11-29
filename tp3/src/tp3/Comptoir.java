package tp3;

import java.util.concurrent.Semaphore;

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
    	this.vendTicket = false;
    	this.caissierLibre = 0;
    	this.sem = new Semaphore(2);
    }

    /**
     * Etat de la vente
     */
    private boolean vendTicket;
    
    /**
     * Nombre de caissire libre
     */
    private int caissierLibre;

    private Semaphore sem;
    
    /**
     * Nombre de client dans le comptoir
     */
    //TODO: Ne pas oublier de tuer les 2 caissier quand il n'y a plus de clients
    
    /**
     * achat d'un ticket
     */
    public void acheterTicket(Client c) {//acheterTicket à juste besoin d'un simple verrou: 1 personne par guichet
    	try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	try {
			Thread.sleep((int)(Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	sem.release();
    }
    
    /**
     * vente d'un ticket
     */
    public synchronized void vendreTicket(Caissier c) {
    	System.out.println("Coucou");
    	if(this.caissierLibre >= 2) {
    		try {wait();} catch (InterruptedException e) {e.printStackTrace();}
    	}
    	
    	this.caissierLibre++;
    	notifyAll();
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