package Negocios;

import java.awt.*;
import java.util.Scanner;

public class Consola {
    PeliculaSessionBean consola;
    Scanner teclado = new Scanner(System.in);
    public static void AgregarLibro(){
        System.out.print("Ingrese el nombre: ");
        String nom = "";
        do{
            nom = teclado.next();
        }while(nom=="");
        System.out.println("Nombre ingresado: "+nom);
        consola.getInstance().addBook(nom);
    }
    public static void ModificarLibro(){
        consola.getInstance().toString();
        System.out.print("Ingrese el id del libro a modifcar");
        int mod=-1;
        mod = teclado.nextInt();
        if (mod <0 || mod > consola.getInstance().getBooks().size()) {
            System.out.println("OPCION INCORRECTA");
            ModificarLibro();
        }
        System.out.print("Ingrese nuevo nombre: ");
        String nom = "";
        do{
            nom = teclado.next();
        }while(nom=="");
        consola.getInstance().Modificar(mod,nom);
    }

    public void ListarLibros(){consola.getInstance().toString();}

    public static void Menu(){
        System.out.println("      MENU");
        System.out.println("1) Agregar libro");
        System.out.println("2) Modificar libro");
        System.out.println("3) Listar Libros");
        System.out.print("Opcion: ");
        int op=-1;
        op = teclado.nextInt();
        switch (op){
            case 1:
                AgregarLibro();
                break;
            case 2:
                ModificarLibro();
                break;
            case 3:
                ListarLibros();
                break;
            case 0:
                System.out.println("Gracias por preferirnos");
                System.exit(0);
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                Menu();
                break;
        }
    }
    public static void main (String [ ] args){
        while(true){
            Menu();
        }
    }
}