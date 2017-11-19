/**
 * 
 */
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
		Piscine p = new Piscine();
		
		for(int i = 0; i < 100; i++) {
			cl.add(new Client(p));
		}
		
		for(int i = 0; i < 100; i++) {
			cl.get(i).start();	
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
