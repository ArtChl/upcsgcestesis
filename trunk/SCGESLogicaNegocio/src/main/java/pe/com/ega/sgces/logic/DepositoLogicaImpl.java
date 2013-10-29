/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.DepositoDao;
import pe.com.ega.sgces.model.Deposito;


public class DepositoLogicaImpl implements DepositoLogica{

    SessionFactory session; 
    DepositoDao depositoDao;

    public DepositoLogicaImpl() {
        
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    public void setDepositoDao(DepositoDao depositoDao) {
        this.depositoDao = depositoDao;
    }

    @Override
    public void insertar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.insertar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
    }

    @Override
    public void actualizar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.actualizar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
        
    }

    @Override
    public void eliminar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.eliminar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
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
        Double monto;
        try{
            List lis=depositoDao.buscarMonto(tipo, turno); 
            monto=Util.recuperarNumero(lis);
        } catch (Exception ex) {
            monto=0.00;
        }
        return monto;
    }
      
    }    

