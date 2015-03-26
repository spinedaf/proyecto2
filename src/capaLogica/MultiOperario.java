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
            "(cedulaOperario, nombreOperario, apellidoOperario, telefonoOperario, direccionOperario, fechaIngresoOperario, "
                    + "anosExperienciaOperario, cargoOperario) "+
            "VALUES ('"+id+"', '"+nombre+"', '"+apellido+"', '"+telefono+"', '"+
                        direccion+"', '"+ mmddyyyyXmas+"', '"+anios+"', '"+cargo+"')";

            
            try {
                Conector.getConector().ejecutarSQL(sql);
                operario = new Operario(id, nombre,apellido,telefono,direccion,hoy,anios,cargo);
            }
            catch (Exception e) {
                throw new Exception ("El operario ya esta en el sistema.");
            }
            return operario;
    }
    
    public Operario buscar(String pcedula) throws
        java.sql.SQLException,Exception{
            Operario operario = null;
            java.sql.ResultSet rs;
            String sql;
            sql = "SELECT * "+
            "FROM TOperario "+
            "WHERE cedulaOperario='"+pcedula+"';";
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
            "WHERE cedulaOperario='"+poperario.getId()+"';";
            try {
                Conector.getConector().ejecutarSQL(sql);
            }
            catch (Exception e) {
                throw new Exception ("Operario tiene entradas.");
            }
	}
}
