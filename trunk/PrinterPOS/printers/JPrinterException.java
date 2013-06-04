// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:45:48 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JPrinterException.java

package Zeus.core.printers;

import Zeus.core.Tools.JExcepcion;

public class JPrinterException extends JExcepcion
{

    public JPrinterException()
    {
        super("Error de Impresora");
    }

    public JPrinterException(String s)
    {
        super(s);
    }

    public static void SendError(String s)
        throws JPrinterException
    {
        throw new JPrinterException(s);
    }
}