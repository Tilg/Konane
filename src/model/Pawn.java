/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Caedes
 */
public class Pawn implements java.io.Serializable {

    private Color color; // 0 : noir et 1 : blanc
    private int x;
    private int y;

    //Fonctions
    public Pawn(int x, int y, Color color) {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Fonctions

    @Override
    public String toString() {
        return "Pawn{" + "color=" + color + ", x=" + x + ", y=" + y + '}';
    }
}
