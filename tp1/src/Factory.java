//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Factory represent a factory with two processing workshops.
 * A factory has a stock of products to process and, a stock of processed products (initially empty).
 * Both workshops process half of the products. The method activate() launch successively the two
 * workshops and then print the state of the stocks when the processing is finished.
 */
class Factory {
	/**
	 * source stock
	 */
    Stock sourceStock = new Stock("source", 10);
    /**
     * destination stock
     */
    Stock destinationStock = new Stock("destination", 0);
    /**
     * processing workshops
     */
    Workshop workshop1 = new Workshop(sourceStock, destinationStock, 5);
    Workshop workshop2 = new Workshop(sourceStock, destinationStock, 5);
    
    /**
     * Launch the factory work
     */
    public void activate() {
    		workshop1.work();
    		workshop2.work();
    		sourceStock.print();
    		destinationStock.print();
    }
    
    /**
     * Entry point for the lab
     * @param args Not used
     */
    public static void main(String[] args) {


    }
}
