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
     */
    public Pieza crear(String pcodigoPieza, String pmarca, String ppais,
            String pdescripcion, int pcantidad, String pproblema, String pNombreTarea) {

        try {
            Pieza pieza = null;
            String sql;
            sql = "INSERT INTO TPieza "
                    + "(codigoPieza, marca, pais, descripcion, cantidad, problema, nombreTarea) "
                    + "VALUES ('" + pcodigoPieza + "', '" + pmarca + "', '" + ppais + "', "
                    + "'" + pdescripcion + "', " + pcantidad + ", '" + pproblema + "', '" + pNombreTarea + "')";

            Conector.getConector().ejecutarSQL(sql);
            pieza = new Pieza(pcodigoPieza, pmarca, ppais, pdescripcion,
                    pcantidad, pproblema, pNombreTarea);

            return pieza;
        } catch (Exception ex) {
            Logger.getLogger(MultiPieza.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param pidTarea
     * @return
     */
    public ArrayList<Pieza> buscarPiezaPorIdTarea(String pNombreTarea) {

        try {
            Pieza pieza = null;
            ArrayList<Pieza> piezas = new ArrayList<Pieza>();
            java.sql.ResultSet rs;

            String sql;
            sql = "SELECT * "
                    + "FROM TPieza "
                    + "WHERE nombreTarea='" + pNombreTarea + "';";
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs.next()) {
                pieza = new Pieza(
                        rs.getString("codigoPieza"),
                        rs.getString("marca"),
                        rs.getString("pais"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getString("problema"),
                        rs.getString("nombreTarea")
                );
                piezas.add(pieza);
            }
            rs.close();
            return piezas;
        } catch (Exception ex) {
            Logger.getLogger(MultiPieza.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Pieza> buscarTodos() {

        try {
            Pieza pieza = null;
            ArrayList<Pieza> piezas = new ArrayList<Pieza>();
            java.sql.ResultSet rs;

            String sql;
            sql = "SELECT * "
                    + "FROM TPieza ";
            rs = Conector.getConector().ejecutarSQL(sql, true);
            while (rs.next()) {
                pieza = new Pieza(
                        rs.getString("codigoPieza"),
                        rs.getString("marca"),
                        rs.getString("pais"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getString("problema"),
                        rs.getString("nombreTarea")
                );
                piezas.add(pieza);
            }
            rs.close();
            return piezas;
        } catch (Exception ex) {
            Logger.getLogger(MultiPieza.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param pidTarea
     */
    public void borrarPorTarea(String pNombreTarea) {

        try {
            java.sql.ResultSet rs;
            String sql;
            sql = "DELETE * "
                    + "FROM TPieza "
                    + "WHERE id_tarea='" + pNombreTarea + "';";

            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception ex) {
            Logger.getLogger(MultiPieza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

}
