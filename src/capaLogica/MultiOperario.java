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
    
    public  void actualizarSala(Operario poperario) throws 
			java.sql.SQLException,Exception{
        String sql;
        sql = "UPDATE TOperario "+
        "SET sala='"+poperario.getSala()+"' "+
        "WHERE identificacion='"+poperario.getId()+"';";
        try {
                Conector.getConector().ejecutarSQL(sql);
        }
        catch (Exception e) {
                throw new Exception ("El Operario no esta registrado.");
        }
    }
    
    public Operario buscar(String pnombre) throws
        java.sql.SQLException,Exception{
            Operario operario = null;
            java.sql.ResultSet rs;
            String sql;
            sql = "SELECT identificacion,nombre,apellido,telefono,direccion,fechaIngreso,aniosExperiencia,cargo,sala "+
            "FROM TOperario "+
            "WHERE nombre='"+pnombre+"';";
            rs = Conector.getConector().ejecutarSQL(sql,true);
            if (rs.next()){
                operario = new Operario(
                    rs.getString("identificacion"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getDate("fechaIngreso"),
                    rs.getInt("aniosExperiencia"),
                    rs.getString("cargo")
                    );
            } else {
                throw new Exception ("Operario no esta registrado.");
            }
            rs.close();
            return operario;
    }
    
    public  void borrar(Operario poperario) throws
        java.sql.SQLException,Exception{
            java.sql.ResultSet rs;
            String sql;
            sql= "DELETE FROM TOperario "+
            "WHERE nombre='"+poperario.getNombre()+"';";
            try {
                Conector.getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("Operario tiene entradas.");
            }
	}
}
