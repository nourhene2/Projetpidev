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
            String requete = "INSERT INTO Reservation (id_U,id_E,Date)VALUES(?,?,?)" ;
            PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete);
              pst.setInt(1,t.getUser().getId());
            pst.setInt(2,t.getEvents().getId_e());
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
            String requete5 =" UPDATE reservation SET " + " id_E=? "+" ,date= ? WHERE id = ?";
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete5);
              pst.setInt(1,t.getEvents().getId_e()); 
            pst.setInt(3,t.getId());
          
            pst.setDate(2,new Date(t.getDate().getTime()));
        
            
            pst.executeUpdate();
            System.out.println("Reservation  modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public List<Reservation> Afficher() {
        List<Reservation> myList = new ArrayList<>();
        try {
           
            String requete="SELECT*FROM reservation";
            Statement st=
                    MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while(rs.next()){
            Reservation r = new Reservation();
            r.setId(rs.getInt(1));
            r.setUser(new Utilisateur(rs.getInt(2)));
            r.setEvents (new Evenement(rs.getInt(3)));
            r.setDate(rs.getDate("Date"));
            myList.add(r);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }
    
     public ObservableList filecombBox()
    {
         ObservableList<Integer> list3 =FXCollections.observableArrayList();
             
      try {
            String req = "select *from utilisateur ";
            PreparedStatement ps = MyConnexion.getInstance().getCnx().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list3.add(rs.getInt("id"));
                 
            
            }
          
    
    }   catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
     return list3;
     
    }
    }
    

