/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sportfile;

import Util.KDataFormatter;
import Util.KLogManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.imptec.model.Abastecimiento;
import pe.com.imptec.model.MArena;
import pe.com.imptec.service.AbastecimientoServiceSql;
import pe.com.imptec.service.MArenaService;
import pe.com.imptec.service.MArenaServiceSql;

/**
 *
 * @author Luis Angel
 */
public class Export {

    private AbastecimientoServiceSql abastecimientoService;
    private MArenaService mArenaService;
    private Abastecimiento aba= new Abastecimiento();
    private MArena mArena;
    private KDataFormatter format= new KDataFormatter();
    KLogManager log;

    public Export() {
                log = new KLogManager();
                ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.abastecimientoService =  context.getBean("abastecimientoService",
				AbastecimientoServiceSql.class);
                this.mArenaService =  context.getBean("mArenaService",
				MArenaServiceSql.class);
    }

      
  
    public void cargarArena() throws IOException{
        String source;
        int f=0;
        FileWriter f0 = new FileWriter("c://Report//Files//arena.csv",false);
        try (BufferedWriter bw = new BufferedWriter(f0)) {
            ArrayList<MArena> mArenas = mArenaService.obtenerListaArena();
            for (MArena marena : mArenas){
                String nota=marena.getNota().toString().trim();
                System.out.println(KDataFormatter.formatNull(3)+"Consumo Combustible Arena;1;1;1;"+KDataFormatter.formatNull(1)+"3;2;"+KDataFormatter.formatActual()+";2367;"
                        +KDataFormatter.formatActual()+";2367;"+KDataFormatter.formatNull(5)+"54226;"+KDataFormatter.formatNull(21)+"4997;"
                        +marena.getCantidad()+";"+marena.getCantidad()+";GLN;"+KDataFormatter.formatDateForSQLKallpa(marena.getFecha())
                        +";"+KDataFormatter.formatNull(1)+"0009;"+KDataFormatter.formatNull(55)+"345;"
                        +KDataFormatter.formatNull(4)+"99004;MIN;99004;911010111;0002;"+marena.getFrente()+";"+marena.getPartida()+";"
                        +"J000;0000;"+KDataFormatter.formatNull(92)+marena.getSisme()+";"+KDataFormatter.formatNull(6)
                        +nota+";"+KDataFormatter.formatCode(marena.getFecha())+"-"+KDataFormatter.formatSite(marena.getVale())+
                        KDataFormatter.formatVale(marena.getNumero()));
                try {
                source = KDataFormatter.formatNull(3)+"Consumo Combustible Arena;1;1;1;"+KDataFormatter.formatNull(1)+"3;2;"+KDataFormatter.formatActual()+";2367;"
                        +KDataFormatter.formatActual()+";2367;"+KDataFormatter.formatNull(5)+"54226;"+KDataFormatter.formatNull(21)+"4997;"
                        +marena.getCantidad()+";"+marena.getCantidad()+";GLN;"+KDataFormatter.formatDateForSQLKallpa(marena.getFecha())
                        +";"+KDataFormatter.formatNull(1)+"0009;"+KDataFormatter.formatNull(55)+"345;"
                        +KDataFormatter.formatNull(4)+"99004;MIN;99004;911010111;0002;"+marena.getFrente()+";"+marena.getPartida()+";"
                        +"J000;0000;"+KDataFormatter.formatNull(93)+marena.getSisme()+";"+KDataFormatter.formatNull(6)
                        +nota+";"+KDataFormatter.formatCode(marena.getFecha())+"-"+KDataFormatter.formatSite(marena.getVale())+
                        KDataFormatter.formatVale(marena.getNumero());
                                             bw.write(source);
                                             bw.newLine();
                                             f++;
                                    } catch (Exception e) {
                                     KLogManager.logDebug("Error de Valores Nulos en Datos"+e);
                                    }}
             mArenaService.actualizarEstado();
             KLogManager.logDebug("Se realizo exportacion de: "+f+" Registros");
        }
    }  
}


