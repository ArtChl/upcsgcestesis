// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:45:36 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JPrinter.java

package Zeus.core.printers;

import Zeus.core.Database.JBD;
import Zeus.core.Database.JBDs;
import Zeus.core.Layout.JFieldInterface;
import Zeus.core.Layout.JbLayout;
import Zeus.core.TerminalCom.JbTerminalCom;
import Zeus.core.Tools.*;
import java.awt.print.PrinterException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

// Referenced classes of package Zeus.core.printers:
//            JbPrinter

public abstract class JPrinter
{

    public static String getID()
    {
        return "";
    }

    public static String getDescrip()
    {
        return getID();
    }

    public void setLayout(JbLayout jblayout)
    {
        setIsLayoutRequired(true);
        oLayout = jblayout;
        if(oLayout != null)
            oLayout.setPrinter(this);
    }

    public void setIsParalelo(boolean flag)
    {
        bParalelo = flag;
    }

    public void setModalidad(String s)
    {
        sModalidad = s;
    }

    public void setFuente(String s)
    {
        sFont = s;
    }

    public void setIsLayoutRequired(boolean flag)
    {
        bIsLayoutRequired = flag;
    }

    public void setFieldInterface(JFieldInterface jfieldinterface)
        throws Exception
    {
        oInterface = jfieldinterface;
        if(oLayout != null)
            oLayout.setFieldInterface(oInterface);
    }

    public JbLayout getLayout()
        throws Exception
    {
        if(oLayout == null)
            JExcepcion.SendError("Comprobante Invalido / no pudo encontrar Layout");
        return oLayout;
    }

    public String getModalidad()
    {
        return sModalidad;
    }

    public String getFuente()
    {
        return sFont;
    }

    public boolean isParalelo()
        throws Exception
    {
        return bParalelo;
    }

    public boolean isDocumentOpen()
        throws Exception
    {
        return isOpen;
    }

    public int getMaxItems()
        throws Exception
    {
        return oLayout != null ? oLayout.getMaxItems() : 0;
    }

    public void setTerminalCom(JbTerminalCom jbterminalcom)
    {
    }

    public long getCurrentNum()
        throws Exception
    {
        return 0L;
    }

    public boolean isLayoutRequired()
        throws Exception
    {
        return bIsLayoutRequired;
    }

    public JBDs getModalidades()
        throws Exception
    {
        JBDs jbds = JBDs.createVirtualBDs();
        jbds.AddItem(JBD.virtualBD("PRINTER_DEFAULT", "Modo Unico", 1));
        return jbds;
    }

    public JBDs getFontType()
        throws Exception
    {
        JBDs jbds = JBDs.createVirtualBDs();
        jbds.AddItem(JBD.virtualBD("PRINTER_DEFAULT", "Fuente Unica", 1));
        return jbds;
    }

    public JPrinter(JbPrinter jbprinter)
        throws Exception
    {
        oPrinterData = jbprinter;
    }

    public static Class getPrinterClass(String s)
        throws Exception
    {
        for(int i = 0; i < impresorasSoportadas.length; i++)
        {
            if(!JTools.isInstalled(impresorasSoportadas[i]))
                continue;
            String s1 = (String)Class.forName(impresorasSoportadas[i]).getMethod("getID", null).invoke(null, new Object[0]);
            if(s1.equals(s))
                return Class.forName(impresorasSoportadas[i]);
        }

        JExcepcion.SendError("No existe Driver para la Impresora " + s);
        return null;
    }

    public static JPrinter VirtualCreate(JbPrinter jbprinter)
        throws Exception
    {
        JPrinter jprinter = (JPrinter)getPrinterClass(jbprinter.getTipo()).getConstructor(new Class[] {
            Zeus.core.printers.JbPrinter.class
        }).newInstance(new Object[] {
            jbprinter
        });
        jprinter.printerType = jbprinter.getTipo();
        return jprinter;
    }

