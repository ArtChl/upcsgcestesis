package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Despacho generated by hbm2java
 */
public class Despacho  implements java.io.Serializable {


     private int id;
     private Producto producto;
     private Caraproducto caraproducto;
     private Integer idestado;
     private BigDecimal montosoles;
     private BigDecimal nrogalones;
     private BigDecimal preciounitario;
     private Date fecharegistro;
     private String turno;
     private String hora;
     private String idcem;
     private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Caraproducto getCaraproducto() {
        return this.caraproducto;
    }
    
    public void setCaraproducto(Caraproducto caraproducto) {
        this.caraproducto = caraproducto;
    }
    public Integer getIdestado() {
        return this.idestado;
    }
    
    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }
    public BigDecimal getMontosoles() {
        return this.montosoles;
    }
    
    public void setMontosoles(BigDecimal montosoles) {
        this.montosoles = montosoles;
    }
    public BigDecimal getNrogalones() {
        return this.nrogalones;
    }
    
    public void setNrogalones(BigDecimal nrogalones) {
        this.nrogalones = nrogalones;
    }
    public BigDecimal getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getIdcem() {
        return this.idcem;
    }
    
    public void setIdcem(String idcem) {
        this.idcem = idcem;
    }
    public Set<Transaccion> getTransaccions() {
        return this.transaccions;
    }
    
    public void setTransaccions(Set<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }




}


