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
    private Hashtable<String,Operario> listaOperarios;
    
    public Tarea(String pnombre, String pdescripcion, Date pfecha)
    {
        this.setDescripcion(pdescripcion);
        this.setNombre(pnombre);
        this.setFechaCreacion(pfecha);
        
        listaOperarios = new Hashtable<String,Operario>();
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
    
    public void agregarOperario(Operario pOperario)
    {
        if(pOperario != null)
        {
            listaOperarios.put(pOperario.getId(), pOperario);
        }
    }

    /**
     * @return the sala
     */
    public SalaDeReparacion getSala() {
        return sala;
    }

    /**
     * @return the listaOperarios
     */
    public ArrayList<Operario> getListaOperarios() {
        ArrayList<Operario> lista = new ArrayList<Operario>();
        for(Operario op: listaOperarios.values())
        {
            lista.add(op);
        }
        return lista;
    }

    /**
     * @param sala the sala to set
     */
    private void setSala(SalaDeReparacion sala) {
        this.sala = sala;
    }
}
