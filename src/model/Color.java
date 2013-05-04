/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romain
 */
public enum Color {

    NO_PAWN(-1), BLACK_PAWN(0), WHITE_PAWN(1);
    private int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Color getColor(int value) {
        if (value == 0) {
            return Color.BLACK_PAWN;
        } else if (value == 1) {
            return Color.WHITE_PAWN;
        } else {
            return Color.NO_PAWN;
        }
    }

    public Color getOppponent() {
        if (value == 0) {
            return Color.WHITE_PAWN;
        } else if (value == 1) {
            return Color.BLACK_PAWN;
        }
        return null;
    }
};