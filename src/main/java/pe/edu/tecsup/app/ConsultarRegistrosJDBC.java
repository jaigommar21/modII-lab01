package pe.edu.tecsup.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarRegistrosJDBC {

	public static void main(String[] args) {
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Conectarme a la BD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/almacen?useSSL=false", "root", "");
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
		}
	}

}
