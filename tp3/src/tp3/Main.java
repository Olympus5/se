/**
 * 
 */
package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erwan
 *
 */
public class Main {
	
	public static final int MAX_VESTIAIRE = 20;
	public static final int MAX_BASSIN = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Client> cl = new ArrayList<Client>();
		Comptoir c = new Comptoir();
		Vestiaire v = new Vestiaire(MAX_VESTIAIRE);
		Bassin b = new Bassin(MAX_BASSIN);
		Piscine p = new Piscine(c, v, b);
		
		for(int i = 0; i < 100; i++) {
			cl.add(new Client(p));
		}
		
		for(int i = 0; i < 100; i++) {
			cl.get(i).start();
		}
	}

}
