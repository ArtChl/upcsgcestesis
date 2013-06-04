// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 22/05/2013 11:46:34 a.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JwPrinterCloses.java

package Zeus.core.printers;

import Zeus.core.Database.JBDs;
import Zeus.core.Wins.JDefaultLista;
import Zeus.core.Wins.JWins;

public class JwPrinterCloses extends JWins
{

    public JwPrinterCloses()
        throws Exception
    {
    }

    public int GetNroIcono()
        throws Exception
    {
        return 205;
    }

    public String GetTitle()
        throws Exception
    {
        return "Cierre Impresoras";
    }

    public Class GetClassWin()
    {
        return Zeus.core.printers.JwPrinterClose.class;
    }

    public void OnGenerarAcciones()
        throws Exception
    {
    }

    public void ConfigurarColumnasLista(JDefaultLista jdefaultlista)
        throws Exception
    {
        jdefaultlista.AddIcono("");
        jdefaultlista.AddColumnaLista("descripcion_printer");
        jdefaultlista.AddColumnaLista("tipo_cierre");
        jdefaultlista.AddColumnaLista("id");
        jdefaultlista.AddColumnaLista("numero");
        jdefaultlista.AddColumnaLista("fecha_desde");
        jdefaultlista.AddColumnaLista("hora_desde");
        jdefaultlista.AddColumnaLista("fecha_hasta");
        jdefaultlista.AddColumnaLista("hora_hasta");
        jdefaultlista.GetWins().GetDatos().ClearOrderBy();
        jdefaultlista.GetWins().GetDatos().SetOrderBy("secuencia", "DESC");
    }
}