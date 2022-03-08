/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Evenement;
import edu.connexion3a15.entities.Reservation;
import edu.connexion3a15.entities.Utilisateur;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author USER
 */
public class ReservationCRUD implements Utilisateur_CRUD<Reservation>{

    @Override
    public void Ajouter(Reservation t) {
       
    try {
            String requete = "INSERT INTO Reservation (nom,nom_e,Date)VALUES(?,?,?)" ;
            PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete);
              pst.setString(1,t.getNom());
            pst.setString(2,t.getNom_e());
            
            pst.setDate(3,new Date(t.getDate().getTime()));
           
           pst.executeUpdate();
            System.out.println("Reservation AJOUTEE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(int id) {
 try {
            String requete3 ="DELETE FROM reservation WHERE id=?";
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete3);
            pst.setInt(1, id);
            
            pst.executeUpdate();
            System.out.println("Reservation est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void Modifier(Reservation t) {
try {
            String requete5 ="UPDATE reservation SET" + " nom=?,nom_e=? WHERE nom=?" ;
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete5);
              pst.setString(1,t.getNom());
            pst.setString(2,t.getNom_e());
            
          
          // pst.setDate(5,new Date(t.getDate().getTime()));
         pst.setString(5,t.getNom());
            
            pst.executeUpdate();
            System.out.println("Reservation  modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public ObservableList<Reservation> Afficher() {
     
        ObservableList<Reservation> myList = FXCollections.observableArrayList();
        try {
           
            String requete="SELECT*FROM reservation";
            Statement st=
                    MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while(rs.next()){
            Reservation r = new Reservation();
            r.setId(rs.getInt(1));
            r.setId(rs.getInt("id"));
                r.setNom(rs.getString("nom"));
                r.setNom_e(rs.getString("nom_e"));
              
               r.setDate(rs.getDate("Date"));
           
                myList.add(r);
            
            
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }

    
//     public ObservableList filecombBox()
//    {
//         ObservableList<Integer> list3 =FXCollections.observableArrayList();
//             
//      try {
//            String req = "select *from utilisateur ";
//            PreparedStatement ps = MyConnexion.getInstance().getCnx().prepareStatement(req);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                list3.add(rs.getInt("id"));
//                 
//            
//            }
//          
//    
//    }   catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//    }
//     return list3;
//     
//    }
//    }
//    

// public ObservableList<Reservation> Afficher(int id) {
//     
//        ObservableList<Reservation> myList = FXCollections.observableArrayList();
//        ObservableList <Utilisateur> clients= FXCollections.observableArrayList();
//        try {
//           
//            String requete="SELECT*FROM reservation";
//            String req = "select Utilisateur.type from Utilisateur,reservation where reservation.id_u=Utilisateur.id=?";
//            Statement st=
//                    MyConnexion.getInstance().getCnx().createStatement();
//            PreparedStatement ps =   MyConnexion.getInstance().getCnx().prepareStatement(req);
//            ps.setInt(1,id);
//            ResultSet rs = st.executeQuery(requete);
//            ResultSet rs2 = ps.executeQuery();
//            rs2.next();
//                   Utilisateur client = new Utilisateur(rs2.getString(1));
//                   clients.add(client);
//            while(rs.next()){
//            Reservation r = new Reservation();
//            r.setId(rs.getInt(1));
//            r.setId(rs.getInt("id"));
//                r.setNom(rs.getString("nom"));
//                r.setNom_e(rs.getString("nom_e"));
//               r.setEmail_cl(rs.getString("email_cl"));
//               r.setDate(rs.getDate("Date"));
//           
//                myList.add(r);
//            
//            
//        }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return myList;
//        }
//
}