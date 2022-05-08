package Negocios;

import java.util.Scanner;

public class Consola {
    PeliculaSessionBean consola;
    Scanner teclado = new Scanner(System.in);
    public int Menu(){
        System.out.println("      MENU");
        System.out.println("1) Agregar libro");
        System.out.println("2) Modificar libro");
        System.out.println("3) Listar Libros");
        System.out.print("Opcion: ");
        int op=-1;
        op = teclado.nextInt();
        if (op == 0){System.exit(0);} else if (op<0 || op>3) {
            System.out.println("OPCION INCORRECTA");
            op= Menu();
        }
        return op;
    }
    public void AgregarLibro(){
        System.out.print("Ingrese el nombre: ");
        String nom = "";
        do{
            nom = teclado.next();
        }while(nom=="");
        consola.getInstance().addBook(nom);
    }
    public static void Main(){

    }
}
