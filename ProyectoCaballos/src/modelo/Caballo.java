package modelo;

public class Caballo {
	
	private int idCaballo;
	private String nombreCaballo;
	private String raza; 
	private String color;
	
	private static int contCaballo;

		
	public Caballo(String nombreCaballo, String raza, String color) {
		
		contCaballo++;
		this.idCaballo = contCaballo;
		this.nombreCaballo = nombreCaballo;
		this.raza = raza;
		this.color = color;
		
		
	}

	public int getIdCaballo() {
		return idCaballo;
	}

	public void setIdCaballo(int idCaballo) {
		this.idCaballo = idCaballo;
	}

	public String getNombreCaballo() {
		return nombreCaballo;
	}

	public void setNombreCaballo(String nombreCaballo) {
		this.nombreCaballo = nombreCaballo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static int getContCaballo() {
		return contCaballo;
	}

	public static void setContCaballo(int contCaballo) {
		Caballo.contCaballo = contCaballo;
	}

	@Override
	public String toString() {
		return "Caballo [idCaballo=" + idCaballo + ", nombreCaballo=" + nombreCaballo + ", raza=" + raza + ", color="
				+ color + "]";
	}

	
	
	
	
}
