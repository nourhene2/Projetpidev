/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;
/**
 *
 * @author USER
 */
public  class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
 
    private String email;
    private String type;
    private String mdp;
    public Utilisateur(int id, String nom, String prenom,String mdp , String email,String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp=mdp;
        
        this.email = email;
        this.type=type;
        
        
    }

    public Utilisateur(String nom) {
        this.nom = nom;
    }
    

    public Utilisateur(String nom, String prenom, String email, String type, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        
        this.email = email;
        this.type = type;
        this.mdp = mdp;
    }
    

    public Utilisateur(int id) {
        this.id = id;
    }

    public  Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType(Type type) {
        return type;
    }
  public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", type=" + type + ", mdp=" + mdp + '}';
    }

    

    

    
    
    
}
