/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion3a15.tests;

import connexion3a15.entities.Nutritionniste;
import connexion3a15.entities.Regime;

import connexion3a15.entities.Type;
import connexion3a15.services.NutritionnisteCRUD;
import connexion3a15.services.RegimeCRUD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 *
 * @author User
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
  //  MyConnection mc=new MyConnection();}
//    PersonneCRUD pcd=new PersonneCRUD();
    RegimeCRUD rcd=new RegimeCRUD();
//    RegimeCRUD r1cd=new RegimeCRUD();
   //NutritionnisteCRUD ncd=new NutritionnisteCRUD();
   NutritionnisteCRUD n = new NutritionnisteCRUD();
 Nutritionniste n1 = new Nutritionniste("zzzzz", "zzzz", "zzz", "zzz", "hh", Type.Types.nutritionniste);
 Nutritionniste n2= new Nutritionniste("n","zahra", "mm", "g", "hh", Type.Types.nutritionniste);

  /*URL yahoo = new URL("http://localhost:3000/bmi?height=190&weight=90&unit=metric");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
       Float bmi= Float.valueOf(inputLine);
       
        in.close();*/
n.Ajouter(n1);
//n.Modifier(n1,0);
//  System.out.println(n.Afficher());
 //n.Supprimer(5);
//    Personne m=new Personne(52,"m","k");
  
  //  Regime r2 =new Regime(2,"strict","gain");
    //rcd.ajouterRegime(r2);
    //rcd.modifierRegime(r2, "facile", "perte");
      //  System.out.println(rcd.listerRegime());
  //  n.Ajouter(n1);
  // int a= rcd.listerrRegime1();
    //rcd.listerrRegime();
    //pcd.ajouterPersonne2(m);
       // System.out.println(r1.getCategorie());
   // rcd.ajouterRegime(r2);
        
     //rcd.supprimerRegime(r2);
  //  rcd.modifierRegime(r2,"facile","perte");
    //System.out.println(rcd.listerRegime()); 
  // rcd.ajouterRegime(r2) ;
   
   //pcd.ajouterPersonne();
}}
