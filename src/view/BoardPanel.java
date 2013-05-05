    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Color;
import model.Konane;
import model.Pawn;

/**
 *
 * @author Caedes
 */
public class BoardPanel extends JPanel {
    
    private ArrayList<SquarePanel> square_list = new ArrayList<SquarePanel>();
    private int nb_case;
    
    public BoardPanel(int nbCase, Konane konane) {
        this.setPreferredSize(new Dimension(800, 800));
        GridLayout layout = new GridLayout(nbCase, nbCase);
        this.nb_case = nbCase;
        JPanel board = new JPanel(new GridLayout(nbCase, nbCase));
        for (int i = 0; i < nbCase; i++) {
            for (int j = 0; j < nbCase; j++) {
                Color color = Color.getColor((i + j) % 2);
                Image img = getImgWithKonanePawn(i, j, konane);
                SquarePanel sp = new SquarePanel(i, j, color, konane, img);
                board.add(sp);
                layout.addLayoutComponent("panel", sp);
                square_list.add(sp);
            }
        }
        board.setVisible(true);
        this.add(board);
        this.setVisible(true);
    }
    
    public Image getImgWithKonanePawn(int x, int y, Konane konane){
        Image img;
        Pawn pawn = konane.getBoard().getPawn(x, y);
        if(pawn.getColor() == Color.BLACK_PAWN){
            //charger url image noir
        }
        else {
            //charger url image blanc
        }
        return img;
    }
}
