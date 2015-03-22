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
public class MultiOperario {
    
    public Operario crear(String id, String nombre, String apellido, String telefono,
            String direccion, int anios, String cargo)throws
			java.sql.SQLException,Exception
    {
        Date hoy = new Date();
        Timestamp mmddyyyyXmas = 
        new Timestamp(hoy.getTime()); 
        
        Operario operario=null;
            String sql;
            sql = "INSERT INTO TOperario "+
            "(identificacion, nombre, apellido, telefono, direccion, fechaIngreso, "
                    + "aniosExperiencia, cargo) "+
            "VALUES ('"+id+"', '"+nombre+"', '"+apellido+"', '"+telefono+"', '"+
                        direccion+"', '"+ mmddyyyyXmas+"', '"+anios+"', '"+cargo+"');";
            try {
                Conector.getConector().ejecutarSQL(sql);
                operario = new Operario(id, nombre,apellido,telefono,direccion,hoy,anios,cargo);
            }
            catch (Exception e) {
                throw new Exception ("El numero de identificaci�n ya esta en el sistema.");
            }
            return operario;
    }
}
