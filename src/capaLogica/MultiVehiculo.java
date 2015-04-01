/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jagonchen
 */
public class MultiVehiculo {

    /**
     *
     * @param pplaca
     * @param pmodelo
     * @param pnombrePropietario
     * @param papellidoPropietario
     * @param pestado
     * @return
     */
    public Vehiculo crear(String pplaca, String pmodelo, String pnombrePropietario,
            String papellidoPropietario, String pestado) {

        try {
            Vehiculo vehiculo = null;
            String sql;
            sql = "INSERT INTO TVehiculo "
                    + "(placa, modelo, nombrePropietario, apellidoPropietario, estado) "
                    + "VALUES ('" + pplaca + "', '" + pmodelo + "', '" + pnombrePropietario + "', '" + papellidoPropietario
                    + "', '" + pestado + "');";

            Conector.getConector().ejecutarSQL(sql);
            vehiculo = new Vehiculo(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
            return vehiculo;

        } catch (Exception ex) {
            Logger.getLogger(MultiVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param pplaca
     * @return
     */
    public Vehiculo buscarPorPlaca(String pplaca) {

        try {

            Vehiculo vehiculo = null;

            java.sql.ResultSet rs;
            String sql;
            sql = "SELECT * "
                    + "FROM TVehiculo "
                    + "WHERE placa='" + pplaca + "';";
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("nombrePropietario"),
                        rs.getString("apellidoPropietario"),
                        rs.getString("estado")
                );
            } 
            rs.close();
            return vehiculo;

        } catch (Exception ex) {
            Logger.getLogger(MultiVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @return
     */
    public ArrayList<Vehiculo> buscarTodos() {

        try {
            Vehiculo vehiculo = null;
            ArrayList<Vehiculo> carros = new ArrayList<Vehiculo>();
            java.sql.ResultSet rs;
            String sql;

            sql = "SELECT * "
                    + "FROM TVehiculo ";
            rs = Conector.getConector().ejecutarSQL(sql, true);
            while (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("nombrePropietario"),
                        rs.getString("apellidoPropietario"),
                        rs.getString("estado")
                );
                carros.add(vehiculo);
            }
            rs.close();
            return carros;

        } catch (Exception ex) {
            Logger.getLogger(MultiVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param pplaca
     */
    public void borrarPorPlaca(String pplaca) {
        try {
            String msg;

            java.sql.ResultSet rs;
            String sql;
            sql = "DELETE FROM TVehiculo "
                    + "WHERE placa='" + pplaca + "';";
            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception ex) {
            Logger.getLogger(MultiVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
