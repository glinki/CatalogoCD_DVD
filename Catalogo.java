import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

public class Catalogo  implements Global_Variable,Procesable, 
								  Modificable,Listable, Ordenable{	
	protected ArrayList <Disco> catalogo;
	private Disco miDisco  ; 
	private CD miCd;
	private Dvd miDvd;
	Scanner entrada = new Scanner(System.in);
	private static Formatter salida;

	/***
	 * Metodo privado que permite generar una lista Inicial de Dvd´s y Cd´s
	 * para utilizar diversos metodos. 
	 */
private void cargarXDefecto( ){
	catalogo.add( new Dvd(DVD,"Matrix: Revoluciones","Accion",125,"Buena",false,"Hnos. Wachowsky"));
	catalogo.add( new CD (CD,"Cualquiera","Pop",46,"Bueno",true,12,"Autenticos Decadentes"));
	catalogo.add( new CD (CD,"Best hits","Musical",68,"Excelente",true,9,"Bethoven"));
	catalogo.add( new CD (CD,"Gulp","Rock",78,"Regular",false,18,"Patricio Rey"));
	catalogo.add( new CD (CD,"A song from USA","Pop",34,"Regular",false,8,"Hnos. Wachowsky"));
	catalogo.add( new CD (CD,"Grandes Exitos","Pop",64,"Bueno",true,19,"Autenticos Decadentes"));

	catalogo.add(new Dvd(DVD,"Matrix","Accion",123,"Regular",false,"Hnos. Wachowsky"));
	catalogo.add(new Dvd(DVD,"Thor","Comic",142,"Muy Buena",true,"Odin"));
	catalogo.add(new Dvd(DVD,"Houdini","Drama",100,"Mala",true,"Mago Black"));
	catalogo.add(new Dvd(DVD,"Titanic","Drama",189,"Excelente",false,"James Cameron"));
	catalogo.add(new Dvd(DVD,"Matrix: Recargado","Accion",142,"Muy Mala",true,"Hnos. Wachowsky"));
	catalogo.add(new Dvd(DVD,"Pepe","Comedia", 120, "Mala", false, "Stargate"));
		
	miDisco = new Dvd ("Ivan");
	catalogo.add(miDisco);
		
	miDisco = new CD (14,"Ivancho");
	catalogo.add(miDisco);
		
	miDvd = new Dvd (DVD,"AAAAAAAAAA","SA",123,"Mala",true,"Martes");
	catalogo.add(miDvd);
		
	miCd = new CD (CD,"Intento","Drama",12,"Malo",true,14,"Viernes"); 
	catalogo.add(miCd);
}
	
/***
	 * Constructor desde el cual se realizan TODAS las operaciones de Catalogo:
	 * Agregar, Modificar, Eliminar, Listar,Informar,Ordenar.
	 * También carga y muestra  un listado de Cd´s y Dvd´s.
	 * Posee además la opcion de salir, para finalizar la operatoria.
	 * @throws FileNotFoundException 
	 */
public Catalogo() throws FileNotFoundException { /// Constructor 
	boolean continuarCiclo = true;
		do {
			try {
				catalogo = new ArrayList<Disco>(); // Genero el catalogo  
				miDisco = new Dvd (); // 
				boolean menuCatalogo = false;
				Scanner entrada = new Scanner (System.in);
				File fileCatalogo = new File ("catalogo.txt");
				
				existeArchivo( fileCatalogo );
				if ( fileCatalogo.exists() ) { 
					miDvd = new Dvd (); 
					 miCd = new CD();
					}
				while (menuCatalogo == false) {	
					int menu =  inicio(entrada);
					switch ( menu )		{
					case 1: menuAgregar(entrada); break;
					case 2: menuModificar(entrada); break;
					case 3: menuEliminar(entrada); break;
					case 4: menuListar(entrada); break;
					case 5: menuInformar (entrada); break; 
					case 6: menuOrdenar (entrada); break;
					case 7: System.out.println("Mostrando todo el Catalogo:");
							System.out.println(catalogo);break;
					case 0:	salir(entrada);
							menuCatalogo = true; 
							continuarCiclo = false;	
					} // fin del switch
				}
				return;	// Vuelta a Main.
			}
			
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos: 1,2,3,4,5,6,0.");
			}
		}while (continuarCiclo);
	}

@Override
	public String toString() {
		return "Catalogo";
	}

public int inicio(Scanner entrada) {
	boolean varMenu = false;
	int MenuOpcion = 0;
	System.out.println("MENU PRINCIPAL");
	System.out.println("Que desea realizar? ");
	System.out.println("Valido para Cd y Dvd");
	System.out.println("1: Agregar");
	System.out.println("2: Modificar informacion especifica");
	System.out.println("3: Eliminar");
	System.out.println("4: Listar");
	System.out.println("5: Informar");
	System.out.println("6: Ordenar");
	System.out.println("7: Mostrar el catalogo");
	System.out.println("0: Salir");

	while (varMenu == false) {
		System.out.println("-->");
		MenuOpcion = entrada.nextInt();
		entrada.nextLine();
		if ( (MenuOpcion >=0 && MenuOpcion <=7 )  ) 
			varMenu = true;
		 else
			System.out.println("No se ingreso un valor Valido."
					+ " Intente Nuevamente con 0,1,2,3,4,5,6,7.");
	}
	return MenuOpcion;
}

public void menuAgregar(Scanner entrada) { 
	int opcion = 0;
	opcion = varOpcion("Agregar");
	if (opcion == DVD) 
	Agregar(miDisco, opcion);

	if (opcion == CD ) 
	Agregar(miDisco, opcion );
	
} 

