package base;

public class Cliente {
	String nombre;
	boolean membresia;
	//Parametrizar el carrito con el objeto abstracto	
	Carrito<Producto> carrito;
	public Cliente(String nombre, boolean membresia) {
		super();
		this.nombre = nombre;
		this.membresia = membresia;
		this.carrito = new Carrito<>();
	}
	
}
