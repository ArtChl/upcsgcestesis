package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Impresorapuntoventa generated by hbm2java
 */
public class Impresorapuntoventa  implements java.io.Serializable {


     private ImpresorapuntoventaId id;
     private Impresora impresora;
     private Puntoventa puntoventa;
     private Date fecharegistro;

    public Impresorapuntoventa() {
    }

	
    public Impresorapuntoventa(ImpresorapuntoventaId id, Impresora impresora, Puntoventa puntoventa) {
        this.id = id;
        this.impresora = impresora;
        this.puntoventa = puntoventa;
    }
    public Impresorapuntoventa(ImpresorapuntoventaId id, Impresora impresora, Puntoventa puntoventa, Date fecharegistro) {
       this.id = id;
       this.impresora = impresora;
       this.puntoventa = puntoventa;
       this.fecharegistro = fecharegistro;
    }
   
    public ImpresorapuntoventaId getId() {
        return this.id;
    }
    
    public void setId(ImpresorapuntoventaId id) {
        this.id = id;
    }
    public Impresora getImpresora() {
        return this.impresora;
    }
    
    public void setImpresora(Impresora impresora) {
        this.impresora = impresora;
    }
    public Puntoventa getPuntoventa() {
        return this.puntoventa;
    }
    
    public void setPuntoventa(Puntoventa puntoventa) {
        this.puntoventa = puntoventa;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }




}

