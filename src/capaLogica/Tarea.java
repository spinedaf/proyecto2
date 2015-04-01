/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Hashtable;

/**
 *
 * @author pinedas
 */
public class Tarea {

    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private int duracionPropuesta;
    private int duracionReal;
    private String descripcionSala;  
    private String codigoReparacion;
    
    private SalaDeReparacion sala;
    private Reparacion reparacion;
    private ArrayList<Operario> listaOperarios;
    private ArrayList<Pieza> listaPiezas;
    
    /**
     *
     * @param pnombre
     * @param pdescripcion
     * @param pfechaCreacion
     * @param pduracionReal
     * @param pduracionPropuesta
     * @param pcodigoReparacion
     * @param pDescripcionSala
     */
    public Tarea(String pnombre, String pdescripcion, Date pfechaCreacion, int pduracionReal, int pduracionPropuesta, 
            String pcodigoReparacion, String pDescripcionSala)
    {
        this.setDescripcion(pdescripcion);
        this.setNombre(pnombre);
        this.setFechaCreacion(pfechaCreacion);
        this.setDuracionReal(pduracionReal);
        this.setDuracionPropuesta(pduracionPropuesta);
        this.setCodigoReparacion(pcodigoReparacion);
        this.setDescripcionSala(pDescripcionSala);
        
        sala = null;
        sala = null;
        listaOperarios = new ArrayList<Operario>();
        listaPiezas = new ArrayList<Pieza>();
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
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public SalaDeReparacion getSala(){
        if(sala == null){
            sala = new MultiSalaDeReparacion().buscarSalaDeReparacion(descripcionSala);
        }
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    private void setSala(SalaDeReparacion sala) {
        this.sala = sala;
    }

    /**
     * @return the duracionPropuesta
     */
    public int getDuracionPropuesta() {
        return duracionPropuesta;
    }

    /**
     * @param duracionPropuesta the duracionPropuesta to set
     */
    public void setDuracionPropuesta(int duracionPropuesta) {
        this.duracionPropuesta = duracionPropuesta;
    }

    /**
     * @return the duracionReal
     */
    public int getDuracionReal() {
        return duracionReal;
    }

    /**
     * @param duracionReal the duracionReal to set
     */
    public void setDuracionReal(int duracionReal) {
        this.duracionReal = duracionReal;
    }

    /**
     * @return the descripcionSala
     */
    public String getDescripcionSala() {
        return descripcionSala;
    }

    /**
     * @param pdescripcionSala
     */
    public void setDescripcionSala(String pdescripcionSala) {
        this.descripcionSala = pdescripcionSala;
    }

    /**
     * @return the reparacion
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public Reparacion getReparacion() throws
            java.sql.SQLException,Exception{
        if(reparacion == null){
            this.reparacion = new MultiReparacion().buscar(this.codigoReparacion);
        }
        return reparacion;
    }

    /**
     * @param reparacion the reparacion to set
     */
    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    /**
     * @return the listaOperarios
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public ArrayList<Operario> getListaOperarios(){
        if(listaOperarios.isEmpty()){
            this.setListaOperarios(new MultiOperario().buscarPorTarea(nombre));
        }
        return listaOperarios;
    }

    /**
     * @param listaOperarios the listaOperarios to set
     */
    public void setListaOperarios(ArrayList<Operario> listaOperarios) {
        this.listaOperarios = listaOperarios;
    }

    /**
     * @return the codigoReparacion
     */
    public String getCodigoReparacion() {
        return codigoReparacion;
    }

    /**
     * @param codigoReparacion the codigoReparacion to set
     */
    public void setCodigoReparacion(String codigoReparacion) {
        this.codigoReparacion = codigoReparacion;
    }

    /**
     * @return the listaPiezas
     */
    public ArrayList<Pieza> getListaPiezas() {
        if(listaPiezas.isEmpty()){
            this.setListaPiezas(new MultiPieza().buscarPiezaPorIdTarea(this.nombre));
        }
        return listaPiezas;
    }

    /**
     * @param listaPiezas the listaPiezas to set
     */
    public void setListaPiezas(ArrayList<Pieza> listaPiezas) {
        this.listaPiezas = listaPiezas;
    }
}
