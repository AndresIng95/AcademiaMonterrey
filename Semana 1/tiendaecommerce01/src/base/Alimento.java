package base;

public class Alimento extends Producto {
	boolean perishable;

	public Alimento(int pID, String nombre, double precio, boolean perishable) {
		super(pID, nombre, precio);
		this.perishable = perishable;
	}

	public boolean isPerishable() {
		return perishable;
	}

	public void setPerishable(boolean perishable) {
		this.perishable = perishable;
	}



	
}
