//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Stock represent a set of products stacked one above the other.
 * Due to the stack layout, it is not possible that two workshops take two products 
 * at the same time.
 */
class Stock {
	/**
	 * Number of products in the stack
	 */
    private int nbProducts;
    /**
     * Name of the stock
     */
    private String name;

    /**
     * Constructor
     * @param name: Name of the new stock
     * @param nbProducts: Initial number of products
     */
    public Stock(String name, int nbProducts) {
        this.nbProducts = nbProducts;
        this.name = name;
    }

    /**
     * Add a product on top of the stack
     */
    public void stock() {
        nbProducts++;
    }

    /**
     * Remove the highest product on the stack
     */
    public void destock() {
        nbProducts--;
    }

    /**
     * Print the state of the stock object
     */
    public void print() {
        System.out.println("Stock " + name + ": " + nbProducts + " product(s).");
    }

    /** 
     * Method main for unit testing
     * @param args Not used
     */
    static public void main(String[] args) {



    }
}
