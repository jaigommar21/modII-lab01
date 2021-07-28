package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertarRegistrosJDBC {

	// ENGINE : MYSQL  [jdbc:<<engine>>:<<port>>//<<IP o DOMINIO >>/<<SCHEMA>>?<<PARAMETROS OPCIONALES>> ]
	public static String URL = "jdbc:mysql://192.168.64.2/inventariodb?useSSL=false";
	
	public static String USERNAME = "tecsup";
	
	public static String PASSWORD = "tecsup";
	
	public static void main(String[] args) {
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			
			// Preparar la sentencia SQL
			String sql = "INSERT INTO categorias (nombre,descripcion,orden) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
		    // Preparar los datos a Ingresar
			stmt.setString(1, "Portatiles");  // corresponde al nombre
			stmt.setString(2, "Portatiles de Gama Alta"); // corresponde a la descripcion
			stmt.setInt(3, 4); // corresponde al orden
			// Ejecutar la insercion
			int estado = stmt.executeUpdate(); 
			// Analizar el resultado
			if (estado != 1)
				throw new SQLException("No se pudo insertar");
			
			/*
			// Obtener el ultimo id
			int id = 0;
			sql = "SELECT last_insert_id()"; 
			stmt = con.prepareStatement(sql); 
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) 
				id = rs.getInt(1);
			System.out.println("Se inserto el registro de categoria con ID = " + id);
			*/
			
			// Cerrar conexiones
			//rs.close(); 
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}

}
