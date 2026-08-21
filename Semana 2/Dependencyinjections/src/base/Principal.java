package base;

public class Principal {

	public static void main(String[] args) {
		//Se inicia con una clase estudiante, y clase abstracta celular, 
		//Esta es la parte de inyeccion por variable a traves de inyector, donde directamente se inyecta un objeto variable a 
		// la instancia de estudiante
		Student estudiante = new Student("Anon");
		Inyector.inyectarphone(estudiante);
		estudiante.usarphone(); //Muestra celular android enciende
		
		//Cambiamos de variable en el inyector, aunque tecnicamente para la demostracion en usarphone se deberia cambiar, pero
		//para fines de demostracion se uso inyectarphone2
		Inyector.inyectarphone2(estudiante);
		System.out.println("************ ");
		estudiante.usarphone();

	}

}
