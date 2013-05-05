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
public class KonaneMove {

    private int from_X;
    private int from_Y;
    private int to_X;
    private int to_Y;

    //Constructor
    public KonaneMove(int fromX, int fromY, int toX, int toY) {
        this.from_X = fromX;
        this.from_Y = fromY;
        this.to_X = toX;
        this.to_Y = toY;
    }

    public KonaneMove(int fromX, int fromY) {
        this.from_X = fromX;
        this.from_Y = fromY;
        this.to_X = fromX;
        this.to_Y = fromY;
    }

    public KonaneMove(KonaneMove m) {
        this.from_X = m.from_X;
        this.from_Y = m.from_Y;
        this.to_X = m.to_X;
        this.to_Y = m.to_Y;
    }
    
    //Getter and Setters
    public int getFromX() {
        return from_X;
    }

    public void setFromX(int fromX) {
        this.from_X = fromX;
    }

    public int getFromY() {
        return from_Y;
    }

    public void setFromY(int fromY) {
        this.from_Y = fromY;
    }

    public int getToX() {
        return to_X;
    }

    public void setToX(int toX) {
        this.to_X = toX;
    }

    public int getToY() {
        return to_Y;
    }

    public void setToY(int toY) {
        this.to_Y = toY;
    }

    //Fonctions

    /**
     * 
     * @param possible_moves ArrayList de KonaneMove possibles
     * @return  
     */
    public boolean isValid(ArrayList<KonaneMove> possible_moves) {

        for (KonaneMove move : possible_moves) {
            if ((this.from_X == move.from_X)
                    && (this.from_Y == move.from_Y)
                    && (this.to_X == move.to_X)
                    && (this.to_Y == move.to_Y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    public boolean isJump() {
        boolean isJumpX = ((this.to_X - this.from_X) % 2 == 0);
        boolean isJumpY = ((this.to_Y - this.from_Y) % 2 == 0);
        return (isJumpX || isJumpY);
    }
}
