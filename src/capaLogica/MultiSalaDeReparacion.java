/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.ArrayList;

import capaAccesoBD.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jagonchen
 */
public class MultiSalaDeReparacion {

    /**
     *
     * @param pdescripcion
     * @param pubicacion
     * @param pcapacidad
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public SalaDeReparacion crear(String pdescripcion, String pubicacion, int pcapacidad) {

        try {
            SalaDeReparacion sala;
            String sql;
            sql = "INSERT INTO TSala "
                    + "(descripcionSala, ubicacionSala, capacidadSala) "
                    + "VALUES ('" + pdescripcion + "', '" + pubicacion + "', "
                    + pcapacidad + ");";

            Conector.getConector().ejecutarSQL(sql);
            sala = new SalaDeReparacion(pdescripcion, pubicacion, pcapacidad);
            return sala;
        } catch (Exception ex) {
            Logger.getLogger(MultiSalaDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param pidTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public SalaDeReparacion buscarSalaDeReparacion(String pdescripcionSala) {

        try {
            SalaDeReparacion sala = null;
            java.sql.ResultSet rs;

            String sql;
            sql = "SELECT * "
                    + "FROM TSala "
                    + "WHERE descripcionSala = " + pdescripcionSala + ";";

            rs = Conector.getConector().ejecutarSQL(sql, true);
            
             if (rs.next()){
                sala = new SalaDeReparacion(
                    rs.getString("descripcionSala"),
                    rs.getString("ubicacionSala"),
                    rs.getInt("capacidadSala")
                    );
            } 
            
            
            return sala;
        } catch (Exception ex) {
            Logger.getLogger(MultiSalaDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<SalaDeReparacion> buscarTodos() {

        try {

            SalaDeReparacion sala = null;
            java.sql.ResultSet rs;
            ArrayList<SalaDeReparacion> salas = new ArrayList<SalaDeReparacion>();
            String sql;
            sql = "SELECT * "
                    + "FROM TSala ";

            rs = Conector.getConector().ejecutarSQL(sql, true);

            while (rs.next()) {
                sala = new SalaDeReparacion(
                        rs.getString("descripcionSala"),
                        rs.getString("ubicacionSala"),
                        rs.getInt("capacidadSala")
                );
                salas.add(sala);
            }

            rs.close();
            return salas;
        } catch (Exception ex) {
            Logger.getLogger(MultiSalaDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param pIdSala
     * @throws SQLException
     * @throws Exception
     */
    public void borrarSalaId(int pIdSala) {
        try {

            java.sql.ResultSet rs;
            String sql;
            sql = "DELETE * "
                    + "FROM TSala"
                    + "WHERE id_sala='" + pIdSala + "';";

            rs = Conector.getConector().ejecutarSQL(sql, true);
            Conector.getConector().ejecutarSQL(sql);
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(MultiSalaDeReparacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
