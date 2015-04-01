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
     */
    public void agregarVehiculo(String pplaca, String pmodelo,
            String pnombrePropietario, String papellidoPropietario, String pestado) {
        Vehiculo instance;

        if (new MultiVehiculo().buscarPorPlaca(pplaca) == null) {
            instance = new MultiVehiculo().crear(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
            this.setMensaje("Vehiculo Registrado");
        }

    }

    /**
     *
     * @param codigo
     * @param nombre
     * @param tipo
     * @param fecha
     * @param placa
     */
    public void agregarReparacion(String codigo, String nombre, String tipo,
            Date fecha, String placa) {
        Reparacion instance;

        if (new MultiReparacion().buscar(codigo) == null) {
            instance = new MultiReparacion().crear(codigo, nombre, tipo, fecha, placa);
            this.setMensaje("Vehiculo Registrado");
        }

    }

    /**
     *
     * @param pid
     * @param pnombre
     * @param papellido
     * @param ptelefono
     * @param pdireccion
     * @param panios
     * @param pcargo
     */
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
     * @param pdescripcion
     * @param pubicacion
     * @param capacidad
     */
    public void agregarSala(String pdescripcion, String pubicacion, int capacidad) {
        SalaDeReparacion instance = null;
        MultiSalaDeReparacion multi = new MultiSalaDeReparacion();

        if (multi.buscarSalaDeReparacion(pdescripcion) == null) {
            instance = multi.crear(pdescripcion, pubicacion, capacidad);
            this.setMensaje("Nueva Sala Registrada");
        }
    }

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
    public void agregarTarea(String pnombre, String pdescripcion, Date pfechaCreacion,
            int pduracionReal, int pduracionPropuesta, String pcodigoReparacion,
            String pDescripcionSala) {

        Reparacion instance = new MultiReparacion().buscar(pcodigoReparacion);

        if (instance != null) {
            instance.agregarTarea(pnombre, pdescripcion, pfechaCreacion,
                    pduracionReal, pduracionPropuesta, pcodigoReparacion,
                    pDescripcionSala);
            this.setMensaje("Nueva Tarea Registrada");
        }
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaVehiculos() {
        ArrayList<Vehiculo> listaVehiculos = (new MultiVehiculo()).buscarTodos();
        String lista[] = new String[listaVehiculos.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaVehiculos.get(i).getPlaca() + ","
                    + listaVehiculos.get(i).getModelo() + ","
                    + listaVehiculos.get(i).getNombrePropietario() + ","
                    + listaVehiculos.get(i).getEstado()+ ",";
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaSalas() {
        ArrayList<SalaDeReparacion> listaSalas = (new MultiSalaDeReparacion()).buscarTodos();
        String lista[] = new String[listaSalas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaSalas.get(i).getDescripcion() + ","
                    + listaSalas.get(i).getUbicacion() + ","
                    + listaSalas.get(i).getCapacidad();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerPlacasVehiculo() {
        ArrayList<Vehiculo> listaVehiculos = (new MultiVehiculo()).buscarTodos();
        String lista[] = new String[listaVehiculos.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaVehiculos.get(i).getPlaca();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaOperarios() {
        ArrayList<Operario> listaOperarios = (new MultiOperario()).buscarTodos();
        String lista[] = new String[listaOperarios.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaOperarios.get(i).getNombre() + ","
                    + listaOperarios.get(i).getApellido() + ","
                    + listaOperarios.get(i).getId();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerNombreOperarios() {
        ArrayList<Operario> listaOperarios = (new MultiOperario()).buscarTodos();
        String lista[] = new String[listaOperarios.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaOperarios.get(i).getNombre();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaReparaciones() {
        ArrayList<Reparacion> listaReparaciones = (new MultiReparacion()).buscarTodos();
        String lista[] = new String[listaReparaciones.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaReparaciones.get(i).getNombre() + ","
                    + listaReparaciones.get(i).getCodigo() + ","
                    + listaReparaciones.get(i).getTipo();
        }

        return lista;
    }
    
    /**
     *
     * @param pplaca
     * @return
     */
    public String[] obtenerListaTrabajosPorVehiculo(String pplaca)
    {
        ArrayList<Reparacion> listaReparaciones = (new MultiReparacion()).buscarPorVehiculo(pplaca);
        String lista[] = new String[listaReparaciones.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaReparaciones.get(i).getNombre();
        }

        return lista;
    }

    /**
     *
     * @param pcodigoPieza
     * @param pmarca
     * @param ppais
     * @param pdescripcion
     * @param pcantidad
     * @param pproblema
     * @param pNombreTarea
     */
    public void AgregarPieza(String pcodigoPieza, String pmarca, String ppais,
            String pdescripcion, int pcantidad, String pproblema, String pNombreTarea) {

        Pieza instance;

        if (new MultiTarea().buscar(pNombreTarea) != null) {
            instance = new MultiPieza().crear(pcodigoPieza, pmarca, ppais,
                    pdescripcion, pcantidad, pproblema, pNombreTarea);
            this.setMensaje("Nueva Pieza Registrada");
        } else {
            this.setMensaje("No se pudo registrar la pieza");
        }

    }

    /**
     *
     * @param poperarioID
     * @param pdescripcion
     */
    public void agregarTareaOperario(String poperarioID, String pdescripcion) {

        Operario instance = new MultiOperario().buscar(poperarioID);

        if (instance != null) {
            new MultiTarea().agregarOperario(poperarioID, pdescripcion);
            this.setMensaje("Tarea y Operario relacionados");
        }
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaPiezas() {
        ArrayList<Pieza> listaPiezas = (new MultiPieza()).buscarTodos();
        String lista[] = new String[listaPiezas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaPiezas.get(i).getCodigo() + ","
                    + listaPiezas.get(i).getMarca() + ","
                    + listaPiezas.get(i).getPaisFabricacion() + ","
                    + listaPiezas.get(i).getDescripcionProblema() + ","
                    + listaPiezas.get(i).getNumeroUnidadesCambiadas() + ","
                    + listaPiezas.get(i).getTareaUsa();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerListaTareas() {
        ArrayList<Tarea> listaPiezas = (new MultiTarea()).buscarTodos();
        String lista[] = new String[listaPiezas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaPiezas.get(i).getNombre() + ","
                    + listaPiezas.get(i).getDescripcion() + ","
                    + listaPiezas.get(i).getFechaCreacion() + ","
                    + listaPiezas.get(i).getDuracionPropuesta() + ","
                    + listaPiezas.get(i).getDuracionReal() + ","
                    + listaPiezas.get(i).getCodigoReparacion();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerNombresListaTareas() {
        ArrayList<Tarea> listaPiezas = (new MultiTarea()).buscarTodos();
        String lista[] = new String[listaPiezas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaPiezas.get(i).getNombre();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerNombresListaReparaciones() {
        ArrayList<Reparacion> listaReparaciones = (new MultiReparacion()).buscarTodos();
        String lista[] = new String[listaReparaciones.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaReparaciones.get(i).getCodigo();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerNombresListaSalasDeReparacion() {
        ArrayList<SalaDeReparacion> listaSalas = (new MultiSalaDeReparacion()).buscarTodos();
        String lista[] = new String[listaSalas.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaSalas.get(i).getDescripcion();
        }

        return lista;
    }

    /**
     *
     * @return
     */
    public String[] obtenerCedulaOperarios() {
        ArrayList<Operario> listaOperarios = (new MultiOperario()).buscarTodos();
        String lista[] = new String[listaOperarios.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaOperarios.get(i).getId();
        }

        return lista;
    }
}
