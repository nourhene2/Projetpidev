/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Reservation {
    private int id;
 private int id_U;
   
    private String nom;
    private String nom_e;
  
    private Date Date ;

   

    public int getId_U() {
        return id_U;
    }

    public void setId_U(int id_U) {
        this.id_U = id_U;
    }

    public Reservation(int id, int id_U, String nom, String nom_e, Date Date) {
        this.id = id;
        this.id_U = id_U;
        this.nom = nom;
        this.nom_e = nom_e;
        
        this.Date = Date;
    }

    public Reservation(int id, String nom, String nom_e) {
        this.id = id;
        this.nom = nom;
        this.nom_e = nom_e;
        
    }
    

   
    

    public Reservation( String nom, String nom_e,Date Date) {
     
        this.Date = Date;
        this.nom = nom;
        this.nom_e = nom_e;
        
    }

    
   

    public String getNom() {
        return nom;
    }

    public String getNom_e() {
        return nom_e;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    
    public Reservation() {
    }

   
    public int getId() {
        return id;
    }

    
    public Date getDate() {
        return Date;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_U=" + id_U + ", nom=" + nom + ", nom_e=" + nom_e + ", Date=" + Date + '}';
    }

    

   
   
    

    
    
}
