/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romain
 */
public class Human extends Player {
    
    //Constructors
    public Human(String name) {
        super(name);
    }

    public Human(String name, int nb_wins ,int nb_loose) {
        super(name,nb_wins,nb_loose);
    }

    @Override
    public KonaneMove makeMove(Konane game, KonaneMove move) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
