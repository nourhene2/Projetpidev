/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import connexion3a15.entities.Regime;
import connexion3a15.services.RegimeCRUD;
import connexion3a15.tools.MyConnection;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RegimeController implements Initializable {

    @FXML
    private ChoiceBox<String> tfcategorie;
    @FXML
    private ChoiceBox<String> tfobjectif;
    @FXML
    private TableView<Regime> table;
    @FXML
    private TableColumn<Regime, String> objectif;
    @FXML
    private TableColumn<Regime, String> categorie;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnmodifier;
    public ObservableList<Regime> data = FXCollections.observableArrayList();
   ObservableList<String> categories = FXCollections.observableArrayList("strict","facile","moyen");
 ObservableList<String> objectifs = FXCollections.observableArrayList("gain de poids","perte de poids","garde de poids");
    @FXML
    private TextField image;
    @FXML
    private TableColumn<Regime, String> imagee;
    @FXML
    private Button tftelecharger;
    @FXML
    private Button Btnlister;
    @FXML
    private Label liste;
    @FXML
    private Button btnclcuu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tfcategorie.setItems(categories);
      tfobjectif.setItems(objectifs);
     show();
         final Desktop desktop = Desktop.getDesktop();
         final FileChooser fileChooser = new FileChooser();
       
        tftelecharger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                image.clear();
                fileChooser.setTitle("Select Cours ");
                fileChooser.setInitialDirectory(new File(System.getProperty("C:\\Users\\User\\Desktop\\projetpidev\\connexion3a15\\src\\connexion3a15\\assets"), "C:\\Users\\User\\Desktop\\projetpidev\\connexion3a15\\src\\connexion3a15\\assets"));
                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    List<File> files = Arrays.asList(file);
                  // r.setImage(file.getName());
                  image.setText(file.getName());
               
                }
            }
        });
          // TODO
    }   
          ObservableList<Regime> Regime;
      MyConnection cnx = null;
      Statement st = null;
      RegimeCRUD rcd = new RegimeCRUD();
      Regime r = new Regime();
      public void updateTable_r(){
      Regime = rcd.listerRegime();
        table.getItems().setAll(Regime);
    }
     
private void show(){
     try {
            String requete="SELECT * FROM regime";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
              data.add(new Regime(rs.getString(2),rs.getString(3),rs.getString(4)));}}
     catch (SQLException ex) 
         {
            System.out.println(ex.getMessage());
         }
               categorie.setCellValueFactory(new PropertyValueFactory<Regime,String>("Categorie"));
                 objectif.setCellValueFactory(new PropertyValueFactory<Regime, String>("Objectif"));
                 imagee.setCellValueFactory(new PropertyValueFactory<Regime, String>("Image"));
               
                 table.setItems(data);
    }


    @FXML
    private void AjouterRegime(ActionEvent event) {
    Regime r=new Regime();
 
   
        String categorie_r=tfcategorie.getValue();
        String objectif_r=tfobjectif.getValue();
        String image_r=image.getText();
        RegimeCRUD rc = new  RegimeCRUD();
        r.setCategorie(categorie_r);
        r.setObjectif(objectif_r);
        r.setImage(image_r);
        rc.ajouterRegime(r);
     
      updateTable_r();
      }

    @FXML
    private void SupprimerRegime(ActionEvent event) {
       RegimeCRUD rcd = new RegimeCRUD();
              Regime r= new Regime();  
              r= table.getSelectionModel().getSelectedItem();
              rcd.supprimerRegime(r);

       updateTable_r();}

    @FXML
    private void ModifierRegime(ActionEvent event) {
    
          Regime r=new Regime();
          String categorie_r=tfcategorie.getValue();
          String objectif_r=tfobjectif.getValue();
          String image_r=image.getText();
        
          r.setCategorie(categorie_r);
          r.setObjectif(objectif_r);
            RegimeCRUD rc = new  RegimeCRUD();
          r= table.getSelectionModel().getSelectedItem();
          rc.modifierRegime(r, categorie_r, objectif_r,image_r);
        
       updateTable_r();}

    @FXML
    private void listerr(ActionEvent event) {
      RegimeCRUD rc = new  RegimeCRUD();
//        liste = rc.listerrRegime();
    }

    @FXML
    private void faircalc(ActionEvent event) {
        
             Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("metieer.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Calcul chambre");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
        
        
    }
    
}
