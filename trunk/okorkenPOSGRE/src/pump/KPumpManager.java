// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:29:44 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KPumpManager.javaadsasasas

package pump;

import core.KLogManager;
import java.io.PrintStream;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import pos.KLicense;
import pos.KPosManager;

// Referenced classes of package pump:
//            KPumpMessenger, KDispatch, KgPrice

public class KPumpManager
{

    public KPumpManager()
    {
    }

    public static void main(String args[])
    {
        Thread thread = new Thread(new Runnable() {

            public void run()
            {
                KPumpManager.startProcess();
            }

        }
);
        thread.start();
    }

    public static void stopProcess(String as[])
        throws Exception
    {
        oneMoreTime = false;
        oThread.interrupt();
    }

    public static void startProcess()
    {
        KPumpMessenger pumpMessenger = null;
        KPosManager posManager = null;
        try
        {
            KLogManager.logDebug("Trying to start interface...");
           // verifyLicense();
            oThread = Thread.currentThread();
            oThread.setName("Korken Interface");
            pumpMessenger = new KPumpMessenger();
            posManager = new KPosManager();
            KLogManager.logDebug("Interface has been started.");
        }
        catch(Exception e)
        {
            KLogManager.logDebug("ERROR: I coud not start the interface process.");
            KLogManager.logDebug(e.getMessage());
            e.printStackTrace();
            oneMoreTime = false;
            oThread.interrupt();
        }
        try
        {
            while(oneMoreTime) 
                try
                {
                    exportDispatches(pumpMessenger, posManager);
                }
                catch(Exception e)
                {
                    Thread.sleep(1000L);
                }
        }
        catch(Exception e)
        {
            KLogManager.logDebug("Interface has been stopped.");
            KLogManager.logDebug(e.getMessage());
        }
    }

 /*   private static void verifyLicense()
        throws Exception
    {
        try
        {
            KLicense.verify();
        }
        catch(Exception e)
        {
            throw new Exception("License error.");
        }
    }*/

