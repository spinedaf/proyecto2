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
    private String marca;
    private String paisFabricacion;
    private String descripcionPieza;
    private String descripcionProblema;
    private int numeroUnidadesCambiadas;
    private int idTareaUsa;
    private Reparacion reparacion;

    /**
     *
     * @param pcodigo
     * @param pmarca
     * @param pdescripcion
     * @param ppais
     * @param pnumeroUnidades
     * @param pdescripcionProblema
     * @param pidIdTarea
     */
    public Pieza(String pcodigo, String pmarca, String ppais, String pdescripcion,
            int pnumeroUnidades, String pdescripcionProblema, int pidIdTarea) {

        this.setCodigo(pcodigo);
        this.setMarca(pmarca);
        this.setDescripcionPieza(pdescripcion);
        this.setPaisFabricacion(ppais);
        this.setDescripcionProblema(pdescripcionProblema);
        this.setNumeroUnidadesCambiadas(pnumeroUnidades);
        this.setIdTareaUsa(pidIdTarea);
    }

//    public String getDescripcionPieza() {
//        return descripcionPieza;
//    }

    /**
     *
     * @param descripcionPieza
     */
    
    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    /**
     *
     * @return
     */
    public int getIdTareaUsa() {
        return idTareaUsa;
    }

    /**
     *
     * @param idTareaUsa
     */
    public void setIdTareaUsa(int idTareaUsa) {
        this.idTareaUsa = idTareaUsa;
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

//    /**
//     * @return the reparacion
//     */
//    public Reparacion getReparacion() {
//        return reparacion;
//    }

//    /**
//     * @param reparacion the reparacion to set
//     */
//    public void setReparacion(Reparacion reparacion) {
//        this.reparacion = reparacion;
//    }
}
