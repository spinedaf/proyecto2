/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author pinedas
 */
public class Tarea {

    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    
    private SalaDeReparacion sala;
    private Operario operario;
    
    public Tarea(String pnombre, String pdescripcion, Date pfecha)
    {
        this.setDescripcion(pdescripcion);
        this.setNombre(pnombre);
        this.setFechaCreacion(pfecha);
        
        sala = null;
        operario = null;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the sala
     */
    public SalaDeReparacion getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    private void setSala(SalaDeReparacion sala) {
        this.sala = sala;
    }

    /**
     * @return the operario
     */
    public Operario getOperario() {
        return operario;
    }

    /**
     * @param operario the operario to set
     */
    public void setOperario(Operario operario) {
        this.operario = operario;
    }
}
