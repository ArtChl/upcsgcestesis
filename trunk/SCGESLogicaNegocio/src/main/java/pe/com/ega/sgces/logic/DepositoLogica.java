/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Deposito;
/**
 *
 * @author CHRISTIAN
 */
public interface DepositoLogica {
    public void insertar(Deposito deposito);
    public void actualizar(Deposito deposito);
    public void eliminar(Deposito deposito);
    public Deposito buscarPorCodigo(Integer id);
    public List<Deposito> buscarTodos();
    public Double buscarMonto(String tipo, String turno);
    public String depositar(String tipo, String monto);
    //public void setSession(SessionFactory session);
   // public void setDepositoDao(DepositoDao depositoDao);
}
