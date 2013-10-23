/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.Date;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.InterfaceDaoImpl;
import pe.com.ega.sgces.dao.TurnoDao;
import pe.com.ega.sgces.model.InterfaceConfig;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author Flopez
 */
public class TurnoLogicaImpl implements TurnoLogica{

    private InterfaceLogicaImpl interfaceLogica;
    Session session; 
    TurnoDao turnoDao;
    
    public TurnoLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        interfaceLogica= new InterfaceLogicaImpl();
        interfaceLogica.setInterfaceDao(new InterfaceDaoImpl());
        
    }
       
    @Override
    public void insertar(Turno turno) {
        session.beginTransaction();
        turnoDao.insertar(turno);
        session.getTransaction().commit();
        this.cem44();       
    }

    @Override
    public void actualizar(Turno turno) {
        turno.setEstado("S");
        turno.setFechacierre(new Date());
        session.beginTransaction();
        turnoDao.actualizar(turno);
        session.getTransaction().commit();
        
    }

    @Override
    public void eliminar(Turno turno) {
        session.beginTransaction();
        turnoDao.eliminar(turno);
        session.getTransaction().commit();
    }

    @Override
    public Turno buscarPorCodigo(String estado) {
         
        return turnoDao.buscarPorCodigo(estado);
    }
    
    public void setTurnoDao(TurnoDao turnoDao) {
       this.turnoDao= turnoDao;
       this.turnoDao.setSession(session);
    }
    
    public final void cem44()
    {
        InterfaceConfig cierre=interfaceLogica.buscarPorCodigo(1);     
        cierre.setCambioturno(1);
        cierre.setFechaTotalizadoresElectronicos(new Date());      
        interfaceLogica.actualizar(cierre);
        System.out.println("estado Cem44");
             
    }
    
    
}
