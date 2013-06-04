// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:43:41 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JbPrinter.java

package Zeus.core.printers;

import Zeus.core.Database.*;
import Zeus.core.Tools.JExcepcion;
import Zeus.core.Tools.JTools;
import java.lang.reflect.Method;
import java.util.Date;

// Referenced classes of package Zeus.core.printers:
//            JPrinter

public class JbPrinter extends JBD
{

    public void setNombreEquipo(String s)
        throws Exception
    {
        pNombreEquipo.SetValor(s);
    }

    public String getNombreEquipo()
        throws Exception
    {
        return pNombreEquipo.GetValor();
    }

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

    public void setTipo(String s)
        throws Exception
    {
        pTipo.SetValor(s);
    }

    public String getTipo()
        throws Exception
    {
        return pTipo.GetValor();
    }

    public void setPuerto(String s)
        throws Exception
    {
        pPuerto.SetValor(s);
    }

    public String getPuerto()
        throws Exception
    {
        return pPuerto.GetValor();
    }

    public void setBaudios(long l)
        throws Exception
    {
        pBaudios.SetValor(l);
    }

    public int getBaudios()
        throws Exception
    {
        return (int)pBaudios.GetValor();
    }

    public void setTieneRollo(boolean flag)
        throws Exception
    {
        pTieneRollo.SetValor(flag);
    }

    public boolean getTieneRollo()
        throws Exception
    {
        return pTieneRollo.GetValor();
    }

    public void setCashDrawer(String s)
        throws Exception
    {
        pCashDrawer.SetValor(s);
    }

    public String getCashDrawer()
        throws Exception
    {
        return pCashDrawer.GetValor();
    }

    public void setNroRollo(String s)
        throws Exception
    {
        pNroRollo.SetValor(s);
    }

    public String getNroRollo()
        throws Exception
    {
        return pNroRollo.GetValor();
    }

    public String getDescrPrinter()
        throws Exception
    {
        return pDescrPrinter.GetValor();
    }

    public String getNroSerie()
        throws Exception
    {
        return pNroSerie.GetValor();
    }

    public boolean isCierreInformeParticular()
        throws Exception
    {
        return pCierreInformeParticular.GetValor();
    }

    public Date getFechaInicioFiscal()
        throws Exception
    {
        return pFechaInicioFiscal.GetValor();
    }

    public String getHoraInicioFiscal()
        throws Exception
    {
        return pHoraInicioFiscal.GetValor();
    }

    public String getPais()
        throws Exception
    {
        return pPais.GetValor();
    }

    public boolean hasHoraInicioFiscal()
        throws Exception
    {
        return pHoraInicioFiscal.GetValorOrig() != null;
    }

    public JbPrinter()
        throws Exception
    {
        pPais = new JString();
        pNodo = new JString();
        pPrinterId = new JLong();
        pDescrip = new JString();
        pTipo = new JString();
        pPuerto = new JString();
        pNombreEquipo = new JString();
        pBaudios = new JLong();
        pTieneRollo = new JBoolean();
        pCashDrawer = new JString();
        pNroRollo = new JString();
        pNroSerie = new JString();
        pDescrPrinter = new JString() {

            public void Pre()
                throws Exception
            {
                pDescrPrinter.SetValor(pDescrip.GetValor() + " - " + pTipo.GetValor());
            }

            
                throws Exception
            {
                super();
            }
        };
        pCierreInformeParticular = new JBoolean();
        pFechaInicioFiscal = new JDate();
        pHoraInicioFiscal = new JHour();
        oPrinter = null;
    }

    public void addVarProperties()
        throws Exception
    {
        AddItem("pais", pPais);
        AddItem("nodo", pNodo);
        AddItem("printer_id", pPrinterId);
        AddItem("descripcion", pDescrip);
        AddItem("tipo", pTipo);
        AddItem("puerto", pPuerto);
        AddItem("baudios", pBaudios);
        AddItem("tiene_rollo", pTieneRollo);
        AddItem("cash_drawer", pCashDrawer);
        AddItem("nro_rollo", pNroRollo);
        AddItem("nro_serie", pNroSerie);
        AddItem("descr_printer", pDescrPrinter);
        AddItem("cierre_informe_particular", pCierreInformeParticular);
        AddItem("fecha_inicio_fiscal", pFechaInicioFiscal);
        AddItem("hora_inicio_fiscal", pHoraInicioFiscal);
    }

    public void AddFixedProperties()
        throws Exception
    {
        AddItemFijo(2, "pais", "Pais", true, true, 15);
        AddItemFijo(2, "nodo", "Nodo", true, true, 15);
        AddItemFijo(2, "printer_id", "Printer id", true, true, 18);
        AddItemFijo(1, "descripcion", "Descripci\363n", true, true, 60);
        AddItemFijo(1, "tipo", "Tipo", true, true, 30);
        AddItemFijo(1, "puerto", "Puerto", true, false, 15, 0);
        AddItemFijo(1, "baudios", "Baudios", true, false, 5);
        AddItemFijo(1, "tiene_rollo", "Tiene rollo", true, true, 1);
        AddItemFijo(1, "nro_rollo", "Nro rollo", true, false, 20);
        AddItemFijo(1, "nro_serie", "Nro Serie", true, false, 30);
        AddItemFijo(1, "cash_drawer", "Cajon de Dinero", true, true, 1, 0, null, "N");
        AddItemFijo(3, "descr_printer", "Printer", true, true, 30);
        AddItemFijo(1, "cierre_informe_particular", "Cierre Informe Particular", true, false, 1, 0, null, "N");
        AddItemFijo(1, "fecha_inicio_fiscal", "Fecha Inicio Fiscal", true, false, 10);
        AddItemFijo(1, "hora_inicio_fiscal", "Hora Inicio Fiscal", true, false, 10);
    }

