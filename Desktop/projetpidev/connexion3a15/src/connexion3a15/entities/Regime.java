/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion3a15.entities;

/**
 *
 * @author User
 */
public class Regime {
    private int idR;
    
     private String categorie ;
    private  String objectif ;
    private  String image ;
    

    public Regime(int idR, String categorie) {
        this.idR = idR;
        this.categorie = categorie;
    }



    public Regime() {
    }

    public Regime(int idR, String categorie, String objectif, String image) {
        this.idR = idR;
        this.categorie = categorie;
        this.objectif = objectif;
        this.image = image;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Regime(String categorie, String objectif, String image) {
        this.categorie = categorie;
        this.objectif = objectif;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Categorie = "+categorie+" , Objectif ="+objectif;
    }

    
    

    
   
    
}
