/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    /**
     *
     */
    public MultiReparacionTest() {
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
     * Test of crear method, of class MultiReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pcodigo = "bravos";
        String pnombre = "Arreglar bumper";
        String tipo = "Enderazado";
        Date pfechaAsignacion = new Date(Calendar.getInstance().getTimeInMillis());
        String pplacaVehiculo = "TX-101";
        MultiReparacion instance = new MultiReparacion();
        Reparacion expResult = new Reparacion(pcodigo, pnombre,tipo,pfechaAsignacion,pplacaVehiculo);
        Reparacion result = instance.crear(pcodigo, pnombre, tipo, pfechaAsignacion, pplacaVehiculo);
        
        assertEquals(expResult.getCodigo(), result.getCodigo());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getTipo(), result.getTipo());
        assertEquals(expResult.getPlacaVehiculo(), result.getPlacaVehiculo());
        assertEquals(expResult.getFechaAsignacion(), result.getFechaAsignacion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MultiReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String pcodigo = "pentos";
        String pnombre = "Arreglar bumper";
        String tipo = "Enderazado";
        Date pfechaAsignacion = new Date(Calendar.getInstance().getTimeInMillis());
        String pplacaVehiculo = "TX-101";
        
        MultiReparacion instance = new MultiReparacion();
        Reparacion expResult = new Reparacion(pcodigo, pnombre,tipo,pfechaAsignacion,pplacaVehiculo);
        instance.crear(pcodigo, pnombre, tipo, pfechaAsignacion, pplacaVehiculo);
        Reparacion result = instance.buscar(pcodigo);
        
        assertEquals(expResult.getCodigo(), result.getCodigo());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getTipo(), result.getTipo());
        assertEquals(expResult.getPlacaVehiculo(), result.getPlacaVehiculo());
        //assertEquals(expResult.getFechaAsignacion(), result.getFechaAsignacion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class MultiReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        String pcodigo = "qart";
        String pnombre = "Arreglar bumper";
        String tipo = "Enderazado";
        Date pfechaAsignacion = new Date(Calendar.getInstance().getTimeInMillis());
        String pplacaVehiculo = "TX-101";
        
        Reparacion preparacion = new Reparacion(pcodigo, pnombre,tipo,pfechaAsignacion,pplacaVehiculo);
        MultiReparacion instance = new MultiReparacion();
        instance.crear(pcodigo, pnombre, tipo, pfechaAsignacion, pplacaVehiculo);
        
        preparacion.setNombre("Arreglar retrovisores");
        
        instance.actualizar(preparacion);
        Reparacion nueva = instance.buscar(pcodigo);
        
        assertEquals(nueva.getNombre(), "Arreglar retrovisores");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorVehiculo method, of class MultiReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarPorVehiculo() throws Exception {
        System.out.println("buscarPorVehiculo");
        String pplaca = "TX-101";
        MultiReparacion instance = new MultiReparacion();
        ArrayList<Reparacion> result = instance.buscarPorVehiculo(pplaca);
        
        boolean placaCorrecta = true;
        
        for(Reparacion r: result)
            if(r.getPlacaVehiculo().compareTo(pplaca) != 0)
                placaCorrecta = false;
        
        assertEquals(placaCorrecta, true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class MultiReparacion.
     * @throws java.lang.Exception
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        
        String pcodigo = "pentos";
        String pnombre = "Arreglar bumper";
        String tipo = "Enderazado";
        Date pfechaAsignacion = new Date(Calendar.getInstance().getTimeInMillis());
        String pplacaVehiculo = "TX-101";
        MultiReparacion instance = new MultiReparacion();
        
        Reparacion repa = instance.crear(pcodigo, pnombre, tipo, pfechaAsignacion, pplacaVehiculo);
        instance.borrar(pcodigo);
        
        Reparacion resultado = null;
        try{
            resultado = instance.buscar(pnombre);
        }catch(Exception e){}
        
        boolean encontrada = (resultado == null?false:true);
        assertEquals(encontrada, false);
        
    }
    
}
