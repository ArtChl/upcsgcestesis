package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Lista generated by hbm2java
 */
public class Lista  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Date fecharegistro;
     private Set<Listavalor> listavalors = new HashSet<Listavalor>(0);

    public Lista() {
    }

	
    public Lista(int id) {
        this.id = id;
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
    public Set<Listavalor> getListavalors() {
        return this.listavalors;
    }
    
    public void setListavalors(Set<Listavalor> listavalors) {
        this.listavalors = listavalors;
    }




}