    public String GetTable()
    {
        return "PRT_PRINTER";
    }

    public boolean Read(String s, String s1, long l)
        throws Exception
    {
        SetFiltros("pais", s);
        SetFiltros("nodo", s1);
        SetFiltros("printer_id", l);
        return Read();
    }

    public void ProcesarAlta()
        throws Exception
    {
        JbPrinter jbprinter = new JbPrinter();
        jbprinter.SetFiltros("pais", pPais.GetValor());
        jbprinter.SetFiltros("nodo", pNodo.GetValor());
        pPrinterId.SetValor(jbprinter.SelectMaxLong("printer_id") + 1L);
        InsertarRegistro();
    }

    public void ProcesarDelete()
        throws Exception
    {
        if(JBDs.existsComplete("Zeus.Retail.Pos.JbPosImpresora", "nodo", pNodo.GetValor(), "printer_id", pPrinterId.GetValor()))
            JExcepcion.SendError("No se puede eliminar esta impresora porque est\341 asociada a un POS.");
        if(JBDs.existsComplete(Zeus.core.printers.JbPrinterClose.class, "nodo", pNodo.GetValor(), "printer_id", pPrinterId.GetValor()))
            JExcepcion.SendError("No se puede eliminar esta impresora porque se efectuaron cierres X y/o cierres Z.");
        super.ProcesarDelete();
    }

    public void ValidarConstraints()
        throws Exception
    {
        if(pNroRollo.IsNull())
            pNroRollo.SetValor("0");
        if(pTieneRollo.GetValor())
        {
            if(pNroRollo.GetValor().equals("0"))
                JExcepcion.SendError("Debe ingresar el Nro. de Rollo");
            JBDs jbds = new JBDs(Zeus.core.printers.JbPrinter.class);
            jbds.SetFiltros("nodo", getNodo());
            jbds.SetFiltros("nro_rollo", getNroRollo());
            jbds.SetFiltros("printer_id", getPrinterId(), "<>");
            if(jbds.exists())
                JExcepcion.SendError("El Rollo est\341 en uso por otra impresora");
        }
        if(!pTipo.GetValor().equals("Windows Default") && !pTipo.GetValor().equals("Parallel") && (getBaudios() == 0 || getPuerto().equals("")))
            JExcepcion.SendError("Debe ingresar valores para los campos baudios y puerto.");
    }

    public boolean isTieneRollo()
        throws Exception
    {
        return pTieneRollo.GetValor();
    }

    public boolean hasCashDrawer()
        throws Exception
    {
        return !pCashDrawer.GetValor().equals("N");
    }

    public boolean hasSensor()
        throws Exception
    {
        return hasSensorAbierto() || hasSensorCerrado();
    }

    public boolean hasSensorAbierto()
        throws Exception
    {
        return pCashDrawer.GetValor().equals("A");
    }

    public boolean hasSensorCerrado()
        throws Exception
    {
        return pCashDrawer.GetValor().equals("C");
    }

    public JPrinter getPrinterPointer()
        throws Exception
    {
        if(oPrinter != null)
        {
            return oPrinter;
        } else
        {
            oPrinter = JPrinter.VirtualCreate(this);
            return oPrinter;
        }
    }

    public void setPrinterPointer(JPrinter jprinter)
    {
        oPrinter = jprinter;
    }

    public static JBDs getTipoImpresoras()
        throws Exception
    {
        JBDs jbds = JBDs.createVirtualBDs();
        for(int i = 0; i < JPrinter.impresorasSoportadas.length; i++)
            if(JTools.isInstalled(JPrinter.impresorasSoportadas[i]))
            {
                Class class1 = Class.forName(JPrinter.impresorasSoportadas[i]);
                String s = (String)class1.getMethod("getID", null).invoke(null, new Object[0]);
                String s1 = (String)class1.getMethod("getDescrip", null).invoke(null, new Object[0]);
                jbds.AddItem(JBD.virtualBD(s, s1, 555));
            }

        return jbds;
    }

    public static JBDs getTipoImpresorasFiscales()
        throws Exception
    {
        JBDs jbds = JBDs.createVirtualBDs();
        for(int i = 0; i < JPrinter.impresorasSoportadas.length; i++)
            if(JTools.isInstalled(JPrinter.impresorasSoportadas[i]) && JPrinter.impresorasSoportadas[i].startsWith("Zeus.Retail.fiscalPrinters"))
            {
                Class class1 = Class.forName(JPrinter.impresorasSoportadas[i]);
                String s = (String)class1.getMethod("getID", null).invoke(null, new Object[0]);
                String s1 = (String)class1.getMethod("getDescrip", null).invoke(null, new Object[0]);
                jbds.AddItem(JBD.virtualBD(s, s1, 555));
            }

        return jbds;
    }

    public static final String SIN_CAJON = "N";
    public static final String SIN_SENSOR = "S";
    public static final String SENSOR_APERTURA = "A";
    public static final String SENSOR_CIERRE = "C";
    private JString pPais;
    private JString pNodo;
    private JLong pPrinterId;
    private JString pDescrip;
    private JString pTipo;
    private JString pPuerto;
    private JString pNombreEquipo;
    private JLong pBaudios;
    private JBoolean pTieneRollo;
    private JString pCashDrawer;
    private JString pNroRollo;
    private JString pNroSerie;
    private JString pDescrPrinter;
    private JBoolean pCierreInformeParticular;
    JDate pFechaInicioFiscal;
    JHour pHoraInicioFiscal;
    private JPrinter oPrinter;



}