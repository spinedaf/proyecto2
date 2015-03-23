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
public class Pieza {
    
    private String codigo;
    private String descripcionProblema;
    private String marca;
    private String paisFabricacion;
    private int numeroUnidadesCambiadas;
    
    private Reparacion reparacion;
    
    public Pieza(String pcodigo, String pdescripcion, String pmarca, String pais, 
            int numeroUnidades)
    {
        this.setCodigo(pcodigo);
        this.setDescripcionProblema(pdescripcion);
        this.setMarca(pmarca);
        this.setPaisFabricacion(pais);
        this.setNumeroUnidadesCambiadas(numeroUnidades);
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
     * @return the descripcionProblema
     */
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    /**
     * @param descripcionProblema the descripcionProblema to set
     */
    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the paisFabricacion
     */
    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    /**
     * @param paisFabricacion the paisFabricacion to set
     */
    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    /**
     * @return the numeroUnidadesCambiadas
     */
    public int getNumeroUnidadesCambiadas() {
        return numeroUnidadesCambiadas;
    }

    /**
     * @param numeroUnidadesCambiadas the numeroUnidadesCambiadas to set
     */
    public void setNumeroUnidadesCambiadas(int numeroUnidadesCambiadas) {
        this.numeroUnidadesCambiadas = numeroUnidadesCambiadas;
    }

    /**
     * @return the reparacion
     */
    public Reparacion getReparacion() {
        return reparacion;
    }

    /**
     * @param reparacion the reparacion to set
     */
    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }
}
