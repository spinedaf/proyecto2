/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author pinedas
 */
public class MultiTarea {
    
    public Tarea crear(String pnombre, String pdescripcion)throws
			java.sql.SQLException,Exception
    {
        java.util.Date hoy = new java.util.Date();
        String fechaAbono = new SimpleDateFormat("MM/dd/yyyy").format(hoy);
        SimpleDateFormat mmddyyyyFormat = new SimpleDateFormat("MM/dd/yyyy");
        Timestamp mmddyyyyXmas = 
        new Timestamp(mmddyyyyFormat.parse(fechaAbono).getTime()); 
        
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
    
}
