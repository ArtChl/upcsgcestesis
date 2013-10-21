/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.DepositoDao;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.model.Cliente;
import pe.com.ega.sgces.model.Deposito;

/**
 *
 * @author Flopez
 */
public class DepositoLogicaImpl implements DepositoLogica{

    Session session; 
    DepositoDao depositoDao;

    public DepositoLogicaImpl() {
        
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void setDepositoDao(DepositoDao depositoDao) {
        this.depositoDao = depositoDao;
        this.depositoDao.setSession(session);
    }

    @Override
    public void insertar(Deposito deposito) {
        session.beginTransaction();
        depositoDao.insertar(deposito);
        session.getTransaction().commit(); 
    }

    @Override
    public void actualizar(Deposito deposito) {
        session.beginTransaction();
        depositoDao.actualizar(deposito);
        session.getTransaction().commit(); 
        
    }

    @Override
    public void eliminar(Deposito deposito) {
        session.beginTransaction();
        depositoDao.eliminar(deposito);
        session.getTransaction().commit(); 
    }

    @Override
    public Deposito buscarPorCodigo(Integer id) {
       return depositoDao.buscarPorCodigo(id);
    }

    @Override
    public List<Deposito> buscarTodos() {
        return depositoDao.buscarTodos();
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
         Double monto=0.00;
        try {
            session.beginTransaction();
            List lis=depositoDao.buscarMonto(tipo, turno);
            session.getTransaction().commit(); 
            String numero=lis.toString().replace("[", "");
            numero=numero.replace("]", "");
            monto=Double.parseDouble(numero);
        } catch (Exception ex) {
            monto=0.00;
        }
        return monto;
    }
    
    
}
