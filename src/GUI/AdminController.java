/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.connexion3a15.entities.Admin;
import edu.connexion3a15.services.Adminlogin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminController implements Initializable {

    @FXML
    private TextField tfuser;
    @FXML
    private PasswordField tfpass;
    @FXML
    private Button vtlog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void start(Stage primaryStage) {
        try { 
            Parent root=
                    FXMLLoader.load(getClass().getResource("Inscription.fxml"));
           
            Scene scene = new Scene(root);
         
           
            primaryStage.setTitle("Inscription");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void Login(ActionEvent event) {
        String username = tfuser.getText();
        String password = tfpass.getText();
       
    Adminlogin A= new Adminlogin();
    Admin ad = new Admin(username, password);
        A.log(ad);
     try {
            
           Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
}
    

