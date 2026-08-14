package base;

public class Electronico extends Producto {
	protected String Brand;

	public Electronico(int pID, String nombre, double precio, String brand) {
		super(pID, nombre, precio);
		Brand = brand;
	}

	public String getBrand() {
		return Brand;
	}

	protected void setBrand(String brand) {
		Brand = brand;
	}



	
}
