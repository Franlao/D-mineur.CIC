
package projetapoocic.Entites;

/***********************************************************************
 * Module:  Personnel.java
 * Author:  francois
 * Purpose: Defines the Class Personnel
 ***********************************************************************/

import java.io.FileInputStream;
import java.sql.Date;


public class utilisateur {
   
    private String userName;
   private String password;


    public utilisateur(String userName,String password) {
    
        this.userName=userName;
        this.password=password;
 
      }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  
   
}