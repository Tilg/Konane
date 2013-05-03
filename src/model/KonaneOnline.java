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

    public KonaneOnline(Player p1, Player p2, int nbCase) {
        super(p1, p2, nbCase, 0, 0);
    }
    
    public KonaneOnline(String save_name, Player p1, Player p2, Player last, Board board, 
            int type_white_player, int type_black_player, boolean help, boolean start) {
        this.save_name = save_name;
        this.board = board;
        this.player_white = p1;
        this.player_black = p2;
        this.last_player_played = last;
        this.type_ia_white_player = type_white_player;
        this.type_ia_black_player = type_black_player;
        this.help = help;
        this.start = start;
    }
    
    
}
