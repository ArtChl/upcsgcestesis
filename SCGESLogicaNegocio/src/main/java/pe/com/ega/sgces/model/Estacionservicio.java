package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Estacionservicio generated by hbm2java
 */
public class Estacionservicio  implements java.io.Serializable {


     private int id;
     private Distrito distrito;
     private String nombre;
     private String direccion;
     private Long latitud;
     private Long longitud;
     private String razonsocial;
     private String ruc;
     private String telefono;
     private Date fechaapertura;
     private Date fecharegistro;
     private Set<Turno> turnos = new HashSet<Turno>(0);
     private Set<Trabajador> trabajadors = new HashSet<Trabajador>(0);
     private Set<Puntoventa> puntoventas = new HashSet<Puntoventa>(0);
     private Set<Surtidor> surtidors = new HashSet<Surtidor>(0);
     private Set<Tanque> tanques = new HashSet<Tanque>(0);

    public Estacionservicio() {
    }

     public Estacionservicio(int id) {
        this.id = id;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Distrito getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Long getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }
    public Long getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
    public String getRazonsocial() {
        return this.razonsocial;
    }
    
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFechaapertura() {
        return this.fechaapertura;
    }
    
    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Set<Turno> getTurnos() {
        return this.turnos;
    }
    
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
    public Set<Trabajador> getTrabajadors() {
        return this.trabajadors;
    }
    
    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }
    public Set<Puntoventa> getPuntoventas() {
        return this.puntoventas;
    }
    
    public void setPuntoventas(Set<Puntoventa> puntoventas) {
        this.puntoventas = puntoventas;
    }
    public Set<Surtidor> getSurtidors() {
        return this.surtidors;
    }
    
    public void setSurtidors(Set<Surtidor> surtidors) {
        this.surtidors = surtidors;
    }
    public Set<Tanque> getTanques() {
        return this.tanques;
    }
    
    public void setTanques(Set<Tanque> tanques) {
        this.tanques = tanques;
    }




}


