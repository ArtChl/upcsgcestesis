package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Tipocambio generated by hbm2java
 */
public class Tipocambio  implements java.io.Serializable {


     private int id;
     private Long cambio;
     private Integer idMoneda;
     private Date fechaRegistro;

    public Tipocambio() {
    }

	
    public Tipocambio(int id) {
        this.id = id;
    }
    public Tipocambio(int id, Long cambio, Integer idMoneda, Date fechaRegistro) {
       this.id = id;
       this.cambio = cambio;
       this.idMoneda = idMoneda;
       this.fechaRegistro = fechaRegistro;
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
    public Integer getIdMoneda() {
        return this.idMoneda;
    }
    
    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }




}

