package pe.edu.tecsup.app.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.uitls.ConexionDB;

public class CategoriaRepository {

	public static List<Categoria> listar() throws Exception{
		List<Categoria> lista =  new ArrayList<Categoria>();
		
		// Conexion
		Connection con = ConexionDB.getConexion();
		
		// Preparamos la sentencia
		String sql = "select * from categorias";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		// Recuperar los registros del result set
		while(rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId_categoria(rs.getInt("id"));
			categoria.setNombre(rs.getString("nombre"));
			categoria.setDescripcion(rs.getString("descripcion"));
			lista.add(categoria);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		return lista;
	}
	
	public static void registrar(Categoria categoria) throws Exception {
		
		Connection con = ConexionDB.getConexion();
		
		String sql = "insert into categorias (nombre, descripcion) values (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, categoria.getNombre());
		stmt.setString(2, categoria.getDescripcion());
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
	}
	
}
