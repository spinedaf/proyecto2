/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jagonchen
 */
public class MultiPiezaTest {
    
    /**
     *
     */
    public MultiPiezaTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class MultiPieza.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pcodigoPieza = "A13";
        String pmarca = "ACME";
        String ppais = "WB";
        String pdescripcion = "Algo";
        int pcantidad = 10;
        String pproblema = "Todo";
        int pidTarea = 9;
        MultiPieza instance = new MultiPieza();
        Pieza expResult = new Pieza(pcodigoPieza, pmarca, ppais, pdescripcion, pcantidad, pproblema, pidTarea);
        Pieza result = instance.crear(pcodigoPieza, pmarca, ppais, pdescripcion, pcantidad, pproblema, pidTarea);
        assertEquals(expResult.getCodigo(), result.getCodigo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPiezaPorIdTarea method, of class MultiPieza.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarPiezaPorIdTarea() throws Exception {
        System.out.println("buscarPiezaPorIdTarea");
        int pidTarea = 9;
        MultiPieza instance = new MultiPieza();
        ArrayList<Pieza> expResult = instance.buscarPiezaPorIdTarea(pidTarea);
        ArrayList<Pieza> result = instance.buscarPiezaPorIdTarea(pidTarea);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPorTarea method, of class MultiPieza.
     * @throws java.lang.Exception
     */
    @Test
    public void testBorrarPorTarea() throws Exception {
        System.out.println("borrarPorTarea");
        int pidTarea = 9;
        MultiPieza instance = new MultiPieza();
        String expResult = null;
        String result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
