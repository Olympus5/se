package tp3;

/**
 * Piscine object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Piscine {

    /**
     * Constructor
     */
    public Piscine(Comptoir comptoir, Vestiaire vestiaire, Bassin bassin) {
    	this.comptoir = comptoir;
    	this.vestiaire = vestiaire;
    	this.bassin = bassin;
    }

    /**
     * Le bassin
     */
    private Bassin bassin;

    /**
     * Le guichet
     */
    private Comptoir comptoir;
    /**
     * Le vestiaire
     */
    private Vestiaire vestiaire;

    /**
     * Va au comptoir
 	 * @param client Le client qui va au comptoir
     */
    public void allerComptoir(Client client) {
    	this.comptoir.acheterTicket(client);
    }

    /**
     * Va au vestiaire
 	 * @param client Le client qui va au vestiaire
     */
    public void allerVestiaire(Client client) {
    	this.vestiaire.entrerVestiaire();
		
		//System.out.println("Client " + client.getName() + " dit: je vais dans le vestiaire.");
		
		try {
			client.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.vestiaire.quitterVestiaire();
		
		//System.out.println("Client " + client.getName() + " dit: je quitte le vestiaire.");
    }

    /**
     * Va au comptoir
 	 * @param client Le client qui va au vestiaire
     */
    public void allerBassin(Client client) {
    	this.bassin.entrerBassin();
		
		//System.out.println("Client " + client.getName() + " dit: je vais dans le bassin.");
		
        try {
        	client.sleep((int) (Math.random() * 10000));
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        this.bassin.quitterBassin();
        
		//System.out.println("Client " + client.getName() + " dit: je quitte le bassin.");
    }
}