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

    public KonaneLocal(KonaneLocal k) {
        this.board = k.getBoard();
        this.player_white = k.getPlayerWhite();
        this.player_black = k.getPlayerBlack();
        this.last_player_played = k.getLastPlayerPlayed();
        // p_white.setTmp_color(Color.WHITE_PAWN);
        // p_black.setTmp_color(Color.BLACK_PAWN);
        this.type_ia_white_player = k.getType_ia_white_player();
        this.type_ia_black_player = k.getType_ia_black_player();
    }
    
    
    
}
