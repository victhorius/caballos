package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Carrera {

	private String nombreCarrera;
	private HashSet<Integer> listaCaballos;
	private int apostado;

	
	/****************/
	/**CONSTRUCTOR**/
	/**************/
	
	public Carrera() {

		this.nombreCarrera = nombreCarrera;
		listaCaballos = new HashSet<Integer>();
		this.listaCaballos = listaCaballos;
		this.apostado = apostado;
		generarCarrera();
		
	}

	
	
	/**********************/
	/**GETTERS & SETTERS**/
	/********************/
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}


	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
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
	
	
	
	/************/
	/**METODOS**/
	/**********/
	
	@Override
	public String toString() {
		return "Carrera [ " + nombreCarrera + ", listaCaballos=" + listaCaballos + "]";
	}

	
	//Llama a un metodo que devuelve el numero total de los caballos que hay en la base de datos y devuelve un numero aleatorio dentro del rango
	public int caballoAleatorio() {

		int idCaballo = 0;
		int caballosTotales = 0;

		Random rndm = new Random();
		EnlaceBD enlaceBD = new EnlaceBD();

		caballosTotales = enlaceBD.contarCaballos("select count(*) from caballos");

		idCaballo = (int) (rndm.nextDouble() * caballosTotales + 1);

		return idCaballo;

	}//caballoAleatorio

	
	//Llama al metodo que genera un numero aleatorio y crea un Set con 5 caballos que conforman la carrera.
	public void generarCarrera() {
					
		while (this.listaCaballos.size() < 5) {
			listaCaballos.add(caballoAleatorio());
		}
		
	}//generarCarrera

	
	//Inserta la carrera genrada en la Base de datos
	public void insertarCarreraBBDD(String nombre) {
		
		EnlaceBBDD enbd = new EnlaceBBDD();
		ArrayList<Integer> arrListaCarrera = new ArrayList<Integer>();
		
		String query = "insert into carreras (nombreCarrera) values ('" + this.nombreCarrera + "')";
		enbd.modificarRegistro(query);
		
				
		for(int pos : this.listaCaballos) {		
			arrListaCarrera.add(pos);			
		}
		
		System.out.println(arrListaCarrera);
		for(int pos : arrListaCarrera) {
			query = "insert into listaCarreras (nombreCarrera, idCaballo) values" + "('" + this.nombreCarrera + "'," + pos + ");";
			enbd.modificarRegistro(query);
		}
		System.out.println("Carrera generada");
		
	}//insertarCarrera
	
	
	//El usuario elige un caballo al que quiere apostar dentro de la carrera y lo guarda en la variable apostado.
	public void apostar() {

		Scanner scan = new Scanner(System.in);
		int apuesta = 0;

		System.out.println("Introduce el dorsal de tu apuesta");
		apuesta = scan.nextInt();
		this.setApostado(apuesta);

	}//apostar
	


	public ArrayList<Integer> generarResultadoCarrera() {
		
		ArrayList<Integer> resultadosCarrera = new ArrayList<Integer>();
		EnlaceBBDD enBD = new EnlaceBBDD();
		
		
		for(int pos : this.listaCaballos) {			
			Collections.shuffle(generarResultadoCarrera());
			resultadosCarrera.add(pos);			
		}
		
		//Hace un insert de los datos del resultado en la BBDD
		for (int i = 0; i < 5; i++) {
			
			int posicion=0;
			posicion = resultadosCarrera.get(i);
			
			enBD.modificarRegistro("update listacarreras set posicion="+(i+1)+ "where idCaballo="+posicion+";");
		}
		
		return resultadosCarrera;		
	}//generarResultadosCarrera

	
	public void comprobarResultadoCarrera(String carrera) {
		
		ArrayList<Integer> resultadosCarrera = new ArrayList<Integer>();
		EnlaceBBDD enBD = new EnlaceBBDD();
		//int apostado = enBD.consultaCaballosCarrera("select apostado from listacarreras where nombreCarrera = '" + carrera + "';");
		
		resultadosCarrera = generarResultadoCarrera();
		
		
		System.out.println("Resultado de la carrera: " + resultadosCarrera);
		System.out.println("Tu apuesta: " + resultadosCarrera.get(apostado));
		
		if(this.apostado == resultadosCarrera.get(0)) {
			System.out.println("Enhorabuena, has ganado la apuesta!");
		} else {
			System.out.println("Esta vez no pudo ser, sigue intentandolo");
		}		
		
	}//comprobarResultado*/
	
	
}//Carrera
