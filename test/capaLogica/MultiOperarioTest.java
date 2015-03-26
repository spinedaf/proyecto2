/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class MultiOperarioTest {
    
    
    
    public MultiOperarioTest() {
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
        try{
            Files.delete(Paths.get(Conector.getDBPath()));
        }catch(Exception e){}
    }

    /**
     * Test of crear method, of class MultiOperario.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        String id = "123";
        String nombre = "Oldemarsh";
        String apellido = "De Tierra Blanca";
        String telefono = "88888888";
        String direccion = "Tierra Blanca de Cartago";
        int anios = 0;
        String cargo = "Jefe";
        String sala = "Tramado";
        MultiOperario instance = new MultiOperario();
        Operario expResult = new Operario(id,nombre,apellido,telefono, direccion,new Date(),anios,cargo);
        Operario result = instance.crear(id, nombre, apellido, telefono, direccion, anios, cargo);
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getApellido(), result.getApellido());
        assertEquals(expResult.getCargo(), result.getCargo());
        assertEquals(expResult.getDireccion(), result.getDireccion());
        assertEquals(expResult.getTelefono(), result.getTelefono());
        assertEquals(expResult.getFechaIngreso(), result.getFechaIngreso());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MultiOperario.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String id = "1234";
        String nombre = "Oldemarsh";
        String apellido = "De Tierra Blanca";
        String telefono = "88888888";
        String direccion = "Tierra Blanca de Cartago";
        int anios = 0;
        String cargo = "Jefe";
        MultiOperario instance = new MultiOperario();
        instance.crear(id, nombre, apellido, telefono, direccion, anios, cargo);
        
        Operario result = instance.buscar(id);
        assertEquals(nombre, result.getNombre());
        assertEquals(apellido, result.getApellido());
        assertEquals(cargo, result.getCargo());
        assertEquals(direccion, result.getDireccion());
        assertEquals(telefono, result.getTelefono());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class MultiOperario.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        
        String id = "1235";
        String nombre = "Oldemarsh";
        String apellido = "De Tierra Blanca";
        String telefono = "88888888";
        String direccion = "Tierra Blanca de Cartago";
        int anios = 0;
        String cargo = "Jefe";
        MultiOperario instance = new MultiOperario();
        Operario poperario = instance.crear(id, nombre, apellido, telefono, direccion, anios, cargo);
        instance.borrar(poperario);
        
        Operario operarioBorrado = null;
        
        try{
            poperario = instance.buscar("Tarea");
        }catch(Exception e){}
        
        boolean resultado = (operarioBorrado==null?true:false);
        assertEquals(resultado,true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
