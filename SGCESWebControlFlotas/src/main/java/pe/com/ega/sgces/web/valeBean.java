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
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.NumComprobanteDao;
import pe.com.ega.sgces.dao.NumComprobanteDaoImpl;
import pe.com.ega.sgces.dao.ValeDao;
import pe.com.ega.sgces.dao.ValeDaoImpl;
import pe.com.ega.sgces.logic.NumComprobanteLogicaImpl;
import pe.com.ega.sgces.logic.ValeLogica;
import pe.com.ega.sgces.model.Numcomprobante;
import pe.com.ega.sgces.model.Vale;

/**
 *
 * @author Flopez
 */
@ManagedBean(name="valeBean")
@SessionScoped
public class valeBean implements Serializable{

    private Vale vale;
    private List<Vale> vales;
    private ValeDao valedao;
    private NumComprobanteDao numdao;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private static SessionFactory sessionFactory;
    
    public valeBean() {
        sessionFactory = HibernateUtil.getSessionFactory();
        numdao=new NumComprobanteDaoImpl();
        valedao=new ValeDaoImpl();
        valedao.setSession(sessionFactory);
        numdao.setSession(sessionFactory); 
    }
    
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    public Vale getVale() {
        if(vale==null){
            vale=new Vale();
        }
        return vale;
    }

    public void setUsuario(Vale val) {
        this.vale = val;
    }

    public List<Vale> getVales() {       
        vales=valedao.buscarConsumo(String.valueOf(loginBean.getUsuario().getTrabajador().getDni()));
        return vales;
    }

    public void setVales(List<Vale> vales) {
        this.vales = vales;
    }   
    
    public void prepararVale(Integer id) {
        vale= valedao.buscarPorCodigo(id);
    }
    
    public void inicioVale() {
        vale = new Vale();
    }
    
    public void agregarVale() {
        FacesContext context = FacesContext.getCurrentInstance(); 
        Numcomprobante comprobantes= numdao.buscarPorCodigo(1);
        try {
            System.out.println("Numero Comporbante"+comprobantes.getNumero());
            vale.setCliente(loginBean.getUsuario().getTrabajador().getDni());
            vale.setNumero(agregarCeros(String.valueOf(comprobantes.getNumero()),6));
            comprobantes.setNumero(comprobantes.getNumero()+1);
            numdao.actualizar(comprobantes);
            valedao.insertar(vale);                     
            context.addMessage(null, new FacesMessage("Datos Almacenados Correctamente", "Salvado"));
            vale = new Vale();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No Almacenado", "Error"));
        }
    }
    
    public void actualizarVale(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            valedao.actualizarVale(vale);              
            context.addMessage(null, new FacesMessage("Datos Actualizados Correctamente", "Actualizado"));
            vale = new Vale();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No se han Actualizado", "Actualizado"));
        }
    
    }
    
    public void eliminarVale(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            valedao.eliminar(vale);            
            context.addMessage(null, new FacesMessage("Datos Eliminados Correctamente", "Eliminados"));
            vale = new Vale();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Datos No se han eliminado", "Eliminados"));
        }    
    }
    
    private static String agregarCeros(String string, int largo)
    {
    	String ceros = "";
    	int cantidad = largo - string.length();
    	if (cantidad >= 1){
    		for(int i=0;i<cantidad;i++)
    		{
    		ceros += "0";	
    		}
    		return (ceros + string);
    	}else {
            return string;
        }
    }
}
