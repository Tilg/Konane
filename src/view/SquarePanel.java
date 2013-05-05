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
import javax.swing.ImageIcon;
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

    public SquarePanel(int cox, int coy, Konane konane, JLabel img) {
        this.img = img;
        this.konane = konane;
        this.cox = cox;
        this.coy = coy;
        this.color = color;
        
        this.setPreferredSize(new Dimension(60, 60));
        // Définition de l'arriere plan
        if ((cox + coy) % 2 == 1) {
            //this.add(new JLabel(new ImageIcon(getClass().getResource("icons/caseN.png"))));
            this.setBackground(java.awt.Color.ORANGE);
        } else {
            //this.add(new JLabel(new ImageIcon(getClass().getResource("icons/caseB.png"))));
            this.setBackground(java.awt.Color.black);
        }
        this.add(img);
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
