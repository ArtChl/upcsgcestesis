package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {


     private String id;
     private String nombre;
     private Set<Provincia> provincias = new HashSet<Provincia>(0);
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Provincia> getProvincias() {
        return this.provincias;
    }
    
    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }




}


