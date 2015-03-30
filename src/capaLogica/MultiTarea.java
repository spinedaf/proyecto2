/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author pinedas
 */
public class MultiTarea {
    
    /**
     *
     * @param pnombre
     * @param pdescripcion
     * @param pFecha
     * @param duracionReal
     * @param duracionPropuesta
     * @param codigoReparacion
     * @param idSala
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Tarea crear(String pnombre, String pdescripcion, Date pFecha, int duracionReal, int duracionPropuesta, 
            String codigoReparacion, int idSala)throws
			java.sql.SQLException,Exception
    {
        Timestamp mmddyyyyXmas = 
        new Timestamp(pFecha.getTime()); 
        
        Tarea tarea=null;
        String sql;
        sql = "INSERT INTO TTarea "+
        "(nombreTarea, descripcionTarea, fechaCreacionTarea, duracionPropuestaTarea, duracionRealTarea, id_sala, codigo_reparacion) "+
        "VALUES ('"+pnombre+"', '"+pdescripcion+"', '"+mmddyyyyXmas+"', '"+duracionPropuesta+"', '"+duracionReal+"', '"+idSala
                +"', '"+codigoReparacion+"');";
        try {
            Conector.getConector().ejecutarSQL(sql);
            tarea = new Tarea (pnombre, pdescripcion,pFecha,duracionPropuesta,duracionReal,codigoReparacion,idSala);
        }
        catch (Exception e) {
            throw new Exception ("El nombre de tarea ya esta en el sistema.");
        }
        return tarea;
    }
    
    /**
     *
     * @param pnombre
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Tarea buscar(String pnombre) throws
        java.sql.SQLException,Exception{
        Tarea tarea = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TTarea "+
        "WHERE nombreTarea='"+pnombre+"';";
        rs = Conector.getConector().ejecutarSQL(sql,true);
        if (rs.next()){
            tarea = new Tarea(
                rs.getString("nombreTarea"),
                rs.getString("descripcionTarea"),
                rs.getDate("fechaCreacionTarea"),
                rs.getInt("duracionRealTarea"),
                rs.getInt("duracionPropuestaTarea"),
                rs.getString("codigo_reparacion"),
                rs.getInt("id_sala")
                );
        } else {
            throw new Exception ("La tarea no esta registrada.");
        }
        rs.close();
        return tarea;
    }
    
    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Tarea> buscarPorReparacion(String codigo)throws java.sql.SQLException,Exception{
	java.sql.ResultSet rs;
        String sql;
        Tarea tarea=null;
        ArrayList<Tarea> tareas= new ArrayList<Tarea>();
        sql="SELECT * "+
        "FROM TTarea "+
        "WHERE codigo_reparacion='"+codigo+"';";
        Conector.getConector().ejecutarSQL(sql);
        rs = Conector.getConector().ejecutarSQL(sql,true);
        while (rs.next()){
            tarea = new Tarea(
                rs.getString("nombreTarea"),
                rs.getString("descripcionTarea"),
                rs.getDate("fechaCreacionTarea"),
                rs.getInt("duracionRealTarea"),
                rs.getInt("duracionPropuestaTarea"),
                rs.getString("codigo_reparacion"),
                rs.getInt("id_sala")
                );
            tareas.add(tarea);
        }
        rs.close();
        return tareas;    
    }
    
    /**
     *
     * @param idSala
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Tarea> buscarPorSala(int idSala)throws java.sql.SQLException,Exception{
	java.sql.ResultSet rs;
        String sql;
        Tarea tarea=null;
        ArrayList<Tarea> tareas= new ArrayList<Tarea>();
        sql="SELECT * "+
        "FROM TTarea "+
        "WHERE id_sala='"+idSala+"';";
        Conector.getConector().ejecutarSQL(sql);
        rs = Conector.getConector().ejecutarSQL(sql,true);
        while (rs.next()){
            tarea = new Tarea(
                rs.getString("nombreTarea"),
                rs.getString("descripcionTarea"),
                rs.getDate("fechaCreacionTarea"),
                rs.getInt("duracionRealTarea"),
                rs.getInt("duracionPropuestaTarea"),
                rs.getString("codigo_reparacion"),
                rs.getInt("id_sala")
                );
            tareas.add(tarea);
        }
        rs.close();
        return tareas;    
    }
    
    /**
     *
     * @param ptarea
     * @throws SQLException
     * @throws Exception
     */
    public  void borrar(Tarea ptarea) throws
        java.sql.SQLException,Exception{
            java.sql.ResultSet rs;
            String sql;
            sql= "DELETE FROM TTarea "+
            "WHERE nombreTarea='"+ptarea.getNombre()+"';";
            try {
                Conector.getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("La tarea tiene entradas.");
            }
	}
}
