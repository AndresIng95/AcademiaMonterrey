package base;

public class Student {
	String nombre;
    private Club club;
    private Transport transporte;
    public Cellphone celular;
    
    public Student (String nombre, Transport transporte) {
    	this.nombre = nombre;
    	this.transporte = transporte;
    }
    
    //Transporte da nombre para evidenciar que son 2 diferentes metodos contruidos ya que usa inyeccion por constructor
    void transporte() {
    	System.out.println("El nombre es " + nombre);
    	transporte.transporta();
    }
    
    void usarphone() {
    	celular.encender();
    }
    
    void queclub(){
    	club.attend();
    }

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
}
