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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String codigoReparacion, String descripcionSala)
    {
        Timestamp mmddyyyyXmas = 
        new Timestamp(pFecha.getTime()); 
        
        Tarea tarea=null;
        String sql;
        sql = "INSERT INTO TTarea "+
        "(nombreTarea, descripcionTarea, fechaCreacionTarea, duracionPropuestaTarea, duracionRealTarea, id_sala, codigo_reparacion) "+
        "VALUES ('"+pnombre+"', '"+pdescripcion+"', '"+mmddyyyyXmas+"', '"+duracionPropuesta+"', '"+duracionReal+"', '"+descripcionSala
                +"', '"+codigoReparacion+"');";
        try {
            Conector.getConector().ejecutarSQL(sql);
            tarea = new Tarea (pnombre, pdescripcion,pFecha,duracionPropuesta,duracionReal,codigoReparacion,descripcionSala);
            return tarea;
        }
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param pnombre
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Tarea buscar(String pnombre){
        Tarea tarea = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TTarea "+
        "WHERE nombreTarea='"+pnombre+"';";
        try {
            rs = Conector.getConector().ejecutarSQL(sql,true);
            if (rs.next()){
                tarea = new Tarea(
                    rs.getString("nombreTarea"),
                    rs.getString("descripcionTarea"),
                    rs.getDate("fechaCreacionTarea"),
                    rs.getInt("duracionRealTarea"),
                    rs.getInt("duracionPropuestaTarea"),
                    rs.getString("codigo_reparacion"),
                    rs.getString("descripcionSala")
                    );
            } 
            rs.close();
            return tarea;
        } catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public Tarea buscar(int pidTarea){
        Tarea tarea = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TTarea "+
        "WHERE id_tarea='"+pidTarea+"';";
        try {
            rs = Conector.getConector().ejecutarSQL(sql,true);
            if (rs.next()){
                tarea = new Tarea(
                    rs.getString("nombreTarea"),
                    rs.getString("descripcionTarea"),
                    rs.getDate("fechaCreacionTarea"),
                    rs.getInt("duracionRealTarea"),
                    rs.getInt("duracionPropuestaTarea"),
                    rs.getString("codigo_reparacion"),
                    rs.getString("descripcionSala")
                    );
            } 
            rs.close();
            return tarea;
        } catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Tarea> buscarPorReparacion(String codigo){
	java.sql.ResultSet rs;
        String sql;
        Tarea tarea=null;
        ArrayList<Tarea> tareas= new ArrayList<Tarea>();
        sql="SELECT * "+
        "FROM TTarea "+
        "WHERE codigo_reparacion='"+codigo+"';";
        try {
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
                    rs.getString("descripcionSala")
                    );
                tareas.add(tarea);
            }
            rs.close();
            return tareas; 
         } catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param idSala
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Tarea> buscarPorSala(String pdescripcionSala){
	java.sql.ResultSet rs;
        String sql;
        Tarea tarea=null;
        ArrayList<Tarea> tareas= new ArrayList<Tarea>();
        sql="SELECT * "+
        "FROM TTarea "+
        "WHERE descripcionSala='"+pdescripcionSala+"';";
        try {
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
                    rs.getString("descripcionSala")
                    );
                tareas.add(tarea);
            }
            rs.close();
            return tareas;   
        } catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Tarea> buscarTodos(){
	java.sql.ResultSet rs;
        String sql;
        Tarea tarea=null;
        ArrayList<Tarea> tareas= new ArrayList<Tarea>();
        sql="SELECT * "+
        "FROM TTarea ";
        try {
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
                    rs.getString("descripcionSala")
                    );
                tareas.add(tarea);
            }
            rs.close();
            return tareas;   
         } catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param ptarea
     * @throws SQLException
     * @throws Exception
     */
    public  void borrar(Tarea ptarea){
        java.sql.ResultSet rs;
        String sql;
        sql= "DELETE FROM TTarea "+
        "WHERE nombreTarea='"+ptarea.getNombre()+"';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        }
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
