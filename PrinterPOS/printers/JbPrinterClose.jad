// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:44:19 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JbPrinterClose.java

package Zeus.core.printers;

import Zeus.core.Database.*;
import Zeus.core.NodosRemotos.JbNodo;
import Zeus.core.Tools.JExcepcion;
import java.util.Date;

// Referenced classes of package Zeus.core.printers:
//            JbPrinter

public class JbPrinterClose extends JBD
{

    public void setNodo(String s)
        throws Exception
    {
        pNodo.SetValor(s);
    }

    public String getNodo()
        throws Exception
    {
        return pNodo.GetValor();
    }

    public void setPrinterId(long l)
        throws Exception
    {
        pPrinterId.SetValor(l);
    }

    public long getPrinterId()
        throws Exception
    {
        return pPrinterId.GetValor();
    }

    public void setTipoCierre(String s)
        throws Exception
    {
        pTipoCierre.SetValor(s);
    }

    public String getTipoCierre()
        throws Exception
    {
        return pTipoCierre.GetValor();
    }

    public void setId(long l)
        throws Exception
    {
        pId.SetValor(l);
    }

    public long getId()
        throws Exception
    {
        return pId.GetValor();
    }

    public long getNro()
        throws Exception
    {
        return pNro.GetValor();
    }

    public void setFechaHasta(Date date)
        throws Exception
    {
        pFechaHasta.SetValor(date);
    }

    public Date getFechaHasta()
        throws Exception
    {
        return pFechaHasta.GetValor();
    }

    public void setHoraHasta(String s)
        throws Exception
    {
        pHoraHasta.SetValor(s);
    }

    public String getHoraHasta()
        throws Exception
    {
        return pHoraHasta.GetValor();
    }

    public Date getFechaDesde()
        throws Exception
    {
        return pFechaDesde.GetValor();
    }

    public String getHoraDesde()
        throws Exception
    {
        return pHoraDesde.GetValor();
    }

    public long getSecuencia()
        throws Exception
    {
        return pSecuencia.GetValor();
    }

    public JbPrinterClose()
        throws Exception
    {
        pNodo = new JString();
        pPrinterId = new JLong();
        pTipoCierre = new JString();
        pId = new JLong();
        pNro = new JLong();
        pFechaHasta = new JDate();
        pHoraHasta = new JHour();
        pFechaDesde = new JDate();
        pHoraDesde = new JHour();
        pSecuencia = new JLong();
        oPrinter = null;
        oNodo = null;
        pDescrPrinter = new JString() {

            public void Pre()
                throws Exception
            {
                pDescrPrinter.SetValor(obtenerPrinter().getDescrPrinter());
            }

            
                throws Exception
            {
                super();
            }
        };
        oAnteriorCierre = null;
    }

    public void addVarProperties()
        throws Exception
    {
        AddItem("nodo", pNodo);
        AddItem("printer_id", pPrinterId);
        AddItem("tipo_cierre", pTipoCierre);
        AddItem("id", pId);
        AddItem("numero", pNro);
        AddItem("fecha_desde", pFechaDesde);
        AddItem("hora_desde", pHoraDesde);
        AddItem("fecha_hasta", pFechaHasta);
        AddItem("hora_hasta", pHoraHasta);
        AddItem("secuencia", pSecuencia);
        AddItem("descripcion_printer", pDescrPrinter);
    }

    public void AddFixedProperties()
        throws Exception
    {
        AddItemFijo(2, "nodo", "Nodo", true, true, 15);
        AddItemFijo(2, "printer_id", "Printer id", true, true, 18);
        AddItemFijo(2, "tipo_cierre", "Tipo cierre", true, true, 1);
        AddItemFijo(2, "id", "Id", true, true, 18);
        AddItemFijo(1, "numero", "N\372mero", true, false, 5);
        AddItemFijo(1, "fecha_desde", "Fecha desde", true, false, 10);
        AddItemFijo(1, "hora_desde", "Hora desde", true, false, 6);
        AddItemFijo(1, "fecha_hasta", "Fecha hasta", true, true, 10);
        AddItemFijo(1, "hora_hasta", "Hora hasta", true, true, 6);
        AddItemFijo(1, "secuencia", "Secuencia", true, true, 18);
        AddItemFijo(3, "descripcion_printer", "Impresora", true, true, 18);
    }

    public String GetTable()
    {
        return "PRT_CIERRES";
    }

    public boolean Read(String s, long l, String s1, long l1)
        throws Exception
    {
        SetFiltros("nodo", s);
        SetFiltros("printer_id", l);
        SetFiltros("tipo_cierre", s1);
        SetFiltros("id", l1);
        return Read();
    }

    public void ProcesarAlta()
        throws Exception
    {
        calcularID();
        calcularSecuencia();
        calcularFechaDesde();
        calcularFechaHasta();
        calcularNumeroX();
        super.ProcesarAlta();
    }

