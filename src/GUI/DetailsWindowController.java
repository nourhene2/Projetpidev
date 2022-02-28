/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DetailsWindowController implements Initializable {

    @FXML
    private TextField TextID;
    @FXML
    private TextField TextNom;
    @FXML
    private TextField TextPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     public void setTextID(String message) {
        this.TextID.setText(message);
    }

    public void setTextNom(String message) {
        this.TextNom.setText(message);
    }

    public void setTextPrenom(String message) {
        this.TextPrenom.setText(message);
    }
    
}
