package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * Movimiento generated by hbm2java
 */
public class Movimiento  implements java.io.Serializable {


     private int id;
     private Turnopuntoventacaja turnopuntoventacaja;
     private Transaccion transaccion;
     private String pago;
     private BigDecimal montorecibido;
     private BigDecimal montototal;
     private BigDecimal montodevuelto;
     private Date fecharegistro;
     private String nrooperacion;
     private String tipo;
     private String turno;
     private String cerrado;

    public Movimiento() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turnopuntoventacaja getTurnopuntoventacaja() {
        return turnopuntoventacaja;
    }

    public void setTurnopuntoventacaja(Turnopuntoventacaja turnopuntoventacaja) {
        this.turnopuntoventacaja = turnopuntoventacaja;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public BigDecimal getMontorecibido() {
        return montorecibido;
    }

    public void setMontorecibido(BigDecimal montorecibido) {
        this.montorecibido = montorecibido;
    }

    public BigDecimal getMontototal() {
        return montototal;
    }

    public void setMontototal(BigDecimal montototal) {
        this.montototal = montototal;
    }

    public BigDecimal getMontodevuelto() {
        return montodevuelto;
    }

    public void setMontodevuelto(BigDecimal montodevuelto) {
        this.montodevuelto = montodevuelto;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getNrooperacion() {
        return nrooperacion;
    }

    public void setNrooperacion(String nrooperacion) {
        this.nrooperacion = nrooperacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCerrado() {
        return cerrado;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }

    
}


