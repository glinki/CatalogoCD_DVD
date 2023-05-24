
public interface Listable {
	/***
	 * Lista los Discos que coincidan con el texto ingresado por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param texto nombre del titulo a buscar
	 * @author ivang
	 */
	public void listarXTitulo ( int opcion, String texto  );
	
	/***
	 * Lista los Discos que coincidan con el texto ingresado por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param texto nombre del genero a buscar
	 * @author ivang
	 */
	public  void listarXGenero ( int opcion, String texto);
	
	/***
	 * Lista los Discos que coincidan con la duracion exacta ingresada por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param dur duracion exacta a listar
	 * @author ivang
	 */
	public  void listarXDuracionExacta ( int opcion, int dur );
	
	/***
	 * Lista los Discos que coincidan con el texto ingresado por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param texto nombre del Comentario a buscar
	 * @author ivang
	 */
	public  void listarXComentario ( int opcion, String texto );
	
	/***
	 * Lista los Discos que coincidan con el boolean ingresado por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param valor tipo de valor boolean (True or False ) a listar
	 * @author ivang
	 */
	public  void listarXLoTengo ( int opcion, boolean valor );
	
	/***
	 * Lista los Discos que coincidan con la duracion menor o igual ingresada por teclado
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @param dur duracion maxima o igual a listar
	 * @author ivang
	 */
	public  void listarXDuracionMenorIgual( int opcion ,int duracion);

	/***
	 * Lista los Discos segun el tipo
	 * @param catalogo Lugar de busqueda del Disco
	 * @param opcion Tipo de disco a Listar
	 * @author ivang
	 */
	public  void listarDisco ( int opcion );
	
	
}