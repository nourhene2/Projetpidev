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
public class ListPersonne {
    private int id;
    private int id_U;
    private int id_e;

    public int getId() {
        return id;
    }

    public int getId_U() {
        return id_U;
    }

    public int getId_e() {
        return id_e;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_U(int id_U) {
        this.id_U = id_U;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public ListPersonne(int id, int id_U, int id_e) {
        this.id = id;
        this.id_U = id_U;
        this.id_e = id_e;
    }

    @Override
    public String toString() {
        return "ListPersonne{" + "id=" + id + ", id_U=" + id_U + ", id_e=" + id_e + '}';
    }

    public ListPersonne() {
    }
    
}
