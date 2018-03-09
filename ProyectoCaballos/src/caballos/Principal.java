package caballos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import javax.sound.midi.Patch;

public class Principal {
	
	public static void main(String[] args) {
		
		
		String caballo="";
		
		Caballo caballo1 = new Caballo("PEPE", "andaluz", "marron");
		
		caballo = caballo1.toString();		
	
		
		Path file = Paths.get("ficheros/caballos.txt");
		Charset charset = Charset.forName("UTF-8");
		String s = "vamos a añadir una linea";
		OpenOption[] options = new OpenOption[2];
		options[0]=APPEND;
		options[1]=CREATE;
		
		try(BufferedWriter writer = Files.newBufferedWriter(file, charset,options)) {
			
			writer.newLine();
			writer.write(caballo,0,caballo.length());
			writer.close();
			
		} catch (IOException x) {
			System.err.format("IOException: &s&n", x);
		}		
		
	}

}
