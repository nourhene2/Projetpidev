/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;

/**
 *
 * @author Dhia
 */
public class Produit {
        private int id ;
        private int prix ;
        private int quantite ;
        private String date_exp ;
        private String type ;
        private String promotion ;
        
         public Produit() {
    }

    public Produit(int id, int prix, int quantite,String type , String date_exp, String promotion) {
        this.id = id;
        this.prix = prix;
        this.quantite = quantite;
        this.type= type;
        this.date_exp = date_exp;
        this.promotion = promotion;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate_exp() {
        return date_exp;
    }

    public void setDate_exp(String date_exp) {
        this.date_exp = date_exp;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", prix=" + prix + ", quantite=" + quantite + ", date_exp=" + date_exp + ", type=" + type + ", promotion=" + promotion + '}';
    }

   
        
    
}
