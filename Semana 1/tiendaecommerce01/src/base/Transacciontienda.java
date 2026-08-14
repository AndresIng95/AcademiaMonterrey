package base;

public enum Transacciontienda {
	
	//Para singleton, sera un array que solo tendra una instancia para guardar las transacciones de la tienda.
	//Preguntarle al profe si se puede usar enum para singleton

	INSTANCE;

	private double totalMoney = 0.0;

	public void addIncome(double amount) {
	    totalMoney += amount;
	}

	public double getTotalMoney() {
	    return totalMoney;
	}
}
