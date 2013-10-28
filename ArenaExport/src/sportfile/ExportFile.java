/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportfile;

import Util.KLogManager;

/**
 *
 * @author Flopez
 */
public class ExportFile {

    private static KLogManager log;
    public static void main(String[] args) {
        log=new KLogManager();
        try {
            Export exp = new Export();
            exp.cargarArena();
            log.logDebug("Exportacion ha Finalizado");
        } catch (Exception ex) {
            log.logDebug("Error de Exportacion:  "+ex);
        }
    }
}
