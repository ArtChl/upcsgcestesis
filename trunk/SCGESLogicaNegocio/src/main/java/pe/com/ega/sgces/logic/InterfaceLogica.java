/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.dao.InterfaceDao;
import pe.com.ega.sgces.model.InterfaceConfig;
/**
 *
 * @author CHRISTIAN
 */
public interface InterfaceLogica {
    public void insertar(InterfaceConfig turno);
    public void actualizar(InterfaceConfig turno);
    public InterfaceConfig buscarPorCodigo(int codigo);
    public void setInterfaceDao(InterfaceDao interfaceDao);
}
