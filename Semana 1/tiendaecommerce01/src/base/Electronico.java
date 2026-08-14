package base;

public class Electronico extends Producto {
	String Brand;

	public Electronico(int pID, String nombre, double precio, String brand) {
		super(pID, nombre, precio);
		Brand = brand;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}



	
}
