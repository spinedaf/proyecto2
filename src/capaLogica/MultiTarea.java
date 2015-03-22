/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pinedas
 */
public class MultiTarea {
    
    public Tarea crear(String pnombre, String pdescripcion)throws
			java.sql.SQLException,Exception
    {
        Date hoy = new Date();
        Timestamp mmddyyyyXmas = 
        new Timestamp(hoy.getTime()); 
        
        Tarea tarea=null;
            String sql;
            sql = "INSERT INTO TTarea "+
            "(nombre, descripcion, fechaCreacion) "+
            "VALUES ('"+pnombre+"', '"+pdescripcion+"', '"+mmddyyyyXmas+"');";
            try {
                Conector.getConector().ejecutarSQL(sql);
                tarea = new Tarea (pnombre, pdescripcion,hoy);
            }
            catch (Exception e) {
                throw new Exception ("El numero de identificaci�n ya esta en el sistema.");
            }
            return tarea;
    }
    
    public Tarea buscar(String pnombre) throws
        java.sql.SQLException,Exception{
            Tarea tarea = null;
            java.sql.ResultSet rs;
            String sql;
            sql = "SELECT nombre,descripcion,fechaCreacion "+
            "FROM TTarea "+
            "WHERE nombre='"+pnombre+"';";
            rs = Conector.getConector().ejecutarSQL(sql,true);
            if (rs.next()){
                tarea = new Tarea(
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDate("fechaCreacion")
                    );
            } else {
                throw new Exception ("La tarea no esta registrada.");
            }
            rs.close();
            return tarea;
    }
    
    public  void borrar(Tarea ptarea) throws
        java.sql.SQLException,Exception{
            java.sql.ResultSet rs;
            String sql;
            sql= "DELETE FROM TTarea "+
            "WHERE nombre='"+ptarea.getNombre()+"';";
            try {
                Conector.getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("La tarea tiene entradas.");
            }
	}
}
