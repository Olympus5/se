package tp3;

/**
 * Piscine object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Piscine {

    /**
     * Default constructor
     */
    public Piscine() {
    	this.bassin = new Bassin();
    	this.comptoir = new Comptoir();
    	this.vestiaire = new Vestiaire();
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
     * Getter
     * @return le comptoir
     */
    public Comptoir getComptoir() {
    	return this.comptoir;
    }

    /**
     * Getter
     * @return Le vestiaire
     */
    public Vestiaire getVestiaire() {
    	return this.vestiaire;
    }

    /**
     * Getter
     * @return Le bassin
     */
    public Bassin getBassin() {
        return this.bassin;
    }
}