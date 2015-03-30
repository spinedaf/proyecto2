/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

/**
 *
 * @author pinedas
 */
public class Vehiculo {
    
    private String placa;
    private String modelo;
    private String nombrePropietario;
    private String apellidoPropietario;
    private String estado;
    
    /**
     *
     * @param pplaca
     * @param pmodelo
     * @param pnombrePropietario
     * @param papellidoPropietario
     * @param pestado
     */
    public Vehiculo(String pplaca, String pmodelo, String pnombrePropietario, String papellidoPropietario, String pestado) {
        this.setPlaca(pplaca);
        this.setModelo(pmodelo);
        this.setNombrePropietario(pnombrePropietario);
        this.setApellidoPropietario(papellidoPropietario);
        this.setEstado(pestado);
    }

    /**
     *
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     *
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     *
     * @param nombrePropietario
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    /**
     *
     * @return
     */
    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    /**
     *
     * @param apellidoPropietario
     */
    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
