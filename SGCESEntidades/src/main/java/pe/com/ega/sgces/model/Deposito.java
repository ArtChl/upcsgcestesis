package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Deposito generated by hbm2java
 */
public class Deposito  implements java.io.Serializable {


     private int id;
     private Turnopuntoventacaja turnopuntoventacaja;
     private Long montoTotal;
     private Date fechaRegistro;
     private Integer idTipoPago;

    public Deposito() {
    }

	
    public Deposito(int id, Turnopuntoventacaja turnopuntoventacaja) {
        this.id = id;
        this.turnopuntoventacaja = turnopuntoventacaja;
    }
    public Deposito(int id, Turnopuntoventacaja turnopuntoventacaja, Long montoTotal, Date fechaRegistro, Integer idTipoPago) {
       this.id = id;
       this.turnopuntoventacaja = turnopuntoventacaja;
       this.montoTotal = montoTotal;
       this.fechaRegistro = fechaRegistro;
       this.idTipoPago = idTipoPago;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Turnopuntoventacaja getTurnopuntoventacaja() {
        return this.turnopuntoventacaja;
    }
    
    public void setTurnopuntoventacaja(Turnopuntoventacaja turnopuntoventacaja) {
        this.turnopuntoventacaja = turnopuntoventacaja;
    }
    public Long getMontoTotal() {
        return this.montoTotal;
    }
    
    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Integer getIdTipoPago() {
        return this.idTipoPago;
    }
    
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }




}

