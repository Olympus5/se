package tp3;

/**
 * Object client
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 3.0
 */
public class Client extends Thread {
	
	/**
	 *  Boolean qui permet de savoir si le client va ou non prendre des palmes
	 */
	private boolean palmes;

	
	/**
	 * Default constructor
	 */
	public Client(Piscine piscine) {
		this.piscine = piscine;
		this.palmes =  Math.random() < 0.5;
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
	
	/**
	 * Action de prendre des palmes dans le palmesStore
	 */
	public void prendrePalmes() {
		this.piscine.prendrePalmes(this);
	}
	
	/**
	 * Action de rendre des palmes dnas le palmesStore 
	 */
	public void rendrePalmes() {
		this.piscine.rendrePalmes(this);
	}

	/**
	 *  Trajet dans la piscine du client
	 */
	@Override
	public void run() {
		this.acheterTicket();
		this.allerVestiaire();
		
		if(this.palmes) {
			this.prendrePalmes();
		}
		
		this.allerBassin();
		
		if(this.palmes) {
			this.rendrePalmes();
		
		}
		this.allerVestiaire();
		System.out.println("Je quitte la piscine. Il reste: " + --this.nbClient + " clients.");
	}

}