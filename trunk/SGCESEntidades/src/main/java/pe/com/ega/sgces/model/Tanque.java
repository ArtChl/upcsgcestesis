package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tanque generated by hbm2java
 */
public class Tanque  implements java.io.Serializable {


     private int id;
     private Producto producto;
     private Estacionservicio estacionservicio;
     private Date fecharegistro;
     private Integer capacidad;
     private Integer numero;
     private Integer alturavarillaje;
     private Integer alturasensor;
     private Set<Varillaje> varillajes = new HashSet<Varillaje>(0);

    public Tanque() {
    }

	
    public Tanque(int id, Producto producto, Estacionservicio estacionservicio) {
        this.id = id;
        this.producto = producto;
        this.estacionservicio = estacionservicio;
    }
    public Tanque(int id, Producto producto, Estacionservicio estacionservicio, Date fecharegistro, Integer capacidad, Integer numero, Integer alturavarillaje, Integer alturasensor, Set<Varillaje> varillajes) {
       this.id = id;
       this.producto = producto;
       this.estacionservicio = estacionservicio;
       this.fecharegistro = fecharegistro;
       this.capacidad = capacidad;
       this.numero = numero;
       this.alturavarillaje = alturavarillaje;
       this.alturasensor = alturasensor;
       this.varillajes = varillajes;
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
    public Estacionservicio getEstacionservicio() {
        return this.estacionservicio;
    }
    
    public void setEstacionservicio(Estacionservicio estacionservicio) {
        this.estacionservicio = estacionservicio;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Integer getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Integer getAlturavarillaje() {
        return this.alturavarillaje;
    }
    
    public void setAlturavarillaje(Integer alturavarillaje) {
        this.alturavarillaje = alturavarillaje;
    }
    public Integer getAlturasensor() {
        return this.alturasensor;
    }
    
    public void setAlturasensor(Integer alturasensor) {
        this.alturasensor = alturasensor;
    }
    public Set<Varillaje> getVarillajes() {
        return this.varillajes;
    }
    
    public void setVarillajes(Set<Varillaje> varillajes) {
        this.varillajes = varillajes;
    }




}

