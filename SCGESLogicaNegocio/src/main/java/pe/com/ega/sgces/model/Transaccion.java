package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Transaccion generated by hbm2java
 */

public class Transaccion  implements java.io.Serializable {


     private int id;
     private Cliente cliente;
     private Despacho despacho;
     private String idtipotransaccion;
     private Integer idestado;
     private Integer numero;
     private String numerotransaccion;
     private String numeroplaca;
     private String numerovale;
     private String numerotiket;
     private String producto;
     private BigDecimal montototal;
     private BigDecimal nrogalones;
     private BigDecimal preciounitario;
     private Date fecharegistro;
     private Boolean facturado;
     private Boolean anulado;
     private String turno;
     private Set<Puntoacumulado> puntoacumulados = new HashSet<Puntoacumulado>(0);
     private Set<Transacciondetalle> transacciondetalles = new HashSet<Transacciondetalle>(0);
     private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

    public Transaccion() {
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Despacho getDespacho() {
        return this.despacho;
    }
    
    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }
    public String getIdtipotransaccion() {
        return this.idtipotransaccion;
    }
    
    public void setIdtipotransaccion(String idtipotransaccion) {
        this.idtipotransaccion = idtipotransaccion;
    }
    public Integer getIdestado() {
        return this.idestado;
    }
    
    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getNumerotransaccion() {
        return this.numerotransaccion;
    }
    
    public void setNumerotransaccion(String numerotransaccion) {
        this.numerotransaccion = numerotransaccion;
    }
    public String getNumeroplaca() {
        return this.numeroplaca;
    }
    
    public void setNumeroplaca(String numeroplaca) {
        this.numeroplaca = numeroplaca;
    }
    public String getNumerovale() {
        return this.numerovale;
    }
    
    public void setNumerovale(String numerovale) {
        this.numerovale = numerovale;
    }
    public String getNumerotiket() {
        return this.numerotiket;
    }
    
    public void setNumerotiket(String numerotiket) {
        this.numerotiket = numerotiket;
    }
    public String getProducto() {
        return this.producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public BigDecimal getMontototal() {
        return this.montototal;
    }
    
    public void setMontototal(BigDecimal montototal) {
        this.montototal = montototal;
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
    public Boolean getFacturado() {
        return this.facturado;
    }
    
    public void setFacturado(Boolean facturado) {
        this.facturado = facturado;
    }
    public Boolean getAnulado() {
        return this.anulado;
    }
    
    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Set<Puntoacumulado> getPuntoacumulados() {
        return this.puntoacumulados;
    }
    
    public void setPuntoacumulados(Set<Puntoacumulado> puntoacumulados) {
        this.puntoacumulados = puntoacumulados;
    }
    public Set<Transacciondetalle> getTransacciondetalles() {
        return this.transacciondetalles;
    }
    
    public void setTransacciondetalles(Set<Transacciondetalle> transacciondetalles) {
        this.transacciondetalles = transacciondetalles;
    }
    public Set<Movimiento> getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }




}


