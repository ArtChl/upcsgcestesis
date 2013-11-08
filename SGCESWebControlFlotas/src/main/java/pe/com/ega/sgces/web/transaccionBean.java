/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.web;



import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.ega.sgces.logic.ArqueoLogica;
import pe.com.ega.sgces.logic.TransaccionLogica;
import pe.com.ega.sgces.logic.TransaccionLogicaImpl;
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
    private TransaccionLogica transaccionLogica;
  
  private ArqueoLogica arqueoLogica;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Float totalSoles;
    
    public transaccionBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
                this.transaccionLogica =  context.getBean("transaccionService",
				TransaccionLogicaImpl.class);    
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
        transaccions=transaccionLogica.buscarListaId(String.valueOf(loginBean.getUsuario().getId()));
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
        transaccions=transaccionLogica.buscarListaId(String.valueOf(loginBean.getUsuario().getId()));
        for (Transaccion string : transaccions) {
            nim = Double.parseDouble(String.valueOf(string.getMontototal()));
            total = total+nim;
        }
        return Float.parseFloat(String.valueOf(total));
    }
    
}
