/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romain
 */
public class Human extends Player implements java.io.Serializable {
    
    //Constructors
    public Human(String name) {
        super(name);
    }

    public Human(String name, int nb_wins ,int nb_loose) {
        super(name,nb_wins,nb_loose);
    }
    
}
