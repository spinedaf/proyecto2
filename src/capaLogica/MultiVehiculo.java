/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * @throws SQLException
     * @throws Exception
     */
    public Vehiculo crear(String pplaca, String pmodelo, String pnombrePropietario,
            String papellidoPropietario, String pestado) throws
            java.sql.SQLException, Exception {

        Vehiculo vehiculo = null;
        String sql;
        sql = "INSERT INTO TVehiculo "
                + "(placa, modelo, nombrePropietario, apellidoPropietario, estado) "
                + "VALUES ('" + pplaca + "', '" + pmodelo + "', '" + pnombrePropietario + "', '" + papellidoPropietario
                + "', '" + pestado + "');";
        try {
            Conector.getConector().ejecutarSQL(sql);
            vehiculo = new Vehiculo(pplaca, pmodelo, pnombrePropietario, papellidoPropietario, pestado);
        } catch (Exception e) {
            throw new Exception("Ya existe un vehiculo registrado con esa placa.");
        }
        return vehiculo;
    }

    /**
     *
     * @param pplaca
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Vehiculo buscarPorPlaca(String pplaca) throws
            java.sql.SQLException, Exception {
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
        } else {
            rs.close();
            return vehiculo;
           
        }
        rs.close();
        return vehiculo;
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Vehiculo> buscarTodos() throws
            java.sql.SQLException, Exception {
        Vehiculo vehiculo = null;
        java.sql.ResultSet rs;
        String sql;
        ArrayList<Vehiculo> carros = new ArrayList<Vehiculo>(); 
        sql = "SELECT * "
                + "FROM TVehiculo ";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        while(rs.next()){
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
    }
    
    /**
     *
     * @param pplaca
     * @throws SQLException
     * @throws Exception
     */
    public void borrarPorPlaca(String pplaca) throws
            java.sql.SQLException, Exception {
        String msg;

        java.sql.ResultSet rs;
        String sql;
        sql = "DELETE FROM TVehiculo "
                + "WHERE placa='" + pplaca + "';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception e) {
            throw new Exception("No hay vehiculo con esa placa.");
        }
    }

}
