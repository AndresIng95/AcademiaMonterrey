package base;

public class Cliente {
	private String nombre;
	private boolean membresia;
	//Parametrizar el carrito con el objeto abstracto	
	Carrito<Producto> carrito;
	public Cliente(String nombre, boolean membresia) {
		super();
		this.nombre = nombre;
		this.membresia = membresia;
		this.carrito = new Carrito<>();
	}
	public String getNombre() {
		return nombre;
	}
	public boolean isMembresia() {
		return membresia;
	}
	public void setMembresia(boolean membresia) {
		this.membresia = membresia;
	}
	
	
}