public void Agregar (Disco d,int opcion ) {
	boolean noAgregar = false;
	boolean continuarCiclo = true;
	do {
		try { 
			
			while (noAgregar == false) { 
				System.out.println("- INGRESE LOS DATOS - ");
				System.out.println("Titulo: ");
				String titulo = entrada.nextLine();
				System.out.println("Genero: ");
				String genero = entrada.nextLine();
				System.out.println("comentario: ");
				String comentario = entrada.nextLine();
				System.out.println("Duracion: ");
				int duracion = entrada.nextInt();
				entrada.nextLine();
				boolean varControl = false; // Variable para validar el Si o No de lotiene
				boolean lotiene = false;
				while (varControl == false) {
					System.out.println("Tiene El "+ getTipo(opcion) +"?: S/N");
					String tieneDvd = entrada.next();
					if ("S".equals(tieneDvd) || "N".equals(tieneDvd)  ) {
						varControl = true;
						if ("S".equals(tieneDvd) ) {
							lotiene = true;
						} else 
							lotiene = false;
					} 
					else 
						varControl = false; /// Repito hasta ingresar un dato correcto
				}
				entrada.nextLine();
				if (opcion == DVD ) {
				System.out.println("Ingrese Director:");
				String director = entrada.nextLine();
				d = new Dvd(DVD,titulo, genero, duracion, comentario, lotiene, director);
				}
				else {
					System.out.println("Interprete: ");
					String interprete = entrada.nextLine();
					System.out.println("Cantidad de Temas: ");
					int cantidadt = entrada.nextInt();
					entrada.nextLine();
				d = new CD (CD,titulo, genero,duracion, comentario, lotiene, cantidadt, interprete ) ;
				}
				catalogo.add(d);
				System.out.println(catalogo);				
				String AgregarOtra = "" ; 
				while ( varControl == true ) {
				System.out.println("quiere agregar otro "+getTipo (opcion) +" ?:  (S/N)");
				AgregarOtra = entrada.next();
				entrada.nextLine();
				if ("N".equals(AgregarOtra) || "n".equals(AgregarOtra)|| 
					"S".equals(AgregarOtra) || "s".equals(AgregarOtra)	) {
					varControl = false;
					if ( "N".equals(AgregarOtra) || "n".equals(AgregarOtra))
					noAgregar = true;
					else
					noAgregar = false;
				}
				else
					varControl = true;
					
				continuarCiclo = false;
				}
			}
		}
		catch (InputMismatchException e ) {
			System.err.printf( "%nException: %s%n",e);
			entrada.nextLine();
			System.out.println("Debe introducir NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Se reinicia la carga de datos.");
		}
		catch (OutOfMemoryError e ) {
			System.err.printf( "%nException: %s%n",e);
			entrada.nextLine();
			System.out.println("NO HAY MEMORIA suficiente para agregar el DVD.");
			continuarCiclo = false ;
		}
	} while (continuarCiclo);

}

private String getTipo(int tipo)
{String cad = "";
	switch (tipo ) {
	case 1: cad = "DVD"; break;
	case 2: cad = "CD"; break;
	default: cad = "DISCO"; break ;
	}
	return cad;
}

public void menuModificar(Scanner entrada){
	int opcion = 0;
	opcion = varOpcion("modificar");
	if(opcion == DVD) 
		modificar(miDisco, opcion);
	
	if ( opcion == CD) 
		modificar(miDisco, opcion);
	
}

public void modificar (Disco d, int opcion ) {
	int posicion = -1;
	boolean noAgregar = false ;
	boolean continuarCiclo = true;
	do {
		try {
		if ( DVD == opcion ) {
			while (posicion == -1)
				posicion = buscarXTitulo( opcion);
			
			  d = new Dvd();
				while (noAgregar == false ) {
					System.out.println("Que Informacion del DVD quiere ingresar/Editar?");
					System.out.println("1-  Titulo");
					System.out.println("2-  Genero");
					System.out.println("3-  Duracion");
					System.out.println("4-  Comentarios");
					System.out.println("5-  Si esta 'ADQUIRIDO'");
					System.out.println("6-  Director");
					System.out.print("");

					int MenuEdicion = entrada.nextInt();
					entrada.nextLine();
					switch (MenuEdicion) {
					case 1: modificarTitulo(posicion ); break;
					case 2: modificarGenero ( posicion ); break;
					case 3: modificarDuracion(posicion );break;
					case 4: modificarComentario (posicion );break;
					case 5: modificarLoTengo (posicion );break;
					case 6: modificarDirector(posicion );break;
					default: 
		System.out.println("Ha seleccionado una opcion no valida, vuelve hacia atras."); 
						return;
					}
					String modificar = "" ; 
					boolean varControl = true;
					while ( varControl == true ) {
					System.out.println("quiere Modificar algo más?:  (S/N)");
					modificar = entrada.next();
					entrada.nextLine();
					if ("N".equals(modificar) || "n".equals(modificar)|| 
						"S".equals(modificar) || "s".equals(modificar)	) {
						varControl = false;
						if ( "N".equals(modificar) || "n".equals(modificar))
						noAgregar = true;
						else
						noAgregar = false;
					}
					else 
						varControl = true;
					
					}
			}
			continuarCiclo = false;
		} 
		else {
			 d = new CD();
			 posicion = -1;
			boolean noModificar = false; 
			
			while (posicion == -1)
				posicion = buscarXTitulo(opcion );
			
			while (noModificar == false ) {
				System.out.println("Que Informacion del CDs quiere ingresar/Editar?");
				System.out.println("1-  Titulo");
				System.out.println("2-  Genero");
				System.out.println("3-  Interprete");
				System.out.println("4-  Duracion");
				System.out.println("5-  Comentarios");
				System.out.println("6-  Cantidad De Canciones");
				System.out.println("7-  Si esta 'ADQUIRIDO'");
				System.out.print("");
				int menuEdicionCd = entrada.nextInt();
				entrada.nextLine();

				switch (menuEdicionCd) 	{
				case 1: modificarTitulo( posicion ); break;
				case 2: modificarGenero(posicion); break;
				case 3: modificarInterprete ( posicion ); break;
				case 4: modificarDuracion ( posicion ); break;
				case 5: modificarComentario ( posicion);break;
				case 6: modificarCantCanciones ( posicion );break;
				case 7: modificarLoTengo (  posicion ); break;
				default: 
			System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
					return;
				}
				String modificar = "" ; 
				boolean varControl = true;
				while ( varControl == true ) {
				System.out.println("quiere Modificar algo más?:  (S/N)");
				modificar = entrada.next();
				entrada.nextLine();
				if ("N".equals(modificar) || "n".equals(modificar)|| 
					"S".equals(modificar) || "s".equals(modificar)	) {
					varControl = false;
					if ( "N".equals(modificar) || "n".equals(modificar))
					noModificar = true;
					else
					noModificar = false;
						}
				else 
					varControl = true;
				}
				
				continuarCiclo = false;
				}
			}
		} // fin del try 
		catch (InputMismatchException e ) {
			System.err.printf( "%nException: %s%n",e);
			entrada.nextLine();
		System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
		System.out.println("Nros validos: 1,2,3,4,5,6.");
		}
		
	}while(continuarCiclo);
}

