/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

/**
 *
 * @author FLOPEZ
 */
public class TiradaDaoTest {
    
    private Deposito deposito;
    private DepositoDao depositoDao;
    private Session session;
    private TurnoDao turnoDao;
    public TiradaDaoTest() {
        session=HibernateUtil.sessionFactory.openSession();
        depositoDao= new DepositoDaoImpl();
        depositoDao.setSession(session);
        turnoDao=new TurnoDaoImpl();
        turnoDao.setSession(session);
    }
    @Test
    public void insertDeposito(){
        List<Deposito> listaI=depositoDao.buscarTodos();
        
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        deposito= new Deposito();
        deposito.setIdtipopago("SOLES");
        deposito.setMontototal(300.0);
        caja.setId(new TurnopuntoventacajaId(turnoDao.buscarPorCodigo("N").getId(), 1, 1));
        deposito.setTurnopuntoventacaja(caja);
        deposito.setFecharegistro(new Date());
        deposito.setCerrado("N");
        deposito.setTurno(String.valueOf(turnoDao.buscarPorCodigo("N").getId()));
        
        session.beginTransaction();
        depositoDao.insertar(deposito);
        session.getTransaction().commit();
        
        assertEquals(listaI.size()+1, depositoDao.buscarTodos().size());
    }
    
    @Test
    public void anularDeposito(){
        List<Deposito> listaI=depositoDao.buscarTodos();
        deposito=listaI.get(listaI.size()-1);
        deposito.setCerrado("S");
        
        session.beginTransaction();
        depositoDao.actualizar(deposito);
        session.getTransaction().commit();
        
        assertEquals(deposito.getCerrado(), depositoDao.buscarTodos().get(listaI.size()-1).getCerrado());
    }
    /*
     @Test
    public void eliminarDeposito(){       
        List<Deposito> listaI=depositoDao.buscarTodos();
        deposito=listaI.get(listaI.size());     
        session.beginTransaction();
        depositoDao.eliminar(deposito);
        session.getTransaction().commit();
        String eliminado = "NO";
        try {         
           deposito=depositoDao.buscarPorCodigo(deposito.getId()); 
           System.out.println("Deposito"+deposito.getId());
       } catch (Exception e) {
            eliminado="SI";
       }
        assertEquals("SI",eliminado);        
    }
    */
}
