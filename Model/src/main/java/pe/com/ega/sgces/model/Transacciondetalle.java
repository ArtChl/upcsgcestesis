package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Transacciondetalle generated by hbm2java
 */
public class Transacciondetalle  implements java.io.Serializable {


     private int id;
     private Producto producto;
     private Transaccion transaccion;
     private Long monto;
     private Integer cantidad;
     private Date fechaRegistro;

    public Transacciondetalle() {
    }

	
    public Transacciondetalle(int id, Producto producto, Transaccion transaccion) {
        this.id = id;
        this.producto = producto;
        this.transaccion = transaccion;
    }
    public Transacciondetalle(int id, Producto producto, Transaccion transaccion, Long monto, Integer cantidad, Date fechaRegistro) {
       this.id = id;
       this.producto = producto;
       this.transaccion = transaccion;
       this.monto = monto;
       this.cantidad = cantidad;
       this.fechaRegistro = fechaRegistro;
    }
   
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
    public Transaccion getTransaccion() {
        return this.transaccion;
    }
    
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    public Long getMonto() {
        return this.monto;
    }
    
    public void setMonto(Long monto) {
        this.monto = monto;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }




}


