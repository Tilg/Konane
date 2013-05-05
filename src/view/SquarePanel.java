/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Color;
import model.Konane;

/**
 *
 * @author Caedes
 */
public class SquarePanel extends JPanel {

    private int cox;
    private int coy;
    private Color color;
    private Konane konane;
    private JLabel img;

    public SquarePanel(int cox, int coy, Color color, Konane konane, JLabel img) {
        this.img = img;
        this.add(img);
        this.konane = konane;
        this.cox = cox;
        this.coy = coy;
        this.color = color;
        this.setPreferredSize(new Dimension(60, 60));
        // Définition de l'arriere plan
        if (color.equals(Color.BLACK_PAWN)) {
            this.setBackground(java.awt.Color.BLACK);
        } else {
            this.setBackground(java.awt.Color.WHITE);
        }
        //Mettre une image correspondant 

        
    }

    public int getCox() {
        return cox;
    }

    public int getCoy() {
        return coy;
    }

    public JLabel getImg() {
        return img;
    }

    public void setImg(JLabel img) {
        this.img = img;
        this.add(img);
    }
    
    
    
    
    
    

}
