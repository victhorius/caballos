package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class EnlaceBBDDV2 {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/caballos";
	public static final String USUARIO = "root";
	public static final String CLAVE= "";
	
	
	
	/************************/
	/***MÉTODOS GENERALES***/
	/**********************/
	
	
	//Se pueden hacer updates o inserts o deletes
	public int modificarRegistro (String consultaSQL) {
		
		Connection con = null;
		PreparedStatement sentencia = null;
		int filasAfectadas = 0;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = con.prepareStatement(consultaSQL);
			filasAfectadas = sentencia.executeUpdate();			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error en el driver: " + e.getMessage());
		}
		catch(SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		finally {
			if(sentencia != null) {
				try {
					sentencia.close();
					System.out.println("Modificación correcta");
				}
				catch(SQLException e) {					
				}
			}
			if(con != null) {
				try {
					con.close();					
				}
				catch(SQLException e) {}
			}
		}//finally
		
		return filasAfectadas;
	}
	
	
	//Consulta a una tabla
	public ResultSet seleccionarRegistros(String consultaSQL) {
		Connection con = null;
		Statement sentencia = null;
		ResultSet filas = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = con.createStatement();
			filas = sentencia.executeQuery(consultaSQL);									
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error en el driver: " + e.getMessage());
		}
		catch(SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
	
		return filas;
	}//seleccionarRegistros
	
	
	/****/
	/**METODOS ESPECIFICOS CONSULTA**/
	/****/
	
	
	public void consultaTodosCaballos (String sqlQuery) {
		
		ResultSet filas = seleccionarRegistros(sqlQuery);
		
		try {
			while (filas.next()) {
				System.out.println ("idCaballo: " + filas.getInt (1) + "  nombre: "  + filas.getString (2) + 
					" raza: "+filas.getString(3)+" color: "+filas.getString(4) );
			}
		}
		catch(SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		
	}//consultaCaballos
	
	
	public ArrayList<String> caballosToLista(String sqlQuery){
		
		ResultSet filas = seleccionarRegistros(sqlQuery);
		ArrayList<String> resultados = new ArrayList<String>();
		String res = "";
		
		try {
			
			while (filas.next())
            {
                res= "idCaballo:" + filas.getInt (1) + "  nombre:" + filas.getString (2)+ 
                    " raza: "+ filas.getString(3) + " color:" + filas.getString(4);
                resultados.add(res);
            }
		 
		} 
		catch(SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
	
    return resultados;
	
	}//caballosToLista
	
	
	public int contarCaballos(String sqlQuery) {
		
		ResultSet filas = seleccionarRegistros(sqlQuery);
		int caballosTotales = 0;
		
		try {
			
			while (filas.next()) {
				System.out.println ("Caballos totales:"+ filas.getInt (1) );
				caballosTotales =  filas.getInt (1);
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		
		return caballosTotales;
	}//contarCaballos
		
	
	
	
	
}//CLASS
