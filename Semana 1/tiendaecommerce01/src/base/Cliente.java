package base;

public class Cliente {
	private String nombre;
	private boolean membresia;
	//Polymorfismo, capacidad de meter directamente objetos especificos en carrito
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
	protected void setMembresia(boolean membresia) {
		this.membresia = membresia;
	}

    public Carrito<Producto> getCarrito() {
        return carrito;
    }

    public MetodoPago getMetodoPago() {
        return metodopago;
    }
    
    public double checkout() {
        double originalTotal = carrito.getTotal();

        double finalTotal = metodopago.pay(originalTotal);

        Transacciontienda.INSTANCE.addIncome(finalTotal);

        return finalTotal;
    }
	
}
