package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Carrera {

	private int idCarrera;
	private HashSet<Integer> listaCaballos;
	private int apostado;

	public Carrera(int idCarrera) {

		this.idCarrera = idCarrera;
		listaCaballos = new HashSet<Integer>();
		this.listaCaballos = listaCaballos;
		this.apostado = apostado;
		generarCarrera();
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public HashSet<Integer> getListaCaballos() {
		return listaCaballos;
	}

	public int getApostado() {
		return apostado;
	}

	public void setApostado(int apostado) {
		this.apostado = apostado;
	}
	
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", listaCaballos=" + listaCaballos + "]";
	}

	public int caballoAleatorio() {

		int idCaballo = 0;
		int caballosTotales = 0;

		Random rndm = new Random();
		EnlaceBD enlaceBD = new EnlaceBD();

		caballosTotales = enlaceBD.contarCaballos("select count(*) from caballos");

		idCaballo = (int) (rndm.nextDouble() * caballosTotales + 1);

		return idCaballo;

	}

	public void generarCarrera() {

		while (this.listaCaballos.size() < 5) {

			listaCaballos.add(caballoAleatorio());

		}

	}

	public void apostar() {

		Scanner scan = new Scanner(System.in);
		int apuesta = 0;

		System.out.println("Introduce el dorsal de tu apuesta");

		System.out.println("Carrera: " + this.toString());

		apuesta = scan.nextInt();
		
		this.setApostado(apuesta);

	}//apostar
	


	public ArrayList<Integer> generarResultadoCarrera() {
		
		ArrayList<Integer> resultadosCarrera = new ArrayList<Integer>();
		
		for(int pos : this.listaCaballos) {
			
			Collections.shuffle(generarResultadoCarrera());
			resultadosCarrera.add(pos);
			
		}						
		return resultadosCarrera;		
	}//generarResultadosCarrera
	
	
	public void comprobarResultado() {
		
		ArrayList<Integer> resultadosCarrera = new ArrayList<Integer>();
		resultadosCarrera = generarResultadoCarrera();
		
		System.out.println("Resultado de la carrera: " + resultadosCarrera);
		System.out.println("Tu apuesta: " + this.apostado);
		
		if(this.apostado == resultadosCarrera.get(0)) {
			System.out.println("Enhorabuena, has ganado la apuesta!");
		} else {
			System.out.println("Esta vez no pudo ser, sigue intentándolo");
		}
		
		
	}

}//