    public void openDocument()
        throws Exception
    {
        if(isOpen)
            JExcepcion.SendError("Ya existe un comprobante abierto");
        bInitializePrintCopies = true;
        openDoc();
        isOpen = true;
    }

    public void cancelDocument()
        throws Exception
    {
        if(!isOpen)
        {
            return;
        } else
        {
            cancelDoc();
            isOpen = false;
            return;
        }
    }

    public void closeDocument()
        throws Exception
    {
        if(!isOpen)
        {
            return;
        } else
        {
            closeDoc();
            isOpen = false;
            printCopies();
            oInterface = null;
            return;
        }
    }

    protected void printCopies()
        throws Exception
    {
        if(oLayout == null)
            return;
        int i = oLayout.getCopias();
        int j = 1;
        do
        {
            if(j > i)
                break;
            try
            {
                openDoc();
                isOpen = true;
                getLayout().printCopy(j, linesToSkip);
                flush();
                closeDoc();
                isOpen = false;
            }
            catch(Exception exception)
            {
                isOpen = false;
                JDebugPrint.logError("Error imprimiendo Copias. " + exception.getMessage());
                break;
            }
            j++;
        } while(true);
        linesToSkip = 0;
    }

    public void print(String s, Object obj)
        throws Exception
    {
        if(!isLayoutRequired())
            return;
        if(bInitializePrintCopies)
        {
            bInitializePrintCopies = false;
            getLayout().inicializePrintCopies();
        }
        getLayout().print(s, obj);
    }

    public static JBDs ObtenerImpresorasWindows()
        throws Exception
    {
        PrintService aprintservice[] = PrintServiceLookup.lookupPrintServices(null, null);
        JBDs jbds = JBDs.createVirtualBDs();
        for(int i = 0; i < aprintservice.length; i++)
        {
            PrintService printservice = aprintservice[i];
            jbds.AddItem(JBD.virtualBD(printservice.getName(), printservice.getName(), 1));
        }

        return jbds;
    }

    public static PrintService ObtenerImpresoraWindows(String s)
        throws PrinterException
    {
        PrintService aprintservice[] = PrintServiceLookup.lookupPrintServices(null, null);
        for(int i = 0; i < aprintservice.length; i++)
        {
            PrintService printservice = aprintservice[i];
            JDebugPrint.logError("Impresora encontrada: " + printservice.getName());
            if(printservice.getName().equals(s))
                return printservice;
        }

        JDebugPrint.logError("No se encuentra la impresora " + s);
        return null;
    }

