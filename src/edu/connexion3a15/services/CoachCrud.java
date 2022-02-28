/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.connexion3a15.entities.Coach;
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
 * @author 21658
 */
public class CoachCrud implements Utilisateur_CRUD<Coach> {
    

//   public void ajouterCoach(Coach co){
//        try {
//            String requete = "INSERT INTO coach(nom,prenom,num_tel,email,specialite_co ) VALUES (?,?,?,?,?)";
//            PreparedStatement pst =cnx2.prepareStatement(requete);
//            pst.setString(1, co. getNom());
//            pst.setString(2, co.getPrenom());
//            pst.setInt(3, co.getNum_tel());
//            pst.setString(4, co.getEmail());
//            pst.setString(5, co.getSpecialite_co());
//            pst.executeUpdate();
//            System.out.println("Coach ajoutée");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//   public void SupprimerCoach(Coach co) {
//       
//        String req="DELETE FROM coach WHERE id ="+co.getId();
//        try{
//              Statement st=cnx2.createStatement();
//              st.executeUpdate(req);
//              
//              System.out.println("Coach supprimé avec succès");
//           
//        }
//        catch(SQLException ex){  
//         ex.printStackTrace();
//        }
//   }
//   public void ModifierCoach (Coach co, int id) {
//     try{      
//      String req="UPDATE coach SET nom='"+co.getNom()+"',prenom='"+co.getPrenom()+"',num_tel='"+co.getNum_tel()+"',email='"+co.getEmail()+"',specialite_co='"+co.getSpecialite_co()+"' WHERE id=" +id;
//       Statement st=cnx2.createStatement();
//       st.executeUpdate(req);
//        System.out.println("Coach modifie avec succes");
//   
//     }
//     catch(SQLException ex){
//         ex.printStackTrace();
//     }
//   }
//     public List<Coach> listerCoachs(){
//        List<Coach> myList = new ArrayList();
//        try {    
//            String requete="SELECT * FROM coach";
//            Statement st = cnx2.createStatement();
//             ResultSet rs =   st.executeQuery(requete);
//        
//             while(rs.next()){
//                 Coach coa = new Coach();
//                 coa.setId(rs.getInt(1));
//                 coa.setNom(rs.getString("nom"));
//                 coa.setPrenom(rs.getString("prenom"));
//                 coa.setNum_tel(rs.getInt("num_tel"));
//                 coa.setEmail(rs.getString("email"));
//                 coa.setSpecialite_co(rs.getString("specialite_co"));
//                 
//                 
//                 myList.add(coa);
//             }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return myList;
//    }
//     

    @Override
    public void Ajouter(Coach t) {
         try {
            String requete = "INSERT INTO coach(specialite_co ) VALUES (?)";
            String requete1 = "INSERT INTO utilisateur(nom,prenom,num_tel,email ) VALUES (?,?,?,?)";
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete);
             PreparedStatement pst1 =MyConnexion.getInstance().getCnx().prepareStatement(requete1);
             pst.setString(1, t.getSpecialite_co());
            pst1.setString(1, t. getNom());
            pst1.setString(2, t.getPrenom());
            pst1.setInt(3, t.getNum_tel());
            pst1.setString(4, t.getEmail());
            
            pst.executeUpdate();
            System.out.println("Coach ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(int id) {
  try {
            String requete3 ="DELETE FROM coach WHERE id=?";
            String requete4 ="DELETE FROM utilisateur WHERE id=?";
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete3);
            PreparedStatement pst1 =MyConnexion.getInstance().getCnx().prepareStatement(requete4);
            pst.setInt(1, id);
            pst1.setInt(1, id);
            
              pst.executeUpdate();
              pst1.executeUpdate();
          
            System.out.println("coach est supprimee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void Modifier(Coach t) {

 try {
            String requete5 =" UPDATE Coach SET " + " specialite_co= ? WHERE id = ?";
            String requete6 =" UPDATE Utilisateur SET " + " nom= ?,prenom= ?,num_tel=?,email=?  WHERE id = ?";
            
            PreparedStatement pst =MyConnexion.getInstance().getCnx().prepareStatement(requete5);
            PreparedStatement pst1 =MyConnexion.getInstance().getCnx().prepareStatement(requete6);
            pst.setString(1,t.getSpecialite_co());
            pst.setInt(2,t.getId());
            pst1.setString(1,t.getNom());
            pst1.setString(2,t.getPrenom());
            pst1.setInt(3,t.getNum_tel());
            pst1.setString(4,t.getEmail());
             pst1.setInt(5,t.getId());
            pst.executeUpdate();
            pst1.executeUpdate();
            System.out.println("coach  modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }    

    @Override
    public List<Coach> Afficher() {
List<Coach> myList = new ArrayList<>();
        try {
            
            String requete7 = "SELECT * FROM utilisateur";
            
            Statement st = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs = st.executeQuery(requete7);
           while(rs.next()){
               Coach F = new Coach();
               F.setId(rs.getInt("id"));
               F.setNom(rs.getString("nom"));
               F.setPrenom(rs.getString("prenom"));
               F.setNum_tel(rs.getInt("num_tel"));
               F.setEmail(rs.getString("email"));
               
               String requete8 = "SELECT specialite_co FROM coach WHERE id="+F.getId();
               Statement st1 = MyConnexion.getInstance().getCnx().createStatement();
           ResultSet rs1 = st1.executeQuery(requete8);
           if(rs1.next()){   
           F.setSpecialite_co(rs1.getString("specialite_co"));}
               myList.add(F);
               
           }
    }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
        }
    }
     
     
     
     
     
     
     
    

    
    

