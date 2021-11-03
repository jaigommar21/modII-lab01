package pe.edu.tecsup.app.services;

import java.util.List;

import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.repositories.CategoriaRepository;

public class CategoriaService {

	public static List<Categoria> listar() throws Exception{
		return CategoriaRepository.listar();
	}
	
	public static void registrar(String nombre, String descripcion) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		CategoriaRepository.registrar(categoria);
	}
	
}
