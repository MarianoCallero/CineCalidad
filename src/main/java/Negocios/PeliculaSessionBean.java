package Negocios;
import Clases.Book;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
 
@Stateless
public class PeliculaSessionBean implements PeliculaSessionBeanRemote {
    
   private List<Book> bookShelf;
   private PeliculaSessionBean instance= null;
   public int P = 1;

   public PeliculaSessionBean() {
      bookShelf = new ArrayList<Book>();
   }

   @Override
   public PeliculaSessionBean getInstance(){
       if (instance==null)
           instance=new PeliculaSessionBean();
       return instance;
   }

   @Override
   public void addBook(String bookName) {
      Book in;
      int id = bookShelf.size()+1;
      in = new Book(id,bookName);
       bookShelf.add(in);
   }    

   @Override
   public List<Book> getBooks() {
      return bookShelf;
   }

   @Override
   public int getO() {
	   	int O = 1 + 1;
	      return  O;
	   }

   @Override
    public Book getBook(int id){return bookShelf.get(id);}
}
