package base;

public class Inyector {
	//Por variable directa a la clase student
	static void inyectarphone(Student studen) {
		studen.celular= new Androidphone();
	}
	static void inyectarphone2(Student studen) {
		studen.celular= new Iphone();
	}
	
	// Por setter a la clase student, para fines de demostraccion se muestra que setclub puede aceptar varios objetos club
	static void inyectarclub(Student studen) {
		studen.setClub(new Soccerclub());
	}
	static void inyectarclub2(Student studen) {
		studen.setClub(new Bookclub());
	}


}
