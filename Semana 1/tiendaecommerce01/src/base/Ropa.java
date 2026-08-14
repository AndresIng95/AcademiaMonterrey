package base;

public class Ropa extends Producto {
	char talla;

	public Ropa(int pID, String nombre, double precio, char talla) {
		super(pID, nombre, precio);
		this.talla = talla;
	}

	public char getTalla() {
		return talla;
	}

	public void setTalla(char talla) {
		this.talla = talla;
	}


	
}
