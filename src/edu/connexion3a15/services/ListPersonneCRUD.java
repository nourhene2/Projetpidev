/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.ListPersonne;
import edu.connexion3a15.entities.Personne;
import edu.connexion3a15.entities.Utilisateur;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ListPersonneCRUD {

    
    public void ajouterPersonne2( ListPersonne p){
        try {
            String requete = "INSERT INTO ListPersonne (id,id_U,id_e)VALUES(?,?,?)" ;
            PreparedStatement pst= MyConnexion.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1,p.getId());
           pst.setInt(2,p.getId_U());
           pst.setInt(3,p.getId_e());
           pst.executeUpdate();
             ClientCRUD c=new ClientCRUD()  ;       
          Client c1=  c.AfficherClient(p.getId_U()) ;
            System.out.println(c1.getNb_fidelite()+1);
          c1.setNb_fidelite(c1.getNb_fidelite()+1);
          c.Modifier(c1);
            System.out.println("Element AJOUTEE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
        public List<ListPersonne>listerPersonne(int id_e){
             List<ListPersonne> mylist=new ArrayList();
        try {
           
            String requete="SELECT * FROM ListPersonne where id_e="+id_e;
            Statement st=
                    MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while(rs.next()){
            ListPersonne per = new ListPersonne();
            per.setId(rs.getInt(1));
            per.setId_U(rs.getInt(2));
            per.setId_e(rs.getInt(3));
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
        }
        public List<ListPersonne>listerEvents(int id_U){
             List<ListPersonne> mylist=new ArrayList();
        try {
           
            String requete="SELECT * FROM ListPersonne where id_U="+id_U;
            Statement st=
                    MyConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while(rs.next()){
            ListPersonne per = new ListPersonne();
            per.setId(rs.getInt(1));
            per.setId_U(rs.getInt(2));
            per.setId_e(rs.getInt(3));
            mylist.add(per);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
        }
}
