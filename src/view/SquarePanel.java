/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import model.Color;

/**
 *
 * @author Caedes
 */
public class SquarePanel extends JPanel {

    private int x;
    private int y;
    private Color color;

    public SquarePanel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.setPreferredSize(new Dimension(60, 60));
        // Définition de l'arriere plan
        if (color.equals(Color.BLACK_PAWN)) {
            this.setBackground(java.awt.Color.BLACK);
        }
        else {
            this.setBackground(java.awt.Color.WHITE);
        }
    }
}
