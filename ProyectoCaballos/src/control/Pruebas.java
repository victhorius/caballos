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

public class Pruebas {
	
	public static void main(String[] args) {
		
		Carrera carrera = new Carrera(1);
		
		carrera.apostar();
		carrera.generarCarrera();
		carrera.comprobarResultado();
		
		
		
		
	}

}
