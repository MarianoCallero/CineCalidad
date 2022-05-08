package Negocios;

import Clases.Book;

import java.util.List;
import javax.ejb.Remote;
 
@Remote
public interface PeliculaSessionBeanRemote {

	PeliculaSessionBean getInstance();

	void addBook(String bookName);
	List getBooks();

	int getO();

	Book getBook(int id);

	void Modificar(int id, String n);

	String toString();
}
