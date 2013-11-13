/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.web;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.context.RequestContext;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.UsuarioDao;
import pe.com.ega.sgces.dao.UsuariodaoImpl;
import pe.com.ega.sgces.logic.UsuarioLogica;
import pe.com.ega.sgces.logic.UsuarioLogicaImpl;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author Flopez
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private Usuario usuario;
    private UsuarioLogica usuarioLogica;
    private UsuarioDao usuariodao;
    private static SessionFactory sessionFactory;


    public LoginBean() {
        sessionFactory = HibernateUtil.getSessionFactory();
        usuarioLogica=new UsuarioLogicaImpl();
        usuariodao=new UsuariodaoImpl();
        usuariodao.setSession(sessionFactory);
        usuarioLogica.setUsuarioDao(usuariodao);        
    }
    
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;       
        usuario=usuarioLogica.buscarPorUsuario(usuario);
        if(usuario != null) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Usuario");  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
    
    public Usuario getUsuario() {
        if(usuario==null){
            usuario= new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }      
}
