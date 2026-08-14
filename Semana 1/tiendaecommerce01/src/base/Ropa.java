package base;

public class Ropa extends Producto {
	String talla;

	public Ropa(int pID, String nombre, double precio, String talla) {
		super(pID, nombre, precio);
		this.talla = talla;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}


	
}
