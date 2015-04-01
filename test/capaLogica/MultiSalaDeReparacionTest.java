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
public class MultiSalaDeReparacionTest {
    
    /**
     *
     */
    public MultiSalaDeReparacionTest() {
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
     * Test of crear method, of class MultiSalaDeReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pdescripcion = "Una";
        String pubicacion = "Algun Lugar";
        int pcapacidad = 9;
        MultiSalaDeReparacion instance = new MultiSalaDeReparacion();
        SalaDeReparacion expResult = new SalaDeReparacion(pdescripcion, pubicacion, pcapacidad);
        SalaDeReparacion result = instance.crear(pdescripcion, pubicacion, pcapacidad);
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarSalaDeReparacion method, of class MultiSalaDeReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarSalaDeReparacion() throws Exception {
        System.out.println("buscarSalaDeReparacion");
        String descripcion = "motores diesel";
        MultiSalaDeReparacion instance = new MultiSalaDeReparacion();
        SalaDeReparacion expResult = instance.buscarSalaDeReparacion(descripcion);
        SalaDeReparacion result = instance.buscarSalaDeReparacion(descripcion);
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrarSalaId method, of class MultiSalaDeReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testBorrarSalaId() throws Exception {
        System.out.println("borrarSalaId");
        int pIdSala = 9;
        MultiSalaDeReparacion instance = new MultiSalaDeReparacion();
        String expResult = null;
        String result =null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
