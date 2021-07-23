package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarRegistrosJDBC {

	public static String URL = "jdbc:mysql://localhost/almacen?useSSL=false";
	public static String USERNAME = "root";
	public static String PASSWORD = "";
	
	public static void main(String[] args) {
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Preparar la sentencia SQL
			String sql = "select * from categorias";
			PreparedStatement stmt = con.prepareStatement(sql);
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
