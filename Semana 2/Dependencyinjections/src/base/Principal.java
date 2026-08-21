package base;

public class Principal {

	public static void main(String[] args) {
		//Se inicia con una clase estudiante, y clase abstracta celular, 
		//Esta es la parte de inyeccion por variable a traves de inyector, donde directamente se inyecta un objeto variable a 
		// la instancia de estudiante
		Student estudiante = Inyector.getStudent();
		Inyector.inyectarphone(estudiante);
		estudiante.usarphone(); //Muestra celular android enciende
		
		//Cambiamos de variable en el inyector, aunque tecnicamente para la demostracion en usarphone se deberia cambiar, pero
		//para fines de demostracion se uso inyectarphone2
		Inyector.inyectarphone2(estudiante);
		System.out.println("************ ");
		estudiante.usarphone();
		
		System.out.println("\n");
		
		//Seccion de inyeccion por setter
		Inyector.inyectarclub(estudiante);
		estudiante.queclub();
		System.out.println("************ ");
		Inyector.inyectarclub2(estudiante);
		estudiante.queclub();
		
		System.out.println("\n");
		//Inyeccion por constructor, default es por camion, pero si se llama getStudent2(), se cambia por carro
		//Para fines de diferenciacion, getstudent2() usa Anon2 como nombre
		estudiante.transporte();
		System.out.println("************ ");
		Student estudiante2 = Inyector.getStudent2();
		estudiante2.transporte();

	}

}
