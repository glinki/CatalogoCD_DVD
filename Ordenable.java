

public interface Ordenable  {
/***
 * Ordena de forma Ascendente por nombre del titulo
 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
 * @param opcion tipo de disco
 * @author ivang
 */
public void ordenarXTitulo ( int opcion  );

	/***
	 * Ordena de forma Ascendente por nombre del Genero
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXGenero ( int opcion);
	
/***
	 * Ordena de forma Ascendente por duracion
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXDuracion ( int opcion );

/***
	 * Ordena de forma Ascendente por comentario
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXComentario ( int opcion );

/***
	 * Ordena de forma Ascendente el parametro 'loTengo'
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXLoTengo (int opcion );

/***
 * Ordena de forma Descendente por nombre del titulo
 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
 * @param opcion tipo de disco
 * @author ivang
 */
public void ordenarXTitulo_Descendente ( int opcion  );

	/***
	 * Ordena de forma Descendente por nombre del Genero
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXGenero_Descendente ( int opcion);
	
/***
	 * Ordena de forma Descendente por duracion
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXDuracion_Descendente ( int opcion );

/***
	 * Ordena de forma Descendente por comentario
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXComentario_Descendente ( int opcion );

/***
	 * Ordena de forma Descendente el parametro 'loTengo'
	 * @param catalogo Lugar de Busqueda y ordenamiento de los Discos
	 * @param opcion tipo de disco
	 * @author ivang
	 */
public void ordenarXLoTengo_Descendente (int opcion );

}
