/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Caedes
 */
public class Board {
    
    private String game_name;
    private int nb_case;
    private Pawn squares [][];

    //Constructeur: nouveau plateau
    public Board(String game_name,int nb_case) {
        
        this.game_name = game_name;
        this.nb_case = nb_case;
        this.squares = new Pawn [nb_case][nb_case];
        for(int i = 0; i < nb_case; i++){
            for(int j = 0; j < nb_case; j++){
                if((i+j)%2 == 0){
                    this.squares[i][j] = new Pawn(i,j,Pawn.WHITE_PAWN);
                }
                else{
                    this.squares[i][j] = new Pawn(i,j,Pawn.BLACK_PAWN);
                }
            }
        }
    }
    
    //Constructeur: plateau deja existant
    public Board(String game_name, int nb_cases, Pawn [][] squares) {
        this.game_name = game_name;
        this.nb_case = nb_cases;
        this.squares = squares;
    }
    
    //Getter

    public String getGame_name() {
        return game_name;
    }
    
    public Pawn[][] getSquares() {
        return squares;
    }

    public int getNb_case() {
        return nb_case;
    }
    
    
    
    
}
