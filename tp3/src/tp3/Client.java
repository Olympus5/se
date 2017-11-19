package tp3;

import java.util.*;

/**
 * Client object
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
     * 
     */
    private int id;

    /**
     * 
     */
    private boolean ticket;

    /**
     * 
     */
    private Piscine piscine;

    /**
     * 
     */
    private Zone zone;

    /**
     * 
     */
    public void acheterTicket() {
        this.piscine.gestionComptoir(this);
        this.zone = Zone.Comptoir;
        this.ticket = true;
        System.out.println("Client " + this.getName() + " dit: j'achète un ticket.");
    }

    /**
     * 
     */
    public void allerVestiaire() {
        this.piscine.gestionVestiaire(this);
        this.zone = Zone.Vestiaire;
        System.out.println("Client " + this.getName() + " dit: je vais dans le vestiaire.");
    }

    /**
     * 
     */
    public void allerBassin() {
        this.piscine.gestionBassin(this);
        this.zone = Zone.Bassin;
        System.out.println("Client " + this.getName() + " dit: je vais dans le bassin.");
    }

    /**
     * 
     */
    public void quitterPiscine() {
    	this.zone = Zone.Dehors;
        this.ticket = false;
        System.out.println("Client " + this.getName() + " dit: Je quitte la piscine.");
    }
    
    @Override
    public void run() {
    	while(true) {
    		this.acheterTicket();
    		this.allerVestiaire();
    		this.allerBassin();
    		this.allerVestiaire();
    		this.quitterPiscine();
    	}
    }

}