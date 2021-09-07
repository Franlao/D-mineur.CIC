/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetapoocic.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author francois
 */
public class authentification {
    
    
        public authentification(){
    
       }

      public boolean authentificate(String login ,String pass)
      {
         String username = "root";
         String password = "";
         String url = "jdbc:mysql://localhost:3306/demineur";
 
         try
         {
			//connexion base
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(url,username,password);
            Statement instruction = connexion.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM utilisateur");
 
            while(resultat.next())
            {
 
              if( login.equals(resultat.getString("username"))&& pass.equals(resultat.getString("password")))
               {
                   return true;
               } else {
                   return false;
               }
               
 
            }
         }
            catch (Exception e)
            {
               System.out.println("echec pilote : "+e);
            }
            return true;
      
   }

}
