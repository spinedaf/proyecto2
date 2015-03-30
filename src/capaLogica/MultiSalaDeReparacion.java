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
                + "VALUES ('" + pdescripcion + "', '" + pubicacion + "', " + pcapacidad +  ");";
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
    public ArrayList<SalaDeReparacion>  buscarSalaDeReparacion(int pidTarea) throws
            java.sql.SQLException, Exception {
        SalaDeReparacion sala = null;
        ArrayList<SalaDeReparacion> salas= new ArrayList<>();
        java.sql.ResultSet rs;
      
        String sql;
        sql = "SELECT * "
                + "FROM TSala "
                + "WHERE id_sala = " + pidTarea + ";";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()) {
            sala = new SalaDeReparacion(
                    rs.getString("descripcionSala"),
                    rs.getString("ubicacionSala"),
                    rs.getInt("capacidadSala")
            );
            salas.add(sala);
        } else {
            throw new Exception("No hay piezas para una tarea que no existe.");
        }
        rs.close();
        return salas;
    }

    /**
     *
     * @param pIdSala
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public String borrarSalaId(int pIdSala) throws
            java.sql.SQLException, Exception {
        String msg;
        java.sql.ResultSet rs;
        String sql;
        sql = "DELETE * "
                + "FROM TSala"
                + "WHERE id_sala='" + pIdSala + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()) {
            msg = "Registro Eliminado";
        } else {
            msg = "Registro No eliminado";
            throw new Exception("No hay salas con ese id.");
        }
        rs.close();
        return msg;
    }
    

        
    

   
}
