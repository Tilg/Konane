/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romain
 */
public class KonaneLocal extends Konane implements java.io.Serializable {
    
    public KonaneLocal(Player p1, Player p2, int nbCase, int type_white_player, int type_back_player) {
        super(p1, p2, nbCase, type_white_player, type_back_player);
    }
    
}
