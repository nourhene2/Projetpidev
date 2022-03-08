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
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherReservationController implements Initializable {

    @FXML
    private TableColumn<Reservation, String> colnom;
    @FXML
    private TableColumn<Reservation, String> colevents;
    @FXML
    private TableColumn<Reservation, Integer> col_tel;
    @FXML
    private TableColumn<Reservation, String> colemail;
    @FXML
    private TableColumn<Reservation, Date> colDate;
    @FXML
    private TableColumn<Reservation, Type> colType;
    @FXML
    private TableView<Reservation> vbox;
     public ObservableList<Reservation> data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservation();
    }    
    public void showReservation (){
         
         try { 
            String requete="SELECT * FROM Reservation";
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
               
                data.add(new Reservation(rs.getString(2),rs.getString(3),rs.getDate(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        
         
        ReservationCRUD c1 = new ReservationCRUD();
      ObservableList<Reservation> list = c1.Afficher();
      colnom.setCellValueFactory(new PropertyValueFactory<Reservation,String>("nom"));
      colevents.setCellValueFactory(new PropertyValueFactory<Reservation,String>("nom_e"));
      
//      col_tel.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("tel_cl"));
//      colemail.setCellValueFactory(new PropertyValueFactory<Reservation,String>("email_cl"));
      //coltype.setCellValueFactory(new PropertyValueFactory<Client,Type>("type"));
      vbox.setItems(list);
    }
  
}
