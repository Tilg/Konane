/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Caedes
 */
public class Pawn {
    
    public final static int NO_PAWN = -1;
    public final static int BLACK_PAWN = 0;
    public final static int WHITE_PAWN = 1;
    
    private int color; // 0 : noir et 1 : blanc
    private int x;
    private int y;

    //Fonctions
    public Pawn(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //Fonctions
    
}
