/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.DepositoDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.MovimientoDaoImpl;
import pe.com.ega.sgces.model.Arqueo;

/**
 *
 * @author sistemas
 */
public class ArqueoLogicaImpl implements ArqueoLogica{

    Session session; 
    MovimientoLogicaImpl movimientoLogica;
    DepositoLogicaImpl depositoLogica;

    public ArqueoLogicaImpl() {
         session = HibernateUtil.getSessionFactory().openSession();
         movimientoLogica = new MovimientoLogicaImpl();
         movimientoLogica.setMovimientoDao(new MovimientoDaoImpl());
         depositoLogica = new DepositoLogicaImpl();
         depositoLogica.setDepositoDao(new DepositoDaoImpl());
    }
     
    @Override
    public ArrayList<Arqueo> buscarPorCodigo(String turno) {
         ArrayList<Arqueo> arqueos= new ArrayList<>();
         ArrayList<String> lista= new ArrayList<>();
         lista.add("SOLES");
         lista.add("DOLARES");
         lista.add("VISA");
         lista.add("MASTERCARD");
         
         for (int i = 0; i < lista.size(); i++) {
            String string = lista.get(i);
            Arqueo arqueo=new Arqueo();
            arqueo.setComprobante(string);
            Double mov=movimientoLogica.buscarMonto(string,turno);
            Double dep=depositoLogica.buscarMonto(string,turno);
            arqueo.setCantidad(mov-dep);
            arqueos.add(arqueo);           
        }
         return arqueos;
    }
    
}
