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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class MultiOperario.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        String id = "123";
        String nombre = "Oldemarsh";
        String apellido = "De Tierra Blanca";
        String telefono = "88888888";
        String direccion = "Tierra Blanca de Cartago";
        int anios = 0;
        String cargo = "Jefe";
        MultiOperario instance = new MultiOperario();
        instance.crear(id, nombre, apellido, telefono, direccion, anios, cargo);
        
        Operario result = instance.buscar(nombre);
        assertEquals(nombre, result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class MultiOperario.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        
        String id = "123";
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
