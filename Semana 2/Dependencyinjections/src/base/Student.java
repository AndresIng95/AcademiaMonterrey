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