public void modificarTitulo (int pos) {
System.out.println("Ingrese el Titulo:");
String TituloNuevo = entrada.nextLine();
catalogo.get(pos).setTitulo(TituloNuevo);
System.out.println("Se Cambio el Titulo del Disco");
System.out.println(catalogo.get(pos));	
}

public void modificarGenero ( int pos){
System.out.println("Ingrese el nuevo Genero:");
String GeneroNue = entrada.nextLine();
catalogo.get(pos).setGenero(GeneroNue);
System.out.println("Se Cambio Genero del Disco");
System.out.println(catalogo.get(pos));
}

public void modificarDuracion ( int posicion){
	boolean continuarCiclo = true; 
	do {
		try {
			System.out.println("Ingrese la nueva duracion");
			int DuracionNue = entrada.nextInt();
			entrada.nextLine();
			catalogo.get(posicion).setDuracion(DuracionNue);
			System.out.println("Se Cambio la duracion del Disco");
			System.out.println(catalogo.get(posicion));
			continuarCiclo = false;
		}
		catch (InputMismatchException ex ) {
			System.err.printf( "%nException: %s%n",ex);
			entrada.nextLine();
			System.out.println("Debe introducir NUMEROS ENTEROS (sin punto ni coma).");
		}
	}while(continuarCiclo);
}

public void modificarComentario ( int posicion ){
System.out.println("Ingrese el nuevo Comentario:");
String ComentarioNue = entrada.nextLine();
catalogo.get(posicion).setComentario(ComentarioNue);
System.out.println("Se Cambio Satifactoriamente el comentario del Disco");
System.out.println(catalogo.get(posicion));
}

public void modificarLoTengo (int posicion){
boolean valorValido = false;
boolean lotiene = false;
while ( valorValido == false) {
	System.out.println("Usted quiere agregar este Disco a 'Adquiridos' o quiere eliminarlo? ");
	System.out.println("S-para agregarlo");
	System.out.println("N-para eliminarlo de la lista de adquiridos");
	String LoTieneNue = entrada.nextLine();
	if("S".equals(LoTieneNue) || "N".equals(LoTieneNue)){
		valorValido = true;
		if("S".equals(LoTieneNue)) {
			lotiene = true;}
		else {
			lotiene = false;
			}
		}
	else {
		valorValido = false;
		}
	}
catalogo.get(posicion).setLoTengo(lotiene);
System.out.println("Se Actualizo el 'ADQUIRIDO'.");
System.out.println(catalogo.get(posicion));
}

/***
 * Metodo para modificar el nombre del director 
 * @param catalogo Destino del ingreso del  nuevo nombre del director
 * @param posicion Lugar donde se encuentra el Dvd
 * @param entrada Ingreso del parametro director por teclado
 */
protected void modificarDirector(int posicion){
		System.out.println("Ingrese el Director");
		String directorNue = entrada.nextLine();
		((Dvd)catalogo.get(posicion)).setDirector(directorNue);
		System.out.println("Se Cambio el Director del DVD");
		System.out.println( (Dvd)catalogo.get(posicion));
}

/***
 * Modifica el interprete del CD en el Catalogo, ingresando por teclado.
 * @author ivang
 * @param catalogo Destino del ingreso del nuevo dato en el CD
 * @param posicion Lugar donde se encuentra el CD
 * @param entrada  Ingreso por teclado
 */
private void modificarInterprete ( int posicion ){
System.out.println("Ingrese el Interprete Nuevo");
String interpreteNue = entrada.nextLine();
((CD)catalogo.get(posicion)).setInterprete(interpreteNue);
System.out.println("Se Cambio el Interprete del CD");
System.out.println((CD)catalogo.get(posicion));
}

/***
* Modifica la cantidad de Canciones del CD en el Catalogo, ingresando por teclado.
* @author ivang
* @param catalogo Destino del ingreso del nuevo dato en el CD
* @param posicion Lugar donde se encuentra el CD
* @param entrada  Ingreso por teclado
*/
private void modificarCantCanciones ( int posicion ) {
boolean continuarCiclo = true;
do {
	try {
		System.out.println("Ingrese la nueva Cantidad de canciones");
		int cantCancionesNue = entrada.nextInt();
		entrada.nextLine();
		((CD)catalogo.get(posicion)).setCantTemas(cantCancionesNue);
		System.out.println("Se Cambio la Cantidad de Canciones del CD");
		System.out.println((CD)catalogo.get(posicion));
		continuarCiclo = false ; 
	}
	catch (InputMismatchException ex ) {
		System.err.printf( "%nException: %s%n",ex);
		entrada.nextLine();
		System.out.println("Debe introducir NUMEROS ENTEROS (sin punto ni coma), no letras.");
		}
	}while(continuarCiclo);
}


public void menuEliminar(Scanner entrada) {
	int opcion = 0;
	opcion = varOpcion("eliminar");
	if (opcion == DVD) 
		 eliminar(miDisco, opcion);
	
	if (opcion == CD ) 
		eliminar(miDisco, opcion);
	
}

public void eliminar (Disco d, int opcion ) {
	if ( opcion == DVD) {
		int posicionDvd = -1 ;
		while (posicionDvd == -1) 
			posicionDvd = buscarXTitulo (opcion ) ; 

		catalogo.remove(posicionDvd);
		System.out.println("El DVD fue eliminado exitosamente");
		return;
	}
	else {
		int posicionCd = -1 ;
		while (posicionCd == -1 ) 
			posicionCd = buscarXTitulo ( opcion ) ; 

		catalogo.remove(posicionCd);
		System.out.println("El CD fue eliminado exitosamente");
		return; 
	}
}

public void menuListar(Scanner entrada) {
	int opcion = 0;
	opcion = varOpcion("listar");
	if (opcion == DVD )  
		listar( opcion);
	
	if (opcion == CD )
		 listar( opcion);

}

