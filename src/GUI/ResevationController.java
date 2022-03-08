/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Reservation;
import edu.connexion3a15.entities.Type;
import edu.connexion3a15.services.ClientCRUD;
import edu.connexion3a15.services.ReservationCRUD;
import edu.connexion3a15.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.activation.DataSource;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ResevationController implements Initializable {

    
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void PlacerReservation(ActionEvent event) {
        ReservationCRUD pcd = new ReservationCRUD();
          
Date Date = new Date(new java.util.Date().getTime());
           String nom =tfNom.getText();
           String nom_e=tfPrenom.getText();
            
            
            Reservation a = new Reservation(nom, nom_e,Date);
        
            a.setDate(Date);
             
            pcd.Ajouter(a);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Resevation ajoutée");
                
                alert.showAndWait();
        
            
    }

    @FXML
    private void ModifierRes(ActionEvent event) {
         ReservationCRUD pcd = new ReservationCRUD();
          
Date Date = new Date(new java.util.Date().getTime());
           String nom =tfNom.getText();
           String nom_e=tfPrenom.getText();
            
            
            Reservation a = new Reservation(nom, nom_e,Date);
        
           a.setDate(Date);
             
            pcd.Modifier(a);
            tfNom.setText("");
        tfPrenom.setText(""); 
       
        
    }
    
}
