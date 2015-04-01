/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

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
public class MultiVehiculoTest {
    
    /**
     *
     */
    public MultiVehiculoTest() {
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
     * Test of crear method, of class MultiVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pplaca = "124a31";
        String pmodelo = "B1";
        String pnombrePropietario = "Joe";
        String papellidoPropietario = "Dow";
        String pestado = "Malo";
        MultiVehiculo instance = new MultiVehiculo();
        Vehiculo expResult = new Vehiculo (pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
        Vehiculo result = instance.crear(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
        assertEquals(expResult.getModelo(), result.getModelo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorPlaca method, of class MultiVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarPorPlaca() throws Exception {
        System.out.println("buscarPorPlaca");
        String pplaca = "124a3";
        MultiVehiculo instance = new MultiVehiculo();
        String expResult = "124a3";
        Vehiculo result = instance.buscarPorPlaca(pplaca);
        assertEquals(expResult, result.getPlaca());
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
          /**
     * Test of borrarPorPlaca method, of class MultiVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testBorrarPorPlaca() throws Exception {
        System.out.println("borrarPorPlaca");
        String pplaca = "124a3";
        MultiVehiculo instance = new MultiVehiculo();
        String expResult = null;
        String result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

 
    
}
