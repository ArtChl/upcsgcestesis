/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import pe.com.ega.sgces.model.Arqueo;

/**
 *
 * @author CHRISTIAN
 */
public interface ArqueoLogica {
    public ArrayList<Arqueo> buscarPorCodigo(String turno);
}
