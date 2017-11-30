package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erwan IQUEL, Mathieu LE CLEC'H
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Client> cl = new ArrayList<Client>();
		List<Caissier> ca = new ArrayList<Caissier>();
		Comptoir comptoir = new Comptoir();
		Vestiaire vestiaire = new Vestiaire();
		Bassin bassin = new Bassin();
		Piscine p = new Piscine(comptoir, vestiaire, bassin);
		
		for(int i = 0; i < 100; i++) {
			cl.add(new Client(p));
		}
		
		for(int i = 0; i < 2; i ++) {
			ca.add(new Caissier(comptoir, 100, i));
		}
		
		for(int i = 0; i < 100; i++) {
			cl.get(i).start();	
		}
		

		for(int i = 0; i < 2; i++) {
			ca.get(i).start();	
		}
		
		for(int i = 0; i < 100; i++) {
			try {
				cl.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
