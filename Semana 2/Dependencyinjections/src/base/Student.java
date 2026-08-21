package base;

public class Student {
	String nombre;
    private Club club;
    private Transport transporte;
    public Cellphone celular;
    
    public Student (String nombre) {
    	this.nombre = nombre;
    }
    
    void usarphone() {
    	celular.encender();
    }
}
