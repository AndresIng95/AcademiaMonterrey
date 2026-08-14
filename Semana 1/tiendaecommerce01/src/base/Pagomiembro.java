package base;

public class Pagomiembro implements MetodoPago {
	
	//Static y final, ya que el descuento nunca va cambiar con la membresia, y no cambia con los objetos pago miembro.
	
	//Pago miembro podria hacerse abstracto para simplificar
	private static final double DISCOUNT = 0.10;
    private boolean isMember;

    public Pagomiembro(boolean isMember) {
        this.isMember = isMember;
    }

    @Override
    public double pay(double amount) {
        if (isMember) {
        	//O return amount * 0.90
            return amount * (1 - DISCOUNT);
        }

        return amount;
    }

    public boolean isMember() {
        return isMember;
    }

}
