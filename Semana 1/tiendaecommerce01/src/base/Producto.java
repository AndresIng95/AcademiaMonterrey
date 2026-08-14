package base;

public abstract class Producto {
	//Producto nunca va a existir solo, siempre sera alimento, Electronico o Ropa
	// Tambien hay variables protected, que solamente deben ser usadas por las subclases en si
	
	//Un contador estatico para demostrar una variable que no pertenece a una instancia de producto, para contar
	//cuantos productos son
	private static int productocounter = 0;
	
	private int pID;
	protected String nombre;
	protected double precio;
	public Producto(int pID,String nombre, double precio) {
		super();
		this.pID = pID;
		this.nombre = nombre;
		this.precio = precio;
		productocounter++;
	}
	
    public String getName() {
        return nombre;
    }

    public double getPrice() {
        return precio;
    }
    
    public int getpID() {
    	return pID;
    }
    
    public static int getProductCounter() {
        return productocounter;
    }
    
}
