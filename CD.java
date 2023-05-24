
public class CD extends Disco {

	private int cantTemas;
	private String interprete;
	 
	public CD(int tipo,String titulo, String genero, int duracion, String comentario, boolean loTengo,
			int cantTemas, String interprete) {
		super(tipo,titulo, genero, duracion, comentario, loTengo);
		this.cantTemas = cantTemas;
		this.interprete = interprete;
	}
	
	public CD (String linea) {
		String aux [] = linea.split(","); // separator
		Tipo = super.getTipo(aux[0]);
		Titulo = aux[1];
		Genero = aux[2];
		Duracion = Integer.parseInt(aux[3]);
		Comentario = aux[4];
		LoTengo = Boolean.parseBoolean(aux[5]);
		
		cantTemas = Integer.parseInt(aux[6]);
		interprete = aux[7];
	}

	public CD (int cantT, String interprete){
		super (CD," "," ",0," ",false );
		this.cantTemas = cantT;
		this.interprete = interprete;
	}

	public CD (){
		super (CD," "," ",0," ",false );
		
		this.cantTemas = 0 ;
		this.interprete = null;
	}

	public int getCantTemas() {
		return cantTemas;
	}

	public void setCantTemas(int cantTemas) {
		this.cantTemas = cantTemas;
	}

	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	
	@Override
	public String toString() {
		return "[" + super.toString() + 
				", cantTemas=" + cantTemas + 
				", interprete=" + interprete + "]\n";
	}
	
	@Override
	public String aString() {
		return super.aString() + "," + cantTemas + "," + interprete + "\n" ;
	}
	
}/// Fin 