/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import org.hibernate.Session;
import pe.com.ega.sgces.dao.DespachoDao;
import pe.com.ega.sgces.dao.DespachoDaoImpl;
import pe.com.ega.sgces.dao.HibernateUtil;
import pe.com.ega.sgces.dao.TransaccionDao;
import pe.com.ega.sgces.dao.TransaccionDetalleDao;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Transaccion;
import pe.com.ega.sgces.model.Transacciondetalle;

/**
 *
 * @author CHRISTIAN
 */
public class TransaccionLogicaImpl implements TransaccionLogica
{
    Session session; 
    TransaccionDao transaccionDao;
  
    
    public TransaccionLogicaImpl()
    {
        session = HibernateUtil.getSessionFactory().openSession();
     
    }
    
   
    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
        this.transaccionDao.setSession(session);

    }
    
    TransaccionDetalleDao transacciondetalleDao;
    public void setTransaccionDetalleDao(TransaccionDetalleDao transacciondetalleDao) {
        this.transacciondetalleDao = transacciondetalleDao; 
        this.transaccionDao.setSession(session);
    }
    
    public void grabar(Transaccion transaccion) {
        session.beginTransaction();
        transaccionDao.insertar(transaccion);
        for (Transacciondetalle detalle : transaccion.getTransacciondetalles()) {
            transacciondetalleDao.insertar(detalle);
        }
        session.getTransaction().commit(); 
    }

    public Transaccion buscarPorCodigo(Integer id) {
        return transaccionDao.buscarPorCodigo(id);
    }

    public List<Transaccion> buscarListaId(String id) {
        return transaccionDao.buscarListaId(id);
    }

    public List<Transaccion> buscarTodo() {
        return transaccionDao.buscarTodos();
    }
    
     public List<Transaccion> buscarTodoDoc(String documento) {
        return transaccionDao.buscarTodosDoc(documento);
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        Double monto=0.00;
        try {
            session.beginTransaction();
            List lis=transaccionDao.buscarMonto(tipo, turno);
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
