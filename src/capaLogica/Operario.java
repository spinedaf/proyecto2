/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pinedas
 */
public class Operario {
    
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Date fechaIngreso;
    private int aniosExperiencia;
    private String cargo;
   
    private SalaDeReparacion  sala;
    
    /**
     *
     * @param pid
     * @param pnombre
     * @param papellido
     * @param ptelefono
     * @param pdireccion
     * @param fecha
     * @param panios
     * @param pcargo
     */
    public Operario(String pid, String pnombre, String papellido, String ptelefono,
            String pdireccion, Date fecha, int panios, String pcargo)
    {
        this.setCargo(pcargo);
        this.setTelefono(ptelefono);
        this.setNombre(pnombre);
        this.setApellido(papellido);
        this.setDireccion(pdireccion);
        this.setAniosExperiencia(panios);
        this.setId(pid);
        this.setFechaIngreso(fecha);
        
    }
    
    /**
     *
     * @param pid
     * @param pnombre
     * @param papellido
     * @param pcargo
     */
    public Operario(String pid, String pnombre, String papellido, String pcargo)
    {
        this(pid,pnombre,papellido,"","",new Date(),0,pcargo);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @return the aniosExperiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param id the id to set
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param apellido the apellido to set
     */
    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @param telefono the telefono to set
     */
    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param direccion the direccion to set
     */
    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    private void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @param aniosExperiencia the aniosExperiencia to set
     */
    private void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * @param cargo the cargo to set
     */
    private void setCargo(String cargo) {
        this.cargo = cargo;
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
    public void setSala(SalaDeReparacion sala) {
        this.sala = sala;
    }
}
