package Negocios;

import Negocios.PeliculaSessionBeanRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Clases.Book;
 
public class EJBTester {

   BufferedReader brConsoleReader = null; 
   Properties props;
   InitialContext ctx;
   {
      //props = new Properties();
	   props = new Properties();

       // set the properties value
	   props.setProperty("java.naming.provider.url", "localhost");
	   props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
	   props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

      /*try {
         props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }*/
      try {
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   
   public static void main(String[] args) {
 
      EJBTester ejbTester = new EJBTester();
 
      ejbTester.testStatelessEjb();
   }
   
   private void showGUI() {
      System.out.println("**********************");
      System.out.println("Welcome to Book Store");
      System.out.println("**********************");
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
   }
   
   private void testStatelessEjb() {
 
      try {
         int choice = 1; 
 
         PeliculaSessionBeanRemote peliculaBean =
        		 (PeliculaSessionBeanRemote)ctx.lookup("PeliculaSessionBean/remote");
 
         while (choice != 2) {
            String bookName;
            showGUI();
            String strChoice = brConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);
            if (choice == 1) {
               System.out.print("Enter book name: ");
               bookName = brConsoleReader.readLine();
               Book book = new Book();
               book.setName(bookName);
               peliculaBean.addBook(book.getName());          
            } else if (choice == 2) {
               break;
            }
         }
 
         List<Book> peliculaList = peliculaBean.getBooks();
 
         System.out.println("Book(s) entered so far: " + peliculaList.size());
         int i = 0;
         for (Book book:peliculaList) {
            System.out.println((i+1)+". " + book.getName());
            i++;
         }       
         PeliculaSessionBeanRemote peliculaBean1 = 
            (PeliculaSessionBeanRemote)ctx.lookup("LibrarySessionBean/remote");
         List<String> peliculaList1 = peliculaBean1.getBooks();
         System.out.println(
            "***Using second lookup to get library stateless object***");
         System.out.println(
            "Book(s) entered so far: " + peliculaList1.size());
         for (int h = 0; h < peliculaList1.size(); ++h) {
            System.out.println((h+1)+". " + peliculaList1.get(h));
         }		 
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }finally {
         try {
            if(brConsoleReader !=null) {
               brConsoleReader.close();
            }
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         }
      }
   }
}