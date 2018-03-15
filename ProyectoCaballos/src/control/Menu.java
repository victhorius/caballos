package control;
import java.io.IOException;
import java.util.*;

import modelo.EnlaceBD;
import presentacion.LecturaEscritura;

public class Menu {
	
	
	public void lanzarMenuUsuario() throws IOException {
		
				
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("Introduce 1 para consultar los caballos disponibles\n 2 para descargar lista de caballos\n ");
		
		opcion = scan.nextInt();
		
		EnlaceBD enlaceBD = new EnlaceBD();
		
		switch (opcion) {
		case 1:
			
						
			enlaceBD.consultarCaballo("Select * from caballos");
			
		break;
		
		case 2:
			
			
			LecturaEscritura.descargarCaballos("Select * from caballos");
			
			

		break;
		
		case 3:
			
				
			
			

		break;
		
		}
	}
	
	
	public void lanzarMenuAdministrador () throws IOException {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("Introduce 1 para agregar un nuevo caballo\n 2 para borrar un caballo");
		
		opcion = scan.nextInt();
		
		EnlaceBD enlaceBD = new EnlaceBD();
		
		switch (opcion) {
		case 1:
			
			//consulta a la base de datos,contar caballos y sumar uno para asignarle un id automatico
			
			
			
			
			int idCaballo;
			
			
			String nombre;
			String raza;
			String color;
			
			
			
			break;

		default:
			break;
		}
		
	}
	

}
