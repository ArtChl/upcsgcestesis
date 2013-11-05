/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import pe.com.ega.sgces.model.Cierre;
import pe.com.ega.sgces.model.Turno;

/**
 *
 * @author CHRISTIAN
 */
public interface CierreLogica {
    public ArrayList<Cierre> buscarPorCodigo(String turno);
    public String cierreTurno(Turno turno);
}
