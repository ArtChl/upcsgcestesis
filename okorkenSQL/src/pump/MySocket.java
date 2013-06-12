// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:30:19 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KPumpMessenger.java

package pump;

import java.net.Socket;

class MySocket extends Socket
{

    public MySocket(String host, int port)
        throws Exception
    {
        super(host, port);
    }

    public MySocket()
    {
    }
}
