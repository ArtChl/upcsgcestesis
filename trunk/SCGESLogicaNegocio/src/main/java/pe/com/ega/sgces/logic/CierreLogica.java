/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.model.Cierre;

/**
 *
 * @author CHRISTIAN
 */
public interface CierreLogica {
    public ArrayList<Cierre> buscarPorCodigo(String turno);
    public String cierreTurno();
}
