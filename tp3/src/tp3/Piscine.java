package tp3;

/**
 * Piscine object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Piscine {

	/**
	 * Stande de palme
	 */
    private StandePalme palmesStore;

	/**
     * Constructor
     */
    public Piscine(Comptoir comptoir, Vestiaire vestiaire, Bassin bassin, StandePalme palmesStore) {
    	this.comptoir = comptoir;
    	this.vestiaire = vestiaire;
    	this.bassin = bassin;
    	this.palmesStore = palmesStore;
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
		
		System.out.println("Client " + client.getName() + " dit: je vais dans le vestiaire.");
		
		try {
			client.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.vestiaire.quitterVestiaire();
		
		System.out.println("Client " + client.getName() + " dit: je quitte le vestiaire.");
    }

    /**
     * Va au comptoir
 	 * @param client Le client qui va au vestiaire
     */
    public void allerBassin(Client client) {
    	this.bassin.entrerBassin();
		
		System.out.println("Client " + client.getName() + " dit: je vais dans le bassin.");
		
        try {
        	client.sleep((int) (Math.random() * 10000));
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        this.bassin.quitterBassin();
        
		System.out.println("Client " + client.getName() + " dit: je quitte le bassin.");
    }
    
    /**
     * Prend des palmes 
 	 * @param client Le client qui va prendre des palmes 
     */
    public void prendrePalmes(Client client) {
    	
    	System.out.println("Client " + client.getName() + " dit: je vais prendre des palmes.");
    	this.palmesStore.PrendrePalmes();
    	
    	
    	
    	try {
			client.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    /**
     * rendre des palmes 
 	 * @param client Le client qui va rendre des palmes 
     */
    public void rendrePalmes(Client client) {
    	System.out.println("Client " + client.getName() + " dit: je vais rendre des palmes.");
    	
    	this.palmesStore.RendrePalmes();
    	
    	
    	try {
			client.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}