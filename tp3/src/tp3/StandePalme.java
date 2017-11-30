    	package tp3;


/**
 * PalmesStore object
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 3.0
 */
public class StandePalme {
	
	final static int NBPALMESMAX = 10;
	private int nbPairPalmes;
	
	 /**
     * Default constructor
     */
	public StandePalme() {
		this.nbPairPalmes=StandePalme.NBPALMESMAX;
	}
	
	/**
	 *  fonction qui permet de prendre une pair de palmes au PamesStore 
	 */
	public synchronized void PrendrePalmes() {
		while(this.nbPairPalmes <=0) {  
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.nbPairPalmes--;
		System.out.println("il reste " + this.nbPairPalmes + " palmes");
		notify();
	}
	
	/**
	 *  fonction qui permet de rendre une pair de palmes 
	 */
	public synchronized void RendrePalmes()  {
		this.nbPairPalmes++;
		System.out.println("il reste " + this.nbPairPalmes + " palmes");
		notify();
	}
}

