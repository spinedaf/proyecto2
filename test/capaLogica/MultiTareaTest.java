/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
public class MultiTareaTest {
    
    public MultiTareaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        try{
            Files.delete(Paths.get(Conector.getDBPath()));
        }catch(Exception e){}
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        try{
            Files.delete(Paths.get(Conector.getDBPath()));
        }catch(Exception e){}
    }

    /**
     * Test of crear method, of class MultiTarea.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String pnombre = "Engrasar";
        String pdescripcion = "Engrase";
        Date pFecha = new Date();
        int duracionPropuesta = 5;
        int duracionReal = 4;
        int idSala = 3;
        int idReparacion = 10;
        MultiTarea instance = new MultiTarea();
        Tarea expResult = new Tarea(pnombre,pdescripcion,pFecha,duracionPropuesta,duracionReal,idSala,idReparacion);
        Tarea result = instance.crear(pnombre, pdescripcion, pFecha, duracionPropuesta, duracionReal, idSala, idReparacion);
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        assertEquals(expResult.getDuracionPropuesta(), result.getDuracionPropuesta());
        assertEquals(expResult.getDuracionReal(), result.getDuracionReal());
        assertEquals(expResult.getFechaCreacion(), result.getFechaCreacion());
        assertEquals(expResult.getIdReparacion(), result.getIdReparacion());
        assertEquals(expResult.getIdSala(), result.getIdSala());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MultiTarea.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
       String pnombre = "Engrasar";
        String pdescripcion = "Engrase";
        Date pFecha = new Date();
        int duracionPropuesta = 5;
        int duracionReal = 4;
        int idSala = 3;
        int idReparacion = 10;
        MultiTarea instance = new MultiTarea();
        Tarea expResult = new Tarea(pnombre,pdescripcion,pFecha,duracionPropuesta,duracionReal,idSala,idReparacion);
        instance.crear(pnombre, pdescripcion, pFecha, duracionPropuesta, duracionReal, idSala, idReparacion);

        Tarea result = instance.buscar(pnombre);
        assertEquals(expResult.getNombre(), result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorReparacion method, of class MultiTarea.
     */
    @Test
    public void testBuscarPorReparacion() throws Exception {
        System.out.println("buscarPorReparacion");
        int idReparacion = 10;
        MultiTarea instance = new MultiTarea();
        ArrayList<Tarea> result = instance.buscarPorReparacion(idReparacion);
        
        boolean idCorrecta = true;
        
        for(Tarea t: result)
        {
            if(t.getIdReparacion() != idReparacion)
                idCorrecta = false;
        }
        
        assertEquals(idCorrecta, true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorSala method, of class MultiTarea.
     */
    @Test
    public void testBuscarPorSala() throws Exception {
        System.out.println("buscarPorSala");
        int idSala = 3;
        MultiTarea instance = new MultiTarea();
        ArrayList<Tarea> result = instance.buscarPorSala(idSala);
        
        boolean idCorrecta = true;
        
        for(Tarea t: result)
        {
            if(t.getIdSala() != idSala)
                idCorrecta = false;
        }
        
        assertEquals(idCorrecta, true);
    }

    /**
     * Test of borrar method, of class MultiTarea.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        
        String pnombre = "Desengrasar";
        String pdescripcion = "Desengrase";
        Date pFecha = new Date();
        int duracionPropuesta = 5;
        int duracionReal = 4;
        int idSala = 3;
        int idReparacion = 10;
        
        MultiTarea instance = new MultiTarea();
        Tarea tarea = instance.crear(pnombre, pdescripcion, pFecha, duracionPropuesta, duracionReal, idSala, idReparacion);
        instance.borrar(tarea);
        
        Tarea resultado = null;
        try{
            resultado = instance.buscar(pnombre);
        }catch(Exception e){}
        
        boolean encontrada = (resultado == null?false:true);
        assertEquals(encontrada, false);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
        
}