public void listar (int opcion ) {
	if (opcion == DVD) {
		int menuDvd = 0;
		String texto ="" ;
		boolean continuarCiclo = true;
		do {
			try {
				System.out.println("Que lista desea ver?");
				System.out.println("1 - Todos los DVDs");
				System.out.println("2 - DVDs que poseo");
				System.out.println("3 - Duracion Exacta");
				System.out.println("4 - DVDs de un Determinado director");		
				System.out.println("5 - Titulo");
				System.out.println("6 - Genero");
				System.out.println("7 - Comentario");
				System.out.println("8 - DVDs que duran menos de un determinado tiempo en Minutos");

					menuDvd = entrada.nextInt();
					entrada.nextLine();
					
				switch (menuDvd)	{
				case 1 : listarDisco( opcion ); break;
				case 2 : loTengo ( opcion );break;
				case 3:	 int dur = 0 ;
						 System.out.println("Ingrese la Duracion Exacta:");
						 dur =entrada.nextInt() ;
						 entrada.nextLine();
						 listarXDuracionExacta( opcion, dur ); break;
				case 4:	 System.out.println("Ingrese el nombre del director:");
						 texto = entrada.nextLine();
						 listarXDirector(  texto) ; break;
				case 5:  System.out.println("Ordenando DVDS Por titulo:");
						 ordenarXTitulo( opcion); break;
				case 6:  System.out.println("Ingrese el Genero:");
				 		 texto = entrada.nextLine();
				 		 listarXGenero( opcion, texto); break;
				case 7:  System.out.println("Ingrese el Comentario:");
				 		 texto = entrada.nextLine();
				 		 listarXComentario( opcion, texto); break;
				case 8: System.out.println("Ingrese la duracion Maxima para listar:");
						int duracion = entrada.nextInt();
						 entrada.nextLine();
						 listarXDuracionMenorIgual( opcion, duracion);  break;
				default: 
					System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
							return;
				}
				continuarCiclo = false;
			}
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos: 1,2,3,4,5,6,7,8.");
			}
			
		}while (continuarCiclo);
	}
	else {
		int menuCd = 0;
		String texto = "";
		boolean continuarCiclo = true ;
		do {
			try { 
				System.out.println("Que lista desea ver?");
				System.out.println("1 - Todos los CDs");
				System.out.println("2 - CDs que poseo");
				System.out.println("3 - Listar por Interprete");
				System.out.println("4 - Genero");
				System.out.println("5 - Comentario");
				System.out.println("6 - Duracion Exacta ");
				System.out.println("7 - Titulo");
				System.out.println("8 - Cantidad de Temas");
				System.out.println("9 - Duracion Exacta o Menor");
				menuCd = entrada.nextInt();
				entrada.nextLine();
					
				switch (menuCd){
				case 1: listarDisco(  opcion); break;
				case 2: loTengo ( opcion ); break;
				case 3: System.out.println("Ingrese el interprete a buscar:");
						texto = entrada.nextLine() ;
						listarPorInterprete (  texto);		break;
				case 4: System.out.println("Ingrese el Genero a buscar:");
						texto = entrada.nextLine() ; 
						listarXGenero( opcion, texto); ;break;
				case 5:	System.out.println("Ingrese el Comentario a buscar:");
						texto = entrada.nextLine() ; 
						listarXComentario( opcion, texto);;break;
				case 6:	System.out.println("Ingrese la Duracion Exacta a buscar:");
						int duracion = entrada.nextInt() ;
						entrada.nextLine();
						listarXDuracionExacta( opcion, duracion);;break;
				case 7:	System.out.println("Ingrese el Titulo a buscar:");
					   	texto = entrada.nextLine() ;
					   	listarXTitulo( opcion, texto);;break;
				case 8: System.out.println("Ingrese la cant de temas a buscar: ");
						int cant = entrada.nextInt() ;
						entrada.nextLine();
						listarXCantTemas( opcion, cant ); break; 
				case 9: System.out.println("Ingrese la Duracion Menor o Igual a buscar:");
						duracion = entrada.nextInt() ;
						entrada.nextLine();
						listarXDuracionMenorIgual(opcion,duracion); break; 
				default: 
			System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
							return;
				}
				continuarCiclo = false;
			}
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos para Opcion: 1,2,3,4,5,6,7,8,9.");
			System.out.println("Para duraciones, usar cualquier nro Entero Positivo.");
			}

		}while (continuarCiclo);

	}
}

/***
 * Metodo para listar por adquiridos o No adquiridos los Discos del tipo opcion
 * @author ivang
 * @param catalogo Lugar de busqueda del Disco
 * @param opcion tipo de dato a Listar
 * @param entrada Ingreso de valor por teclado
 */
	
public void loTengo (int opcion ) {
	boolean b = false;
	boolean adquiridos = true;
	while ( b== false ) {
	System.out.println("Ingrese 1 para buscar Adquiridos, 0 NO Adquiridos: ");
	int  valor =entrada.nextInt();
	entrada.nextLine();
	if (valor == 1 ) 
		adquiridos = true;
		else 
		adquiridos = false;
	
	b = true; 
	}
	System.out.println("Listando :"); 
	listarXLoTengo( opcion, adquiridos);
}


public void listarDisco ( int opcion ) {
System.out.println("Listando " + getTipo(opcion) + ":"   );
for ( int i = 0; i< catalogo.size(); i++ )	{
	if (opcion == DVD ) {
		if (catalogo.get(i).getTipo() == DVD   )
			System.out.println ( ((Dvd)catalogo.get(i)  ) ) ;	 
	}
	else {
		if (catalogo.get(i).getTipo() == CD   )
			System.out.println ( ((CD)catalogo.get(i)  ) ) ;
		}
	}
}

public void listarXDuracionMenorIgual(int opcion ,int duracion) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )
		if( catalogo.get(i).getDuracion() <= duracion    )
				System.out.println(catalogo.get(i) );
}
}

public void listarXTitulo ( int opcion , String texto ) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )
		if (texto.equals(catalogo.get(i).getTitulo())    )
			System.out.println(catalogo.get(i) );
}
}
public void listarXGenero ( int opcion, String texto) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )
		if (texto.equals(catalogo.get(i).getGenero())    )
			System.out.println(catalogo.get(i) );
}	
}
public void listarXDuracionExacta ( int opcion, int dur ) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )
		if (dur == catalogo.get(i).getDuracion()   )
			System.out.println(catalogo.get(i) );
}
}
public void listarXComentario ( int opcion, String texto ) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )
		if (texto.equals(catalogo.get(i).getComentario())    )
			System.out.println(catalogo.get(i) );
}
}

public void listarXLoTengo (int opcion,boolean valor ) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == opcion )	
		if (  valor == catalogo.get(i).isLoTengo() )
			System.out.println(catalogo.get(i) );
}
}

