/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import pe.com.ega.sgces.util.Util;
import pe.com.ega.sgces.util.ImprimirComprobante;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.dao.DepositoDao;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class DepositoLogicaImpl implements DepositoLogica {

    private DepositoDao depositoDao;
    private TurnoLogica turnoLogica;
    private Deposito deposito;
    private ImprimirComprobante imprimircomprobante;

    public DepositoLogicaImpl() {
        deposito = new Deposito();
        imprimircomprobante = new ImprimirComprobante();
    }

    public void setTurnoLogica(TurnoLogica turnoLogica) {
        this.turnoLogica = turnoLogica;
    }

    public void setDepositoDao(DepositoDao depositoDao) {
        this.depositoDao = depositoDao;
    }

    @Override
    public void insertar(Deposito deposito) {
        depositoDao.insertar(deposito);
    }

    @Override
    public void actualizar(Deposito deposito) {
        depositoDao.actualizar(deposito);

    }

    @Override
    public void eliminar(Deposito deposito) {
        depositoDao.eliminar(deposito);
    }

    @Override
    @Transactional(readOnly = true)
    public Deposito buscarPorCodigo(Integer id) {
        return depositoDao.buscarPorCodigo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Deposito> buscarTodos() {
        return depositoDao.buscarTodos();
    }

    @Override
    @Transactional(readOnly = true)
    public Double buscarMonto(String tipo, String turno) {
        Double monto;
            List lis = depositoDao.buscarMonto(tipo, turno);
            monto = Util.recuperarNumero(lis);
        
        return monto;
    }

    @Override
    public String depositar(String monto, String pago) {
        String mensaje = null;

        TurnopuntoventacajaId turnoPuntoVentaCajaId = new TurnopuntoventacajaId();
        turnoPuntoVentaCajaId.setIdcaja(1);
        turnoPuntoVentaCajaId.setIdturno(turnoLogica.buscarPorCodigo("N").getId());
        turnoPuntoVentaCajaId.setIdpuntoventa(1);

        Turnopuntoventacaja caja = new Turnopuntoventacaja();
        caja.setId(turnoPuntoVentaCajaId);
        deposito.setTurnopuntoventacaja(caja);
        Double dos = Double.parseDouble(monto);
        deposito.setMontototal(dos);
        deposito.setFecharegistro(new Date());
        deposito.setIdtipopago(pago);
        deposito.setTurno(String.valueOf(turnoLogica.buscarPorCodigo("N").getId()));
        deposito.setCerrado("N");
        this.insertar(deposito);
        //TODO Borrar el nombre en duro
        imprimircomprobante.imprimirTirada("0001", "1", pago, monto, "ROSA MARIA DAVILA");
        return mensaje;
    }
}
