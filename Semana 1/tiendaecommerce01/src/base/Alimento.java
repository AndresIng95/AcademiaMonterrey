package base;

public class Alimento extends Producto {
	boolean perishable;

	public Alimento(String nombre, double precio, boolean perishable) {
		super(nombre, precio);
		this.perishable = perishable;
	}



	
}
