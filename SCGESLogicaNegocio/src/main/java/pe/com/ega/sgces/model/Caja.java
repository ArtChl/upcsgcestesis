package pe.com.ega.sgces.model;
// Generated 17/10/2013 09:33:40 AM by Hibernate Tools 3.2.1.GA


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
     private Date fecharegistro;
     private Set<Turnopuntoventacaja> turnopuntoventacajas = new HashSet<Turnopuntoventacaja>(0);
   
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
    public Date getFecharegistro() {
        return this.fecharegistro;
    }
    
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Set<Turnopuntoventacaja> getTurnopuntoventacajas() {
        return this.turnopuntoventacajas;
    }
    
    public void setTurnopuntoventacajas(Set<Turnopuntoventacaja> turnopuntoventacajas) {
        this.turnopuntoventacajas = turnopuntoventacajas;
    }




}


