/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Utilisateur;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class ClientCRUD implements Utilisateur_CRUD <Client> {

    @Override
    public void Ajouter(Client t) {
       try {
            String requete = "INSERT INTO Client (nb_fidelite)VALUES(?)" ;
            String requete2 ="INSERT INTO utilisateur (nom,prenom,num_tel,email)VALUES(?,?,?,?)";
            PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete);
            PreparedStatement pst1= MyConnexion.getInstance().getCnx().prepareStatement(requete2);
            pst.setInt(1,t.getNb_fidelite());
            pst1.setString(1,t.getNom());
            pst1.setString(2,t.getPrenom());
            pst1.setInt(3,t.getNum_tel());
            pst1.setString(4,t.getEmail());
            
           pst1.executeUpdate();
           pst.executeUpdate();
           
           
            System.out.println("Element AJOUTEE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(int id) {
       try {
            String requete3 ="DELETE FROM client WHERE id=?";
            String requete4 ="DELETE FROM utilisateur WHERE id=?";
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete3);
            PreparedStatement pst1 =MyConnexion.getInstance().getCnx().prepareStatement(requete4);
            pst.setInt(1, id);
            pst1.setInt(2, id);
            
              pst.executeUpdate();
              pst1.executeUpdate();
          
            System.out.println("client est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(Client t) {
        
        try {
            String requete5 =" UPDATE Client SET " + " nb_fidelite= ? WHERE id = ?";
            String requete6 =" UPDATE Utilisateur SET " + " nom= ?,prenom= ?,num_tel=?,email=?  WHERE id = ?";
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete5);
            PreparedStatement pst1 =MyConnexion.getInstance().getCnx().prepareStatement(requete6);
            pst.setInt(1,t.getNb_fidelite());
            pst.setInt(2,t.getId());
            pst1.setString(1,t.getNom());
            pst1.setString(2,t.getPrenom());
            pst1.setInt(3,t.getNum_tel());
            pst1.setString(4,t.getEmail());
             pst1.setInt(5,t.getId());
            pst.executeUpdate();
            pst1.executeUpdate();
            System.out.println("client  modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }



    @Override
    public List<Client> Afficher() {
       List<Client> myList = new ArrayList<>();
        try {
            
            String requete7 = "SELECT * FROM utilisateur";
            
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs = st.executeQuery(requete7);
           while(rs.next()){
               Client F = new Client();
               F.setId(rs.getInt("id"));
               F.setNom(rs.getString("nom"));
               F.setPrenom(rs.getString("prenom"));
               F.setNum_tel(rs.getInt("num_tel"));
               F.setEmail(rs.getString("email"));
               
               String requete8 = "SELECT nb_fidelite FROM client WHERE id="+F.getId();
               Statement st1 = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs1 = st1.executeQuery(requete8);
           if(rs1.next()){   
           F.setNb_fidelite(rs1.getInt("nb_fidelite"));}
               myList.add(F);
               
           }
    }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }
   public int calculer_nbfidelité(int id_U){
   int nb_fidelite=new ListPersonneCRUD().listerEvents(id_U).size();
 
   
   return nb_fidelite;
   }
    public Client AfficherClient(int id_U) {
       
        try {
            
            String requete7 = "SELECT * FROM utilisateur where id="+id_U;
            
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs = st.executeQuery(requete7);
           String requete8 = "SELECT nb_fidelite FROM client WHERE id="+id_U;
               Statement st1 = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs1 = st1.executeQuery(requete8);
           if(rs.next()&&rs1.next()){
               Client F = new Client();
               F.setId(rs.getInt("id"));
               F.setNom(rs.getString("nom"));
               F.setPrenom(rs.getString("prenom"));
               F.setNum_tel(rs.getInt("num_tel"));
               F.setEmail(rs.getString("email"));
              F.setNb_fidelite(rs1.getInt("nb_fidelite"));
    
           return F;
               
           }
        }
      catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        }
   
}
