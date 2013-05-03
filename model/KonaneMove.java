/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.KonaneException;

/**
 *
 * @author Caedes
 */
public class KonaneMove {
    
    private Konane konane;
    private int from_X;
    private int from_Y;
    private int to_X;
    private int to_Y;

    //Constructor
    public KonaneMove(Konane konane, int fromX, int fromY, int toX, int toY) {
        this.konane = konane;
        this.from_X = fromX;
        this.from_Y = fromY;
        this.to_X = toX;
        this.to_Y = toY;
    }

    //Getter and Setters
    public Konane getKonane() {
        return konane;
    }

    public void setKonane(Konane konane) {
        this.konane = konane;
    }

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
    public boolean isMovePossible() throws KonaneException{
        int nbCases = this.konane.getBoard().getNb_case();
        if((this.to_X >= nbCases) && (this.to_X < 0) && (this.to_Y < 0) && (this.to_Y >= nbCases)){
            throw new KonaneException(1, "La case n'est pas sur le plateau");
        }
        boolean isNotDiagonal = ((this.from_X == this.to_X) || (this.from_Y == this.to_Y));
        if(isJump() && isNotDiagonal && isSquareEmpty(to_X, to_Y)){
            return true;
        }
        return false;
    }
    
    public boolean isSquareEmpty(int x, int y){
        Pawn squares [][] = this.konane.getBoard().getSquares();
        if(squares[x][y] == null){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isJump(){
        boolean isJumpX = ((this.to_X - this.from_X)%2 == 0);
        boolean isJumpY = ((this.to_Y - this.from_Y)%2 == 0);
        return (isJumpX || isJumpY);
    }
}
