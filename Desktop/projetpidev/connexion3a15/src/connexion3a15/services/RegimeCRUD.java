/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion3a15.services;


import connexion3a15.entities.Regime;
import connexion3a15.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

/**
 *
 * @author User
 */
public class RegimeCRUD {
    
         public  void ajouterRegime(Regime r)
        { 
                  String requete="INSERT INTO regime (Categorie,Objectif,Image)VALUES(?,?,?)";

          try {
          PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(requete);
          pst.setString(1,r.getCategorie());
          pst.setString(2,r.getObjectif()); 
          pst.setString(3,r.getImage()); 
             // System.out.println(r.getCategorie().toString());
              
           pst.executeUpdate();
          System.out.println("element Ajouteé!");
                 
        } catch (SQLException ex) {
                  System.out.println(ex.getMessage());}
            
       
         
        }
      

public  ObservableList<Regime> listerRegime(){
      
      ObservableList<Regime>myList= FXCollections.observableArrayList();
      
       try {
             String requete="SELECT * FROM regime";
             Statement st= MyConnection.getInstance().getCnx().createStatement();
             ResultSet rs = st.executeQuery(requete);
              while(rs.next()){
              Regime r = new Regime();
             r.setIdR(rs.getInt(1));
             r.setCategorie(rs.getString("Categorie"));
             r.setObjectif(rs.getString("Objectif"));
             r.setImage(rs.getString("Image"));
           
                myList.add(r);
              }
             
         } catch (SQLException ex) {
              System.out.println(ex.getMessage());
         }
       return myList;
      }
 
 public void supprimerRegime(Regime r){
     
    
         try {
             String requete3="DELETE FROM regime WHERE IdR ="+r.getIdR();
             Statement st= MyConnection.getInstance().getCnx().prepareStatement(requete3);
           
           st.executeUpdate(requete3);
             System.out.println("regime supprimer!");
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());          }
             
       }
        public void modifierRegime(Regime r,String categorie , String objectif, String image){
      
         try {
           String requete2="UPDATE regime SET Categorie = ? ,Objectif = ?, Image= ? WHERE IdR=" + r.getIdR();

             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete2);
             ps.setString(1,categorie);
             ps.setString(2,objectif);
             ps.setString(3,image);
            ps.executeUpdate();
               System.out.println("regime Modifier!");
         } catch (SQLException ex) {
                    System.err.println(ex.getMessage());  }
          
         
       }
         
      

//public void listerrRegime(){
//           String requete ="SELECT categorie , COUNT(categorie) AS nb_regime   FROM regime GROUP BY categorie";
//        try {
//            PreparedStatement  ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
//              ResultSet rs =ps.executeQuery(requete);
//              
//              while(rs.next()){
//              int nb=rs.getInt("nb_regime");
//              
//              
//             String nbb=rs.getString("categorie");
//              System.out.println("le nombre des regime du categorie "+nbb+" est :"+nb);
//             
//              }
//           
//          } catch (SQLException ex) {
//          System.out.println(ex.getMessage());
//          }
//           
//           
//          }  
        
        public void listerrRegime(){
           String requete ="SELECT categorie , COUNT(categorie) AS nb_regime   FROM regime GROUP BY categorie";
        try {
            PreparedStatement  ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
              ResultSet rs =ps.executeQuery(requete);
              
              while(rs.next()){
              int nb=rs.getInt("nb_regime");
              
              
             String nbb=rs.getString("categorie");
              System.out.println("le nombre des regime du categorie "+nbb+" est :"+nb);
            
             
              }
           
          } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          }
        
        }
        
     public int countStrict(String strict) {
   int i = 0;
   

	try{
		try{
           Statement  ps = MyConnection.getInstance().getCnx().createStatement();
			String query = "SELECT COUNT(*) FROM regime WHERE categorie ='strict'";
			ResultSet rs=ps.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des Stricts(*)="+rs.getInt("COUNT(*)"));
                            i++;
			  }
			// close ResultSet rs
		   } catch(SQLException s){						
				s.printStackTrace();
			 }
		// close Connection and Statement
		}catch (Exception e){
			e.printStackTrace();
		 }
        return  i;    }
      public int countFacile(String facile) {
   int i = 0;
   

	try{
		try{
           Statement  ps = MyConnection.getInstance().getCnx().createStatement();
			String query = "SELECT COUNT(*) FROM regime WHERE categorie ='facile'";
			ResultSet rs=ps.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des facile(*)="+rs.getInt("COUNT(*)"));
                            i++;
			  }
			// close ResultSet rs
		   } catch(SQLException s){						
				s.printStackTrace();
			 }
		// close Connection and Statement
		}catch (Exception e){
			e.printStackTrace();
		 }
        return  i;    }
      
      
          public int countMoyen(String facile) {
   int i = 0;
   

	try{
		try{
           Statement  ps = MyConnection.getInstance().getCnx().createStatement();
			String query = "SELECT COUNT(*) FROM regime WHERE categorie ='moyen'";
			ResultSet rs=ps.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des moyen(*)="+rs.getInt("COUNT(*)"));
                            i++;
			  }
			// close ResultSet rs
		   } catch(SQLException s){						
				s.printStackTrace();
			 }
		// close Connection and Statement
		}catch (Exception e){
			e.printStackTrace();
		 }
        return  i;    }
      
}
