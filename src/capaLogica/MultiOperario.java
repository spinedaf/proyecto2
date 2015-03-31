/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaAccesoBD.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pinedas
 */
public class MultiOperario {
    
    /**
     *
     * @param id
     * @param nombre
     * @param apellido
     * @param telefono
     * @param direccion
     * @param pfecha
     * @param anios
     * @param cargo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Operario crear(String id, String nombre, String apellido, String telefono,
            String direccion, Date pfecha, int anios, String cargo){
        Timestamp mmddyyyyXmas = 
        new Timestamp(pfecha.getTime()); 
        
        Operario operario=null;
        String sql;
        sql = "INSERT INTO TOperario "+
        "(cedulaOperario, nombreOperario, apellidoOperario, telefonoOperario, direccionOperario, fechaIngresoOperario, "
                + "anosExperienciaOperario, cargoOperario) "+
        "VALUES ('"+id+"', '"+nombre+"', '"+apellido+"', '"+telefono+"', '"+
                    direccion+"', '"+ mmddyyyyXmas+"', '"+anios+"', '"+cargo+"')";


        try {
            Conector.getConector().ejecutarSQL(sql);
            operario = new Operario(id, nombre,apellido,telefono,direccion,pfecha,anios,cargo);
        }
        catch (Exception ex) {
            Logger.getLogger(MultiTarea.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return operario;
    }
    
    /**
     *
     * @param pcedula
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public Operario buscar(String pcedula){
        Operario operario = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT * "+
        "FROM TOperario "+
        "WHERE cedulaOperario="+pcedula+";";
        try {
            rs = Conector.getConector().ejecutarSQL(sql,true);
            if (rs.next()){
                operario = new Operario(
                    rs.getString("cedulaOperario"),
                    rs.getString("nombreOperario"),
                    rs.getString("apellidoOperario"),
                    rs.getString("telefonoOperario"),
                    rs.getString("direccionOperario"),
                    rs.getDate("fechaIngresoOperario"),
                    rs.getInt("anosExperienciaOperario"),
                    rs.getString("cargoOperario")
                    );
            }
            rs.close();
            return operario;
        } catch (Exception ex) {
            Logger.getLogger(MultiOperario.class.getName()).log(Level.WARNING, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param pnombreTarea
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Operario> buscarPorTarea(String pnombreTarea){
        java.sql.ResultSet rs;
        String sql;
        Operario operario=null;
        ArrayList<Operario> operarios = new ArrayList<Operario>();
        sql="SELECT * "+
        "FROM TOperario INNER JOIN TTareaOperario " +
        "ON TOperario.cedulaOperario = TTareaOperario.cedulaOperario "+
        "WHERE id_tarea='"+pnombreTarea+"';";
        try {
            Conector.getConector().ejecutarSQL(sql);
            rs = Conector.getConector().ejecutarSQL(sql,true);
            while (rs.next()){
                operario = new Operario(
                    rs.getString("cedulaOperario"),
                    rs.getString("nombreOperario"),
                    rs.getString("apellidoOperario"),
                    rs.getString("telefonoOperario"),
                    rs.getString("direccionOperario"),
                    rs.getDate("fechaIngresoOperario"),
                    rs.getInt("anosExperienciaOperario"),
                    rs.getString("cargoOperario")
                    );
                operarios.add(operario);
            }
            rs.close();
            return operarios;  
        } catch (Exception ex) {
            Logger.getLogger(MultiOperario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Operario> buscarTodos(){
        java.sql.ResultSet rs;
        String sql;
        Operario operario=null;
        ArrayList<Operario> operarios = new ArrayList<Operario>();
        sql="SELECT * "+
        "FROM TOperario INNER JOIN TTareaOperario " +
        "ON TOperario.cedulaOperario = TTareaOperario.cedulaOperario ";
        try {
            Conector.getConector().ejecutarSQL(sql);
            rs = Conector.getConector().ejecutarSQL(sql,true);
            while (rs.next()){
                operario = new Operario(
                    rs.getString("cedulaOperario"),
                    rs.getString("nombreOperario"),
                    rs.getString("apellidoOperario"),
                    rs.getString("telefonoOperario"),
                    rs.getString("direccionOperario"),
                    rs.getDate("fechaIngresoOperario"),
                    rs.getInt("anosExperienciaOperario"),
                    rs.getString("cargoOperario")
                    );
                operarios.add(operario);
            }
            rs.close();
            return operarios;  
        } catch (Exception ex) {
            Logger.getLogger(MultiOperario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param poperario
     * @throws SQLException
     * @throws Exception
     */
    public  void borrar(Operario poperario){
            java.sql.ResultSet rs;
            String sql;
            sql= "DELETE FROM TOperario "+
            "WHERE cedulaOperario='"+poperario.getId()+"';";
            try {
                Conector.getConector().ejecutarSQL(sql);
            }
            catch (Exception ex) {
                Logger.getLogger(MultiOperario.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}