    public static void exportDispatches(KPumpMessenger pumpMessenger, KPosManager posManager)
        throws Exception
    {
        while(oneMoreTime) 
        {
            try
            {
                Element dispatches = pumpMessenger.getPendingDispatches();
                if(dispatches != null)
                {
                    Element results = (Element)dispatches.getElementsByTagName("selected_sales_res").item(0);
                    NodeList nodelist = results.getElementsByTagName("sale");
                    int cantidad = nodelist.getLength();
                    for(int j = 0; j < cantidad; j++)
                    {
                        KDispatch dispatch = new KDispatch((Element)nodelist.item(j));
                        if(posManager.registerSale(dispatch))
                        {
                            if(!pumpMessenger.payDispatch(dispatch))
                            {
                                oneMoreTime = false;
                                KLogManager.logDebug("ERROR: Sale_id=" + dispatch.getSaleId() + " could not be paid.");
                            } else
                            {
                                KLogManager.logDebug("Sale_id=" + dispatch.getSaleId() + " was paid successfully.");
                            }
                        } else
                        {
                            KLogManager.logDebug("sale_id=" + dispatch.getSaleId() + " could not be inserted in T_DESPACHO Local table.");
                        }
                    }

                } else
                {
                    KLogManager.logDebug("ERROR: I got 'null' when retrieving pending dispatches.");
                }
            }
            catch(Exception e)
            {
                throw new Exception("ERROR: ExportDispatches loop has encountered an error and will stand by.");
            }
            String pricelist[][] = posManager.getPriceChange();
            String pricelistx[] = pricelist[0];
            String pricelisty[] = pricelist[1];
            if(pricelistx[0] != null)
            {
                KLogManager.logDebug("Change Price Detected : ");
                Element prices = pumpMessenger.getPriceList();
                Element results = (Element)prices.getElementsByTagName("res_prices").item(0);
                NodeList nodelist = results.getElementsByTagName("grade");
                String idp = "";
                String pn1 = "";
                String lid[] = new String[30];
                String lprice[] = new String[30];
                int cantidad = nodelist.getLength();
                for(int p = 0; p < pricelistx.length; p++)
                {
                    idp = pricelistx[p];
                    pn1 = pricelisty[p];
                    for(int j = 0; j < cantidad; j++)
                    {
                        KgPrice price = new KgPrice((Element)nodelist.item(j));
                        Element price2 = (Element)nodelist.item(j);
                        String s1 = price2.getAttribute("id");
                        NodeList nodelist1 = price2.getElementsByTagName("level");
                        int k = nodelist1.getLength();
                        Element element3 = (Element)nodelist1.item(0);
                        String id = price2.getAttribute("id");
                        String ppu = element3.getAttribute("ppu");
                        idp = idp.trim();
                        if(idp.equals(id.trim()))
                        {
                            lid[j] = idp;
                            lprice[j] = pn1;
                        } else
                        {
                            lid[j] = id;
                            lprice[j] = ppu;
                        }
                    }

                    pumpMessenger.sendPrice(lid, lprice);
                    posManager.updateStatusPCh("S", pricelistx);
                }

            }
            String arrayShiftT[][] = posManager.getCloseT();
            String arrayShiftzT[] = arrayShiftT[0];
            String resultdayT = "";
            String statusshiftT = "";
            if(arrayShiftzT[0] != null)
            {
                KLogManager.logDebug("Close Shift Detected ");
                Element resultshift = pumpMessenger.closeShiftGyN();
                Element resultsh = (Element)resultshift.getElementsByTagName("res_period_close").item(0);
                statusshiftT = resultsh.getAttribute("status");
                System.out.println("status cierre " + statusshiftT);
                if(statusshiftT.equals("ok"))
                {
                    System.out.println("entro al ok " + arrayShiftzT[0]);
                    ArrayList totalizers = pumpMessenger.getTotalizers();
                    System.out.println("Paso getTotal");
                    int lista = totalizers.size();
                    for(int i = 0; i < lista; i++)
                    {
                        Element totalizersele = (Element)totalizers.get(i);
                        Element results = (Element)totalizersele.getElementsByTagName("pump_information_res").item(0);
                        NodeList nodelist = results.getElementsByTagName("data");
                        Element data = (Element)nodelist.item(0);
                        NodeList hoselist = results.getElementsByTagName("hose");
                        int cantidad = hoselist.getLength();
                        String hose = "";
                        String electronic_amount = "";
                        String electronic_volume = "";
                        String ppu = "";
                        String id_cem = "";
                        for(int j = 0; j < cantidad; j++)
                        {
                            Element tota = (Element)hoselist.item(j);
                            String prueba = tota.getAttribute("price_level");
                            hose = tota.getAttribute("id");
                            electronic_amount = tota.getAttribute("electronic_amount");
                            electronic_volume = tota.getAttribute("electronic_volume");
                            ppu = tota.getAttribute("ppu");
                            System.out.println("Antes de Pricelist");
                            Element prices = pumpMessenger.getPriceList();
                            System.out.println("Paso Pricelist");
                            Element resultsp = (Element)prices.getElementsByTagName("res_prices").item(0);
                            NodeList nodelistp = resultsp.getElementsByTagName("grade");
                            System.out.println("Cantidad de Nodos " + nodelistp.getLength());
                            for(int p = 0; p < nodelistp.getLength(); p++)
                            {
                                Element element3 = (Element)nodelistp.item(p);
                                String id = element3.getAttribute("id");
                                NodeList nodelist1 = element3.getElementsByTagName("level");
                                Element price = (Element)nodelist1.item(0);
                                String sppu = price.getAttribute("ppu");
                                if(ppu.equals(sppu))
                                    id_cem = id;
                            }

                            String fecha = arrayShiftzT[0];
                            String id_surtidor = String.valueOf(i + 1);
                            posManager.updateTotalizers(hose, electronic_amount, electronic_volume, id_surtidor, id_cem, fecha);
                        }

                    }

                    posManager.updateStatusCloseD();
                }
                if(statusshiftT.equals("no data"))
                {
                    posManager.updateStatusCloseT();
                    KLogManager.logDebug("Close Shift without data ");
                }
            }
            Thread.sleep(3000L);
            
            String arrayShift[][] = posManager.getCloseD();
            String arrayShiftz[] = arrayShift[0];
            String resultday = "";
            String statusshift = "";
            if(arrayShiftz[0] != null)
            {
                KLogManager.logDebug("Close Day Detected ");
                Element resultshift = pumpMessenger.closeDay();
                Element resultsh = (Element)resultshift.getElementsByTagName("res_period_close").item(0);
                statusshift = resultsh.getAttribute("status");
                System.out.println("status cierre " + statusshift);
                System.out.println("fecha " + arrayShiftz[0]);
                if(statusshift.equals("ok"))
                {
                    System.out.println("entro al ok " + arrayShiftz[0]);
                    ArrayList totalizers = pumpMessenger.getTotalizers();
                    System.out.println("Paso getTotal");
                    int lista = totalizers.size();
                    for(int i = 0; i < lista; i++)
                    {
                        Element totalizersele = (Element)totalizers.get(i);
                        Element results = (Element)totalizersele.getElementsByTagName("pump_information_res").item(0);
                        NodeList nodelist = results.getElementsByTagName("data");
                        Element data = (Element)nodelist.item(0);
                        NodeList hoselist = results.getElementsByTagName("hose");
                        int cantidad = hoselist.getLength();
                        String hose = "";
                        String electronic_amount = "";
                        String electronic_volume = "";
                        String ppu = "";
                        String id_cem = "";
                        for(int j = 0; j < cantidad; j++)
                        {
                            Element tota = (Element)hoselist.item(j);
                            String prueba = tota.getAttribute("price_level");
                            hose = tota.getAttribute("id");
                            electronic_amount = tota.getAttribute("electronic_amount");
                            electronic_volume = tota.getAttribute("electronic_volume");
                            ppu = tota.getAttribute("ppu");
                            System.out.println("Antes de Pricelist");
                            Element prices = pumpMessenger.getPriceList();
                            System.out.println("Paso Pricelist");
                            Element resultsp = (Element)prices.getElementsByTagName("res_prices").item(0);
                            NodeList nodelistp = resultsp.getElementsByTagName("grade");
                            System.out.println("Cantidad de Nodos " + nodelistp.getLength());
                            for(int p = 0; p < nodelistp.getLength(); p++)
                            {
                                Element element3 = (Element)nodelistp.item(p);
                                String id = element3.getAttribute("id");
                                NodeList nodelist1 = element3.getElementsByTagName("level");
                                Element price = (Element)nodelist1.item(0);
                                String sppu = price.getAttribute("ppu");
                                if(ppu.equals(sppu))
                                    id_cem = id;
                            }

                            String fecha = arrayShiftz[0];
                            String id_surtidor = String.valueOf(i + 1);
                            posManager.updateTotalizers(hose, electronic_amount, electronic_volume, id_surtidor, id_cem, fecha);
                        }

                    }

                    posManager.updateStatusCloseD();
                }
                if(statusshiftT.equals("ok"))
                {
                    posManager.updateStatusCloseD();
                    KLogManager.logDebug("Close Shift Succeed ");
                }
                if(statusshiftT.equals("no data"))
                {
                    posManager.updateStatusCloseD();
                    KLogManager.logDebug("Close Shift without data ");
                }
                System.out.println("salio del ok  " + arrayShiftz[0]);
                if(statusshift.equals("no data"))
                {
                    System.out.println("entro al no data  " + arrayShiftz[0]);
                    posManager.updateStatusCloseD();
                    KLogManager.logDebug("Close Shift without data ");
                }
                System.out.println("salio del no data  " + arrayShiftz[0]);
            }
            Thread.sleep(1000L);
        }
        KLogManager.logDebug("ExportDispatches loop has been set to end.");
    }

    static Thread oThread;
    static boolean oneMoreTime = true;

}
