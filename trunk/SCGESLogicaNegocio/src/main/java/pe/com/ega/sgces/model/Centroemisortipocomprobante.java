package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Centroemisortipocomprobante generated by hbm2java
 */
public class Centroemisortipocomprobante  implements java.io.Serializable {


     private CentroemisortipocomprobanteId id;
     private Centroemisor centroemisor;
     private Date fecharegistro;

    public Centroemisortipocomprobante() {
    }

	
    public Centroemisortipocomprobante(CentroemisortipocomprobanteId id, Centroemisor centroemisor) {
        this.id = id;
        this.centroemisor = centroemisor;
    }
    public Centroemisortipocomprobante(CentroemisortipocomprobanteId id, Centroemisor centroemisor, Date fecharegistro) {
       this.id = id;
       this.centroemisor = centroemisor;
       this.fecharegistro = fecharegistro;
    }
   
    public CentroemisortipocomprobanteId getId() {
        return this.id;
    }
    
    public void setId(CentroemisortipocomprobanteId id) {
        this.id = id;
    }
    public Centroemisor getCentroemisor() {
        return this.centroemisor;
    }
    
    public void setCentroemisor(Centroemisor centroemisor) {
        this.centroemisor = centroemisor;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }




}


