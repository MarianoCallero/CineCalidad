package Negocios;
import Clases.Pelicula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
 
@Stateless
public class PeliculaSessionBean implements PeliculaSessionBeanRemote {

   public String h="hola";
   private List<Pelicula> Peliculas= new ArrayList<Pelicula>();


   public PeliculaSessionBean() {
      Peliculas.add(new Pelicula(0,"12/12/12","algo","detalle"));
   }

   @Override
   public void addPeliculas(String lanzamiento, String nombre, String descripcion){
      int id;
      if (Peliculas==null){
         Peliculas = new ArrayList<Pelicula>();
         id =0;
      }else{id= Peliculas.size();}
      Peliculas.add(new Pelicula (id, lanzamiento, nombre, descripcion));
   }
   @Override
   public Pelicula getPelicula(int id){
      return Peliculas.get(id);
   }
   @Override
   public List getPeliculas(){
      return Peliculas;
   }

   @Override
   public String toString() {
      String ret="Peliculas: \n";
      if (Peliculas!= null){
         for (int i=0; i< Peliculas.size();i++){
            ret = ret + Peliculas.get(i).toString();
            ret = ret +"\n";
         }
      }else{ret = ret + "VACIO";}
      return ret;
   }
}
