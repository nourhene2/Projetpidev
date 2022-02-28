/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;


/**
 *
 * @author 21658
 */
public class Coach extends Utilisateur{
    
    private String specialite_co ;

    public Coach(String specialite_co) {
        this.specialite_co = specialite_co;
    }

    public Coach(String specialite_co, int id, String nom, String prenom, int num_tel, String email,Type type) {
        super(id, nom, prenom, num_tel, email,type);
        this.specialite_co = specialite_co;
    }

    public Coach() {
    }

    public String getSpecialite_co() {
        return specialite_co;
    }

    public void setSpecialite_co(String specialite_co) {
        this.specialite_co = specialite_co;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "specialite_co=" + specialite_co + '}';
    }
 
}

   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
