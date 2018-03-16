package presentacion;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import modelo.Caballo;
import modelo.EnlaceBD;

public class LecturaEscritura {

	public static void escribirCaballo(Caballo caballo) {

		String fila = caballo.toString();
		Path file = Paths.get("ficheros/caballos.txt");
		Charset charset = Charset.forName("UTF-8");
		String s = "vamos a añadir una linea";
		OpenOption[] options = new OpenOption[2];
		options[0] = APPEND;
		options[1] = CREATE;

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, options)) {

			writer.newLine();
			writer.write(fila, 0, fila.length());
			writer.close();

		} catch (IOException x) {
			System.err.format("IOException: &s&n", x);
		}

	}// escribirCaballo

	public static void leerCaballo() throws IOException {

		Path file = Paths.get("ficheros/caballos.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			reader = Files.newBufferedReader(file, charset);
			String fila = null;
			while ((fila = reader.readLine()) != null) {
				System.out.println(fila);
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}// leerCaballo

	public static void descargarCaballos(String resQuery) throws IOException {
		
		EnlaceBD enlace = new EnlaceBD();
		ArrayList<String> resultados = new ArrayList<String>();
				
		
		resultados = enlace.consultarCaballov2(resQuery);
		Path file = Paths.get("ficheros/listaCaballos.txt");
		Charset charset = Charset.forName("UTF-8");
		
		OpenOption[] options = new OpenOption[2];
		options[0] = APPEND;
		options[1] = CREATE;

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, options)) {
			
			for (String linea : resultados) {
				
				writer.newLine();
				writer.write(linea, 0, linea.length());
				
			}
				writer.close();
		

		} catch (IOException x) {
			System.err.format("IOException: &s&n", x);
		}

	}
	
	
	
	
	
	
	// escribirCaballo


	public static void leerFicheroaBD() throws IOException {

		Path file = Paths.get("ficheros/lectura.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			reader = Files.newBufferedReader(file, charset);
			String fila = null;
			//ArrayList con cada línea leída del archivo
			ArrayList<String> lineas = new ArrayList<>();
			while ((fila = reader.readLine()) != null) {
				//System.out.println(fila);
				lineas.add(fila);
			}

			System.out.println("arrayList lineas "+lineas);
			
			formatearyBD(lineas);
			
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		


	}// leerCaballo
	
	
	public static void formatearyBD(ArrayList<String> registros) {
		
		for (String linea:registros) {
			
			String[] filas = new String[3];
			
			filas = linea.split(";");
			
			String nombre = filas[0];
			String raza = filas[1];
			String color = filas[2];
			
			EnlaceBD enlaceBD = new EnlaceBD();
			
			enlaceBD.insertarCaballo(nombre, raza, color);
		}
		
		/*Otra forma de hacerlo
		 for (int i = 0; i < registros.size(); i++) {
		 
		 String linea = registros.get(i);
		 
		 }
		 */
			
			
			
			
			
		
		
	}
}
