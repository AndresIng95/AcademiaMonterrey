package base;
/* Lista que tiene que tener el proyecto
 Polimorfismo              !!!!!!!!!!!!!
 Casting					!!!!!!!!!!!
 Singleton					!!!!!!!!!!!!!!!!
 HAS-A IS-A					!!!!!!!!!!!!!!!!
 Comparables Comparators	!!!!!!!!!!!!
 Anonimas					!!!!!!!!!!!
 Inmutabilidad
 Static    					!!!!!!!!!!!!!!
 Final						!!!!!!!!!!!!
 Generics					!!!!!!!!!!!!!!!!!
 Interfaces					!!!!!!!!!!!!!!!!!!
 Abstract					!!!!!!!!!!!!!!!!!!!
 Constructors				!!!!!!!!!!!!!!!!!!!
 Modificadores de acceso	!!!!!!!!!!!!!!!!!!
 Encapsulacion				!!!!!!!!!!!
 Lambdas
*/


public class Main {

	public static void main(String[] args) {
		//Si es miembro, con entrada de nombre y boolean, se usan clases anonimas para crear productos en el manejo del
		//carrito
		Cliente cliente = new Cliente("John", true);

		cliente.getCarrito().addProduct(
				//Esto es un anonimo
		    new Alimento(1,"Manzana", 40.00,true)
		);

		cliente.getCarrito().addProduct(
		    new Alimento(2,"Lata de Conserva", 60.00, false)
		);

		double total = cliente.getCarrito().getTotal();

		double amountPaid = cliente.getMetodoPago().pay(total);

		//Polimorfismo en objetos
		System.out.println("\nSeccion base, revisando contador, polimorfismo en objetos,getters: ");
		System.out.println("Client: " + cliente.getNombre());
		System.out.println("Original total: $" + total);
		System.out.println("Final total: $" + amountPaid);
		
		//No es miembro
		Cliente cliente2 = new Cliente("Lola", false);

		cliente2.getCarrito().addProduct(
		    new Alimento(3,"Pastel", 100.00,true)
		);

		cliente2.getCarrito().addProduct(
		    new Electronico(4,"Pantalla", 400.00, "Samsung")
		);
		
		cliente2.getCarrito().addProduct(
			new Ropa(5,"Blusa", 200.00, 'M')
		);


		double total2 = cliente2.getCarrito().getTotal();

		//Aunque no he implementado otro metodo de pago, la estructura esta, la instancia de pagomiembro hace override a metodo
		//pago, aunque la implementacion concreta es hasta el metodo checkout mas abajo en la seccion transaccion
		double amountPaid2 = cliente2.getMetodoPago().pay(total2);

		System.out.println("Client: " + cliente2.getNombre());
		System.out.println("Original total: $" + total2);
		System.out.println("Final total: $" + amountPaid2);
		//No hay descuento, el total es 700.
		
		//Agrege 5 productos, cuenta 5 gracias a static
		System.out.println(Producto.getProductCounter());
		
		System.out.println("\nSeccion de comparator: ");
	    System.out.println("Productos sin sort:");

	    for (Producto product1 : cliente2.getCarrito().getProducts()) {
	        System.out.println(
	            product1.getName() + " - $" + product1.getPrice()
	        );
	    }
	    
		
	    // Sort alfabeticamente
	    cliente2.getCarrito().sort(ProductComparator.byName());

	    System.out.println("Productos alfabeticamente:");

	    for (Producto product2 : cliente2.getCarrito().getProducts()) {
	        System.out.println(
	            product2.getName() + " - $" + product2.getPrice()
	        );
	    }
	    
	    cliente2.getCarrito().sort(ProductComparator.byPrice());

	    System.out.println("Productos por precio:");

	    for (Producto product : cliente2.getCarrito().getProducts()) {
	        System.out.println(
	            product.getName() + " - $" + product.getPrice()
	        );
	    }

		
		Cliente cliente3 = new Cliente("Perez", false);
		//Agregar un alimento varias veces
		Alimento alimento1 = new Alimento(6,"Filete",50.00,true);

		cliente3.getCarrito().addProduct(alimento1);

		cliente3.getCarrito().addProduct(alimento1);
		

		double total3 = cliente3.getCarrito().getTotal();

		double amountPaid3 = cliente3.getMetodoPago().pay(total3);
		
		System.out.println("\nCaso de uso de counter repitiendo producto: ");
		System.out.println("Client: " + cliente3.getNombre());
		System.out.println("Original total: $" + total3);
		System.out.println("Final total: $" + amountPaid3);
		
		System.out.println(Producto.getProductCounter());
		//Se agrego un alimento base sin usar anonimas para demostrar que product counter no se aumenta si es el mismo
		//producto, se agrego filete dos veces al carrito y se aplico bien.
		
		//Sistema singleton para hacer el checkout del dia con el dinero recibido
		//Printea por cliente
		
		
		System.out.println("\nCheckout con singleton de Transacciontienda: ");
		System.out.println(cliente.checkout());
	    System.out.println(cliente2.checkout());
	    System.out.println(cliente3.checkout());
		
	    //Printea total
		System.out.println(
			        "Total money: $" + Transacciontienda.INSTANCE.getTotalMoney()
			    );
		
		//Seccion de casting con objetos, primitivos esta sencillo como para demostrar
		
		Alimento alimento2 = new Alimento(7,"Tortilla",20.00,true);
		
		Producto productoupcasting = alimento2;
		
		System.out.println("\nUpcasting: ");
		System.out.println(productoupcasting.getName());
		System.out.println(productoupcasting.getPrice());
		
		Producto product2 = new Ropa(8,"Pantalon", 40.00,'G');

		Ropa ropadowncast = (Ropa) product2;
		
		System.out.println("\nDowncasting: ");
		System.out.println(ropadowncast.getName());
		System.out.println(ropadowncast.getPrice());
		//Objeto product2 puede acceder al metodo de gettalla de la ropa sin problema
		System.out.println(ropadowncast.getTalla());
		
		
		System.out.println("\nCambiar un producto con setter y aplicacion de override: ");
		Producto product3 = new Ropa(9,"Chaqueta", 85.00,'S');
		System.out.println(product3);
		Ropa ropadowncast2 = (Ropa) product3;
		ropadowncast2.setTalla('G');
		System.out.println(product3);
		
		System.out.println("\nLambdas: ");
		cliente2.getCarrito()
	      .getProducts()
	      .forEach(product4 ->
	          System.out.println(
	              product4.getName() + " - $" + product3.getPrice()
	          )
	      );
	}

}