    public void printCardVoucher(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public void startTicket(String s, Object obj)
        throws Exception
    {
        if(isLayoutRequired() && getLayout() != null)
            getLayout().setFieldInterface(oInterface);
        print(s, obj);
    }

    public void printItemTicket(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public void cancelItemTicket(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public void finishTicket(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public void printPay(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public void printPayHeader(String s, Object obj)
        throws Exception
    {
        print(s, obj);
    }

    public abstract void open()
        throws Exception;

    public abstract void close()
        throws Exception;

    public abstract void closeShift()
        throws Exception;

    public abstract void closeDay()
        throws Exception;

    public abstract void newLine()
        throws Exception;

    public abstract void printLine(String s)
        throws Exception;

    protected abstract void openDoc()
        throws Exception;

    protected abstract void cancelDoc()
        throws Exception;

    protected abstract void closeDoc()
        throws Exception;

    public void flush()
        throws Exception
    {
    }

    public void skipLines(int i)
        throws Exception
    {
    }

    public boolean isFiscalPrinter()
    {
        return false;
    }

    public void setPos(Object obj)
    {
    }

    public void setObjDocumentType(Object obj)
    {
    }

    public boolean hasMontoMaximo(String s)
        throws Exception
    {
        return getMontoMaximo(s) != 0.0D;
    }

    public double getMontoMaximo(String s)
        throws Exception
    {
        return 0.0D;
    }

    public boolean isNumeracionUtilizada()
        throws Exception
    {
        return false;
    }

    public boolean reservePrinter(Object obj)
        throws Exception
    {
        HashMap hashmap = oReservedHash;
        JVM INSTR monitorenter ;
        Object obj1;
        JDebugPrint.logDebug("Printer Synchronized -> Attach " + oPrinterData.getPuerto());
        obj1 = oReservedHash.get(oPrinterData.getPuerto());
        if(obj1 != null && !obj.equals(obj1))
            return false;
        oReservedHash.put(oPrinterData.getPuerto(), obj);
        true;
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean releasePrinter(Object obj)
        throws Exception
    {
        HashMap hashmap = oReservedHash;
        JVM INSTR monitorenter ;
        JDebugPrint.logDebug("Printer Synchronized -> Release " + oPrinterData.getPuerto());
        Object obj1 = oReservedHash.get(oPrinterData.getPuerto());
        if(!obj.equals(obj1))
            break MISSING_BLOCK_LABEL_74;
        oReservedHash.remove(oPrinterData.getPuerto());
        return true;
        false;
        hashmap;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean ImprimeFecha()
        throws Exception
    {
        return false;
    }

    public boolean reservePrinter(Object obj, boolean flag)
        throws Exception
    {
        boolean flag1 = reservePrinter(obj);
        if(!flag1 && flag)
            JExcepcion.SendError("La impresora est\341 en uso, reintente m\341s tarde");
        return flag1;
    }

    public boolean printerPrintDate()
        throws Exception
    {
        return false;
    }

    protected boolean bParalelo;
    protected JbLayout oLayout;
    protected JFieldInterface oInterface;
    protected boolean bConnected;
    protected boolean canRePrint;
    protected boolean isOpen;
    protected String printerType;
    protected String documentType;
    protected boolean bInitializePrintCopies;
    private String sModalidad;
    private String sFont;
    protected int linesToSkip;
    private boolean bIsLayoutRequired;
    protected JbPrinter oPrinterData;
    public static final String impresorasSoportadas[] = {
        "Zeus.core.printers.Axiohm.JAxiohmDH4700", "Zeus.core.printers.epson950.JEpson950", "Zeus.core.printers.epson200.JEpson200", "Zeus.core.printers.okidata320.JOkidata320", "Zeus.core.printers.starSP.starSP320.JStarSP320", "Zeus.core.printers.starSP.starSP2000.JStarSP2000", "Zeus.core.printers.DirectParallelPrinter.JDirectParallelPrinter", "Zeus.core.printers.ParallelPrinter.JParallelPrinter", "Zeus.core.printers.SerialPrinter.JSerialPrinter", "Zeus.core.printers.TerminalPrinter.elite.JElite", 
        "Zeus.core.printers.TerminalPrinter.verifone250.JVerifone250", "Zeus.core.printers.TerminalPrinter.verifone3750.JVerifone3750", "Zeus.core.printers.TerminalPrinter.ingenico5100.JIngenico5100", "Zeus.core.printers.TerminalPrinter.intellectPresto.JIntellectPresto", "Zeus.core.printers.WindowsPrinter.JWindowsPrinter", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.EpsonT285F.JEpsonT285F", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.EpsonLX300F.JEpsonLX300F", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.EpsonFX880.JEpsonFX880", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.EpsonU950F.JEpsonU950F", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.Epson2000AF.JEpson2000AF", 
        "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.Epson2000AFP.JEpson2000AFP", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.Epson2002AFP.JEpson2002AFP", "Zeus.Retail.fiscalPrinters.Argentina.EpsonSerial.EpsonTMU220A.JEpsonTMU220A", "Zeus.Retail.fiscalPrinters.Chile.EpsonT88III.JEpsonT88III", "Zeus.Retail.fiscalPrinters.Argentina.Hasar.Hasar615F.JHasar615F", "Zeus.Retail.fiscalPrinters.Argentina.Hasar.Hasar320F.JHasar320F"
    };
    public static final String PRINTER_DEFAULT = "PRINTER_DEFAULT";
    private static HashMap oReservedHash = new HashMap();

}