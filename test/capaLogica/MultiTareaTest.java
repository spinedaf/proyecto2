/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.nio.file.Files;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import capaAccesoBD.Conector;
import java.io.File;
import java.nio.file.Paths;

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
    }
    
    @Before
    public void setUp() {
        File f = new File(Conector.getDBPath());
        try{
            f.delete();
        }catch(Exception e){}
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
    public void testCrearNombre() throws Exception {
        System.out.println("crear, nombre");
        String pnombre = "Eduardo";
        String pdescripcion = "Una tarea";
        MultiTarea instance = new MultiTarea();
        Tarea expResult = new Tarea(pnombre,pdescripcion,new Date());
        Tarea result = instance.crear(pnombre, pdescripcion);
        assertEquals(expResult.getNombre(), result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCrearDescripcion() throws Exception {
        System.out.println("crear, descripcion");
        String pnombre = "Eduardo";
        String pdescripcion = "Una tarea";
        MultiTarea instance = new MultiTarea();
        Tarea expResult = new Tarea(pnombre,pdescripcion,new Date());
        Tarea result = instance.crear(pnombre, pdescripcion);
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MultiTarea.
     */
    @Test
    public void testBuscarNombre() throws Exception {
        System.out.println("buscar, nombre");
        String pnombre = "Empezar";
        String pdescripcion = "Empiece";
        MultiTarea instance = new MultiTarea();
        
        instance.crear(pnombre,pdescripcion);
        
        Tarea expResult = new Tarea(pnombre,pdescripcion,new Date());
        Tarea result = instance.buscar(pnombre);
        assertEquals(expResult.getNombre(), result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testBuscarDescripcion() throws Exception {
        System.out.println("buscar, nombre");
        String pnombre = "Empezar";
        String pdescripcion = "Empiece";
        MultiTarea instance = new MultiTarea();
        
        instance.crear(pnombre,pdescripcion);
        
        Tarea expResult = new Tarea(pnombre,pdescripcion,new Date());
        Tarea result = instance.buscar(pnombre);
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class MultiTarea.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        MultiTarea instance = new MultiTarea();
        Tarea ptarea = instance.crear("Tarea", "Debe hacerse");
        instance.borrar(ptarea);
        
        Tarea tareaBorrada = null;
        try{
            tareaBorrada = instance.buscar("Tarea");
        }catch(Exception e){}
        
        boolean resultado = (tareaBorrada==null?true:false);
        assertEquals(resultado,true);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
