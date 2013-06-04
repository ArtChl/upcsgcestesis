package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tarjeta generated by hbm2java
 */
public class Tarjeta  implements java.io.Serializable {


     private int id;
     private Cliente cliente;
     private String nombreChofer;
     private String numeroPlaca;
     private Date fechaCaducidad;
     private Date fechaRegistro;
     private Set<Subcuenta> subcuentas = new HashSet<Subcuenta>(0);
     private Set<Puntoacumulado> puntoacumulados = new HashSet<Puntoacumulado>(0);

    public Tarjeta() {
    }

	
    public Tarjeta(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }
    public Tarjeta(int id, Cliente cliente, String nombreChofer, String numeroPlaca, Date fechaCaducidad, Date fechaRegistro, Set<Subcuenta> subcuentas, Set<Puntoacumulado> puntoacumulados) {
       this.id = id;
       this.cliente = cliente;
       this.nombreChofer = nombreChofer;
       this.numeroPlaca = numeroPlaca;
       this.fechaCaducidad = fechaCaducidad;
       this.fechaRegistro = fechaRegistro;
       this.subcuentas = subcuentas;
       this.puntoacumulados = puntoacumulados;
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
    public String getNombreChofer() {
        return this.nombreChofer;
    }
    
    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
    public String getNumeroPlaca() {
        return this.numeroPlaca;
    }
    
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
    public Date getFechaCaducidad() {
        return this.fechaCaducidad;
    }
    
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set<Subcuenta> getSubcuentas() {
        return this.subcuentas;
    }
    
    public void setSubcuentas(Set<Subcuenta> subcuentas) {
        this.subcuentas = subcuentas;
    }
    public Set<Puntoacumulado> getPuntoacumulados() {
        return this.puntoacumulados;
    }
    
    public void setPuntoacumulados(Set<Puntoacumulado> puntoacumulados) {
        this.puntoacumulados = puntoacumulados;
    }




}


