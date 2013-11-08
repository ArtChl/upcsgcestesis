/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.com.ega.sgces.model.Arqueo;
import pe.com.ega.sgces.model.Caja;
import pe.com.ega.sgces.model.Cierre;
import pe.com.ega.sgces.model.Despacho;
import pe.com.ega.sgces.model.Estacionservicio;
import pe.com.ega.sgces.model.Puntoventa;
import pe.com.ega.sgces.model.Turno;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;
import pe.com.ega.sgces.util.Formato;
import pe.com.ega.sgces.util.ImprimirComprobante;

/**
 *
 * @author sistemas
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CierreLogicaImpl implements CierreLogica {

    private TransaccionLogica transaccionLogica;
    private DespachoLogica despachoLogica;
    private TurnopuntoventacajaLogica turnopuntoventacajaLogica;
    private ArqueoLogica arqueoLogica;
    private TurnoLogica turnoLogica;
    private ImprimirComprobante imprimircomprobante;

    public CierreLogicaImpl() {
        imprimircomprobante = new ImprimirComprobante();
    }

    public void setTurnoLogica(TurnoLogica turnoLogica) {
        this.turnoLogica = turnoLogica;
    }

    public void setTransaccionLogica(TransaccionLogica transaccionLogica) {
        this.transaccionLogica = transaccionLogica;
    }

    public void setArqueoLogica(ArqueoLogica arqueoLogica) {
        this.arqueoLogica = arqueoLogica;
    }

    public void setDespachoLogica(DespachoLogica despachoLogica) {
        this.despachoLogica = despachoLogica;
    }

    public void setTurnopuntoventacajaLogica(TurnopuntoventacajaLogica turnopuntoventacajaLogica) {
        this.turnopuntoventacajaLogica = turnopuntoventacajaLogica;
    }

    @Override
    @Transactional(readOnly = false)
    public void cierreTurno(Turno turno) {
        List<Despacho> despachos = null;
        ArrayList<Arqueo> arqueos = null;
        Turno turno2 = null;

        turno2 = turnoLogica.buscarPorCodigo("N");
        despachos = (List<Despacho>) despachoLogica.buscarTodos();
        arqueos = arqueoLogica.buscarPorCodigo(String.valueOf(turno.getId()));

        if (despachos.isEmpty()) {
            if (Formato.redondear(arqueos.get(0).getCantidad()) == 0 && Formato.redondear(arqueos.get(1).getCantidad()) == 0 && Formato.redondear(arqueos.get(2).getCantidad()) == 0 && Formato.redondear(arqueos.get(3).getCantidad()) == 0) {
                Double total = 0.0;
                ArrayList<Cierre> lista = this.buscarPorCodigo(String.valueOf(turno.getId()));
                for (Cierre arqueo1 : lista) {
                    total = total + arqueo1.getCantidad();
                }
                imprimircomprobante.imprimirTurno("0001", String.valueOf(Formato.redondear(lista.get(0).getCantidad())), String.valueOf(Formato.redondear(lista.get(1).getCantidad())), String.valueOf(Formato.redondear(lista.get(2).getCantidad())), String.valueOf(Formato.redondear(total)), String.valueOf(Formato.redondear(lista.get(3).getCantidad())), "ROSARIO");

                turnoLogica.actualizar(turno2);

                this.turno();
                this.turnoCaja();
            } else {
                throw new RuntimeException("Caja No Cuadrada");
            }
        } else {
            throw new RuntimeException("Despachos Pendientes por Facturar");
        }
    }
    
    @Transactional(readOnly = false)
    private void turno() {
        Turno x = new Turno();
        x.setEstacionservicio(new Estacionservicio(1));
        x.setFechaapertura(new Date());
        x.setEstado("N");

        turnoLogica.insertar(x);
    }

    @Transactional(readOnly = false)
    private void turnoCaja() {
        Turnopuntoventacaja cajax = new Turnopuntoventacaja();
        int turno = turnoLogica.buscarPorCodigo("N").getId();

        TurnopuntoventacajaId turnoPuntoVentaCajaId = new TurnopuntoventacajaId();
        //TODO El id caja no puede estar en duro
        turnoPuntoVentaCajaId.setIdcaja(1);
        turnoPuntoVentaCajaId.setIdturno(turno);
        turnoPuntoVentaCajaId.setIdpuntoventa(1);

        cajax.setId(turnoPuntoVentaCajaId);
        Caja caja = new Caja();
        //TODO El id caja no puede estar en duro
        caja.setId(1);
        cajax.setCaja(caja);
        //TODO El id caja no puede estar en duro
        cajax.setPuntoventa(new Puntoventa(1));
        cajax.setTurno(turnoLogica.buscarPorCodigo("N"));
        cajax.setFecharegistro(new Date());

        turnopuntoventacajaLogica.insertar(cajax);
    }

    @Override
    public ArrayList<Cierre> buscarPorCodigo(String turno) {
        ArrayList<Cierre> cierres = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        lista.add("GASOLINA 84");
        lista.add("GASOLINA 90");
        lista.add("GASOLINA 94");
        lista.add("DIESEL");
        for (int i = 0; i < lista.size(); i++) {
            String string = lista.get(i);
            Cierre cierre = new Cierre();
            cierre.setProducto(string);
            Double mov = transaccionLogica.buscarMonto(string, turno);
            cierre.setCantidad(mov);
            cierres.add(cierre);
        }
        return cierres;
    }
}
