package pe.edu.tecsup.app.main;

import java.util.List;

import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.services.CategoriaService;

public class TestApp2 {

	public static void main(String[] args) {
		try {
			
			List<Categoria> categorias = CategoriaService.listar();
			
			System.out.println("Lista de categorias:");
			
			for(Categoria categoria : categorias) {
				System.out.println(categoria);
			}
			
			categorias.stream().forEach(item -> System.out.println(item));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
