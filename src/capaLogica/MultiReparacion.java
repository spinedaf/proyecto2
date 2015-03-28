/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author pinedas
 */
public class MultiReparacion {
    
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
                rs.getDate("tiempoInicioReparacion"),
                rs.getDate("tiempoFinReparacion"),
                rs.getString("placaVehiculo")
                );
        } else {
            throw new Exception ("La reparacion no esta registrada.");
        }
        rs.close();
        return reparacion;
    }

    public  void actualizar(Reparacion preparacion) throws
                    java.sql.SQLException,Exception{
        Timestamp mmddyyyyXmas = new Timestamp(preparacion.getFechaAsignacion().getTime());
        Timestamp mmddyyyyXmas2 = new Timestamp(preparacion.getTiempoDeInicio().getTime());
        Timestamp mmddyyyyXmas3 = new Timestamp(preparacion.getTiempoDeFinalizacion().getTime());
        
        String sql;
        sql="UPDATE TReparacion "+
        "SET nombreReparacion='"+preparacion.getNombre()+"', "+
        "tipoReparacion='"+preparacion.getTipo()+"', "+
        "fechaAsignacionReparacion='"+mmddyyyyXmas+"', "+
        "tiempoInicioReparacion='"+mmddyyyyXmas2+"', "+
        "tiempoFinReparacion='"+mmddyyyyXmas3+"', "+
        "placaVehiculo='"+preparacion.getPlacaVehiculo()+"' "+
        "WHERE codigoReparacion='"+preparacion.getCodigo()+"';";
        try {
            Conector.getConector().ejecutarSQL(sql); 	
        }
        catch (Exception e) {
            throw new Exception ("La reparacion no esta registrada.");
        }
    }
    
    public ArrayList<Reparacion> buscarPorVehiculo(String pplaca)throws java.sql.SQLException,Exception{
	java.sql.ResultSet rs;
        String sql;
        Reparacion reparacion=null;
        ArrayList<Reparacion> reparaciones= new ArrayList<Reparacion>();
        sql="SELECT * "+
        "FROM TReparacion "+
        "WHERE placaVehiculo='"+pplaca+"';";
        Conector.getConector().ejecutarSQL(sql);
        rs = Conector.getConector().ejecutarSQL(sql,true);
        while (rs.next()){
            reparacion = new Reparacion(
                rs.getString("codigoReparacion"),
                rs.getString("nombreReparacion"),
                rs.getString("tipoReparacion"),
                rs.getDate("fechaAsignacionReparacion"),
                rs.getDate("tiempoInicioReparacion"),
                rs.getDate("tiempoFinReparacion"),
                rs.getString("placaVehiculo")
                );
            reparaciones.add(reparacion);
        }
        rs.close();
        return reparaciones;    
    }
    
     public  void borrar(Reparacion preparacion) throws
        java.sql.SQLException,Exception{
         
        java.sql.ResultSet rs;
        String sql;
        sql= "DELETE FROM TReparacion "+
        "WHERE codigoReparacion='"+preparacion.getCodigo()+"';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        }
        catch (Exception e) {
            throw new Exception ("La reparacion tiene entradas.");
        }
    }
}
