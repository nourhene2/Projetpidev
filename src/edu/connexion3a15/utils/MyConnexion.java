/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class MyConnexion {
    Connection cnx;
    public String url="jdbc:mysql://localhost:3306/espritbase";
    public String login="root";
    public String pwd="";
    public static MyConnexion instance;

    public Connection getCnx() {
        return cnx;
    }

    private MyConnexion() {
        try {
           cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion Etablie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static MyConnexion getInstance() {
       if(instance== null){
       instance = new MyConnexion();
       }
       return instance;
    }
   
}
