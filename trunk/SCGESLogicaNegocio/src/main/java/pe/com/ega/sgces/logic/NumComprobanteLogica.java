/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.List;
import pe.com.ega.sgces.model.Numcomprobante;

/**
 *
 * @author FLOPEZ
 */
public interface NumComprobanteLogica {
    public void insertar(Numcomprobante comp);
    public void actualizar(Numcomprobante comp);
    public void eliminar(Numcomprobante comp);
    public Numcomprobante buscarPorCodigo(int tipo);
    public List<Numcomprobante> buscarConsumo(String cliente);
}
