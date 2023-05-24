
public class Dvd  extends Disco {

private String director;


public Dvd(int tipo, String titulo, String genero, int duracion, String comentario, boolean loTengo, String director) {
	super(tipo,titulo, genero, duracion, comentario, loTengo);
	this.director = director;
}
	
public Dvd (String director){
	super (DVD," "," ",0," ",false);
	this.director = director;
}
	
public Dvd (String linea, int tipo) {
	String aux [] = linea.split(","); // separator
	Tipo = super.getTipo(aux[0]);
	Titulo = aux[1];
	Genero = aux[2];
	Duracion = Integer.parseInt(aux[3]);
	Comentario = aux[4];
	LoTengo = Boolean.parseBoolean(aux[5]);
		
	director = aux[6];
}
	
public Dvd () {
	super (DVD," "," ",0," ",false);
	director = null;
}

public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", director=" + director + "]\n";
	}
	
@Override
public String aString() {
		return super.aString() + "," + director + "\n" ;
}
	
} /// Fin