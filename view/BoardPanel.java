    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Caedes
 */
public class BoardPanel extends JPanel{
    
    private ArrayList<SquarePanel> square_list = new ArrayList<SquarePanel>();
    private int nb_case;

    public BoardPanel(int nbCase) {
        GridLayout layout = new GridLayout(nbCase,nbCase);
        this.nb_case = nbCase;
        JPanel board = new JPanel(new GridLayout (nbCase, nbCase));
        for(int i = 0; i<nbCase;i++){
            for(int j = 0; j < nbCase; j++){
                SquarePanel sp = new SquarePanel(i, j);
                board.add(sp);
                layout.addLayoutComponent("panel", sp);
                square_list.add(sp);
            }
       }
       this.setVisible(true);
    }
    
    
    
    
}
