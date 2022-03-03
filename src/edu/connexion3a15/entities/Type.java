/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a15.entities;

import java.util.EnumSet;

/**
 *
 * @author USER
 */
public class Type {
    // Client,nutritionniste,coach;
     public enum Types{
        Client,nutritionniste,coach;
    }
    public static Types find(String abbr){
 
    for(Types v :EnumSet.allOf(Type.Types.class)){
        if( v.toString().equals(abbr)){
            return v;
        }
    }
    return null;
}
}
