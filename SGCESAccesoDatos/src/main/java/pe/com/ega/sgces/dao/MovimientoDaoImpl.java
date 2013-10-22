/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.ega.sgces.model.Movimiento;

/**
 *
 * @author FLOPEZ
 */
public class MovimientoDaoImpl implements MovimientoDao{

    Session session;
    
    public void setSession(Session session) {
        this.session = session;
    }
        
   
    public void insertar(Movimiento movimiento) {
        session.save(movimiento);
    }

    public void actualizar(Movimiento movimiento) {
        session.update(movimiento);
    }

    public void eliminar(Movimiento movimiento) {
        session.delete(movimiento);
    }

    public Movimiento buscarPorCodigo(Integer id) {
        return (Movimiento) session.load(Movimiento.class, id);
    }

    @Override
    public Movimiento buscarTurno(String cerrado) {
        return (Movimiento) session.load(Movimiento.class, cerrado);
    }

    @Override
    public List buscarMonto(String tipo, String turno) throws Exception{
       Query query = session.createQuery("select sum(montototal) from Movimiento where tipo='"+tipo+"' and idturno='"+turno+"'");
       List results = query.list();
       return results;
    }

   
    
}