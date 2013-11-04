package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int id;
     private Integer idtipoproducto;
     private String nombre;
     private Date fecharegistro;
     private Set<Transacciondetalle> transacciondetalles = new HashSet<Transacciondetalle>(0);
     private Set<Caraproducto> caraproductos = new HashSet<Caraproducto>(0);
     private Set<Tanque> tanques = new HashSet<Tanque>(0);
     private Set<Subcuenta> subcuentas = new HashSet<Subcuenta>(0);
     private Set<Despacho> despachos = new HashSet<Despacho>(0);

    public Producto() {
    }

	
    public Producto(int id) {
        this.id = id;
    }
    public Producto(int id, Integer idtipoproducto, String nombre, Date fecharegistro, Set<Transacciondetalle> transacciondetalles, Set<Caraproducto> caraproductos, Set<Tanque> tanques, Set<Subcuenta> subcuentas, Set<Despacho> despachos) {
       this.id = id;
       this.idtipoproducto = idtipoproducto;
       this.nombre = nombre;
       this.fecharegistro = fecharegistro;
       this.transacciondetalles = transacciondetalles;
       this.caraproductos = caraproductos;
       this.tanques = tanques;
       this.subcuentas = subcuentas;
       this.despachos = despachos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getIdtipoproducto() {
        return this.idtipoproducto;
    }
    
    public void setIdtipoproducto(Integer idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Set<Transacciondetalle> getTransacciondetalles() {
        return this.transacciondetalles;
    }
    
    public void setTransacciondetalles(Set<Transacciondetalle> transacciondetalles) {
        this.transacciondetalles = transacciondetalles;
    }
    public Set<Caraproducto> getCaraproductos() {
        return this.caraproductos;
    }
    
    public void setCaraproductos(Set<Caraproducto> caraproductos) {
        this.caraproductos = caraproductos;
    }
    public Set<Tanque> getTanques() {
        return this.tanques;
    }
    
    public void setTanques(Set<Tanque> tanques) {
        this.tanques = tanques;
    }
    public Set<Subcuenta> getSubcuentas() {
        return this.subcuentas;
    }
    
    public void setSubcuentas(Set<Subcuenta> subcuentas) {
        this.subcuentas = subcuentas;
    }
    public Set<Despacho> getDespachos() {
        return this.despachos;
    }
    
    public void setDespachos(Set<Despacho> despachos) {
        this.despachos = despachos;
    }




}


