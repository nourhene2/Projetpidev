/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InscriptionController implements Initializable {

    @FXML
    private Text tfId;
    @FXML
    private Text tfNom;
    @FXML
    private Text tfPrenom;
    @FXML
    private Button vtnvalider;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private ComboBox<?> tftype;
    @FXML
    private TextField tfnum_tel;
    @FXML
    private TextField tfemail;
    @FXML
    private ComboBox<?> type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SavePerson(ActionEvent event) {
    }
    
}
