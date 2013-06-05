/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.com.ega.sgces.model.Usuario;

/**
 *
 * @author FLOPEZ
 */
public class TestDaoHibernate {
    private Usuariodao usuariodao;
    
    public TestDaoHibernate() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      usuariodao = new UsuariodaoImpl();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void usuario(){
        List<Usuario> usuarios = usuariodao.buscarTodos();
        assertEquals(1, usuarios.size());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
