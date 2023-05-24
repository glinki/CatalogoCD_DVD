
public interface Procesable {
	/** Interfaz con los METODOS PRINCIPALES  **/
		
 public void Agregar (Disco d,int opcion );
 public void modificar(Disco d,int opcion);
 public void eliminar(Disco d,int opcion);
 public void listar( int opcion);
 public void informar ( int opcion);
 public void Ordenar ( int opcion );
	
/**//****** METODOS DE UTILIDAD General ********//**//**/
 
 public int buscarXTitulo ( int tipoDeDato) ;
 public void loTengo ( int opcion ) ;
 public void mostrar ( int opcion );
}
