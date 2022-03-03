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
    private int num_tel;
    private String email;
    private Type.Types type;
    private String mdp;
    public Utilisateur(int id, String nom, String prenom,String mdp ,int num_tel, String email,Type.Types type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp=mdp;
        this.num_tel = num_tel;
        this.email = email;
        this.type=type;
        
        
    }

    public Utilisateur(String nom, String prenom, int num_tel, String email, Type.Types type, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
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

    public int getNum_tel() {
        return num_tel;
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

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType(Type type) {
        return type;
    }
  public Type.Types getType() {
        return type;
    }

    public void setType(Type.Types type) {
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
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + ", email=" + email + ", type=" + type + ", mdp=" + mdp + '}';
    }

    

    
    
    
}
