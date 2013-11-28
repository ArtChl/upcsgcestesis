/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ega.sgces.logic;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 *
 * @author CHRISTIAN
 */
public class CalculadoraTest extends TestCase {
    
    public CalculadoraTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    public void testSuma() {
        int a = 1;
        int b = 2;
        
        int valor = a + b;
        
        Assert.assertEquals(3, valor);
    }
    
    public void testResta() {
        int a = 1;
        int b = 2;
        
        int valor = a - b;
        
        Assert.assertEquals(-1, valor);
    }
    
    public void testMultiplicacion() {
        int a = 1;
        int b = 2;
        
        int valor = a * b;
        
        Assert.assertEquals(2, valor);
    }
    
    public void testSumaAyA() {
        int a = 1;
        
        int valor = a * a;
        
        Assert.assertEquals(2, valor);
    }
    
    public void testSumaError() {
        int a = 1;
        int b = 2;
        
        int valor = a + b;
        
        Assert.assertEquals(4, valor);
    }
}
