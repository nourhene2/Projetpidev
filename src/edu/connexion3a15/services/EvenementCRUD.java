/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Evenement;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EvenementCRUD implements Utilisateur_CRUD<Evenement>{

    @Override
     public void Ajouter(Evenement e) {
        try {
            String requete1 = "INSERT INTO evenements(nom_e,descp_e,nbr_pers,nbr_places,date_debut,date_fin) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = MyConnexion.getInstance().getCnx().prepareStatement(requete1);
            pst.setString(1, e.getNom_e());
            pst.setString(2, e.getDescp_e());
            pst.setInt(3, e.getNbr_pers());
            pst.setInt(4,e.getNbr_places());
            pst.setDate(5, e.getDate_debut());
            pst.setDate(6, e.getDate_fin());
            pst.executeUpdate();
            System.out.println("Evenement ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
         @Override
    public List<Evenement> Afficher() {
        List<Evenement> myList = new ArrayList();
        try {

            String requete2 = "Select * FROM evenements";
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                Evenement eve = new Evenement();
                eve.setId_e(rs.getInt(1));
                eve.setNom_e(rs.getString("nom_e"));
                eve.setDescp_e(rs.getString("descp_e"));
                eve.setNbr_pers(rs.getInt(4));
                eve.setNbr_places(rs.getInt(5));
                eve.setDate_debut(rs.getDate("date_debut"));
                eve.setDate_debut(rs.getDate("date_fin"));
                myList.add(eve);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return myList;
    }
  
           @Override
    public void Supprimer(int id_e){
            
    String requete3="DELETE FROM evenements WHERE id_e=?";
        try {
           PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete3);
            pst.setInt(1, id_e);
             pst.executeUpdate();
             System.out.println("Evenement supprimé !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
     public void Modifier(Evenement t){
          try{ 
            String requete5 =" UPDATE evenements SET nom_e = ? , descp_e=?, nbr_pers=?, nbr_places=?, date_debut=? ,date_fin=? WHERE id_e = ?";
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete5);
                       
                        pst.setString(1, t.getNom_e());
                        pst.setString(2, t.getDescp_e());
                        pst.setInt(3, t.getNbr_pers());
                        pst.setInt(4, t.getNbr_pers());
                        pst.setDate(5, t.getDate_debut());
                        pst.setDate(6,t.getDate_fin());
                         pst.setInt(7, t.getId_e());
            pst.executeUpdate();
            System.out.println("Evenement modifié !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
                

    }
    

