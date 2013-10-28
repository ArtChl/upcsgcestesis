/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Deposito;

/**
 *
 * @author Flopez
 */
public interface DepositoDao {
    public void insertar(Deposito deposito);
    public void actualizar(Deposito deposito);
    public void eliminar(Deposito deposito);
    public Deposito buscarPorCodigo(Integer id);
    public List<Deposito> buscarTodos();   
    public void setSession(SessionFactory session);
    public List buscarMonto(String tipo, String turno) ;
}
