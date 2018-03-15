package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.util.ArrayList;

public class EnlaceBD {

	public EnlaceBD() {};
	public static Connection conectar(Connection c) {
		String sDriver="com.mysql.jdbc.Driver";
		String sURL="jdbc:mysql://localhost:3306/caballos";
		
		try {
			Class.forName(sDriver).newInstance();
			c=DriverManager.getConnection(sURL,"root","");
			
			if (c!=null) System.out.println("Conectado a la base de datos");
		
	
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException |SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return c;
	}	
	
	
	public void insertarCaballo(int idCaballo,String nombre, String raza, String color){

		Connection con=null;
		con=conectar(con);
		PreparedStatement stmt=null;
		
		
			try {
				stmt=con.prepareStatement("insert into caballos values (?,?,?,?)");
				stmt.setInt(1,idCaballo);
				stmt.setString(2,nombre);
				stmt.setString(3,raza);
				stmt.setString(4,color);
				int filaInsertada=stmt.executeUpdate();
				if (filaInsertada>0) System.out.println("fila insertada");
				con.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	/*
	public void actualizarDato(int id, String str ){
		int idTI=id;
		String denTI=str;
		
		
		PreparedStatement stmt=null;
		Connection con=null;
			
		con=conectar(con);
	
		try {
			
			stmt=con.prepareStatement("update  tipoIngrediente values (?,?)");
			stmt.setInt(1,idTI);
			stmt.setString(2,denTI);
			int filaInsertada=stmt.executeUpdate();
			if (filaInsertada>0) System.out.println("fila insertada");
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	*/
		
		public void consultarCaballo(String query){
			
						
			Connection con=null;
			Statement stmt=null;
			try {
				
				con=conectar(con);
				
				stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery (query);
				while (rs.next())
		            {
		                System.out.println ("idCaballo:"+rs.getInt (1) + "  nombre:" +rs.getString (2)+ 
		                    " raza: "+rs.getString(3)+" color:"+rs.getString(4) );
		            }
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            // Se crea un Statement, para realizar la consulta
            
	}
		
		public ArrayList<String> consultarCaballov2(String query){
			
			ArrayList<String> resultados = new ArrayList<String>();
			String res = "";
			Connection con=null;
			Statement stmt=null;
			try {
				
				con=conectar(con);
				
				stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery (query);
				while (rs.next())
		            {
		                res= "idCaballo:"+rs.getInt (1) + "  nombre:" +rs.getString (2)+ 
		                    " raza: "+rs.getString(3)+" color:"+rs.getString(4);
		                resultados.add(res);
		            }
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            // Se crea un Statement, para realizar la consulta
            return resultados;
	}
		
		public void consultarCaballoV2(String atributo, String nombre){
			
			
			Connection con=null;
			Statement stmt=null;
			try {
				
				con=conectar(con);
				
				stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery ("select "+ atributo+" from caballos where nombreCaballo = '"+nombre+"';");
				while (rs.next())
		            {
		               if(atributo.equals("idCaballo")) {
		            	   System.out.println ("idCaballo:"+rs.getInt (1));
		               }
		            }
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		}
}
