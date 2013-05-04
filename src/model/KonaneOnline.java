/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import network.TCPClient;
import network.TCPServer;

/**
 *
 * @author Caedes
 */
public class KonaneOnline extends Konane {
    
    private TCPServer server;
    private TCPClient client1;
    private TCPClient client2;

    public KonaneOnline(Player p_white, Player p_black, int nbCase) {
        super(p_white, p_black, nbCase, 0, 0);
    }
    
    public KonaneOnline(String save_name, Player p_white, Player p_black, Player last, Board board, 
            int type_white_player, int type_black_player, boolean help, boolean start) {
        this.save_name = save_name;
        this.board = board;
        this.player_white = p_white;
        this.player_black = p_black;
        p_white.setTmp_color(Pawn.WHITE_PAWN);
        p_black.setTmp_color(Pawn.BLACK_PAWN);
        this.last_player_played = last;
        this.type_ia_white_player = type_white_player;
        this.type_ia_black_player = type_black_player;
        this.help = help;
        this.start = start;
        this.client1 = new TCPClient();
        this.client2 = new TCPClient();
        this.server = new TCPServer(client1, client2);
    }
    
    
}
