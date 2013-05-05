    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Color;
import model.Konane;
import model.KonaneMove;
import model.Pawn;

/**
 *
 * @author Caedes
 */
public class BoardPanel extends JPanel {

    private ArrayList<SquarePanel> square_list = new ArrayList<SquarePanel>();
    private int nb_case;
    private SquarePanel first_clicked = null;
    private SquarePanel second_clicked = null;

    public BoardPanel(int nbCase, final Konane konane) {
        this.setPreferredSize(new Dimension(800, 800));
        GridLayout layout = new GridLayout(nbCase, nbCase);
        this.nb_case = nbCase;
        JPanel board = new JPanel(new GridLayout(nbCase, nbCase));
        for (int i = 0; i < nbCase; i++) {
            for (int j = 0; j < nbCase; j++) {
                Color color = Color.getColor((i + j) % 2);
                JLabel img = getImgWithKonanePawn(i, j, konane);
                final SquarePanel sp = new SquarePanel(i, j, color, konane, img);
                sp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent event) {

                        if (konane.isFirstShot() || konane.isSecondShot()) {
                            first_clicked = sp;
                            KonaneMove move = new KonaneMove(first_clicked.getCox(), first_clicked.getCoy());
                            if (move.isValid(konane.generateMoves(konane.getLastPlayerPlayed()))) {
                                konane.getBoard().makeMove(move);
                                makeMove(move);
                                konane.setLastPlayerPlayed(konane.getOppOf(konane.getLastPlayerPlayed()));
                            }
                            first_clicked = null;
                        } else {
                            if (first_clicked == null) {
                                first_clicked = sp;
                            } else if (second_clicked == null) {
                                second_clicked = sp;
                                KonaneMove move = new KonaneMove(first_clicked.getCox(), first_clicked.getCoy(), second_clicked.getCox(), second_clicked.getCoy());
                                if (move.isValid(konane.generateMoves(konane.getLastPlayerPlayed()))) {
                                    konane.getBoard().makeMove(move);
                                    makeMove(move);
                                    konane.setLastPlayerPlayed(konane.getOppOf(konane.getLastPlayerPlayed()));
                                }
                                first_clicked = null;
                                second_clicked = null;
                            }
                        }
                    }
                });
                board.add(sp);
                layout.addLayoutComponent("panel", sp);
                square_list.add(sp);
            }
        }
        board.setVisible(true);
        this.add(board);
        this.setVisible(true);
    }

    public void makeMove(KonaneMove move) {
        for (int i = 0; i < square_list.size(); i++) {
            if (square_list.get(i).getCox() == move.getFromX() && square_list.get(i).getCoy() == move.getFromY()) {
                square_list.get(i).remove(square_list.get(i).getImg());
                                System.out.println("test");
                repaint();
            }
        }
    }

    public JLabel getImgWithKonanePawn(int x, int y, Konane konane) {
        JLabel img = null;
        Pawn pawn = konane.getBoard().getPawn(x, y);
        if (pawn == null) {
        } else if (pawn.getColor() == Color.BLACK_PAWN) {
            img = new JLabel(new ImageIcon(getClass().getResource("icons/black_pawn.png")));
        } else {
            img = new JLabel(new ImageIcon(getClass().getResource("icons/white_pawn.png")));
        }
        return img;
    }
}