/***
 * Metodo para listar por Director
 * @param catalogo Lugar de busqueda de los CD´s
 * @param director nombre del director a listar
 * @author ivang
 */
private void listarXDirector(  String director ){
	for ( int i =0; i < catalogo.size() ; i ++ ){ 
		if ( catalogo.get(i).getTipo() == DVD ) {
			if ( ((Dvd)catalogo.get(i)).getDirector().equals(director) )
				System.out.println ( catalogo.get(i) ) ;
		}
	}
}


/***
 * Metodo para listar por cantidad de temas Exactas
 * @param catalogo Lugar de busqueda de los CD´s
 * @param tipoDeDato  tipo de dato a filtrar
 * @param cantidad cantidad Exacta de temas 
 * @author ivang
 */
private void listarXCantTemas ( int tipoDeDato, int cantidad) {
for (int i =0; i < catalogo.size(); i++) {
	if ( catalogo.get(i).getTipo() == tipoDeDato )
		if(((CD) catalogo.get(i)).getCantTemas() == cantidad    )
				System.out.println(catalogo.get(i) );
}
}
/***
* Metodo propio de la clase para listar por interprete
* @param catalogo Lugar de busqueda de los CD´s
* @param interprete nombre del interprete a listar
* @author ivang
*/
private void listarPorInterprete ( String interprete ){
for (int i = 0; i < catalogo.size(); i++){
	if (catalogo.get(i).getTipo() == CD){
		if (  ((CD)catalogo.get(i)).getInterprete().equals(interprete))
			System.out.println(catalogo.get(i));
		}	
	}
}

public void menuInformar (Scanner entrada){
	int opcion = 0;
	opcion = varOpcion("informar");
	if ( opcion == DVD )
	 informar( opcion );
	
	if (opcion == CD )  // CD_ Informe de Canciones en el CD
		 informar(opcion  );
}

public void informar (int opcion ) {
	if (opcion == DVD ) {
		int menuDvd = 0;
		boolean continuarCiclo = true;
		do {
			try {
				System.out.println("Que lista desea ver?");
				System.out.println("1 - Cantidad total de DVDs");
				System.out.println("2 - Cantidad de DVDs que poseo");
				
				menuDvd = entrada.nextInt();
				entrada.nextLine();
				switch (menuDvd){
				case 1:	System.out.println("la cantidad total de DVDs es:"+ 
								cantTotalDeDVDS( ));		break;
				case 2:	System.out.println("la cantidad total de DVDs Adquiridos es:"+ 
						cantTotalDeDVDS_Adquiridos(  ));	break;
				default: 
					System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
							return;
				
				}
				continuarCiclo = false;
			}
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos: 1,2.");
			}
		}while ( continuarCiclo);
	}
	else {
		int posicion = -1;
		while (posicion == -1 )
			posicion = buscarXTitulo(opcion );

		System.out.println("La cantidad de temas en el cd es:" + 
				( (CD)catalogo.get(posicion)).getCantTemas() ) ;
	}
}

/***
 * Metodo para contar la cantidad de Dvd´s que hay en el catalogo.
 * @param catalogo Lugar de busqueda de los Dvds
 * @return el total de Dvds que figuran en el catalogo
 */
private int cantTotalDeDVDS (){
		int total = 0; 
		for ( int i =0 ; i < catalogo.size(); i++){
			if (catalogo.get(i).getTipo() == DVD )
				total ++ ;
		}
		return total ;
	}

/***
 * Metodo para contar la cantidad de Dvd´s Adquiridos que hay en el catalogo.
 * @param catalogo Lugar de busqueda de los Dvds
 * @return el total de Dvds Adquiridos que figuran en el catalogo
 */
private int cantTotalDeDVDS_Adquiridos (){
		int total = 0 ;
		for ( int i =0 ; i< catalogo.size(); i++){
			if (catalogo.get(i).getTipo() == DVD ) {
				if ( (catalogo.get(i).isLoTengo() ) == true)
					total ++; 
			}
		}
		return total ;
	}

public void menuOrdenar(Scanner entrada) { 
	int opcion = 0;
	opcion = varOpcion("Ordenar");
	if (opcion == DVD) 
		 Ordenar( opcion);
	
	if (opcion == CD )  
		Ordenar( opcion );
	
} 

public void Ordenar (int opcion ) {
	if (opcion == DVD ) {
		int menuDvd = 0;
		boolean continuarCiclo = true;
		do {
			try {
				System.out.println("Que Ordenar desea ver?");
				System.out.println("1 - Titulo");
				System.out.println("2 - Genero");
				System.out.println("3 - Duracion");
				System.out.println("4 - Comentario");
				System.out.println("5 - Adquirido");
				System.out.println("6 - Director");

				menuDvd = entrada.nextInt();
				entrada.nextLine();				
				switch (menuDvd){
				case 1:menuOrdtitulo( opcion )  ;break;
				case 2: menuOrdGenero( opcion);break;
				case 3: menuOrdDuracion( opcion);break;
				case 4: menuOrdComentario( opcion);break;
				case 5: menuOrdLoTengo( opcion );break;
				case 6: menuOrdDirector( opcion);break;
				default: 
			System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
						return;
				}
				continuarCiclo = false;
			}
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos: 1,2,3,4,5,6.");
			}
		}while ( continuarCiclo);
	}
	else {
		int menuCd = 0;
		boolean continuarCiclo = true;
		do {
			try {
				System.out.println("Que lista desea Ordenar?");
				System.out.println("1 - Titulo");
				System.out.println("2 - Genero");
				System.out.println("3 - Duracion");
				System.out.println("4 - Comentario");
				System.out.println("5 - Adquirido");
				System.out.println("6 - Cant Canciones");
				System.out.println("7 - Interprete");

				menuCd = entrada.nextInt();
				entrada.nextLine();
					
				switch (menuCd)	{
				case 1: menuOrdtitulo( opcion);break;
				case 2: menuOrdGenero( opcion);break;
				case 3: menuOrdDuracion( opcion);break;
				case 4: menuOrdComentario( opcion);break;
				case 5: menuOrdLoTengo( opcion)	 ;break;
				case 6: menuOrdCantTemas( opcion);break;
				case 7: menuOrdInterprete( opcion);break;
				default: 
		System.out.println("Ha ingresado una opcion no valida, vuelve al Menu Principal.");
							return;
				}
				continuarCiclo = false;
			}
			catch (InputMismatchException e ) {
				System.err.printf( "%nException: %s%n",e);
				entrada.nextLine();
			System.out.println("El menú solo acepta NUMEROS ENTEROS (sin punto ni coma).");
			System.out.println("Nros validos: 1,2,3,4,5,6,0.");
			}
		}while (continuarCiclo);
	}
}

