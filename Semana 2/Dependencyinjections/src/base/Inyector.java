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
	
	static Student getStudent() {
		Transport transportestuden = new Bustransport();
		return new Student("Anon",transportestuden);	
	}
	
	static Student getStudent2() {
		Transport transportestuden = new Cartransport();
		return new Student("Anon2",transportestuden);	
	}



}
