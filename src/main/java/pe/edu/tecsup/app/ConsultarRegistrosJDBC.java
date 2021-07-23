package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarRegistrosJDBC {

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
			//String sql = "SELECT * FROM categorias ";
			String sql = "SELECT * FROM categorias WHERE id = ? AND nombre = ? ";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 2);             // posicion 1
			stmt.setString(2, "Memorias"); // posicion 2
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				System.out.printf("id = %d , nombre=%s \n", id, nombre);
			}
			
			rs.close(); 
			
			stmt.close();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}

}
