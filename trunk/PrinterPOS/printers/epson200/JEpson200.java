// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:48:07 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JEpson200.java

package Zeus.core.printers.epson200;

import Zeus.core.Conectividad.Client.Serial.JSerialClient;
import Zeus.core.TerminalCom.CashBox.JCashDrawer;
import Zeus.core.Tools.JExcepcion;
import Zeus.core.Tools.JTools;
import Zeus.core.printers.JPrinter;
import Zeus.core.printers.JbPrinter;

public class JEpson200 extends JPrinter
    implements JCashDrawer
{

    public static String getID()
    {
        return "Epson 200";
    }

    public static String getDescrip()
    {
        return getID();
    }

    public JEpson200(JbPrinter jbprinter)
        throws Exception
    {
        super(jbprinter);
    }

    public void open()
        throws Exception
    {
        oSerial.setPort(oPrinterData.getPuerto());
        oSerial.setBauds(oPrinterData.getBaudios());
        oSerial.setDataBits(8);
        oSerial.setParity("NONE");
        oSerial.setStopBit(1);
        boolean flag = oSerial.connect();
        if(!flag)
            JExcepcion.SendError("No se pudo abrir el Puerto: " + oPrinterData.getPuerto());
    }

    public void printLine(String s)
        throws Exception
    {
        oSerial.write(JTools.getBytesAscii(s));
        oSerial.write("\n");
        Thread.sleep(200L);
    }

    protected void openDoc()
        throws Exception
    {
        linesToSkip = 0;
    }

    protected void cancelDoc()
        throws Exception
    {
        newLine(3);
        Thread.sleep(300L);
        printLine("** COMPROBANTE ANULADO POR EL USUARIO **");
        newLine(5);
        oSerial.write(CUT_TICKET);
    }

    protected void closeDoc()
        throws Exception
    {
        oSerial.write(CUT_TICKET);
    }

    public void openCashDrawer()
    {
        oSerial.write(OPEN_CASH);
    }

    public boolean isCashOpen()
    {
        return false;
    }

    public void printCardVoucher(Object obj)
        throws Exception
    {
        print("REPORT_HEADER", obj);
    }

    public void closeDay()
        throws Exception
    {
    }

    public void closeShift()
        throws Exception
    {
    }

    public void close()
        throws Exception
    {
        if(oSerial != null)
            oSerial.disconnect();
    }

    public void newLine()
        throws Exception
    {
        printLine("");
    }

    private void newLine(int i)
        throws Exception
    {
        for(int j = 0; j < i; j++)
            printLine("");

    }

    private final JSerialClient oSerial = new JSerialClient();
    private static final String START = String.valueOf('\033') + String.valueOf('c') + String.valueOf('0');
    private static final String CUT_TICKET = START + String.valueOf('\003') + String.valueOf('\033') + String.valueOf('d') + String.valueOf('\f') + String.valueOf('\033') + String.valueOf('c') + String.valueOf('\003') + String.valueOf('\033') + String.valueOf('i');
    private static final String RETURN_CAR = "\n";
    private static final String OPEN_CASH = String.valueOf('\033') + String.valueOf('p') + String.valueOf('\0') + String.valueOf('\001') + String.valueOf('\002');

}