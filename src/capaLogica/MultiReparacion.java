/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author pinedas
 */
public class MultiReparacion {
    
    String updateString;
    String insertString;
    PreparedStatement updateReparacion;
    
    public MultiReparacion()
    {
        updateString = "UPDATE TReparacion "+
		"SET codigoReparacion= ?, "+
		"nombreReparacion= ?, "+
		"tipoReparacion= ?, "+
                "fechaAsignacionReparacion= ?, "+
                "placaVehiculo= ?, "+
		"WHERE codigoReparacion= ?;";
        
    }
    
    public Reparacion crear(String pcodigo, String pnombre, String tipo, Date pfechaAsignacion, String pplacaVehiculo)throws
			java.sql.SQLException,Exception   
    {
        Timestamp mmddyyyyXmas = 
        new Timestamp(pfechaAsignacion.getTime());
        
        Reparacion reparacion=null;
        String sql;
        sql = "INSERT INTO TReparacion "+
        "(codigoReparacion, nombreReparacion, tipoReparacion, fechaAsignacionReparacion, placaVehiculo) "+
        "VALUES ('"+pcodigo+"', '"+pnombre+"', '"+tipo+"', '"+mmddyyyyXmas+"', '"+pplacaVehiculo+"')";


        try {
            Conector.getConector().ejecutarSQL(sql);
            reparacion = new Reparacion(pcodigo, pnombre, tipo,pfechaAsignacion,pplacaVehiculo);
        }
        catch (Exception e) {
            throw new Exception ("La reparacion ya esta en el sistema.");
        }
        return reparacion;
    }
    
    public Reparacion buscar(String codigo)throws
        java.sql.SQLException,Exception{
        Reparacion reparacion = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TReparacion "+
        "WHERE codigoReparacion='"+codigo+"';";
        rs = Conector.getConector().ejecutarSQL(sql,true);
        if (rs.next()){
            reparacion = new Reparacion(
                rs.getString("codigoReparacion"),
                rs.getString("nombreReparacion"),
                rs.getString("tipoReparacion"),
                rs.getDate("fechaAsignacionReparacion"),
                rs.getString("placaVehiculo")
                );
        } else {
            throw new Exception ("La tarea no esta registrada.");
        }
        rs.close();
        return reparacion;
    }

}
