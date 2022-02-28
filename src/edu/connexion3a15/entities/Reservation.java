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
    private int id_E;
    private Date Date ;

    public Reservation() {
    }

    public Reservation(int id, int id_U, int id_E, Date Date) {
        this.id = id;
        this.id_U = id_U;
        this.id_E = id_E;
        this.Date = Date;
    }

    public int getId() {
        return id;
    }

    public int getId_U() {
        return id_U;
    }

    public int getId_E() {
        return id_E;
    }

    public Date getDate() {
        return Date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_U(int id_U) {
        this.id_U = id_U;
    }

    public void setId_E(int id_E) {
        this.id_E = id_E;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_U=" + id_U + ", id_E=" + id_E + ", Date=" + Date + '}';
    }
    
}
