package base;

public abstract class Producto {
	//Producto nunca va a existir solo, siempre sera alimento, Electronico o Ropa
	// Tambien hay variables protected, que solamente deben ser usadas por las subclases en si
	protected String nombre;
	protected double precio;
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
    public String getName() {
        return nombre;
    }

    public double getPrice() {
        return precio;
    }
}
