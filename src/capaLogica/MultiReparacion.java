/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.Conector;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pinedas
 */
public class MultiReparacion {
    
    /**
     *
     * @param pcodigo
     * @param pnombre
     * @param tipo
     * @param pfechaAsignacion
     * @param pplacaVehiculo
     * @return
     */
    public Reparacion crear(String pcodigo, String pnombre, String tipo, Date pfechaAsignacion, String pplacaVehiculo){
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
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return reparacion;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public Reparacion buscar(String codigo){
        Reparacion reparacion = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TReparacion "+
        "WHERE codigoReparacion='"+codigo+"';";
        try {
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
            } 
            rs.close();
            return reparacion;
        } catch (Exception ex) {
            Logger.getLogger(MultiReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param preparacion
     */
    public  void actualizar(Reparacion preparacion){
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
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param pplaca
     * @return
     */
    public ArrayList<Reparacion> buscarPorVehiculo(String pplaca){
	java.sql.ResultSet rs;
        String sql;
        Reparacion reparacion=null;
        ArrayList<Reparacion> reparaciones= new ArrayList<Reparacion>();
        sql="SELECT * "+
        "FROM TReparacion "+
        "WHERE placaVehiculo='"+pplaca+"';";
        try {
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
        } catch (Exception ex) {
            Logger.getLogger(MultiReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Reparacion> buscarTodos(){
	java.sql.ResultSet rs;
        String sql;
        Reparacion reparacion=null;
        ArrayList<Reparacion> reparaciones= new ArrayList<Reparacion>();
        sql="SELECT * "+
        "FROM TReparacion ";
        try {
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
        } catch (Exception ex) {
            Logger.getLogger(MultiReparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param pcodigo
     */
    public  void borrar(String pcodigo){
         
        java.sql.ResultSet rs;
        String sql;
        sql= "DELETE FROM TReparacion "+
        "WHERE codigoReparacion='"+pcodigo+"';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        }
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
