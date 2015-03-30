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
public class MultiPieza {

    /**
     *
     * @param pcodigoPieza
     * @param pmarca
     * @param ppais
     * @param pdescripcion
     * @param pcantidad
     * @param pproblema
     * @param pidTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Pieza crear(String pcodigoPieza, String pmarca, String ppais,
            String pdescripcion, int pcantidad, String pproblema, int pidTarea) throws
            java.sql.SQLException, Exception {

        Pieza pieza = null;
        String sql;
        sql = "INSERT INTO TPieza "
                + "(codigoPieza, marca, pais, descripcion, cantidad, problema, id_tarea) "
                + "VALUES ('" + pcodigoPieza + "', '" + pmarca + "', '" + ppais + "', "
                + "'" + pdescripcion + "', " + pcantidad + ", '" + pproblema + "' ,"+ pidTarea + ");";
        try {
            Conector.getConector().ejecutarSQL(sql);
            pieza = new Pieza(pcodigoPieza, pmarca, ppais, pdescripcion,
                    pcantidad, pproblema, pidTarea);

        } catch (Exception e) {
            throw new Exception("No se puedo ingresar la pieza.");
        }
        return pieza;
    }

    /**
     *
     * @param pidTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Pieza>  buscarPiezaPorIdTarea(int pidTarea) throws
            java.sql.SQLException, Exception {
        Pieza pieza = null;
        ArrayList<Pieza> piezas= new ArrayList<Pieza>();
        java.sql.ResultSet rs;
      
        String sql;
        sql = "SELECT * "
                + "FROM TPieza "
                + "WHERE id_tarea=" + pidTarea + ";";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()) {
            pieza = new Pieza(
                    rs.getString("codigoPieza"),
                    rs.getString("marca"),
                    rs.getString("pais"),
                    rs.getString("descripcion"),
                    rs.getInt("cantidad"),
                    rs.getString("problema"),
                    rs.getInt("id_tarea")
            );
            piezas.add(pieza);
        } else {
            throw new Exception("No hay piezas para una tarea que no existe.");
        }
        rs.close();
        return piezas;
    }

    /**
     *
     * @param pidTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public String borrarPorTarea(int pidTarea) throws
            java.sql.SQLException, Exception {
        String msg;
        java.sql.ResultSet rs;
        String sql;
        sql = "DELETE * "
                + "FROM TPieza "
                + "WHERE id_tarea='" + pidTarea + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()) {
            msg = "Registro Eliminado";
        } else {
            msg = "Registro No eliminado";
            throw new Exception("No hay piezas para una tarea que no existe.");
        }
        rs.close();
        return msg;
    }
}
