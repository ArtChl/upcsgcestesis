/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.TransaccionDaoImpl;
import pe.com.ega.sgces.model.Cierre;

/**
 *
 * @author sistemas
 */
public class CierreLogicaImpl implements CierreLogica{

    Session session; 
    TransaccionLogicaImpl transaccionLogica;
    DespachoLogica despachoLogica;

    public CierreLogicaImpl() {
         session = HibernateUtil.getSessionFactory().openSession();
         transaccionLogica = new TransaccionLogicaImpl();
         transaccionLogica.setTransaccionDao(new TransaccionDaoImpl());

    }
    
    @Override
    public ArrayList<Cierre> buscarPorCodigo(String turno) {
        ArrayList<Cierre> cierres= new ArrayList<>();
         ArrayList<String> lista= new ArrayList<>();
         lista.add("GASOLINA 84");
         lista.add("GASOLINA 90");
         lista.add("GASOLINA 94");
         lista.add("DIESEL");
         
         for (int i = 0; i < lista.size(); i++) {
            String string = lista.get(i);
            Cierre cierre=new Cierre();
            cierre.setProducto(string);
            Double mov=transaccionLogica.buscarMonto(string, turno);
            cierre.setCantidad(mov);
            cierres.add(cierre);           
        }
         return cierres;
    }
    
}
