/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Personne;
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

//SQLinjection
/**
 *
 * @author USER
 */
public class PersonneCRUD {
    public void ajouterPersonne(){
        try {
            String requete="INSERT INTO personne(nom,prenom) " +
                    "VALUES('TOUNSI','AHMED')";
            Statement st =MyConnexion.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);//hedhi tabaath lil bd
            System.out.println("Personne AJOUTEE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void ajouterPersonne2(Personne p){
        try {
            String requete = "INSERT INTO personne (nom,prenom)VALUES(?,?)" ;
            PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,p.getNom());
           pst.setString(2,p.getPrenom());
           pst.executeUpdate();
            System.out.println("Element AJOUTEE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
        public List<Personne>listerPersonne(){
             List<Personne> mylist=new ArrayList();
        try {
           
            String requete="SELECT*FROM personne";
            Statement st=
                    MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while(rs.next()){
            Personne per = new Personne();
            per.setId(rs.getInt(1));
            per.setNom(rs.getString("nom"));
            per.setPrenom(rs.getString("prenom"));
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
        }
}
