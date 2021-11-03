package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistroJDBC {

	// ENGINE : MYSQL  [jdbc:<<engine>>:<<port>>//<<IP o DOMINIO >>/<<SCHEMA>>?<<PARAMETROS OPCIONALES>> ]
	public static String URL = "jdbc:mysql://192.168.64.2/almacen?useSSL=false";
	
	public static String USERNAME = "tecsup";
	
	public static String PASSWORD = "tecsup";
	
	public static void main(String[] args) {
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Preparar la sentencia SQL
			String sql = "DELETE FROM categorias WHERE id = ?"; 
			
			//
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// Configura el PK del registro a eliminar
			int id = 7;
			stmt.setInt(1, id); // EL registro con ID igual a 7 existe
			
			// Ejecutar la insercion
			int estado = stmt.executeUpdate(); 
			
			if (estado != 1)
				throw new SQLException("No se pudo eliminar");
			
			System.out.printf("Se elimino la categoria con id = %d \n", id);

			// Cerrar conexiones
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}

}
