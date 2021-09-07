/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetapoocic.bd;
     


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import projetapoocic.Entites.utilisateur;
import static projetapoocic.bd.Connexion.getConnection;

/**
 *
 * @author Franncois
 */
public class PersonnelDb {
    
    private static Statement state;
    private static PreparedStatement prepare;
    //Connexion con=new Connexion();
    
    public static void ajouterutilisateur(utilisateur a){
     try{

            String sql="INSERT INTO utilisateur ("
                    + "userName,password) VALUES (?,?)";
            prepare =getConnection().prepareStatement(sql);
            prepare.setString(1,a.getUserName());
            prepare.setString(2,a.getPassword());
            prepare.executeUpdate();
            prepare.close();  
        }catch(SQLException ex){
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE,null,ex);
        }
      
   }
   

   
//      
   public static void modifierutilisateur(utilisateur a,int id) {
      try {
            String sql="UPDATE utilisateur SET "
                    + " userName=?,password=?"
                    + "WHERE IDutilisateur=?";
            prepare =getConnection().prepareStatement(sql);
            prepare.setString(3, a.getUserName());
            prepare.setString(4, a.getPassword());
            prepare.setInt(12,id);
            prepare.executeUpdate();           
            
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
   public static boolean supprimerutilisateur(int id) {
      try {
          
            
            String sql="DELETE FROM utilisateur WHERE IDutilisateur=?";
            prepare =getConnection().prepareStatement(sql);
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
   }
   
   
   
  private static String accueil="";
     public static String getAccueil() {
        return accueil;
    }

    public static void setAccueil(String ac) {
        accueil = ac;
    }
    
    public static String name(String username,String password){
      String user = null;
      int i=0;
       try {
            
           String req="SELECT IDPersonnel FROM "
           + "personnel WHERE UserName=? and PassWord=?  ";
                        
           prepare =getConnection().prepareStatement(req);
           prepare.setString(1,username);
           prepare.setString(2,password);
            ResultSet res2=prepare.executeQuery();
                while(res2.next()){
                   nom=res2.getString("IDPersonnel");
                }
                return nom;
                
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }

    
    private static String nom=null;
     public static String getNom() {
        return nom;
    }

    public static void setNom(String ac) {
        nom = ac;
    }

     
   
    public static boolean valider(String mail,String phone) {
       String email="^[a-z]{5,}[0-9]{2,4}@[a-z]{5,10}\\.[a-z]{2,5}$";
       String nb="^(9|7){1}[0-9]{7}$";
       Pattern patt1=Pattern.compile(nb);
       Pattern patt=Pattern.compile(email);
       Matcher match1=patt1.matcher(phone);
       Matcher match=patt.matcher(mail);
       if(match.matches()|(match1.matches())){   
           return true;
       }else{
          return false; 
       }
    }

    
}
