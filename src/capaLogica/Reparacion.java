/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author pinedas
 */
public class Reparacion {
    
    private String codigo;
    private String nombre;
    private String tipo;
    private Date fechaAsignacion;
    private Date tiempoDeInicio;
    private Date tiempoDeFinalizacion;
    
    private String placaVehiculo;
    private Vehiculo vehiculo;
    private ArrayList<Tarea> listaDeTareas;
    
    /**
     *
     * @param pcodigo
     * @param pnombre
     * @param ptipo
     * @param pfechaAsignacion
     * @param pplacaVehiculo
     */
    public Reparacion(String pcodigo, String pnombre, String ptipo, Date pfechaAsignacion, String pplacaVehiculo)
    {
        this(pcodigo,pnombre, ptipo, pfechaAsignacion,pfechaAsignacion,pfechaAsignacion,pplacaVehiculo);
    }
    
    /**
     *
     * @param pcodigo
     * @param pnombre
     * @param ptipo
     * @param pfechaAsignacion
     * @param ptiempoInicio
     * @param ptiempoFinal
     * @param pplacaVehiculo
     */
    public Reparacion(String pcodigo, String pnombre, String ptipo, Date pfechaAsignacion, Date ptiempoInicio, Date ptiempoFinal, String pplacaVehiculo)
    {
        this.setCodigo(pcodigo);
        this.setNombre(pnombre);
        this.setTipo(ptipo);
        this.setFechaAsignacion(pfechaAsignacion);
        this.setPlacaVehiculo(pplacaVehiculo);
        this.setTiempoDeInicio(ptiempoInicio);
        this.setTiempoDeFinalizacion(ptiempoFinal);
        
        listaDeTareas = new ArrayList<Tarea>();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fechaAsignacion
     */
    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    /**
     * @param fechaAsignacion the fechaAsignacion to set
     */
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    /**
     * @return the tiempoDeInicio
     */
    public Date getTiempoDeInicio() {
        return tiempoDeInicio;
    }

    /**
     * @param tiempoDeInicio the tiempoDeInicio to set
     */
    public void setTiempoDeInicio(Date tiempoDeInicio) {
        this.tiempoDeInicio = tiempoDeInicio;
    }

    /**
     * @return the tiempoDeFinalizacion
     */
    public Date getTiempoDeFinalizacion() {
        return tiempoDeFinalizacion;
    }

    /**
     * @param tiempoDeFinalizacion the tiempoDeFinalizacion to set
     */
    public void setTiempoDeFinalizacion(Date tiempoDeFinalizacion) {
        this.tiempoDeFinalizacion = tiempoDeFinalizacion;
    }

    /**
     * @return the vehiculo
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public Vehiculo getVehiculo() throws
            java.sql.SQLException,Exception{
        if(vehiculo == null){
            vehiculo = new MultiVehiculo().buscarPorPlaca(this.placaVehiculo);
        }
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the listaDeTareas
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public ArrayList<Tarea> getListaDeTareas() throws
            java.sql.SQLException,Exception{
        if(listaDeTareas.isEmpty()){
            this.setListaDeTareas(new MultiTarea().buscarPorReparacion(codigo));
        }
        return listaDeTareas;
    }

    /**
     * @param listaDeTareas the listaDeTareas to set
     */
    public void setListaDeTareas(ArrayList<Tarea> listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }

    /**
     * @return the placaVehiculo
     */
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    /**
     * @param placaVehiculo the placaVehiculo to set
     */
    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
   
    
}
