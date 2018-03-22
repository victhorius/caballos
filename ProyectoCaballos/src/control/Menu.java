package control;
import java.io.IOException;
import java.util.*;

import modelo.Carrera;
import modelo.EnlaceBBDDV2;
import modelo.EnlaceBD;
import presentacion.LecturaEscritura;

public class Menu {
	
	
	/**Si se selecciona la opci�n 1 abre el men� de usuario.**/
	public void lanzarMenuUsuario() throws IOException {
					
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		/***AGREGADO EL LUNES (FERNANDO)***/
		String consultaSQL = "";
				
		/****FIN AGREGADO****/
		System.out.println("1. Consultar caballos.\n 2. Descargar lista de caballos\n 3. Apostar ");
		
		opcion = scan.nextInt();
		
		EnlaceBD enlaceBD = new EnlaceBD();
		EnlaceBBDDV2 enBD = new EnlaceBBDDV2();
		
		switch (opcion) {
		
		//Consultar caballos disponibles
		case 1:				
			//enlaceBD.consultarCaballo("Select * from caballos");
			
			/**AGREGADO EL LUNES (FERNANDO)**/
			consultaSQL = "Select * from caballos;";
			enBD.consultaTodosCaballos(consultaSQL);
			/****/
			
		break;
		
		//Descargar lista de caballos
		case 2:
			
			LecturaEscritura.descargarCaballos("Select * from caballos");
			
		break;
		
		//Apostar a un caballo
		case 3:
			
			String carrera = "";
			int caballo = 0;
			/*1.Muestra las carreras disponibles para apostar
			  2. Usuario elige carrera
			  3. Usuario elige caballo (se muestra una lista)
			  4. actualiza la base de datos cambiando el campo de apostado de null a true 
			  5. Simula la carrera y actualiza las posiciones
			  6. Comprueba resultado
			  
			 
			 */
			
			//1
			System.out.println("Carreras disponibles:");
			enBD.consultaCarreras("Select distinct nombreCarrera from listacarreras where posicion is null");
			
			//2
			System.out.println("introduce carrera para mostrar caballos:");
			carrera = scan.next();
			
			//3
			ArrayList<Integer> posiciones = new ArrayList<Integer>();
			posiciones=enBD.consultaCaballosCarrera("select idCaballo from listacarreras where nombreCarrera = '" + carrera + "';");
			System.out.println("introduce dorsal del caballo:");
			caballo = scan.nextInt();
			
						
			//4
			enBD.modificarRegistro("update listacarreras set apostado=true where idCaballo="+caballo);
			
			
			//5
			
			Collections.shuffle(posiciones);
			
			for (int i = 0; i<5;i++) {
				
				int posicion=0;
				posicion = posiciones.get(i);
				
				enBD.modificarRegistro("update listacarreras set posicion="+(i+1)+ "where idCaballo="+posicion+";");
			}
			

			
		break;
		
		}
		
	}//lanzarMenuUsuario()
	
	
	/**Si se selecciona la opci�n 2 abre el men� de administrador**/
	public void lanzarMenuAdministrador () throws IOException {
		
		String nombre;
		String raza;
		String color;
		String consultaSQL = "";
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("1. Agregar caballo\n2. Borrar caballo\n3.Generar carrera");
		
		opcion = scan.nextInt();
		
		//EnlaceBD enlaceBD = new EnlaceBD();
		EnlaceBBDDV2 enBD = new EnlaceBBDDV2();//Nuevo fichero de Base de datos
		
		switch (opcion) {
		
		//Agregar caballo
			case 1:
			
				System.out.println("Nombre");
				nombre = scan.next();
				System.out.println("raza");
				raza = scan.next();
				System.out.println("color");
				color = scan.next();
						
				//enlaceBD.insertarCaballo(nombre, raza, color);
				
				/**AGREGADO EL LUNES**/
				consultaSQL = "insert into caballos(nombreCaballo,raza,color) "
						+ "values ('" + nombre + "', '" + raza + "', '" + color + "')";
				enBD.modificarRegistro(consultaSQL);
				System.out.println("Caballo agregado correctamente");
				
				/****/
				
			break;

			
			//Borrar caballo
		    case 2:
		    			    	
		    	System.out.println("Nombre del caballo a borrar");		    	
		    	nombre = scan.next();
		    	consultaSQL = "delete from caballos where nombreCaballo = '" + nombre + "';";
		    	//enlaceBD.borrarCaballo(nombre);
		    	enBD.modificarRegistro(consultaSQL);
		    			    	
			break;
			
		    case 3:
		    	
		    	System.out.println("Escribe el nombre de la carrera");
		    	nombre = scan.next();
		    	Carrera carrera = new Carrera();
		    	carrera.setNombreCarrera(nombre);
		    	carrera.insertarCarreraBBDD(nombre);
		    	
		}//switch
		
	}//lanzarMenuAdministrador()

}//class