/***
 * Menú desde donde se accede a los metodos de ordenar por titulo, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
public void menuOrdtitulo ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXTitulo_Descendente( opcion);
	else
		ordenarXTitulo( opcion);
}

/***
 * Menú desde donde se accede a los metodos de ordenar por Genero, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
public void menuOrdGenero ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXGenero_Descendente( opcion);
	else
		ordenarXGenero( opcion);
}

/***
 * Menú desde donde se accede a los metodos de ordenar por Comentario, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */	
public void menuOrdComentario ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXComentario_Descendente( opcion);
	else
		ordenarXComentario( opcion);
}

/***
 * Menú desde donde se accede a los metodos de ordenar por Duracion, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
public void menuOrdDuracion ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXDuracion_Descendente( opcion);
	else
		ordenarXDuracion( opcion);
}

/***
 * Menú desde donde se accede a los metodos de ordenar por el valor booleano ´loTengo', y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
public void menuOrdLoTengo ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXLoTengo_Descendente( opcion);
	else
		ordenarXLoTengo( opcion);
}

public void ordenarXTitulo ( int opcion  ) {
 
Collections.sort(catalogo,new Comparator <Disco> () {
		/// COMPARA DE MENOR A MAYOR, PORQUE PREGUNTA POR P1 < P2
		@Override
		public int compare (Disco d1, Disco d2) {
		//// return  TIPODATO (             .compareTo TIPODATO........
			return d1.getTitulo().compareTo(d2.getTitulo());
		}
	});
	mostrar( opcion);
	
}

public void ordenarXGenero ( int opcion ) {
Collections.sort(catalogo,new Comparator <Disco> () {
	@Override
	public int compare (Disco d1, Disco d2) {
		return d1.getGenero().compareTo(d2.getGenero());
	}
});
mostrar( opcion );
}

public void ordenarXDuracion ( int opcion ) {
Collections.sort(catalogo,new Comparator <Disco> () {
		
		@Override
		public int compare (Disco d1, Disco d2) {
		if (d1.getDuracion()< d2.getDuracion())
			return -1;
		else {
			if ( d1.getDuracion()> d2.getDuracion() )
				return 1;
			else 
				return 0;
			 }
		}
	});	
mostrar( opcion);
}

public void ordenarXComentario ( int opcion) {
	Collections.sort(catalogo,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			return d1.getComentario().compareTo(d2.getComentario());
		}
	});
mostrar( opcion);
}

public void ordenarXLoTengo (int opcion) {
	Collections.sort(catalogo,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
		return Boolean.compare(d1.isLoTengo(), d2.isLoTengo());
    }
	});
	mostrar( opcion );
}

public void ordenarXTitulo_Descendente ( int opcion  ) {
Collections.sort(catalogo,new Comparator <Disco> () {
		/// COMPARA DE MAYOR A MENOR, PORQUE PREGUNTA POR P2 < P1
		@Override
		public int compare (Disco d1, Disco d2) {
		//// return  TIPODATO (             .compareTo TIPODATO........
			return d2.getTitulo().compareTo(d1.getTitulo());
		}
	});
	mostrar( opcion);
}

public void ordenarXGenero_Descendente ( int opcion ) {
Collections.sort(catalogo,new Comparator <Disco> () {
	@Override
	public int compare (Disco d1, Disco d2) {
		return d2.getGenero().compareTo(d1.getGenero());
	}
});
mostrar( opcion );
}

public void ordenarXDuracion_Descendente ( int opcion ) {
Collections.sort(catalogo,new Comparator <Disco> () {
		
		@Override
		public int compare (Disco d1, Disco d2) {
		if (d2.getDuracion()< d1.getDuracion())
			return -1;
		else {
			if ( d2.getDuracion()> d1.getDuracion() )
				return 1;
			else 
				return 0;
			 }
		}
	});	
mostrar( opcion);
}

public void ordenarXComentario_Descendente ( int opcion) {
	Collections.sort(catalogo,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			return d2.getComentario().compareTo(d1.getComentario());
		}
	});
mostrar( opcion);
}

public void ordenarXLoTengo_Descendente (int opcion) {
	Collections.sort(catalogo,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
		return Boolean.compare(d2.isLoTengo(), d1.isLoTengo());
    }
	});
	mostrar( opcion );
}


/***
 * Menú desde donde se accede a los metodos de ordenar por Director, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
protected void menuOrdDirector ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXDirector_Descendente( opcion);
	else
		ordenarXDirector( opcion);
}

/***
 * Metodo para ordenar por nombre del Director de Forma Ascendente
 * @param catalogo Lugar de busqueda de los Discos de tipo Dvd
 * @param opcion tipo de Disco
 */
private void ordenarXDirector ( int opcion ) {
	ArrayList<Disco> catAux = new ArrayList<>();
	for (int i = 0; i< catalogo.size();i++) {
		if (catalogo.get(i).getTipo() == opcion )
			catAux.add(catalogo.get(i));
	}
	Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			String aux1 = ((Dvd)d1).getDirector();
			String aux2 = ((Dvd)d2).getDirector();
			return aux1.compareTo(aux2);

		}
	});
	mostrarCatAux(catAux, opcion);
}

/***
 * Metodo para ordenar por nombre del Director de Forma Descendente
 * @param catalogo Lugar de busqueda de los Discos de tipo Dvd
 * @param opcion tipo de Disco
 */
private void ordenarXDirector_Descendente ( int opcion ) {
	ArrayList<Disco> catAux = new ArrayList<>();
	for (int i = 0; i< catalogo.size();i++) {
		if (catalogo.get(i).getTipo() == opcion )
			catAux.add(catalogo.get(i));
	}
	Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			String aux1 = ((Dvd)d2).getDirector();
			String aux2 = ((Dvd)d1).getDirector();
			return aux1.compareTo(aux2);

		}
	});
	mostrarCatAux(catAux, opcion);
}


