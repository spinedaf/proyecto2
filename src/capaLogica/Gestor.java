/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author pinedas
 */
public class Gestor extends Observable{
    
    private String mensaje;

    /**
     *
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        this.setChanged();
        this.notifyObservers(mensaje);
    }
    
    /**
     *
     */
    public Gestor(){
        this.mensaje = "";
    }
    
    /**
     *
     * @param pplaca
     * @param pmodelo
     * @param pnombrePropietario
     * @param papellidoPropietario
     * @param pestado
     * @throws Exception
     */
    public void agregarVehiculo(String pplaca, String pmodelo, 
            String pnombrePropietario, String papellidoPropietario, String pestado) throws Exception{
        Vehiculo instance; 
        
        if(new MultiVehiculo().buscarPorPlaca(pplaca) == null){
            instance  = new MultiVehiculo().crear(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
            this.setMensaje("Vehiculo Registrado");
        }
        
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<String> obtenerListaVehiculos()throws 
            java.sql.SQLException,Exception
    {
        ArrayList<Vehiculo> listaVehiculos = (new MultiVehiculo()).buscarTodos();
        
         ArrayList<String> lista  = new ArrayList<String>();
        
        
        for(Vehiculo carro: listaVehiculos)
        {
            String info = carro.getPlaca() +" "+ carro.getModelo()+" " + carro.getNombrePropietario();
            
            lista.add(info);
                    
        }
        
       
        return lista; 
    }
    
}
