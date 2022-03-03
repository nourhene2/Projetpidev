/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Admin;
import javafx.scene.control.Alert;

/**
 *
 * @author USER
 */
public class Adminlogin {
 
    public void log(Admin ad) {
  
   if (((ad.getUsername().equals("nourhene"))|(ad.getUsername().equals("malek"))|(ad.getUsername().equals("molka"))|(ad.getUsername().equals("mehdi"))|(ad.getUsername().equals("dhia"))|(ad.getUsername().equals("feriel")))&(ad.getPassword().equals("pourlaforme"))){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succéee");
        alert.setContentText("Bienvenu");
        alert.show(); ;
   }else{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Echec");
        alert.setContentText("verifier votre param");
        alert.show(); }
  }
    
    
}


