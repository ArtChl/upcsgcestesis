package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Opcion generated by hbm2java
 */
public class Opcion  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Date fecharegistro;
     private Set<Perfilopcion> perfilopcions = new HashSet<Perfilopcion>(0);

    public Opcion() {
    }

	
    public Opcion(int id) {
        this.id = id;
    }
    public Opcion(int id, String nombre, Date fecharegistro, Set<Perfilopcion> perfilopcions) {
       this.id = id;
       this.nombre = nombre;
       this.fecharegistro = fecharegistro;
       this.perfilopcions = perfilopcions;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Set<Perfilopcion> getPerfilopcions() {
        return this.perfilopcions;
    }
    
    public void setPerfilopcions(Set<Perfilopcion> perfilopcions) {
        this.perfilopcions = perfilopcions;
    }




}


