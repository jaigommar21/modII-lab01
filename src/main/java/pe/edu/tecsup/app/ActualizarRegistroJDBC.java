package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarRegistroJDBC {

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
			String sql = "UPDATE categorias SET nombre=? WHERE id=?"; 
			PreparedStatement stmt = con.prepareStatement(sql);
			int id = 4; // PK del registro que se va a cambiar
			
			// Configura el PK del registro a eliminar
			stmt.setString(1, "Portatiles Cambiado"); 
			stmt.setInt(2, id);
			
			// Ejecutar la actualizacion
			int estado = stmt.executeUpdate(); 
			
			// Verificar el cambio
			if (estado != 1)
				throw new SQLException("No se pudo actualizar correctamente"); 
			
			System.out.printf("Se actualiza la categoria con id = %d \n", id);
			
			// Cerrar conexiones
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}

}
