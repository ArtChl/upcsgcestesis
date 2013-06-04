package pe.com.ega.sgces.model;
// Generated 04/06/2013 01:38:23 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Caja generated by hbm2java
 */
public class Caja  implements java.io.Serializable {


     private int id;
     private Trabajador trabajador;
     private String codigo;
     private Date fechaRegistro;
     private Set<Turnopuntoventacaja> turnopuntoventacajas = new HashSet<Turnopuntoventacaja>(0);

    public Caja() {
    }

	
    public Caja(int id, Trabajador trabajador) {
        this.id = id;
        this.trabajador = trabajador;
    }
    public Caja(int id, Trabajador trabajador, String codigo, Date fechaRegistro, Set<Turnopuntoventacaja> turnopuntoventacajas) {
       this.id = id;
       this.trabajador = trabajador;
       this.codigo = codigo;
       this.fechaRegistro = fechaRegistro;
       this.turnopuntoventacajas = turnopuntoventacajas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set<Turnopuntoventacaja> getTurnopuntoventacajas() {
        return this.turnopuntoventacajas;
    }
    
    public void setTurnopuntoventacajas(Set<Turnopuntoventacaja> turnopuntoventacajas) {
        this.turnopuntoventacajas = turnopuntoventacajas;
    }




}


