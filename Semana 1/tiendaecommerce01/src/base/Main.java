package base;
/* Lista que tiene que tener el proyecto
 Polimorfismo              !!!!!!!!!!!!!
 Casting
 Singleton					!!!!!!!!!!!!!!!!
 HAS-A IS-A					!!!!!!!!!!!!!!!!
 Comparables Comparators
 Anonimas
 Inmutabilidad
 Static    					!!!!!!!!!!!!!!
 Final
 Generics					!!!!!!!!!!!!!!!!!
 Interfaces
 Abstract					!!!!!!!!!!!!!!!!!!!
 Constructors				!!!!!!!!!!!!!!!!!!!
 Modificadores de acceso	!!!!!!!!!!!!!!!!!!
 Encapsulacion				!!!!!!!!!!!
 Lambdas
*/

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("John", true);

		cliente.getCarrito().addProduct(
		    new Alimento(1,"Manzana", 40.00,true)
		);

		cliente.getCarrito().addProduct(
		    new Alimento(2,"Lata de Conserva", 60.00, false)
		);

		double total = cliente.getCarrito().getTotal();

		double amountPaid = cliente.getMetodoPago().pay(total);

		System.out.println("Client: " + cliente.getNombre());
		System.out.println("Original total: $" + total);
		System.out.println("Final total: $" + amountPaid);

	}

}
