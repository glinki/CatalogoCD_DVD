

public interface Modificable {
/***
 * Modifica el titulo de un disco, encontrado a traves de la posicion pos, ingresando
 * el nuevo titulo por teclado.
 * @param catalogo Lugar donde se encuentran los discos
 * @param pos posicion donde se encuentra el disco
 * @param entrada ingreso del dato por teclado
 * @author ivang
 */
public void modificarTitulo (int pos );

/***
 * Modifica el genero de un disco, encontrado a traves de la posicion pos, ingresando
 * el nuevo genero por teclado. 
 * @param catalogo Lugar donde se encuentran los discos
 * @param pos posicion donde se encuentra el disco
 * @param entrada ingreso del dato por teclado
 * @author ivang
 */
public void modificarGenero ( int pos );

/***
 * Modifica la duracion de un disco, encontrado a traves de la posicion pos, ingresando
 * la nueva duracion por teclado.
 * @param catalogo Lugar donde se encuentran los discos
 * @param pos posicion donde se encuentra el disco
 * @param entrada ingreso del dato por teclado
 * @author ivang
 */
public void modificarDuracion (  int posicion );

/***
 * Modifica el comentario de un disco, encontrado a traves de la posicion pos, ingresando
 * el nuevo comentario por teclado. 
 * @param catalogo Lugar donde se encuentran los discos
 * @param pos posicion donde se encuentra el disco
 * @param entrada ingreso del dato por teclado
 * @author ivang
 */
public void modificarComentario ( int posicion );

/***
 * Modifica el valor 'loTengo' de un disco, encontrado a traves de la posicion pos, ingresando
 * el nuevo 'loTengo' por teclado. 
 * @param catalogo Lugar donde se encuentran los discos
 * @param pos posicion donde se encuentra el disco
 * @param entrada ingreso del dato por teclado
 * @author ivang
 */
public void modificarLoTengo ( int posicion );

}
