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
    private Utilisateur user;
    private Evenement events ;
    private Date Date ;

    public Reservation() {
    }

   
    public int getId() {
        return id;
    }

    
    public Date getDate() {
        return Date;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Reservation(int id, Utilisateur user, Evenement events, Date Date) {
        this.id = id;
        this.user = user;
        this.events = events;
        this.Date = Date;
    }

    public Utilisateur getUser() {
        return user;
    }

    public Evenement getEvents() {
        return events;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setEvents(Evenement events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", user=" + user.getId() + ", events=" + events.getId_e()+ ", Date=" + Date + '}';
    }

    
    
}