/***
 * Menú desde donde se accede a los metodos de ordenar por Cantidad de temas, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
protected void menuOrdCantTemas ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXCantTemas_Descendete( opcion);
	else
		ordenarXCantTemas( opcion);
}

/***
 * Menú desde donde se accede a los metodos de ordenar por Interprete, y se puede seleccionar
 * el ordenamiento de forma descendente, o de forma predeterminada ascendentemente.  
 * @param catalogo Lugar fisico donde se realizará el ordenamiento
 * @param opcion tipo de disco
 * @param entrada ingreso de datos por teclado
 */
protected void menuOrdInterprete ( int opcion ) {
	String letra = "";
	System.out.println("Ingrese la letra 'D' si quiere ordenar de forma descendente."
			+ "Cualquier otro ingreso ordenará Ascendentemente.");
	letra = entrada.nextLine();
	if ("d".equalsIgnoreCase(letra) )
		ordenarXInterprete_Descendente( opcion);
	else
		ordenarXInterprete( opcion);
}



/***
 * Metodo para ordenar por nombre del interprete de forma Ascendente
 * @param catalogo Lugar de busqueda de los Discos de tipo CD
 * @param opcion tipo de Disco
 */
private void ordenarXInterprete ( int opcion) {
	ArrayList<Disco> catAux = new ArrayList<>();
	for (int i = 0; i< catalogo.size();i++) {
		if (catalogo.get(i).getTipo() == opcion )
			catAux.add(catalogo.get(i));
	}
	Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			return((CD)d1).getInterprete().compareTo( ((CD)d2).getInterprete()) ;
		}
	});
	mostrarCatAux(catAux, opcion);

}

	/***
	 * Metodo propio de la clase para ordenar por nombre del interprete de forma Ascendente
	 * @param catalogo Lugar de busqueda de los Discos de tipo CD
	 * @param opcion tipo de Disco
	 */
private void ordenarXCantTemas ( int opcion ) {
	ArrayList<Disco> catAux = new ArrayList<>();
	for (int i = 0; i< catalogo.size();i++) {
		if (catalogo.get(i).getTipo() == opcion )
			catAux.add(catalogo.get(i));
	}
	Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			if (   ((CD)d1).getCantTemas() < ((CD)d2).getCantTemas()   )
				return -1;
			else {
				if ( ((CD)d1).getCantTemas() > ((CD)d2).getCantTemas()  )
					return 1;
				else 
					return 0;
			}
		}
	});	
	mostrarCatAux(catAux, opcion);
}

	
/***
 * Metodo para ordenar por nombre del interprete de forma Descendente
 * @param catalogo Lugar de busqueda de los Discos de tipo CD
 * @param opcion tipo de Disco
 */
private void ordenarXInterprete_Descendente ( int opcion) {
	ArrayList<Disco> catAux = new ArrayList<>();
	for (int i = 0; i< catalogo.size();i++) {
		if (catalogo.get(i).getTipo() == opcion )
			catAux.add(catalogo.get(i));
	}
	Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
			return((CD)d2).getInterprete().compareTo( ((CD)d1).getInterprete()) ;
		}
	});
	mostrarCatAux(catAux, opcion);

}

/***
 * 	 * Metodo para ordenar por nombre del interprete de forma Descendente
 * @param catalogo Lugar de busqueda de los Discos de tipo CD
 * @param opcion tipo de Disco
 */
private void ordenarXCantTemas_Descendete ( int opcion ) {
		ArrayList<Disco> catAux = new ArrayList<>();
		for (int i = 0; i< catalogo.size();i++) {
			if (catalogo.get(i).getTipo() == opcion )
				catAux.add(catalogo.get(i));
		}
		Collections.sort(catAux,new Comparator <Disco> () {
		@Override
		public int compare (Disco d1, Disco d2) {
		if (   ((CD)d2).getCantTemas() < ((CD)d1).getCantTemas()   )
			return -1;
		else {
			if ( ((CD)d2).getCantTemas() > ((CD)d1).getCantTemas() )
				return 1;
			else 
				return 0;
			 }
		}
	});	
	mostrarCatAux(catAux, opcion);
	}


/***
 * Metodo para imprimir en pantalla los Discos del tipo opcion
 * @author ivang
 * @param catalogo Lugar de busqueda del Disco
 * @param opcion tipo de dato a Listar
 */
	
public void mostrar ( int opcion ) {
	for (int i = 0; i< catalogo.size(); i++) {
		if (opcion == DVD ) {
			if (catalogo.get(i).getTipo() == DVD )
				System.out.println(catalogo.get(i) ) ;
		}
		else {
			if (catalogo.get(i).getTipo() == CD )
				System.out.println(catalogo.get(i) ) ;
		}
	}	
}
/***
 * Metodo que permite mostrar un catalogo Auxiliar Ordenado sin alterar el orden de los 
 * elementos del catologo original. Es necesario para el uso de los metodos propios
 * de CD y Dvd.
 * @param catalogo
 * @param opcion
 */
private void mostrarCatAux (ArrayList<Disco> catalogo ,int opcion ) {
	for (int i = 0; i< catalogo.size(); i++) {
		if (opcion == DVD ) {
			if (catalogo.get(i).getTipo() == DVD )
				System.out.println(catalogo.get(i) ) ;
		}
		else {
			if (catalogo.get(i).getTipo() == CD )
				System.out.println(catalogo.get(i) ) ;
		}
	}	
}

public void salir (Scanner entrada) throws FileNotFoundException {
	boolean guardarCambios = true;
	String cad = "";
	System.out.println("¿ Desea guardar los cambios ? S / N ");
	System.out.println("Si no escribe 's' o 'S', el programa reconocerá que no quiere guardar en el archivo.");
	cad = entrada.nextLine();
	
	if ("s".equalsIgnoreCase(cad))
		guardarCambios = true ;
	else
		guardarCambios = false; 
	
	if (guardarCambios == true ) {
		escribirArchivo(entrada);
		System.out.println("Se ha generado un archivo.");
		System.out.println("Si vuelve a iniciar el programa, podrá usar el"
				+ " Archivo creado.");
	}
}

public void existeArchivo( File fileCatalogo) {	
	try { 
		boolean leido = false;
		 leido = buscarArchivo(entrada, fileCatalogo );
		 if ( leido == false ) { 
			cargarXDefecto( );
			System.out.println("MOSTRANDO CATALOGO INICIAL:");
			System.out.println(catalogo);
			return;
		 }
		 else {
			 miDvd = new Dvd();
			 miCd = new CD ();
			 return;
		 }
	}
	catch( Exception e){
		e.getMessage();
		System.out.println(e);
	}
}

