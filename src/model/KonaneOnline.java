/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Caedes
 */
public class KonaneOnline extends Konane {

    public KonaneOnline(Player p_white, Player p_black, int nbCase) {
        super(p_white, p_black, nbCase, 0, 0);
    }
    
    public KonaneOnline(String save_name, Player p_white, Player p_black, Player last, Board board, 
            int type_white_player, int type_black_player, boolean help, boolean start) {
        this.save_name = save_name;
        this.board = board;
        this.player_white = p_white;
        this.player_black = p_black;
        p_white.setTmp_color(Color.WHITE_PAWN);
        p_black.setTmp_color(Color.BLACK_PAWN);
        this.last_player_played = last;
        this.type_ia_white_player = type_white_player;
        this.type_ia_black_player = type_black_player;
        this.help = help;
        this.start = start;
    }
    
    
}
