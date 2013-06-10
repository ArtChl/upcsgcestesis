/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.web;



import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
import pe.com.ega.sgces.logic.UsuarioLogicaImpl;
import pe.com.ega.sgces.model.Transaccion;

/**
 *
 * @author Flopez
 */
@ManagedBean(name="transsaccionBean")
@SessionScoped
public class transaccionBean implements Serializable{

    private Transaccion transaccion;
    private List<Transaccion> transaccions;
    TransaccionLogicaImpl transacciondao;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Float totalSoles;
    
    public transaccionBean() {
        transacciondao = new TransaccionLogicaImpl();
        transacciondao.setTransaccionDao(new TransaccionDaoImpl());
    }
    
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    public Transaccion getTransaccion() {
        if(transaccion==null){
            transaccion=new Transaccion();
        }
        return transaccion;
    }

    public void setUsuario(Transaccion tran) {
        this.transaccion = tran;
    }

    public List<Transaccion> getTransaccions() {       
        transaccions=transacciondao.buscarListaId(String.valueOf(loginBean.getUsuario().getId()));
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> trans) {
        this.transaccions = trans;
    }
  
      public Float getTotalSoles() {
        return totalSoles=this.sumaSoles();
    }

    public void setTotalSoles(Float totalSoles) {
        this.totalSoles = totalSoles;
    }
    
     private Float sumaSoles() {
        Double total = 0.0;
        Double nim;
        transaccions=transacciondao.buscarListaId(String.valueOf(loginBean.getUsuario().getId()));
        for (Transaccion string : transaccions) {
            nim = Double.parseDouble(String.valueOf(string.getMontoTotal()));
            total = total+nim;
            System.out.println("Suma"+total);
        }
        return Float.parseFloat(String.valueOf(total));
    }
    /* 
    public void prepararUsuario(Integer id) {
        usuario=usuarioDao.buscraPorId(id);
    }
    
    public void inicioUsuario() {
        usuario = new Usuario();
    }
    
    public void agregarUsuario() {
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            usuarioDao.insertar(usuario);                     
            context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado"));
            usuario = new Usuario();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No se han eliminado", "Salvado"));
            usuarioDao.cerrarError();
        }
    }
    
    public void actualizarUsuario(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            usuarioDao.actualizar(usuario);              
            context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado"));
            usuario = new Usuario();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No se han Actualizado", "Actualizado"));
            usuarioDao.cerrarError();
        }
    
    }
    
    public void eliminarCliente(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            usuarioDao.eliminar(usuario);            
            context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminados"));
            usuario = new Usuario();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No se han eliminado", "Eliminados"));
            usuarioDao.cerrarError();
        }
    
    }*/
}
