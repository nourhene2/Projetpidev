/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;


import  edu.connexion3a15.entities.Produit;
import  edu.connexion3a15.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhia
 */
public class ProduitCRUD {
Connection cnx2;

    public ProduitCRUD() {
        cnx2 =MyConnexion.getInstance().getCnx();
        
    }
    
    public void ajouterProduit(){
        try {
            String requete ="INSERT INTO produit(prix,quantite,date_exp,type,promotion)" + "VALUES(1 ,2 ,'elair','elair','elair')";
            Statement st = cnx2.createStatement();  //objet ramener la requette vers sjbd w yekhou resultat;
        st.executeUpdate(requete); //mise a jours de base de donne 
            System.out.println("Produit ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println("ex.getMessage()"); 
        }
        
    }
     public void ajouterProduit2(Produit P){
        try {
            String requete2 ="INSERT INTO Produit(prix,quantite,date_exp,type,promotion)" + "VALUES(?,?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete2);
            pst.setInt(1, P.getPrix());
            pst.setInt(2, P.getQuantite());
            pst.setString(3, P.getDate_exp());
            pst.setString(4, P.getType());
            pst.setString(5, P.getPromotion());
            
            
            pst.executeUpdate();
            System.out.println("votre Produit est ajoutee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public List<Produit>afficherProduit(){
       List<Produit> myList = new ArrayList<>();
        try {
            
            String requete3 = "SELECT * FROM produit";
            Statement st = cnx2.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               Produit P = new Produit();
               P.setId(rs.getInt(1));
               P.setPrix(rs.getInt("prix"));
               P.setQuantite(rs.getInt("quantite"));
               P.setDate_exp(rs.getString("date_exp"));
               P.setType(rs.getString("type"));
               P.setPromotion(rs.getString("promotion"));
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
        
   }  
   public void supprimerProduit(int id){
        try {
            String requete3 ="DELETE FROM produit WHERE id=?";
            PreparedStatement pst =cnx2.prepareStatement(requete3);
            pst.setInt(1, id);
            
            pst.executeUpdate();
            System.out.println("votre produit est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public void updateProduit(int id, int prix, int quantite,String type , String date_exp, String promotion){
        try {
            String requete4 =" UPDATE produit SET " + " prix = ?, quantite = ?, type = ?, date_exp = ?, promotion = ? WHERE id = ?";
            PreparedStatement pst =cnx2.prepareStatement(requete4);
                        pst.setInt(6, id);
                       pst.setInt(1, prix);
                        pst.setInt(2, quantite);
                        pst.setString(3, date_exp);
                        pst.setString(4, type);
                        pst.setString(5, promotion);
                        pst.executeUpdate();
            System.out.println("votre produit est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
        
    }
