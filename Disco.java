
public abstract class Disco implements Global_Variable{
	protected int Tipo; // 1 Dvd ::::: 2 CD
	protected String Titulo;
	protected String Genero;
	protected int Duracion;	
	protected String Comentario;
	protected boolean LoTengo;
	
	
	public Disco(){
		this (0," "," ",0," ",false);
	}

	public Disco(int tipo, String titulo, String genero, int duracion, String comentario, boolean loTengo) {	
		Tipo = tipo; 
		Titulo = titulo;
		Genero = genero;
		Duracion = duracion;
		Comentario = comentario;
		LoTengo = loTengo;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public boolean isLoTengo() {
		return LoTengo;
	}

	public void setLoTengo(boolean loTengo) {
		LoTengo = loTengo;
	}


	public String getTipo(int tipo)
	{String cad = "";
		switch (tipo ) {
		case 1: cad = "DVD"; break;
		case 2: cad = "CD"; break;
		default: cad = "DISCO"; break ;
		}
		return cad;
	}
	
	public int getTipo(String cad )
	{int tipo = 0 ;
		switch (cad ) {
		case "DVD": tipo = DVD; break;
		case "CD": tipo = CD; break;
		default: tipo = 0; break ;
		}
		return tipo;
	}
	
	@Override
	public String toString() {
		return getTipo(Tipo) +" [Titulo=" + Titulo + 
				", Genero=" + Genero + 
				", Duracion=" + Duracion + 
				", Comentario="+ Comentario + 
				", LoTengo=" + LoTengo + "]";
	}

	/***
	 * Recibe un elemento de tipo Disco y lo transforma en una cadena simple 
	 * separando sus campos por 'coma' para
	 * escribir en un archivo.
	 * @return la cadena que se copiará en el archivo.
	 */
	public String aString() {
		return getTipo(Tipo) +"," + Titulo + 
				"," + Genero + "," + Duracion + 
				","+ Comentario + "," + LoTengo ;
	}

} /// FIN 