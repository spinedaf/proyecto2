/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author pinedas
 */
public class MultiReparacion {
    
    public Reparacion crear(String pnombre, String tipo, Date pfechaAsignacion, String pplacaVehiculo)throws
			java.sql.SQLException,Exception   
    {
        Timestamp mmddyyyyXmas = 
        new Timestamp(pfechaAsignacion.getTime());
        
        Reparacion reparacion=null;
        String sql;
        sql = "INSERT INTO TReparacion "+
        "(nombreReparacion, tipoReparacion, fechaAsignacionReparacion, placaVehiculo) "+
        "VALUES ('"+pnombre+"', '"+tipo+"', '"+mmddyyyyXmas+"', '"+pplacaVehiculo+"')";


        try {
            Conector.getConector().ejecutarSQL(sql);
            reparacion = new Reparacion(pnombre, tipo,pfechaAsignacion,pplacaVehiculo);
        }
        catch (Exception e) {
            throw new Exception ("La reparacion ya esta en el sistema.");
        }
        return reparacion;
    }
    
}
