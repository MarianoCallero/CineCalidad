package Negocios;
import Clases.Pelicula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
 
@Stateless
public class PeliculaSessionBean implements PeliculaSessionBeanRemote {

   private List<Pelicula> Peliculas=null;

   public PeliculaSessionBean() {
   }

   @Override
   public void addPeliculas(Date lanzamiento, String nombre, String descripcion){
      int id;
      if (Peliculas==null){
         Peliculas = new ArrayList<Pelicula>();
         id =0;
      }else{id= Peliculas.size()+1;}
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
}
