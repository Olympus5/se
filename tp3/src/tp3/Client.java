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
	 * Action d'acheter un ticket
	 */
	public void acheterTicket() {
		this.piscine.getComptoir().acheterTicket();
		
		System.out.println("Client " + this.getName() + " dit: j'achète un ticket.");
	}

	/**
	 * Action d'aller dans et de sortir des vestiaires
	 */
	public void allerVestiaire() {
		this.piscine.getVestiaire().entrerVestiaire();
		
		System.out.println("Client " + this.getName() + " dit: je vais dans le vestiaire.");
		
		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.piscine.getVestiaire().quitterVestiaire();
		
		System.out.println("Client " + this.getName() + " dit: je quitte le vestiaire.");
	}

	/**
	 * Action d'aller dans et de sortir du bassin
	 */
	public void allerBassin() {
		this.piscine.getBassin().entrerBassin();
		
		System.out.println("Client " + this.getName() + " dit: je vais dans le bassin.");
		
        try {
        	sleep((int) (Math.random() * 10000));
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        this.piscine.getBassin().quitterBassin();
        
		System.out.println("Client " + this.getName() + " dit: je quitte le bassin.");
	}

	@Override
	public void run() {
		this.acheterTicket();
		this.allerVestiaire();
		this.allerBassin();
		this.allerVestiaire();
	}

}