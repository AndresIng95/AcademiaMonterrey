package base;

public class Cliente {
	private String nombre;
	private boolean membresia;
    private Carrito<Producto> carrito;
    private MetodoPago metodopago;
	//Parametrizar el carrito con el objeto abstracto	
	public Cliente(String nombre, boolean membresia) {
		super();
		this.nombre = nombre;
		this.membresia = membresia;
		this.carrito = new Carrito<>();
		this.metodopago = new Pagomiembro(membresia);
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

    public Carrito<Producto> getCarrito() {
        return carrito;
    }

    public MetodoPago getMetodoPago() {
        return metodopago;
    }
	
}
