/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.connexion3a15.services.ReservationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ResevationController implements Initializable {

    @FXML
    private ComboBox<Integer> combobox1;
    @FXML
    private ComboBox<Integer> combobox2;
    ReservationCRUD r = new ReservationCRUD();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showreservation1();
    }
public void showreservation1(){
    ObservableList<Integer> list2 = (ObservableList<Integer>) r.filecombBox();
    

     combobox1.setItems(list2);
}    
    
}
