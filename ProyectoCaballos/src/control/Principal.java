package control;
import presentacion.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;
import javax.sound.midi.Patch;

import modelo.*;

public class Principal {
	

	
	
	public static void main(String[] args) throws IOException {
		
		/*
		
		Caballo caballo1 = new Caballo("PEPE", "andaluz", "marron");
		Caballo caballo2 = new Caballo("ARTURO","arabe","blanco");
		Caballo caballo3 = new Caballo("MANUEL","nordico","negro");
				
		/*escribirCaballo(caballo1);
		escribirCaballo(caballo2);
		escribirCaballo(caballo3);
		
		LecturaEscritura.leerCaballo();*/
		
		EnlaceBD enlaceBD = new EnlaceBD();
		
		
		//enlaceBD.insertarCaballo(caballo1.getIdCaballo(), caballo1.getNombreCaballo(), caballo1.getRaza(), caballo1.getColor());
		//enlaceBD.insertarCaballo(caballo2.getIdCaballo(), caballo2.getNombreCaballo(), caballo2.getRaza(), caballo2.getColor());
		String query = "Select idCaballo from caballos";
		String idNombre="idCaballo";
		String nombre ="PEPE";
		
		//enlaceBD.consultarCaballo(query);
		//enlaceBD.consultarCaballoV2(idNombre, nombre);
		
		/*LecturaEscritura.escribirCaballoV2(query);
		
		LecturaEscritura.leerFicheroaBD();*/
		
		enlaceBD.contarCaballos("select count(*) from caballos");
		
		Scanner scan = new Scanner(System.in);
		int tipoUsuario = 0 ;
		
		System.out.println("Introduce 1 para entrar como usuario, 2 para entrar como administrador");
		
		tipoUsuario = scan.nextInt();
		
		Menu menu  = new Menu();
		
		if (tipoUsuario == 1) menu.lanzarMenuUsuario();
		
		else if(tipoUsuario == 2) menu.lanzarMenuAdministrador();
		
		else System.out.println("Opcion incorrecta");
		
		
		enlaceBD.contarCaballos("select count(*) from caballos");
		
	}

}

