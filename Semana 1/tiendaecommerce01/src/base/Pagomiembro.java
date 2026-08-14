package base;

public class Pagomiembro implements MetodoPago {
	
	private static final double DISCOUNT = 0.10;
    private boolean isMember;

    public Pagomiembro(boolean isMember) {
        this.isMember = isMember;
    }

    @Override
    public double pay(double amount) {
        if (isMember) {
            return amount * (1 - DISCOUNT);
        }

        return amount;
    }

    public boolean isMember() {
        return isMember;
    }

}
