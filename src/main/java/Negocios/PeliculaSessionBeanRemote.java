package Negocios;

import Clases.Book;
import Clases.Pelicula;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
 
@Remote
public interface PeliculaSessionBeanRemote {
	void addPeliculas(Date lanzamiento, String nombre, String descripcion);

	Pelicula getPelicula(int id);

	List getPeliculas();
}
