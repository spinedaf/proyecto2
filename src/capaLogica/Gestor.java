/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.Observable;

/**
 *
 * @author pinedas
 */
public class Gestor extends Observable {

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
    public Gestor() {
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
            String pnombrePropietario, String papellidoPropietario, String pestado) {
        Vehiculo instance;

        if (new MultiVehiculo().buscarPorPlaca(pplaca) == null) {
            instance = new MultiVehiculo().crear(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
            this.setMensaje("Vehiculo Registrado");
        }

    }

    public void agregarOperario(String pid, String pnombre, String papellido, String ptelefono,
            String pdireccion, int panios, String pcargo) {
        Operario instance = null;
        MultiOperario multi = new MultiOperario();
        if (multi.buscar(pid) == null) {
            instance = multi.crear(pid, pnombre, papellido, ptelefono, pdireccion, new Date(Calendar.getInstance().getTimeInMillis()),
                    panios, pcargo);
            this.setMensaje("Nuevo Operario Registrado");
        }
    }

    /**
     *
     * @return @throws SQLException
     * @throws Exception
     */
    public String[] obtenerListaVehiculos() {
        ArrayList<Vehiculo> listaVehiculos = (new MultiVehiculo()).buscarTodos();
        String lista[] = new String[listaVehiculos.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaVehiculos.get(i).getPlaca() + "   "
                    + listaVehiculos.get(i).getModelo() + "   "
                    + listaVehiculos.get(i).getNombrePropietario();
        }

        return lista;
    }

    public String[] obtenerListaOperarios() {
        ArrayList<Operario> listaOperarios = (new MultiOperario()).buscarTodos();
        String lista[] = new String[listaOperarios.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaOperarios.get(i).getNombre() + "   "
                    + listaOperarios.get(i).getApellido() + "   "
                    + listaOperarios.get(i).getId();
        }

        return lista;
    }

    public void AgregarPieza(String pcodigoPieza, String pmarca, String ppais,
            String pdescripcion, int pcantidad, String pproblema, int pidTarea) {

        Pieza instance;

        if (new MultiTarea().buscar(pidTarea) != null) {
            instance = new MultiPieza().crear(pcodigoPieza, pmarca, ppais,
                    pdescripcion, pcantidad, pproblema, pidTarea);
            this.setMensaje("Nueva Pieza Registrada");
        } else {
            this.setMensaje("No se pudo registrar la pieza");
        }

    }

    public String[] obtenerListaPiezas() {
        ArrayList<Pieza> listaPiezas = (new MultiPieza()).buscarTodos();
        String lista[] = new String[listaPiezas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaPiezas.get(i).getCodigo() + "   "
                    + listaPiezas.get(i).getMarca()+ "   "
                    + listaPiezas.get(i).getPaisFabricacion() + " "
                    + listaPiezas.get(i).getDescripcionProblema()+ " "
                    + listaPiezas.get(i).getNumeroUnidadesCambiadas()+ " "
                    + listaPiezas.get(i).getIdTareaUsa();
        }

        return lista;
    }

}
