package base;

public class Inyector {
	static void inyectarphone(Student studen) {
		studen.celular= new Androidphone();
	}
	static void inyectarphone2(Student studen) {
		studen.celular= new Iphone();
	}

}
