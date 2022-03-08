/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Type;
import edu.connexion3a15.entities.Utilisateur;
import edu.connexion3a15.services.ClientCRUD;
import edu.connexion3a15.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private ComboBox<String> tftype;
    @FXML
    private TextField tfnum_tel;
    @FXML
    private TextField tfemail;
    @FXML
    private PasswordField tfmdp;
    @FXML
    private TableView<Client> vbox;
    @FXML
    private TableColumn<Client, Integer> colid;
    @FXML
    private TableColumn<Client, String> colnom;
    @FXML
    private TableColumn<Client, String> colprenom;
    @FXML
    private TableColumn<Client, String> colpassword;
    @FXML
    private TableColumn<Client, Integer> colnum;
    @FXML
    private TableColumn<Client, String> colemail;
    @FXML
    private TableColumn<Client, Type> coltype;
    @FXML
    private Button deletef;
    @FXML
    private Button updatef;
    ClientCRUD hs = new ClientCRUD();
    @FXML
    private TableColumn<Client, Integer> colnb_fidelite;
    public ObservableList<Client> data=FXCollections.observableArrayList();
    @FXML
    private Button exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> list = FXCollections.observableArrayList("Client","Nutritionnist","Coach");
        tftype.setItems(list);
        showClient();
        
        
    }    

 private boolean nomvalide(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(tfnom.getText());
        if(m.find() && m.group().equals(tfnom.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate First Name");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid First Name");
                alert.showAndWait();
           
            return false;            
        }
     }
    private boolean Prenomvalide(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(tfprenom.getText());
        if(m.find() && m.group().equals(tfprenom.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate prenom");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid prenom");
                alert.showAndWait();
           
            return false;            
        }
         
    }
    private boolean Numtelvalide(){
        Pattern p = Pattern.compile("[1-7]{8}");
        Matcher m = p.matcher(tfprenom.getText());
        if(m.find() && m.group().equals(tfprenom.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate prenom");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid prenom");
                alert.showAndWait();
           
            return false;            
        }
         
    }
    @FXML
    private void Select(ActionEvent event) {
        String s= tftype.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    private void SaveUser(ActionEvent event) {
      //if(nomvalide()&&Prenomvalide()&&Numtelvalide()
//               int id = Integer.parseInt(tfid.getText());
        String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String mdp = tfmdp.getText();
//        int num_tel = Integer.parseInt(tfnum_tel.getText());
        String email = tfemail.getText();
        String type = tftype.getValue();
        
       
        
        Client c= new Client(0, nom, prenom, email, type, mdp);
        ClientCRUD c1 = new ClientCRUD();
        c1.Ajouter(c);
        updateTable2();
       if((!tfnom.getText().isEmpty())||(!tfprenom.getText().isEmpty())||(!tfmdp.getText().isEmpty())
               ||(!tfemail.getText().isEmpty())||(!tfnum_tel.getText().isEmpty())){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Client ajoutée");
                
                alert.showAndWait();
        
       }
       else{
           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Ajouter un client ");
           alert.setHeaderText("Information");
           alert.setContentText("Erreur d'ajout !");
           alert.showAndWait();
       }
    }


    @FXML
    private void click_deleteclient(ActionEvent event) {
       
        ClientCRUD c1 = new ClientCRUD();
        Client c = new Client();
        c=vbox.getSelectionModel().getSelectedItem();
       c1.Supprimer(c);
       updateTable2();
           showClient ();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Client supprimé");
                
                alert.showAndWait();
    }

    @FXML
    private void click_updateclient(ActionEvent event) {
    
 int id = Integer.parseInt(tfid.getText());
        String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String mdp = tfmdp.getText();
//        int num_tel = Integer.parseInt(tfnum_tel.getText());
        String email = tfemail.getText();
        String type = tftype.getValue();
        
        Client c= new Client(id, nom, prenom, mdp, email, type);
        ClientCRUD c1 = new ClientCRUD();
      
        c1.Modifier(c);
     updateTable2();
      tfid.setText("");
        tfnom.setText(""); 
        tfprenom.setText("");
        tfmdp.setText("");
        tfnum_tel.setText(""); 
        tfemail.setText(""); 
        tftype.setValue(""); 
        showClient();
            if((!tfid.getText().isEmpty())||(!tfnom.getText().isEmpty())||(!tfprenom.getText().isEmpty())||(!tfmdp.getText().isEmpty())
               ||(!tfemail.getText().isEmpty())||(!tfnum_tel.getText().isEmpty())){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Client is updated successfully!");
        alert.show();
        
    }}
     public void showClient (){
         
         try { 
            String requete="SELECT * FROM Client";
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
               
                data.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        
         
        ClientCRUD c1 = new ClientCRUD();
      ObservableList<Client> list = c1.Afficher();
      colid.setCellValueFactory(new PropertyValueFactory<Client,Integer>("id"));
      
      colnom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
      colprenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
      colpassword.setCellValueFactory(new PropertyValueFactory<Client,String>("mdp"));
      
      colemail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
      coltype.setCellValueFactory(new PropertyValueFactory<Client,Type>("type"));
      colnb_fidelite.setCellValueFactory(new PropertyValueFactory<Client,Integer>("nb_fidelite"));
      vbox.setItems(list);
    }
     
     ObservableList<Client> Client ;
     MyConnexion cnx = null;
     Statement st = null;
     ClientCRUD c = new ClientCRUD();
     
     
     
    public void updateTable2(){
        Client = c.Afficher();
        vbox.getItems().setAll(Client);
    }

    @FXML
    private void exit(ActionEvent event) {
        try {
            
           Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }
}
