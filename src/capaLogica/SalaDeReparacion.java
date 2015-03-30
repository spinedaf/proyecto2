/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;

/**
 *
 * @author pinedas
 */
public class SalaDeReparacion {
    
    //private String nombre;
    //private int numero;
    private String descripcion;
    private String ubicacion;
    private int capacidad;
    
    private ArrayList<Tarea> listaTareas;
    
    /**
     *
     * @param pdescripcion
     * @param pubicacion
     * @param pcapacidad
     */
    public SalaDeReparacion(String pdescripcion, String pubicacion, int pcapacidad)
    {
        this.setCapacidad(pcapacidad);
        //this.setNombre(pnombre);
        //this.setNumero(pnumero);
        this.setDescripcion(pdescripcion);
        this.setUbicacion(pubicacion);
    }

//    /**
//     * @return the nombre
//     */
//    public String getNombre() {
//        return nombre;
//    }

//    /**
//     * @param nombre the nombre to set
//     */
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }

//    /**
//     * @return the numero
//     */
//    public int getNumero() {
//        return numero;
//    }

//    /**
//     * @param numero the numero to set
//     */
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the listaTareas
     */
    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
