// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:32:03 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KElementFactory.java

package core.factory;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class KElementFactory
{

    public static KElementFactory getInstance()
        throws Exception
    {
        if(oFactory == null)
        {
            System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "org.apache.crimson.jaxp.DocumentBuilderFactoryImpl");
            oFactory = new KElementFactory(DocumentBuilderFactory.newInstance());
        }
        return oFactory;
    }

    public KElementFactory()
        throws Exception
    {
        oDocument = null;
        oBuilder = null;
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "org.apache.crimson.jaxp.DocumentBuilderFactoryImpl");
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        oBuilder = documentbuilderfactory.newDocumentBuilder();
        oDocument = oBuilder.newDocument();
    }

    private KElementFactory(DocumentBuilderFactory documentbuilderfactory)
        throws Exception
    {
        oDocument = null;
        oBuilder = null;
        oBuilder = documentbuilderfactory.newDocumentBuilder();
        oDocument = oBuilder.newDocument();
    }

    public Element buildElement(String s)
        throws Exception
    {
        return createElement(s);
    }

    public Element createRootElement()
        throws Exception
    {
        Element element = oDocument.createElement("root");
        return element;
    }

    public synchronized Element createElement(String s)
        throws Exception
    {
        return oDocument.createElement(s);
    }

    public Element parseElement(String s)
        throws Exception
    {
        return createElementFromString(s);
    }

    public synchronized Element createElementFromString(String s)
        throws Exception
    {
        if("".equals(s))
            System.out.println("Fuente inv\341lida para crear elemento XML");
        StringReader stringreader = new StringReader(s);
        InputSource inputsource = new InputSource(stringreader);
        Element element = oBuilder.parse(inputsource).getDocumentElement();
        stringreader.close();
        return element;
    }

    public void adoptNode(Element element, Element element1)
        throws Exception
    {
        Element element2 = (Element)element.getOwnerDocument().importNode(element1, true);
        element.appendChild(element2);
    }

    public synchronized Element parseURIToElement(String s)
        throws Exception
    {
        Document document = oBuilder.parse(s);
        return document.getDocumentElement();
    }

    public synchronized Element parseURIToElement(InputStream inputstream)
        throws Exception
    {
        Document document = oBuilder.parse(inputstream);
        return document.getDocumentElement();
    }

    public Document parseURIToDocument(String s)
        throws Exception
    {
        return oBuilder.parse(s);
    }

    public Document createDocument()
        throws Exception
    {
        return oBuilder.newDocument();
    }

    private static KElementFactory oFactory = null;
    private Document oDocument;
    private DocumentBuilder oBuilder;

}
