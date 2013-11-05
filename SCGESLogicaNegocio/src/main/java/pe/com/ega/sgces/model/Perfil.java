package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Date fecharegistro;
     private Set<Usuarioperfil> usuarioperfils = new HashSet<Usuarioperfil>(0);
     private Set<Perfilopcion> perfilopcions = new HashSet<Perfilopcion>(0);

    public Perfil() {
    }

	
    public Perfil(int id) {
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
    public Set<Usuarioperfil> getUsuarioperfils() {
        return this.usuarioperfils;
    }
    
    public void setUsuarioperfils(Set<Usuarioperfil> usuarioperfils) {
        this.usuarioperfils = usuarioperfils;
    }
    public Set<Perfilopcion> getPerfilopcions() {
        return this.perfilopcions;
    }
    
    public void setPerfilopcions(Set<Perfilopcion> perfilopcions) {
        this.perfilopcions = perfilopcions;
    }




}


