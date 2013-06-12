// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:29:58 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KPumpMessenger.java

package pump;

import core.KCharLiteral;
import core.KLogManager;
import core.factory.KDataFormatter;
import core.factory.KElementFactory;
import java.io.*;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package pump:
//            MySocket, KDispatch

public class KPumpMessenger
{

    public KPumpMessenger()
    {
        socket = null;
        socket = new MySocket();
    }

    private String getOpeningMessageTag()
    {
        return "<" + KCharLiteral.r + KCharLiteral.o + KCharLiteral.o + KCharLiteral.t + ">";
    }

    private String getClosingMessageTag()
    {
        return "</" + KCharLiteral.r + KCharLiteral.o + KCharLiteral.o + KCharLiteral.t + ">";
    }

    public Element getPendingDispatches()
        throws Exception
    {
        Element element = null;
        String message = null;
        try
        {
            message = "<cem action=\"14\" filter=\"//sale[@invoiced='NO']\" sales=\"5\" />";
            element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            String respuesta = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
            System.out.println("Captura de mensaje " + respuesta);
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
        return element;
    }

    public boolean payDispatch(KDispatch dispatch)
    {
        boolean ok = false;
        String message = null;
        try
        {
            message = "<sale action=\"13\" sale_id=\"" + dispatch.getSaleId() + "\" new_status=\"44\" old_status=\"" + dispatch.getStatus() + "\" reference=\"\" />";
            Element element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            String response = ((Element)element.getElementsByTagName("pay_sale_res").item(0)).getAttribute("result");
            if(response.equals("OK"))
                ok = true;
            else
                KLogManager.logDebug("Error when CEM was asked: " + response);
        }
        catch(Exception e)
        {
            KLogManager.logDebug("Error when CEM was asked: " + message);
        }
        return ok;
    }

    public String closeShift()
        throws Exception
    {
        String message = null;
        try
        {
            message = "<cem action=\"17\" period=\"shift\"/>";
            Element element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            return sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
    }

    public Element closeShiftGyN()
        throws Exception
    {
        String message = null;
        try
        {
            message = "<cem action=\"17\" period=\"shift\"/>";
            Element element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            return element;
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
    }

    public Element closeDay()
        throws Exception
    {
        String message = null;
        try
        {
            message = "<cem action=\"17\" period=\"day\"/>";
            Element element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            return element;
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
    }

    public String sendPrice(String id[], String p[])
        throws Exception
    {
        String message = null;
        String idp[] = id;
        String pp[] = p;
        String request = "";
        try
        {
            message = "<cem action=\"26\" date=\"20070214\" time=\"2030\"><grade id=\"" + idp[0] + "\"><level id=\"1\" ppu=\"" + pp[0] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[1] + "\"><level id=\"1\" ppu=\"" + pp[1] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[2] + "\"><level id=\"1\" ppu=\"" + pp[2] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[3] + "\"><level id=\"1\" ppu=\"" + pp[3] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[4] + "\"><level id=\"1\" ppu=\"" + pp[4] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[5] + "\"><level id=\"1\" ppu=\"" + pp[5] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[6] + "\"><level id=\"1\" ppu=\"" + pp[6] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[7] + "\"><level id=\"1\" ppu=\"" + pp[7] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade><grade id=\"" + idp[8] + "\"><level id=\"1\" ppu=\"" + pp[8] + "\" /><level id=\"2\" ppu=\"0.0\" /><level id=\"3\" ppu=\"0.0\" /><level id=\"4\" ppu=\"0.0\" /><level id=\"5\" ppu=\"0.0\" /></grade></cem>";
            request = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
        return request;
    }

    public Element getPriceList()
        throws Exception
    {
        Element element = null;
        String message = null;
        try
        {
            message = "<cem action=\"25\"/>";
            element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            String respuesta = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
            System.out.println("Captura de mensaje " + respuesta);
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
        return element;
    }

    public Element getCemInfo()
        throws Exception
    {
        Element element = null;
        String message = null;
        System.out.println("entro a getCemInfo");
        try
        {
            message = "<cem action=\"1\"/>";
            element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
            String respuesta = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
            System.out.println("Captura de mensaje " + respuesta);
        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
        return element;
    }

    public ArrayList getTotalizers()
        throws Exception
    {
        System.out.println("entro a gettotal");
        ArrayList alelement = new ArrayList();
        Element element = null;
        String message = null;
        disconnect();
        Element confCem = getCemInfo();
        System.out.println("Paso getCemInfo");
        disconnect();
        Element getConfList = (Element)confCem.getElementsByTagName("configuration_res").item(0);
        NodeList nodelist = getConfList.getElementsByTagName("data");
        Element pumpList = (Element)nodelist.item(0);
        String qtyPump = pumpList.getAttribute("pumps_qty");
        int intpumpList = Integer.parseInt(qtyPump);
        try
        {
            for(int c = 1; c < intpumpList + 1; c++)
            {
                message = "<cem action=\"7\" id=\"" + c + "\"/>";
                element = KElementFactory.getInstance().createElementFromString(sendMessage(getOpeningMessageTag() + message + getClosingMessageTag()));
                String respuesta = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
                System.out.println("Captura de mensaje " + respuesta);
                alelement.add(element);
            }

        }
        catch(Exception e)
        {
            throw new Exception("ERROR: CEM could not answer: " + message);
        }
        return alelement;
    }

    public String sendPreset(String dispatchPreset[])
        throws Exception
    {
        String message = null;
        String preset[] = dispatchPreset;
        String request = "";
        if(preset[2] != null)
            try
            {
                message = "<cem action=\"10\" id=\"" + preset[0] + "\" hose=\"" + preset[1] + "\" amount=\"\" volume=\"" + preset[2] + "\"   />";
                request = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
            }
            catch(Exception e)
            {
                throw new Exception("ERROR: CEM could not answer: " + message);
            }
        if(preset[3] != null)
            try
            {
                message = "<cem action=\"10\" id=\"" + preset[0] + "\" hose=\"" + preset[1] + "\" amount=\"" + preset[3] + "\" volume=\"\"   />";
                request = sendMessage(getOpeningMessageTag() + message + getClosingMessageTag());
            }
            catch(Exception e)
            {
                throw new Exception("ERROR: CEM could not answer: " + message);
            }
        return request;
    }

    private String sendMessage(String message)
        throws Exception
    {
        String response = null;
        try
        {
            if(!socket.isConnected() || socket.isClosed())
                connect();
            send(KDataFormatter.justifyStrings("", String.valueOf(message.length()), 8, '0') + message);
            return receive();
        }
        catch(Exception e)
        {
            try
            {
                socket.close();
            }
            catch(Exception exception) { }
            KLogManager.logDebug("ERROR: I could not sendMessage() to CEM (" + e.getMessage() + ")");
            throw e;
        }
    }

    private void connect()
        throws Exception
    {
        try
        {
            socket = new MySocket("localhost", 9010);
            socket.setReceiveBufferSize(14336);
            socket.setSoTimeout(10000);
            KLogManager.logDebug("Connection to CEM has been opened.");
        }
        catch(Exception e)
        {
            KLogManager.logDebug("ERROR: I could not connect() to CEM (" + e.getMessage() + ")");
            throw e;
        }
    }

    private boolean isConnected()
    {
        return socket != null;
    }

    private void disconnect()
        throws Exception
    {
        try
        {
            socket.close();
            KLogManager.logDebug("Connection to CEM has been closed.");
        }
        catch(Exception e)
        {
            KLogManager.logDebug("ERROR: I could not disconnect() from CEM (" + e.getMessage() + ").");
            throw e;
        }
    }

    private void send(String message)
        throws Exception
    {
        byte abyte0[] = new byte[message.length()];
        for(int i = 0; i < message.length(); i++)
            abyte0[i] = (byte)message.charAt(i);

        System.out.println(message.substring(8, message.length()));
        try
        {
            socket.getOutputStream().write(abyte0);
        }
        catch(Exception e)
        {
            KLogManager.logDebug("ERROR: I/O error while trying to write to CEM (" + e.getMessage() + ").");
            throw e;
        }
    }

    public String receive()
    {
        int recvBufferSize = 14336;
        int bytesRead = 0;
        byte abyte0[] = new byte[recvBufferSize];
        int i = 0;
        String lastReply;
        try
        {
            i = socket.getInputStream().read(abyte0, 0, recvBufferSize);
        }
        catch(IOException e)
        {
            bytesRead = i;
            char ac[] = new char[i];
            for(int k = 0; k < i; k++)
                ac[k] = (char)(abyte0[k] & 0xff);

            lastReply = new String(ac);
            String s = "Error de I/O al recibir en el socket del puerto^: ";
            System.out.println(s);
        }
        bytesRead = i;
        if(i < 0)
            System.out.println("No se recibe respuesta del servidor en el socket del puerto^: ");
        char ac1[] = new char[i];
        for(int j = 0; j < i; j++)
            ac1[j] = (char)(abyte0[j] & 0xff);

        lastReply = new String(ac1);
        lastReply = lastReply.substring(8, lastReply.length());
        System.out.println(lastReply);
        return lastReply;
    }

    private MySocket socket;
}
