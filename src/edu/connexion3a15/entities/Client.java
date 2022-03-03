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
public class Client extends Utilisateur {
    

    private int nb_fidelite;
    //public static Evenement e;

    public Client( int id, String nom, String prenom, String mdp, int num_tel, String email, Type.Types type) {
        super(id, nom, prenom, mdp, num_tel, email, type);
       // this.nb_fidelite = nb_fidelite;
    }

   

    public Client(int nb_fidelite,int id, String nom, String prenom, String mdp, int num_tel, String email, Type.Types type) {
        super(id, nom, prenom, mdp, num_tel, email, type);
        this.nb_fidelite = nb_fidelite;
    }

    public Client(int nb_fidelite, String nom, String prenom, int num_tel, String email, Type.Types type, String mdp) {
        super(nom, prenom, num_tel, email, type, mdp);
        this.nb_fidelite = nb_fidelite;
    }

    public Client(int nb_fidelite) {
        this.nb_fidelite = nb_fidelite;
    }
    

    

    public Client() {

    }

    public int getNb_fidelite() {
        return nb_fidelite;
    }

    public void setNb_fidelite(int nb_fidelite) {
        this.nb_fidelite = nb_fidelite;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "nb_fidelite=" + nb_fidelite + '}';
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
        final Client other = (Client) obj;
        if (this.nb_fidelite != other.nb_fidelite) {
            return false;
        }
        return true;
    }

    
}
