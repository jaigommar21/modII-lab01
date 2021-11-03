package pe.edu.tecsup.app.main;

import java.util.List;

import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.services.CategoriaService;

public class TestApp3 {

	public static void main(String[] args) {
		try {
			
			String nombre = "Tablets";
			
			String descripcion = "Lista de tablets";
			
			CategoriaService.registrar(nombre, descripcion);
			
			System.out.println("Se ha insertado correctamente!");
			
			List<Categoria> categorias = CategoriaService.listar();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
