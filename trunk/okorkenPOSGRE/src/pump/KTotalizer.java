// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:30:10 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KTotalizer.java

package pump;

import core.KCharLiteral;
import java.io.PrintStream;
import org.w3c.dom.Element;

public class KTotalizer
{
    class Datum
    {

        protected String getValue()
            throws Exception
        {
            return String.valueOf(oDatum);
        }

        protected void setValue(Object value)
            throws Exception
        {
            oDatum = value;
        }

        protected void setValue(int value)
            throws Exception
        {
            oDatum = Integer.getInteger(null, value);
        }

        protected void setValue(long value)
            throws Exception
        {
            oDatum = Long.getLong(null, value);
        }

        protected void setValue(double value)
            throws Exception
        {
            oDatum = new Double(value);
        }

        Object oDatum;

        public Datum(Object value)
            throws Exception
        {
            oDatum = null;
            setValue(value);
        }

        public Datum(int value)
            throws Exception
        {
            oDatum = null;
            setValue(value);
        }

        public Datum(long value)
            throws Exception
        {
            oDatum = null;
            setValue(value);
        }

        public Datum(double value)
            throws Exception
        {
            oDatum = null;
            setValue(value);
        }
    }

    class SaleId extends Datum
    {

        public SaleId(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Amount extends Datum
    {

        public Amount(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Product extends Datum
    {

        public Product(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class PPU extends Datum
    {

        public PPU(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Volume extends Datum
    {

        public Volume(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Pump extends Datum
    {

        public Pump(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Date extends Datum
    {

        public Date(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Time extends Datum
    {

        public Time(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class ShiftId extends Datum
    {

        public ShiftId(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Hose extends Datum
    {

        public Hose(Object object)
            throws Exception
        {
            super(object);
        }
    }

    class Status extends Datum
    {

        public Status(Object object)
            throws Exception
        {
            super(object);
        }
    }


    public KTotalizer(Element element)
    {
        saleId = null;
        amount = null;
        product = null;
        ppu = null;
        volume = null;
        pump = null;
        date = null;
        time = null;
        shiftId = null;
        hose = null;
        status = null;
        try
        {
            String _1 = "" + KCharLiteral.s + KCharLiteral.a + KCharLiteral.l + KCharLiteral.e + KCharLiteral._ + KCharLiteral.i + KCharLiteral.d;
            setSaleId(element.getAttribute(_1));
            String _2 = "" + KCharLiteral.a + KCharLiteral.m + KCharLiteral.o + KCharLiteral.u + KCharLiteral.n + KCharLiteral.t;
            setAmount(element.getAttribute(_2));
            setProduct(element.getAttribute("" + KCharLiteral.p + KCharLiteral.r + KCharLiteral.o + KCharLiteral.d + KCharLiteral.u + KCharLiteral.c + KCharLiteral.t));
            setPPU(element.getAttribute("" + KCharLiteral.p + KCharLiteral.p + KCharLiteral.u));
            setVolume(element.getAttribute("" + KCharLiteral.v + KCharLiteral.o + KCharLiteral.l + KCharLiteral.u + KCharLiteral.m + KCharLiteral.e));
            setPump(element.getAttribute("" + KCharLiteral.p + KCharLiteral.u + KCharLiteral.m + KCharLiteral.p));
            setDate(element.getAttribute("" + KCharLiteral.d + KCharLiteral.a + KCharLiteral.t + KCharLiteral.e));
            setTime(element.getAttribute("" + KCharLiteral.t + KCharLiteral.i + KCharLiteral.m + KCharLiteral.e));
            setShiftId(element.getAttribute("" + KCharLiteral.s + KCharLiteral.h + KCharLiteral.i + KCharLiteral.f + KCharLiteral.t + KCharLiteral._ + KCharLiteral.i + KCharLiteral.d));
            setHose(element.getAttribute("" + KCharLiteral.h + KCharLiteral.o + KCharLiteral.s + KCharLiteral.e));
            setStatus(element.getAttribute("" + KCharLiteral.s + KCharLiteral.t + KCharLiteral.a + KCharLiteral.t + KCharLiteral.u + KCharLiteral.s));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getSaleId()
        throws Exception
    {
        return saleId.getValue();
    }

    public void setSaleId(Object value)
        throws Exception
    {
        saleId = new SaleId(value);
    }

    public String getAmount()
        throws Exception
    {
        return amount.getValue();
    }

    public void setAmount(Object value)
        throws Exception
    {
        amount = new Amount(value);
    }

    public String getProduct()
        throws Exception
    {
        return product.getValue();
    }

    public void setProduct(Object value)
        throws Exception
    {
        product = new Product(value);
    }

    public String getPPU()
        throws Exception
    {
        return ppu.getValue();
    }

    public void setPPU(Object value)
        throws Exception
    {
        ppu = new PPU(value);
    }

    public String getVolume()
        throws Exception
    {
        return volume.getValue();
    }

    public void setVolume(Object value)
        throws Exception
    {
        volume = new Volume(value);
    }

    public String getPump()
        throws Exception
    {
        return pump.getValue();
    }

    public void setPump(Object value)
        throws Exception
    {
        pump = new Pump(value);
    }

    public String getDate()
        throws Exception
    {
        return date.getValue();
    }

    public void setDate(Object value)
        throws Exception
    {
        date = new Date(value);
    }

    public String getTime()
        throws Exception
    {
        return time.getValue();
    }

    public void setTime(Object value)
        throws Exception
    {
        time = new Time(value);
    }

    public String getShiftId()
        throws Exception
    {
        return shiftId.getValue();
    }

    public void setShiftId(Object value)
        throws Exception
    {
        shiftId = new ShiftId(value);
    }

    public String getHose()
        throws Exception
    {
        return hose.getValue();
    }

    public void setHose(Object value)
        throws Exception
    {
        hose = new Hose(value);
    }

    public String getStatus()
        throws Exception
    {
        return status.getValue();
    }

    public void setStatus(Object value)
        throws Exception
    {
        status = new Status(value);
    }

    SaleId saleId;
    Amount amount;
    Product product;
    PPU ppu;
    Volume volume;
    Pump pump;
    Date date;
    Time time;
    ShiftId shiftId;
    Hose hose;
    Status status;
}
