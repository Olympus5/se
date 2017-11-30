package tp3;

/**
 * Object client
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Client extends Thread {
	/**
	 * Default constructor
	 */
	public Client(Piscine piscine) {
		this.piscine = piscine;
	}

	/**
	 * La piscine
	 */
	private Piscine piscine;
	
	/**
	 * deboguage
	 */
	private static int nbClient = 100;
	
	/**
	 * Action d'acheter un ticket
	 */
	public void acheterTicket() {
		this.piscine.allerComptoir(this);
	}

	/**
	 * Action d'aller dans et de sortir des vestiaires
	 */
	public void allerVestiaire() {
		this.piscine.allerVestiaire(this);
	}

	/**
	 * Action d'aller dans et de sortir du bassin
	 */
	public void allerBassin() {
		this.piscine.allerBassin(this);
	}

	@Override
	public void run() {
		this.acheterTicket();
		this.allerVestiaire();
		this.allerBassin();
		this.allerVestiaire();
		System.out.println("Client " + this.getName() + " dit:Je quitte la piscine. Il reste: " + --this.nbClient + " clients. " + this.activeCount());
	}

}