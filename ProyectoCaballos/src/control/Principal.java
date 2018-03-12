package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import javax.sound.midi.Patch;

import caballos.Caballo;

public class Principal {
	
	public static void escribirCaballo(Caballo caballo) {
		
		String fila = caballo.toString();
		Path file = Paths.get("ficheros/caballos.txt");
		Charset charset = Charset.forName("UTF-8");
		String s = "vamos a añadir una linea";
		OpenOption[] options = new OpenOption[2];
		options[0]=APPEND;
		options[1]=CREATE;
		
		try(BufferedWriter writer = Files.newBufferedWriter(file, charset,options)) {
			
			writer.newLine();
			writer.write(fila,0,fila.length());
			writer.close();
			
		} catch (IOException x) {
			System.err.format("IOException: &s&n", x);
		}				
		
	}//escribirCaballo
	
	public static void leerCaballo() throws IOException {
		
		Path file = Paths.get("ficheros/caballos.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			reader = Files.newBufferedReader(file,charset);
			String fila = null;
			while((fila = reader.readLine()) != null) {
				System.out.println(fila);
			}
			
		}catch(IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if(reader != null) {
				reader.close();
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Caballo caballo1 = new Caballo("PEPE", "andaluz", "marron");
		Caballo caballo2 = new Caballo("ARTURO","arabe","blanco");
		Caballo caballo3 = new Caballo("MANUEL","nordico","negro");
				
		/*escribirCaballo(caballo1);
		escribirCaballo(caballo2);
		escribirCaballo(caballo3);*/
		leerCaballo();
		
	}

}

