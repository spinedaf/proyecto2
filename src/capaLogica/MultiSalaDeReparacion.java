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
    public SalaDeReparacion crear(String pdescripcion, String pubicacion, int pcapacidad) throws
            java.sql.SQLException, Exception {

        SalaDeReparacion sala = null;
        String sql;
        sql = "INSERT INTO TSala "
                + "(descripcionSala, ubicacionSala, capacidadSala) "
                + "VALUES ('" + pdescripcion + "', '" + pubicacion + "', " + pcapacidad + ");";
        try {
            Conector.getConector().ejecutarSQL(sql);
            sala = new SalaDeReparacion(pdescripcion, pubicacion, pcapacidad);

        } catch (Exception e) {
            throw new Exception("No se puede crear  la salsa.");
        }
        return sala;
    }

    /**
     *
     * @param pidTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public SalaDeReparacion buscarSalaDeReparacion(int pidTarea) throws
            java.sql.SQLException, Exception {
        SalaDeReparacion sala = null;
        java.sql.ResultSet rs;

        String sql;
        sql = "SELECT * "
                + "FROM TSala "
                + "WHERE id_sala = " + pidTarea + ";";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()){
            sala = new SalaDeReparacion(
                rs.getString("descripcionSala"),
                rs.getString("ubicacionSala"),
                rs.getInt("capacidadSala")
            );
        } else {
            throw new Exception ("La tarea no esta registrada.");
        }
        
        rs.close();
        return sala;
    }

    /**
     *
     * @param pIdSala
     * @throws SQLException
     * @throws Exception
     */
    public void borrarSalaId(int pIdSala) throws
            java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        String sql;
        sql = "DELETE * "
                + "FROM TSala"
                + "WHERE id_sala='" + pIdSala + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        try {
            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception e) {
            throw new Exception("No hay salas con es id.");
        }
    }

}
