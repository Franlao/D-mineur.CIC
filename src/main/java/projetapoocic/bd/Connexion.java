/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetapoocic.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EDOU Dodji
 */
public class Connexion {
    private static Connection connect;
    private static Statement state;
    private static PreparedStatement prepare;
    private String username="root";
    private String password="";
    String url = "jdbc:mysql://localhost:3306/gesresto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    public Connexion(){
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         connect=DriverManager.getConnection(url,username,password);
        /* String url="jdbc:sqlite:C:\\Program Files (x86)\\Paie\\database\\payement.db";
         Class.forName("org.sqlite.JDBC");
         String url="jdbc:sqlite:C:\\database\\payement.db";
         connect=DriverManager.getConnection(url);*/
         
        }catch(SQLException|ClassNotFoundException ex){
           Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE,null,ex);
           
       }
    }
    
    public static Connection getConnection(){
        
        if(connect==null){
            new Connexion();
        } 
        return connect;
            
    }
    
    public static Statement getStatement(){
        try{
            return getConnection().createStatement();
        }catch(SQLException ex){
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    

    
}
