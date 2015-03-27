/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pinedas
 */
public class MultiReparacionTest {
    
    public MultiReparacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class MultiReparacion.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pnombre = "Arreglar bumper";
        String tipo = "Enderazado";
        Date pfechaAsignacion = new Date();
        String pplacaVehiculo = "TX-101";
        MultiReparacion instance = new MultiReparacion();
        Reparacion expResult = new Reparacion(pnombre,tipo,pfechaAsignacion,pplacaVehiculo);
        Reparacion result = instance.crear(pnombre, tipo, pfechaAsignacion, pplacaVehiculo);
        
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getTipo(), result.getTipo());
        assertEquals(expResult.getPlacaVehiculo(), result.getPlacaVehiculo());
        assertEquals(expResult.getFechaAsignacion(), result.getFechaAsignacion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
