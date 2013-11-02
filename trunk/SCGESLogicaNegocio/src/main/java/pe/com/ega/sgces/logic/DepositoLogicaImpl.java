/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import Imprimir.ImprimirComprobante;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import pe.com.ega.sgces.dao.DepositoDao;
import pe.com.ega.sgces.model.Deposito;
import pe.com.ega.sgces.model.Turnopuntoventacaja;
import pe.com.ega.sgces.model.TurnopuntoventacajaId;


public class DepositoLogicaImpl implements DepositoLogica{

    SessionFactory session; 
    private DepositoDao depositoDao;
    private TurnoLogica turnoLogica;
    private Deposito deposito;
    private ImprimirComprobante imprimircomprobante;

    public DepositoLogicaImpl() {
        deposito=new Deposito();
        imprimircomprobante = new ImprimirComprobante();
    }

    
    public void setTurnoLogica(TurnoLogica turnoLogica) {
        this.turnoLogica = turnoLogica;
    }
    
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    public void setDepositoDao(DepositoDao depositoDao) {
        this.depositoDao = depositoDao;
    }

    @Override
    public void insertar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.insertar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
    }

    @Override
    public void actualizar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.actualizar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
        
    }

    @Override
    public void eliminar(Deposito deposito) {
        session.getCurrentSession().beginTransaction();
        depositoDao.eliminar(deposito);
        session.getCurrentSession().getTransaction().commit(); 
    }

    @Override
    public Deposito buscarPorCodigo(Integer id) {
       return depositoDao.buscarPorCodigo(id);
    }

    @Override
    public List<Deposito> buscarTodos() {
        return depositoDao.buscarTodos();
    }

    @Override
    public Double buscarMonto(String tipo, String turno) {
        Double monto;
        try{
            List lis=depositoDao.buscarMonto(tipo, turno); 
            monto=Util.recuperarNumero(lis);
        } catch (Exception ex) {
            monto=0.00;
        }
        return monto;
    }

    @Override
    public String depositar(String monto, String pago) 
    {
        String mensaje=null;
        Turnopuntoventacaja caja= new Turnopuntoventacaja();
        caja.setId(new TurnopuntoventacajaId(turnoLogica.buscarPorCodigo("N").getId(), 1, 1));            
        deposito.setTurnopuntoventacaja(caja);
        Double dos=Double.parseDouble(monto);
        deposito.setMontototal(dos);
        deposito.setFecharegistro(new Date());
        deposito.setIdtipopago(pago);     
        deposito.setTurno(String.valueOf(turnoLogica.buscarPorCodigo("N").getId()));
        deposito.setCerrado("N");
        this.insertar(deposito);
        imprimircomprobante.imprimirTirada("0001","1", pago,monto, "ROSA MARIA DAVILA");
        return mensaje;
    }  
 }    

