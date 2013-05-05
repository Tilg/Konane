/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import model.Color;
import model.Konane;

/**
 *
 * @author Caedes
 */
public class SquarePanel extends JPanel {

    private int x;
    private int y;
    private Color color;
    private Konane konane;
    private Image img;

    public SquarePanel(int x, int y, Color color, Konane konane, Image img) {
        this.img = img;
        this.konane = konane;
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
        //Mettre une image correspondant 
        
         this.addMouseListener(new MouseAdapter(){      
          public void mouseReleased(MouseEvent event){
                if(event.getButton() == BUTTON1){
                    
                }
            }
        });
    }

   

}
