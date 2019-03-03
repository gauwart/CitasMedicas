package com.mycompany.citasmedicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 *
 * @author Jonatan Santos García
 */
public class Conector {
    
    public static Connection connect = null;
    private java.sql.Statement sql;

    private PreparedStatement pst;

    public void connect(){
    try {
        connect = DriverManager.getConnection("jdbc:sqlite:database.db");
        if (connect!=null) {
            System.out.println("Conectado");
        }
    }catch (SQLException ex) {
        System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
    
    
    public static void close(){
        try {
           connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
