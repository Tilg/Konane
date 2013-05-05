/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Objet représentant la couleur d'un pion dans une case
 * @author Romain
 */
public enum Color implements java.io.Serializable {

    NO_PAWN(-1), BLACK_PAWN(0), WHITE_PAWN(1);
    private int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Getter permettant de trouver une couleur en fonction d'un entier
     * @param value Integer correspondant à une couleur que l'on cherche
     * @return Objet Color représentant la couleur recherchée
     */
    public static Color getColor(int value) {
        if (value == 0) {
            return Color.BLACK_PAWN;
        } else if (value == 1) {
            return Color.WHITE_PAWN;
        } else {
            return Color.NO_PAWN;
        }
    }

    /**
     * On cherche la couleur opposée à la couleur courante ( WHITE : BLACK )
     * @return Object Color représentant la couleur de l'adversaire 
     */
    public Color getOppponent() {
        if (value == 0) {
            return Color.WHITE_PAWN;
        } else if (value == 1) {
            return Color.BLACK_PAWN;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Color{" + "value=" + value + '}';
    }
    
    
};