/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import edu.connexion3a15.entities.Client;
import edu.connexion3a15.services.ClientCRUD;
import edu.connexion3a15.utils.MyConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
 @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private ComboBox  type;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField email_up;

    @FXML
    private ComboBox type_up;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField txt_lastname_up;
    
 @FXML
    public void LoginpaneShow(){
    
    pane_login.setVisible(true);
    pane_signup.setVisible(false);
    
    }
 @FXML
   public void SignuppaneShow(){
      pane_signup.setVisible(true);
       pane_login.setVisible(false);
       
   
   }
   @FXML
   private void Login(ActionEvent event) throws Exception{
    
       conn = MyConnexion.getInstance().getCnx();
       String sql = "SELECT * FROM utilisateur  where nom =  ? and mdp = ? and Type = ? ";
       try {
           pst = conn.prepareCall(sql);
           pst.setString(1, txt_username.getText());
           pst.setString(2, txt_password.getText());
           pst.setString(3, type.getValue().toString());
           rs = pst.executeQuery();
           if(rs.next()){
           
               System.out.println("Username and Password is correct");
               btn_login.getScene().getWindow().hide();
               if(type.getValue()=="Admin"){
               
               Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
               Stage mainStage = new Stage();
               Scene scene = new Scene(root);
               mainStage.setScene(scene);
               mainStage.show();
               }
           } else {
           
               System.out.println("Invalid Username or password  ");
           }
       }catch(Exception e){}
        System.out.println("");
   }
   
    @FXML
   public void add_users(ActionEvent event){
     conn = MyConnexion.getInstance().getCnx();
     String sql = "insert into utilisateur (nom,prenom,mdp,email,Type) values(?,?,?,?,?)";
     
       try {
           pst = conn.prepareStatement(sql);
           pst.setString(1, txt_username_up.getText());
           pst.setString(2, txt_lastname_up.getText());
           pst.setString(3, txt_password_up.getText());
          // pst.setInt(4,Integer.parseInt(txt_phone_number_up.getText()));
           pst.setString(4, email_up.getText());
           pst.setString(5, type_up.getValue().toString());
           
           pst.execute();
           if(type_up.getValue()=="Client"){
           Client c= new Client(0, txt_username_up.getText(), txt_lastname_up.getText(), email_up.getText(), type_up.getValue().toString(), txt_password_up.getText());
        ClientCRUD c1 = new ClientCRUD();
        pst.execute();
        c1.Ajouter(c);
           }
           
           System.out.println("Saved");
           
       } catch (Exception e) {
           System.out.println("no");
       }
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type_up.getItems().addAll("Admin","Client","nutritionniste","coach");
        type.getItems().addAll("Admin","Client","nutritionniste","coach");
    }    

    
}
