package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Tipocambio generated by hbm2java
 */
public class Tipocambio  implements java.io.Serializable {

     private int id;
     private Long cambio;
     private Integer idmoneda;
     private Date fecharegistro;

    public Tipocambio() {
    }

	
    public Tipocambio(int id) {
        this.id = id;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Long getCambio() {
        return this.cambio;
    }
    
    public void setCambio(Long cambio) {
        this.cambio = cambio;
    }
    public Integer getIdmoneda() {
        return this.idmoneda;
    }
    
    public void setIdmoneda(Integer idmoneda) {
        this.idmoneda = idmoneda;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }




}


