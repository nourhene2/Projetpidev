/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.services;

import edu.connexion3a15.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author USER
 */
public interface Utilisateur_CRUD <T> {
    public abstract void Ajouter(T t);
    public abstract void Supprimer(int id);
    public abstract void Modifier(T t);
    public abstract List<T>Afficher();
    
}
