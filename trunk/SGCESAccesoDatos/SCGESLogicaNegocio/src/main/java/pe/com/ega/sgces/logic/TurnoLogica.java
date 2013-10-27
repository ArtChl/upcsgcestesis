/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Turno;
/**
 *
 * @author CHRISTIAN
 */
public interface TurnoLogica {
    public void insertar(Turno turno);
    public void actualizar(Turno turno);
    public void eliminar(Turno turno);
    public Turno buscarPorCodigo(String estado);  
}
