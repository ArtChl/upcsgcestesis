// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 09/01/2010 08:30:49 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KPosManager.java

package pos;

import core.KLogManager;
import core.factory.KDataFormatter;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pump.KDispatch;

// Referenced classes of package pos:
//            KProductasasasasasas

public class KPosManager
{

    public KPosManager()
        throws Exception
    {
        connection = null;
        connectioncen = null;
        Properties file = new Properties();
        try
        {
            file.load(new FileInputStream("C:\\WINDOWS\\CEM44\\Korken\\Korken.ini"));
            SQLDriver = file.getProperty("DRIVER");
            SQLUrl = file.getProperty("URL");
            SQLBd = file.getProperty("BD");
            SQLBd2 = file.getProperty("BDCEN");
            SQLUser = file.getProperty("USER");
            SQLPasswd = file.getProperty("PASSWD");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            KLogManager.logDebug("Error when trying to get ini file. " + e.getMessage());
            throw new Exception("Error when trying to load ini file.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            KLogManager.logDebug("Error when trying to load ini file. " + e.getMessage());
            throw new Exception("Error when trying to load ini file.");
        }
    }

    public boolean registerSale(KDispatch dispatch)
    {
        boolean result = false;
        if(connect())
            try
        {
            String pump = KDataFormatter.justifyStrings("", dispatch.getPump(), 2, '0');
            String sentence = "INSERT INTO DESPACHO (id, idproducto, idcara, fecharegistro, nrogalones, preciounitario, montosoles, turno, hora, idcem, idestado) VALUES (";
            String maximun = "SELECT MAX(id) FROM DESPACHO";
                String nextNumber = "";
                try
                {
                    PreparedStatement next = connection.prepareStatement(maximun);
                    ResultSet rs = next.executeQuery();
                    if(rs.next())
                        try
                        {
                            nextNumber = String.valueOf(Integer.parseInt(rs.getString(1).trim()) + 1);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error while retrieving max number: " + e.getMessage());
                            nextNumber = "1";
                        }
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when getting maximun number: " + s.getMessage());
                }
            sentence = sentence + "'" + KDataFormatter.justifyStrings("", nextNumber, 10, '0') + "',";
            sentence = sentence + "'" + dispatch.getProduct() + "',";
            sentence = sentence + "'" + dispatch.getPump() + "',";
            sentence = sentence + "'" + KDataFormatter.formatDateForSQL(dispatch.getDate()) + "',";
            sentence = sentence + "'" + KDataFormatter.redondeartres(Double.parseDouble(dispatch.getAmount()), Double.parseDouble(dispatch.getPPU())) + "',";
            sentence = sentence + "'" + Double.parseDouble(dispatch.getPPU()) + "',";
            sentence = sentence + "'" + Double.parseDouble(dispatch.getAmount()) + "',";
            sentence = sentence + "'" + dispatch.getShiftId() + "',"; 
            sentence = sentence + "'" + dispatch.getTime() + "',"; 
            sentence = sentence + "'" + dispatch.getSaleId() + "',"; 
            sentence = sentence + "'" + dispatch.getStatus() + "')";
            try
            {
                KLogManager.logDebug(sentence);
                PreparedStatement ps = connection.prepareStatement(sentence);
                ps.executeUpdate();
                connection.commit();
                result = true;
            
            }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when inserting sale: " + s.getMessage());
                    KLogManager.logDebug("[SQL] " + sentence);
                }
            }
            catch(Exception e)
            {
                KLogManager.logDebug("SQL: " + e.getMessage());
                e.printStackTrace();
            }finally
            {
            try {
                if (disconnect()) {
                    KLogManager.logDebug("Disconnected");
                }
            } catch (SQLException ex) {
                Logger.getLogger(KPosManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return result;
    }

    public boolean registerSale2(KDispatch dispatch)
    {
        boolean result = false;
        if(connect())
            try
            {
                String pump = KDataFormatter.justifyStrings("", dispatch.getPump(), 2, '0');
                String sentence = "INSERT INTO DESPACHOS (id_contado, importe\t, id_manguera, volumen, id_surtidor, fecha,ppu,documento) VALUES (";
                String maximun = "SELECT MAX(id_contado) FROM DESPACHOS";
                String nextNumber = "";
                try
                {
                    PreparedStatement next = connection.prepareStatement(maximun);
                    ResultSet rs = next.executeQuery();
                    if(rs.next())
                        try
                        {
                            nextNumber = String.valueOf(Integer.parseInt(rs.getString(1).trim()) + 1);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error while retrieving max number: " + e.getMessage());
                            nextNumber = "1";
                        }
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when getting maximun number: " + s.getMessage());
                }
                sentence = sentence + "'" + KDataFormatter.justifyStrings("", nextNumber, 18, '0') + "',";
                sentence = sentence + "'" + dispatch.getAmount() + "',";
                sentence = sentence + "'" + dispatch.getHose() + "',";
                sentence = sentence + "'" + KDataFormatter.redondear(Double.valueOf(dispatch.getAmount()).doubleValue() / Double.valueOf(dispatch.getPPU()).doubleValue(), 3) + "',";
                sentence = sentence + "'" + pump + "',";
                sentence = sentence + "'" + KDataFormatter.formatDateForSQLISO(dispatch.getDate()) + " " + KDataFormatter.formatTimeForSQL(dispatch.getTime()) + "',";
                sentence = sentence + "'" + dispatch.getPPU() + "',";
                sentence = sentence + "null)";
                try
                {
                    PreparedStatement ps = connection.prepareStatement(sentence);
                    ps.executeUpdate();
                    confirm();
                    result = true;
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when inserting sale: " + s.getMessage());
                    KLogManager.logDebug("[SQL] " + sentence);
                    return false;
                }
                if(disconnect())
                    KLogManager.logDebug("Disconnected DB Local");
            }
            catch(Exception e)
            {
                KLogManager.logDebug("SQL: " + e.getMessage());
                e.printStackTrace();
            }
        return result;
    }

    public boolean registerSaleCen(KDispatch dispatch)
    {
        boolean result = false;
        if(connectcen())
            try
            {
                String pump = KDataFormatter.justifyStrings("", dispatch.getPump(), 2, '0');
                String sentence = "INSERT INTO T_DESPACHO (id_despacho, monto, id_producto, cantidad, id_surtidor, fecha, hora, estado) VALUES (";
                String maximun = "SELECT MAX(id_despacho) FROM T_DESPACHO";
                String nextNumber = "";
                try
                {
                    PreparedStatement next = connectioncen.prepareStatement(maximun);
                    ResultSet rs = next.executeQuery();
                    if(rs.next())
                        try
                        {
                            nextNumber = String.valueOf(Integer.parseInt(rs.getString(1).trim()) + 1);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error while retrieving max number: " + e.getMessage());
                            nextNumber = "1";
                        }
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when getting maximun number: " + s.getMessage());
                }
                sentence = sentence + "'" + KDataFormatter.justifyStrings("", nextNumber, 18, '0') + "',";
                sentence = sentence + "'" + dispatch.getAmount() + "',";
                System.out.println("valor de Monto :" + dispatch.getAmount());
                sentence = sentence + "'" + getIdProduct(dispatch.getProduct()) + "',";
                sentence = sentence + "'" + KDataFormatter.redondear(Double.valueOf(dispatch.getAmount()).doubleValue() / Double.valueOf(dispatch.getPPU()).doubleValue(), 3) + "',";
                System.out.println("valor de Cantidad :" + dispatch.getVolume());
                sentence = sentence + "'" + pump + "',";
                sentence = sentence + "'" + KDataFormatter.formatDateForSQLISO(dispatch.getDate()) + "',";
                sentence = sentence + "'" + KDataFormatter.formatTimeForDBFTime(dispatch.getTime()) + "',";
                sentence = sentence + "'0'" + ")";
                try
                {
                    PreparedStatement ps = connectioncen.prepareStatement(sentence);
                    ps.executeUpdate();
                    confirmcen();
                    result = true;
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when inserting sale: " + s.getMessage());
                    KLogManager.logDebug("[SQL] " + sentence);
                    return false;
                }
                if(disconnectcen())
                    KLogManager.logDebug("Disconnected DB Central");
            }
            catch(Exception e)
            {
                KLogManager.logDebug("SQL: " + e.getMessage());
                e.printStackTrace();
            }
        return result;
    }

    public boolean deleteSales(String fecha)
    {
        boolean result = false;
        if(connect())
        {
            String sentence = "DELETE T_DESPACHO WHERE  estado ='1'";
            try
            {
                PreparedStatement us = connection.prepareStatement(sentence);
                us.executeUpdate();
                confirm();
                disconnect();
                KLogManager.logDebug("Deleted sales table T_DESPACHO  ");
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when updating status in T_DESPACHO: " + s.getMessage());
            }
        }
        return true;
    }

    public boolean deleteSalesCen(String fecha)
    {
        boolean result = false;
        if(connectcen())
        {
            String sentence = "DELETE T_DESPACHO WHERE  estado ='1'";
            try
            {
                PreparedStatement us = connectioncen.prepareStatement(sentence);
                us.executeUpdate();
                confirmcen();
                disconnectcen();
                KLogManager.logDebug("Deleted sales table T_DESPACHO   ");
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when deleting sales in T_DESPACHO: " + s.getMessage());
            }
        }
        return true;
    }

    public boolean updateStatus(String status, String id_dispatch)
    {
        boolean result = false;
        if(connect())
        {
            String sentence = "UPDATE T_DESPACHO set estado = '" + status + "' where id_despa_cem = '" + id_dispatch + "'";
            try
            {
                PreparedStatement us = connection.prepareStatement(sentence);
                us.executeUpdate();
                confirm();
                disconnect();
                KLogManager.logDebug("Updated table T_DESPACHO status to : " + status);
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when updating status in T_DESPACHO: " + s.getMessage());
            }
        }
        return true;
    }

    public boolean updateStatusPCh(String status, String id_grade[])
    {
        boolean result = false;
        if(connectcen())
        {
            for(int x = 0; x < id_grade.length; x++)
            {
                String sentence = "UPDATE T_CAMBIO_PRECIO set estado = '0' where producto = '" + id_grade[x] + "' and estado='1'";
                try
                {
                    PreparedStatement us = connectioncen.prepareStatement(sentence);
                    us.executeUpdate();
                    confirmcen();
                    disconnectcen();
                    KLogManager.logDebug("Updated table T_CAMBIO_PRECIO status to : 0");
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when updating status in T_CAMBIO_PRECIO: " + s.getMessage());
                }
            }

        }
        return true;
    }

    public boolean updateStatusCloseD()
    {
        boolean result = false;
        if(connectcen())
        {
            String sentence = "UPDATE interface_config set cierredia = '0' where cierredia='1' ";
            try
            {
                PreparedStatement uc = connectioncen.prepareStatement(sentence);
                uc.executeUpdate();
                confirmcen();
                disconnectcen();
                KLogManager.logDebug("Updated table Interface_Config status to : 0");
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when updating status in Interface_Config: " + s.getMessage());
            }
        }
        return true;
    }

    public boolean updateStatusCloseT()
    {
        boolean result = false;
        if(connectcen())
        {
            String sentence = "UPDATE interface_config set cambioturno = '0' where cambioturno='1' ";
            try
            {
                PreparedStatement uc = connectioncen.prepareStatement(sentence);
                uc.executeUpdate();
                confirmcen();
                disconnectcen();
                KLogManager.logDebug("Updated table Interface_Config status to : 0");
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when updating status in Interface_Config: " + s.getMessage());
            }
        }
        return true;
    }

    public boolean updateTotalizers(String id_manguera, String mon_tota, String vol_tota, String id_surtidor, String producto, String fecha)
    {
        boolean result = false;
        if(connectcen())
        {
            System.out.println("paso nivel 14 " + id_manguera);
            String sentence = "INSERT INTO TOTALIZADORES (id_surtidor,id_manguera,producto,fecha,mon_total, vol_total, turno) VALUES (";
            sentence = sentence + "'" + id_surtidor + "',";
            sentence = sentence + "'" + id_manguera + "',";
            sentence = sentence + "'" + KProduct.getKallpaCode(producto) + "',";
            sentence = sentence + "'" + KDataFormatter.formatDateForSQLANSI(fecha).trim() + "',";
            sentence = sentence + "'" + mon_tota + "',";
            sentence = sentence + "'" + vol_tota + "',";
            sentence = sentence + "'" + getTurno() + "'" + ")";
            try
            {
                PreparedStatement it = connectioncen.prepareStatement(sentence);
                it.executeUpdate();
                confirmcen();
                disconnectcen();
                KLogManager.logDebug("Inserted shift totalizers into table PC_OP_PARTEDIGITAL:   tipo_cierre Dia  cara " + id_surtidor + "  manguera " + id_manguera + "  articulo " + producto + "  contometro monto " + mon_tota + "  contometro vol " + vol_tota);
            }
            catch(SQLException s)
            {
                KLogManager.logDebug("SQL error when inserting totalizers into T_CONTOMETROS: " + s.getMessage());
            }
        }
        return true;
    }
    public String getTurno(){
                String maximun = "SELECT ID FROM TURNO WHERE ESTADO='N'";
                String nextNumber = "";
                try
                {
                    PreparedStatement next = connectioncen.prepareStatement(maximun);
                    ResultSet rs = next.executeQuery();
                    if(rs.next())
                        try
                        {
                            nextNumber = String.valueOf(Integer.parseInt(rs.getString(1).trim()) + 1);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error while retrieving max number: " + e.getMessage());
                            nextNumber = "1";
                        }
                }
                catch(SQLException s)
                {
                    KLogManager.logDebug("SQL error when getting maximun number: " + s.getMessage());
                }
                return nextNumber;
    }
    public String[][] getPriceChange()
    {
        String ChangP[][] = new String[2][2];
        String varX[] = new String[30];
        String varY[] = new String[30];
        if(connectcen())
        {
            String sentence = "Select producto,precio from T_CAMBIO_PRECIO where estado = '1'";
            try
            {
                PreparedStatement gp = connectioncen.prepareStatement(sentence);
                ResultSet chgp = gp.executeQuery();
                for(int x = 0; chgp.next(); x++)
                {
                    String id_p = chgp.getString("producto");
                    String p = chgp.getString("precio");
                    varX[x] = id_p;
                    varY[x] = p;
                }

                ChangP[0] = varX;
                ChangP[1] = varY;
            }
            catch(SQLException sqlexception) { }
            disconnectcen();
        }
        return ChangP;
    }

    public String[][] getCloseT()
    {
        String Scc[][] = new String[3][3];
        String varX[] = new String[30];
        String varY[] = new String[30];
        String varZ[] = new String[30];
        if(connectcen())
        {
            String sentence = "Select cambioturno from interface_config where cambioturno = '1'";
            try
            {
                PreparedStatement sc = connectioncen.prepareStatement(sentence);
                ResultSet rc = sc.executeQuery();
                for(int x = 0; rc.next(); x++)
                {
                    String cturno = rc.getString("cambioturno");
                    System.out.println("Cambio de Turno :" + cturno);
                    varZ[x] = cturno;
                }

                Scc[0] = varZ;
            }
            catch(SQLException sqlexception) { }
            disconnectcen();
        }
        return Scc;
    }

    public String[][] getCloseD()
    {
        String Scc[][] = new String[3][3];
        String varX[] = new String[30];
        String varY[] = new String[30];
        String varZ[] = new String[30];
        if(connectcen())
        {
            //String sentence = "Select FECHA_CONTOMETROS_ELECTRONICOS from interface_config where cierredia = '1'";
            String sentence = "Select cierredia from interface_config where cierredia = '1'";
            try
            {
                PreparedStatement sc = connectioncen.prepareStatement(sentence);
                ResultSet rc = sc.executeQuery();
                for(int x = 0; rc.next(); x++)
                {
                    //String fecha = rc.getString("FECHA_CONTOMETROS_ELECTRONICOS");
                    String fecha = rc.getString("cierredia");
                    System.out.println("Cambio de Dia :" + fecha);
                    varZ[x] = fecha;
                }

                Scc[0] = varZ;
            }
            catch(SQLException sqlexception) { }
            disconnectcen();
        }
        return Scc;
    }

    public String getFecha()
    {
        System.out.println("Fecha actual transacciones");
        String fecha = "";
        if(connect())
        {
            String sentence = "select top 1 fecha from t_despacho order by fecha desc";
            try
            {
                PreparedStatement sc = connection.prepareStatement(sentence);
                ResultSet rc = sc.executeQuery();
                for(int x = 0; rc.next(); x++)
                    fecha = rc.getString("fecha");

            }
            catch(SQLException s)
            {
                KLogManager.logDebug("Fail capture date : " + s.getMessage());
            }
            System.out.println("Fecha de transacciones " + fecha);
        }
        return fecha;
    }

    public String getIdProduct(String idCem)
    {
        System.out.println("Codigo de Cem " + idCem);
        String idProduct = "";
        if(connect())
        {
            String sentence = "Select id_producto,id_cem from T_PRODUCTO";
            try
            {
                PreparedStatement sc = connection.prepareStatement(sentence);
                ResultSet rc = sc.executeQuery();
                for(int x = 0; rc.next(); x++)
                {
                    String id_product = rc.getString("id_producto");
                    String id_cem = rc.getString("id_cem");
                    if(idCem.equals(id_cem))
                        idProduct = id_product;
                }

            }
            catch(SQLException s)
            {
                KLogManager.logDebug("No price close shift/day detected in table T_CIERRE : " + s.getMessage());
            }
            System.out.println("Valor de salida producto GyN " + idProduct);
        }
        return idProduct;
    }

    public String getIdProductCem(String idGyN)
    {
        System.out.println("Codigo de Cem " + idGyN);
        String idProduct = "";
        if(connect())
        {
            String sentence = "Select id_producto,id_cem from T_PRODUCTO";
            try
            {
                PreparedStatement sc = connection.prepareStatement(sentence);
                ResultSet rc = sc.executeQuery();
                for(int x = 0; rc.next(); x++)
                {
                    String id_product = rc.getString("id_producto");
                    String id_cem = rc.getString("id_cem");
                    if(idGyN.equals(id_product))
                        idProduct = id_cem;
                }

            }
            catch(SQLException s)
            {
                KLogManager.logDebug("No price close shift/day detected in table T_CIERRE : " + s.getMessage());
            }
            System.out.println("Valor de salida producto GyN " + idProduct);
        }
        return idProduct;
    }

    private boolean connect()
    {
        boolean result = false;
        try
        {
            Class.forName(SQLDriver).newInstance();
        }
        catch(Exception e)
        {
            result = false;
            KLogManager.logDebug("Error while trying to load driver " + SQLDriver);
            KLogManager.logDebug(e.getMessage());
        }
        try
        {
            connection = DriverManager.getConnection(SQLUrl + ":" + SQLBd, SQLUser, SQLPasswd);
            connection.setAutoCommit(false);
            KLogManager.logDebug("Connected to Interface DB Local.");
            result = true;
        }
        catch(Exception e1)
        {
            result = false;
            KLogManager.logDebug("Error while trying to open a connection to db. (" + e1.getMessage() + ")");
        }
        return result;
    }

    private boolean connectcen()
    {
        boolean result = false;
        try
        {
            Class.forName(SQLDriver).newInstance();
        }
        catch(Exception e)
        {
            result = false;
            KLogManager.logDebug("Error while trying to load driver " + SQLDriver);
            KLogManager.logDebug(e.getMessage());
        }
        try
        {
            connectioncen = DriverManager.getConnection(SQLUrl + ":" + SQLBd, SQLUser, SQLPasswd);
            connectioncen.setAutoCommit(false);
            result = true;
        }
        catch(Exception e1)
        {
            result = false;
            KLogManager.logDebug("Error while trying to open a connection to db. (" + e1.getMessage() + ")");
        }
        return result;
    }

    private boolean confirm()
    {
        boolean result = true;
        try
        {
            if(connection != null)
                connection.commit();
        }
        catch(Exception e1)
        {
            result = false;
        }
        return result;
    }

    private boolean confirmcen()
    {
        boolean result = true;
        try
        {
            if(connectioncen != null)
                connectioncen.commit();
        }
        catch(Exception e1)
        {
            result = false;
        }
        return result;
    }

    private boolean undo()
    {
        boolean result = true;
        try
        {
            if(connection != null)
                connection.rollback();
        }
        catch(Exception e1)
        {
            result = false;
        }
        return result;
    }

    private boolean undocen()
    {
        boolean result = true;
        try
        {
            if(connectioncen != null)
                connectioncen.rollback();
        }
        catch(Exception e1)
        {
            result = false;
        }
        return result;
    }

    private boolean disconnect() throws SQLException
    {
        boolean result = true;
        try
        {
            if(connection != null)
                connection.close();
        }
        catch(Exception e1)
        {
            result = false;
            e1.printStackTrace();
        }finally{
            connection.close();
        }
        connection = null;
        return result;
    }

    private boolean disconnectcen()
    {
        boolean result = true;
        try
        {
            if(connectioncen != null)
                connectioncen.close();
        }
        catch(Exception e1)
        {
            result = false;
            e1.printStackTrace();
        }
        connectioncen = null;
        return result;
    }

    private String SQLDriver;
    private String SQLUrl;
    private String SQLBd;
    private String SQLBd2;
    private String SQLUser;
    private String SQLPasswd;
    private Connection connection;
    private Connection connectioncen;
}
