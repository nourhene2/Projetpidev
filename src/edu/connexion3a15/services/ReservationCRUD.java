/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Reservation;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
              pst.setInt(1,t.getId_U());
            pst.setInt(2,t.getId_E());
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
              pst.setInt(1,t.getId_E()); 
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
            r.setId_U(rs.getInt("id_U"));
            r.setId_E(rs.getInt("id_E"));
            r.setDate(rs.getDate("Date"));
            myList.add(r);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }
    }
    

