package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Perfilopcion generated by hbm2java
 */
public class Perfilopcion  implements java.io.Serializable {


     private PerfilopcionId id;
     private Perfil perfil;
     private Opcion opcion;
     private Date fecharegistro;

    public Perfilopcion() {
    }

	
    public Perfilopcion(PerfilopcionId id, Perfil perfil, Opcion opcion) {
        this.id = id;
        this.perfil = perfil;
        this.opcion = opcion;
    }
    public Perfilopcion(PerfilopcionId id, Perfil perfil, Opcion opcion, Date fecharegistro) {
       this.id = id;
       this.perfil = perfil;
       this.opcion = opcion;
       this.fecharegistro = fecharegistro;
    }
   
    public PerfilopcionId getId() {
        return this.id;
    }
    
    public void setId(PerfilopcionId id) {
        this.id = id;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Opcion getOpcion() {
        return this.opcion;
    }
    
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }




}


