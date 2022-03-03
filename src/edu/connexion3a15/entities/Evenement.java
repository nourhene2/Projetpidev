/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Evenement {
    private  int id_e;
    private String nom_e;
    private String descp_e;
    private int nbr_pers;
    private int nbr_places;
    private Date date_debut;
    private Date date_fin;
    
    
   public Evenement(){}

    public Evenement(int id_e) {
        this.id_e = id_e;
    }

    public Evenement(String nom_e, String descp_e, int nbr_pers, int nbr_places, Date date_debut, Date date_fin) {
        this.nom_e = nom_e;
        this.descp_e = descp_e;
        this.nbr_pers = nbr_pers;
        this.nbr_places = nbr_places;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Evenement(int id_e, String nom_e, String descp_e, int nbr_pers, int nbr_places, Date date_debut, Date date_fin) {
        this.id_e = id_e;
        this.nom_e = nom_e;
        this.descp_e = descp_e;
        this.nbr_pers = nbr_pers;
        this.nbr_places = nbr_places;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

  
 
    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public String getNom_e() {
        return nom_e;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    public String getDescp_e() {
        return descp_e;
    }

    public void setDescp_e(String descp_e) {
        this.descp_e = descp_e;
    }

    public int getNbr_pers() {
        return nbr_pers;
    }

    public void setNbr_pers(int nbr_pers) {
        this.nbr_pers = nbr_pers;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_e=" + id_e + ", nom_e=" + nom_e + ", descp_e=" + descp_e + ", nbr_pers=" + nbr_pers + ", nbr_places=" + nbr_places + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.id_e;
        hash = 61 * hash + Objects.hashCode(this.nom_e);
        hash = 61 * hash + Objects.hashCode(this.descp_e);
        hash = 61 * hash + this.nbr_pers;
        hash = 61 * hash + this.nbr_places;
        hash = 61 * hash + Objects.hashCode(this.date_debut);
        hash = 61 * hash + Objects.hashCode(this.date_fin);
        return hash;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id_e != other.id_e) {
            return false;
        }
        if (this.nbr_pers != other.nbr_pers) {
            return false;
        }
        if (this.nbr_places != other.nbr_places) {
            return false;
        }
        if (!Objects.equals(this.nom_e, other.nom_e)) {
            return false;
        }
        if (!Objects.equals(this.descp_e, other.descp_e)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

}
