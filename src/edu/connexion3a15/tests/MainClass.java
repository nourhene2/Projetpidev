/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.tests;

import edu.connexion3a15.entities.Client;
import edu.connexion3a15.entities.Coach;
import edu.connexion3a15.entities.Evenement;
import edu.connexion3a15.entities.ListPersonne;
import edu.connexion3a15.entities.Personne;
import edu.connexion3a15.entities.Reservation;
import edu.connexion3a15.entities.Type;
import edu.connexion3a15.services.ClientCRUD;
import edu.connexion3a15.services.CoachCrud;
import edu.connexion3a15.services.EvenementCRUD;
import edu.connexion3a15.services.ListPersonneCRUD;
import edu.connexion3a15.services.PersonneCRUD;
import edu.connexion3a15.services.ReservationCRUD;
import edu.connexion3a15.utils.MyConnexion;
import java.sql.Date;

/**
 *
 * @author USER
 */
public  class MainClass {
     
    public static void main(String[] args) {
       // MyConnexion mc =new MyConnexion();
//        PersonneCRUD P = new PersonneCRUD();
//        Personne m = new Personne(52,"BEN SALAH","HEDI");
//        //P.ajouterPersonne2(m);
//        System.out.println(P.listerPersonne());
        
       // P.ajouterPersonne();
       Client c = new Client(1, 0, "nourhene", "liheouel", 97427003, "nourhene.liheouel@esprit.tn", Type.Client);
        Evenement e = new Evenement(0, "nn", "nn", 0, 5, new Date(20200103), new Date(20200103));
        EvenementCRUD e1 = new EvenementCRUD();
        e1.Ajouter(e);
        ListPersonne l = new ListPersonne(0, 4, 1);
        ListPersonneCRUD l1 = new ListPersonneCRUD();
        l1.ajouterPersonne2(l);
//       Client c3 = new Client(8,8,"nour","kammoun",97427003,"nour.kammoun@esprit.tn");
//       Client c4 = new Client(8,16,"mehdi","kammoun",97427003,"nour.kammoun@esprit.tn");
       ClientCRUD c1= new ClientCRUD();
       //c1.Ajouter(c4);
//       c1.Ajouter(c);
       //c1.Supprimer(3);
//       c1.Modifier( c3);
//      System.out.println(c1.Afficher());
//        Reservation R=new Reservation(1, 10, 9, new Date());
//        Reservation R2=new Reservation(2, 4, 7, new Date());
//        ReservationCRUD R1 = new  ReservationCRUD();
//        //R1.Ajouter(R);
////        
//        R1.Supprimer(4);
////        System.out.println(R1.Afficher());
////        R1.Modifier(R);
////        R1.Supprimer(2);
////        System.out.println(R1.Afficher());
//        CoachCrud cd = new CoachCrud();
        
        
//        Coach a1=new Coach("dm", 7, "nourhene", "liheouel", 0, "nourhene.lihiouel@es");
        //cd.Ajouter(a1);
        //cd.Supprimer(8);
        //System.out.println(cd.Afficher());
        //cd.Modifier(a1);
        //cd.Supprimer(7);
    }
}
