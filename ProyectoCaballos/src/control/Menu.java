package control;
import java.io.IOException;
import java.util.*;

import modelo.EnlaceBBDDV2;
import modelo.EnlaceBD;
import presentacion.LecturaEscritura;

public class Menu {
	
	
	public void lanzarMenuUsuario() throws IOException {
					
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		/***AGREGADO EL LUNES (FERNANDO)***/
		String consultaSQL = "";
				
		/****FIN AGREGADO****/
		System.out.println("1. Consultar caballos.\n 2. Descargar lista de caballos\n ");
		
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
		
		/** CONSULTAR CARRERAS?? **/
		case 3:
					


		break;
		
		}
		
	}//lanzarMenuUsuario()
	
	
	public void lanzarMenuAdministrador () throws IOException {
		
		String nombre;
		String raza;
		String color;
		String consultaSQL = "";
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("1. Agregar caballo\n 2. Borrar caballo");
		
		opcion = scan.nextInt();
		
		EnlaceBD enlaceBD = new EnlaceBD();
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
		}//switch
		
	}//lanzarMenuAdministrador()

}//class
