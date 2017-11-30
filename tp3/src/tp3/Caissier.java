/**
 * 
 */
package tp3;

/**
 * @author erwan
 *
 */
public class Caissier extends Thread {
	/**
	 * Comptoir de la piscine
	 */
	Comptoir comptoir;
	
	/**
	 * Nombre de client dans la piscine
	 */
	int nbClient;
	
	/**
	 * Identifiant du client
	 */
	int id;
	
	/**
	 * Constructeur
	 * @param c
	 * @param nbClient
	 */
	public Caissier(Comptoir c, int nbClient, int id) {
		this.comptoir = c;
		this.id = id;
		this.setDaemon(true);
	}
	
	/**
	 * Action de vendre un ticket
	 */
	public void vendreTicket() {
		this.comptoir.vendreTicket(this);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Caissier n°" + this.id + ": Je peux vendre un ticket !");
			System.out.println(this.isDaemon());
			this.vendreTicket();
		}
	}
}