    private void calcularFechaDesde()
        throws Exception
    {
        if(obtenerAnteriorCierre() != null)
        {
            pHoraDesde.SetValor(obtenerAnteriorCierre().getHoraHasta());
            pFechaDesde.SetValor(JDate.DateTimeToDate(obtenerAnteriorCierre().getFechaHasta(), pHoraDesde));
            pFechaDesde.addSeconds(1);
            pHoraDesde = pFechaDesde.getTime();
            pFechaDesde.stripTime();
        } else
        {
            if(getTipoCierre().equals("X"))
            {
                if(!obtenerPrinter().hasHoraInicioFiscal())
                    JExcepcion.SendError("Cierre X: Falta la hora de inicio fiscal");
                pFechaDesde.SetValor(obtenerPrinter().getFechaInicioFiscal());
                pHoraDesde.SetValor(obtenerPrinter().getHoraInicioFiscal());
            }
            if(getTipoCierre().equals("Z"))
            {
                JbPrinterClose jbprinterclose = new JbPrinterClose();
                jbprinterclose.SetNoExcSelect(true);
                if(!jbprinterclose.Read(getNodo(), getPrinterId(), "X", 1L))
                    JExcepcion.SendError("No se encontr\363 el primer Cierre X necesario para realizar el primer Cierre Z");
                pFechaDesde.SetValor(jbprinterclose.getFechaDesde());
                pHoraDesde.SetValor(jbprinterclose.getHoraDesde());
            }
        }
    }

    private JbPrinterClose obtenerAnteriorCierre()
        throws Exception
    {
        if(oAnteriorCierre != null)
            return oAnteriorCierre;
        JbPrinterClose jbprinterclose = new JbPrinterClose();
        jbprinterclose.SetFiltros("nodo", getNodo());
        jbprinterclose.SetFiltros("printer_id", getPrinterId());
        jbprinterclose.SetFiltros("tipo_cierre", getTipoCierre());
        long l = jbprinterclose.SelectMaxLong("id");
        if(l > 0L)
        {
            oAnteriorCierre = new JbPrinterClose();
            oAnteriorCierre.Read(getNodo(), getPrinterId(), getTipoCierre(), l);
        }
        return oAnteriorCierre;
    }

    private void calcularNumeroX()
        throws Exception
    {
        if(getTipoCierre().equals("Z"))
            return;
        if(getId() == 1L)
        {
            pNro.SetValor(1);
        } else
        {
            JbPrinterClose jbprinterclose = new JbPrinterClose();
            jbprinterclose.SetFiltros("nodo", getNodo());
            jbprinterclose.SetFiltros("printer_id", getPrinterId());
            jbprinterclose.SetFiltros("tipo_cierre", "Z");
            long l = jbprinterclose.SelectMaxLong("id");
            if(l > 0L)
            {
                JbPrinterClose jbprinterclose1 = new JbPrinterClose();
                jbprinterclose1.Read(getNodo(), getPrinterId(), "Z", l);
                if(jbprinterclose1.getSecuencia() > obtenerAnteriorCierre().getSecuencia())
                    pNro.SetValor(1);
                else
                    pNro.SetValor(obtenerAnteriorCierre().getNro() + 1L);
            } else
            {
                pNro.SetValor(obtenerAnteriorCierre().getNro() + 1L);
            }
        }
    }

    private void calcularSecuencia()
        throws Exception
    {
        JbPrinterClose jbprinterclose = new JbPrinterClose();
        jbprinterclose.SetFiltros("nodo", getNodo());
        jbprinterclose.SetFiltros("printer_id", getPrinterId());
        long l = jbprinterclose.SelectMaxLong("secuencia");
        pSecuencia.SetValor(l + 1L);
    }

    private void calcularID()
        throws Exception
    {
        if(obtenerAnteriorCierre() == null)
            setId(1L);
        else
            setId(obtenerAnteriorCierre().getId() + 1L);
    }

    private void calcularFechaHasta()
        throws Exception
    {
        if(getTipoCierre().equals("X"))
        {
            pFechaHasta.SetValor(new Date());
            pHoraHasta.SetValor(JDate.CurrentTime("HH:mm:ss"));
        }
        if(getTipoCierre().equals("Z"))
        {
            JbPrinterClose jbprinterclose = new JbPrinterClose();
            jbprinterclose.SetFiltros("nodo", getNodo());
            jbprinterclose.SetFiltros("printer_id", getPrinterId());
            jbprinterclose.SetFiltros("tipo_cierre", "X");
            long l = jbprinterclose.SelectMaxLong("id");
            if(l == 0L)
                JExcepcion.SendError("No hay Cierres X disponibles para realizar el primer Cierre Z");
            JbPrinterClose jbprinterclose1 = new JbPrinterClose();
            jbprinterclose1.Read(getNodo(), getPrinterId(), "X", l);
            pFechaHasta.SetValor(jbprinterclose1.getFechaHasta());
            pHoraHasta.SetValor(jbprinterclose1.getHoraHasta());
        }
        if(pFechaHasta.GetValor().equals(pFechaDesde.GetValor()))
            if(pHoraDesde.GetValor().compareTo(pHoraHasta.GetValor()) <= 0);
    }

    public JbPrinter obtenerPrinter()
        throws Exception
    {
        if(oPrinter != null)
        {
            return oPrinter;
        } else
        {
            oPrinter = new JbPrinter();
            oPrinter.Read(obtenerNodo().GetPais(), getNodo(), getPrinterId());
            return oPrinter;
        }
    }

    public JbNodo obtenerNodo()
        throws Exception
    {
        if(oNodo != null)
        {
            return oNodo;
        } else
        {
            oNodo = new JbNodo();
            oNodo.Read(getNodo());
            return oNodo;
        }
    }

    private JString pNodo;
    private JLong pPrinterId;
    private JString pTipoCierre;
    private JLong pId;
    private JLong pNro;
    public JDate pFechaHasta;
    public JHour pHoraHasta;
    public JDate pFechaDesde;
    public JHour pHoraDesde;
    private JLong pSecuencia;
    private JbPrinter oPrinter;
    private JbNodo oNodo;
    private JString pDescrPrinter;
    public static final String CIERRE_X = "X";
    public static final String CIERRE_Z = "Z";
    JbPrinterClose oAnteriorCierre;

}