public boolean buscarArchivo (Scanner entrada, File fileName) throws IOException {
	if (fileName.exists()  ) { 
		System.out.println("Ya existe un archivo de catalogo. "
				+ "Desea abrir el archivo? S/N");
		String cad = "";
		cad = entrada.nextLine();
		if ("s".equalsIgnoreCase(cad) ) // Abrir archivo 
			leerArchivo ("catalogo.txt");		
		else {
			System.out.println("Iniciará sin archivo. Mas adelante, al finalizar el "
					+ "programa tendrá la posibilidad de salvar los datos, "
					+ "si así lo quiere.");
			return false; // False: no Utilizo el archivo Existente 
		}
		
		return true; // devuelvo true: Utilizo el archivo
	}
	return false ; // false : No Hay archivo inicial
}

public void leerArchivo (String fileName) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String linea = null;
	ArrayList <Disco> catalogoNue = new ArrayList<Disco>(); 
	Disco miDiscoAux = null;
		try { 
			System.out.println("Extrayendo del archivo: ");
			while ( (linea = br.readLine() ) != null  )	{
				if (linea.contains("CD")  ) {
					miDiscoAux = new CD (linea);
					// tipo titulo genero duracion comentario lotengo 
					System.out.printf("[%s [Titulo=%s, Genero=%s, Duracion=%d, Comentario=%s,  LoTengo=%b], cantTemas=%d, interprete=%s] \n", miDiscoAux.getTipo(CD),
						miDiscoAux.getTitulo(),miDiscoAux.getGenero(),miDiscoAux.getDuracion(),
						miDiscoAux.getComentario(), miDiscoAux.isLoTengo(),
						((CD) miDiscoAux).getCantTemas(),((CD) miDiscoAux).getInterprete() );
				catalogoNue.add(miDiscoAux);
				}
				
				if (linea.contains("DVD") ) {
					miDiscoAux = new Dvd(linea,DVD);
					System.out.printf("[%s [Titulo=%s, Genero=%s, Duracion=%d, Comentario=%s,  LoTengo=%b], director=%s] \n", miDiscoAux.getTipo(DVD),
					miDiscoAux.getTitulo(), miDiscoAux.getGenero(), miDiscoAux.getDuracion(),
					miDiscoAux.getComentario(), miDiscoAux.isLoTengo(),
					((Dvd) miDiscoAux).getDirector());
				catalogoNue.add(miDiscoAux);
				}
			}
			catalogo = catalogoNue ; // Guardo en mi ArrayList de la Class Catalogo
		}
		catch (NoSuchElementException e) {
			System.out.println("El archivo no esta bien formado. Finalizado.");
			br.close();
		}
		catch ( IllegalStateException ise ) {
			System.out.println("Error al leer del archivo. Finalizado.");
			br.close();
		}
		catch (ArrayIndexOutOfBoundsException a ) {
			System.out.println( a );
			catalogo = catalogoNue;
			System.out.println("Se iniciará sin todos los elementos.");
			linea = null;
		}
		
		if (linea != null ) 
			br.close();	
}

public void escribirArchivo(Scanner entrada ) throws FileNotFoundException {
	salida = new Formatter ("catalogo.txt"); 
	int i = 0;
	for (i = 0 ; i< catalogo.size() ;i++ ) {
		try {
			salida.format( catalogo.get(i).aString() ,catalogo.get(i) ) ;
			}
		catch (FormatterClosedException f ) {
			System.out.println("Error al escribir en el archivo. Terminado.");
			break;
			}
		catch (NoSuchElementException e ) {
			System.out.println("Entrada invalida.");
			break;
			}		
	}		
	salida.close();
}

/***
 * Metodo propio de catalogo para devolver el tipo de dato con el que se trabajará. 
 * @param texto nombre del metodo donde se ingresó en el menú
 * @return el valor del tipo de Dato del disco (1 si es Dvd, 2 si es CD). 
 */
private int varOpcion ( String texto ){
	int opcion = 0 ;
	boolean continuarCiclo = true ;
	do {
		try {
			boolean varOpcion = false;
			
			System.out.println("Que desea "+ texto + ":");
			System.out.println("1 - DVDS");
			System.out.println("2 - CDs");
			while (varOpcion == false) {
				opcion = entrada.nextInt();
				entrada.nextLine();
				if (opcion == 1 || opcion == 2) 
					varOpcion = true;
				else 
					System.out.println("Por favor, ingrese un valor valido(1 o 2).");
			
			}
			return opcion;
		}		
		catch (InputMismatchException e ) {
			System.err.printf( "%nException: %s%n",e);
			entrada.nextLine();
		System.out.println("Solo acepta NUMEROS ENTEROS (sin punto ni coma).");
		System.out.println("Nros validos: 1 para DVD,2 para CD");
		}
	}while (continuarCiclo);
	return opcion;
}

/***
 * Busca en el catalogo un  Disco por medio del titulo y tipo. Devuelve la posicion si lo 
 * encontró , o -1 si no lo encontró.
 * @param catalogo Lugar de busqueda de los Discos
 * @param opcion tipo de Disco
 */
public int buscarXTitulo(  int tipoDeDato) {
	System.out.println("Como se LLama el "+getTipo(tipoDeDato) +" que desea buscar?");
	String nombre = entrada.nextLine();
	boolean encontrado = true ;
	int posicionDisco= -1 ;
	for (int i = 0; i < catalogo.size(); i++) {
		if (tipoDeDato == DVD ) {
			if (catalogo.get(i).getTipo() == DVD ) {
				if (nombre.equals(  ((Dvd)catalogo.get(i)).getTitulo() )   ) {
					posicionDisco = i;
					encontrado = true;
					break;
					}
				}	 
			}
		if (tipoDeDato == CD ) {
			if (catalogo.get(i).getTipo() == CD ) {
				if (nombre.equals(  ((CD)catalogo.get(i)).getTitulo() )   ) {
					posicionDisco = i;
					encontrado = true;
					break;
					}
				}	 
			}
		}
	if (posicionDisco == -1)
		encontrado = false;
	
	if (encontrado == false) 
		System.out.println("El "+ getTipo(tipoDeDato) +" no fue encontrado , intente nuevamente.");
	
return posicionDisco; 
}

}/// FIn de la Clase Catalogo