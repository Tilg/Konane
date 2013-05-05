    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Board;
import model.CPU;
import model.Color;
import model.Konane;
import model.KonaneLocal;
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
    private Konane konane;

    public BoardPanel(int nbCase, final Konane konane) {
        this.konane = konane;
        this.setPreferredSize(new Dimension(800, 800));
        GridLayout layout = new GridLayout(nbCase, nbCase);
        this.nb_case = nbCase;
        JPanel board = new JPanel(new GridLayout(nbCase, nbCase));
        for (int i = 0; i < nbCase; i++) {
            for (int j = 0; j < nbCase; j++) {
                Color color = Color.getColor((i + j) % 2);
                JLabel img = getImgWithKonanePawn(i, j, konane);
                final SquarePanel sp = new SquarePanel(i, j, konane, img);
                sp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent event) {

                        if (konane.isFirstShot() || konane.isSecondShot()) {
                            first_clicked = sp;
                            //first_clicked.remove(first_clicked.getImg());
                            //first_clicked.add(getImageSelect(konane.getLastPlayerPlayed().getTmp_color())); 
                            repaint();
                            KonaneMove move = new KonaneMove(first_clicked.getCox(), first_clicked.getCoy());
                            if (move.isValid(konane.generateMoves(konane.getLastPlayerPlayed()))) {
                                konane.getBoard().makeMove(move);
                                konane.setLastPlayerPlayed(konane.getOppOf(konane.getLastPlayerPlayed()));
                                makeMove(move);

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
                                    konane.setLastPlayerPlayed(konane.getOppOf(konane.getLastPlayerPlayed()));
                                    makeMove(move);

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

    public JLabel getImagePion(Color color) {
        if (color == Color.BLACK_PAWN) {
            return new JLabel(new ImageIcon(getClass().getResource("icons/pionN.png")));
        } else {
            return new JLabel(new ImageIcon(getClass().getResource("icons/pionB.png")));
        }
    }

    public JLabel getImageSelect(Color color) {
        if (color == Color.BLACK_PAWN) {
            return new JLabel(new ImageIcon(getClass().getResource("icons/pionBS.png")));
        } else {
            return new JLabel(new ImageIcon(getClass().getResource("icons/pionNS.png")));
        }
    }

    public void makeMove(KonaneMove move) {

        JLabel first = first_clicked.getImg();
        first_clicked.remove(first_clicked.getImg());

        if (move.getFromX() != move.getToX() || move.getFromY() != move.getToY()) {
            int x1 = move.getFromX();
            int x2 = move.getToX();
            int y1 = move.getFromY();
            int y2 = move.getToY();

            int distance = Board.distance(x1, y1, x2, y2);

            int jumps = distance / 2;
            int dx, dy;
            dx = (x2 - x1) / distance;
            dy = (y2 - y1) / distance;

            // for each jump
            for (int j = 0; j < jumps; j++) {
                for (int k = 0; k < square_list.size(); k++) {
                    if (square_list.get(k).getCox() == x1 + dx && square_list.get(k).getCoy() == y1 + dy) {
                        square_list.get(k).remove(square_list.get(k).getImg());

                    }
                }
                x1 += 2 * dx;
                y1 += 2 * dy;
            }
            second_clicked.add(first_clicked.getImg());
        }
        repaint();

        if(konane.generateMoves(konane.getLastPlayerPlayed()).isEmpty()) {
            System.out.println("Game over");
        }
        
        /*if (konane.getLastPlayerPlayed().getTmp_color() == Color.WHITE_PAWN) {
            CPU cpu = (CPU) konane.getLastPlayerPlayed();
            KonaneMove move_cpu = cpu.makeMove((KonaneLocal) konane);
            konane.getBoard().makeMove(move);
            konane.setLastPlayerPlayed(konane.getOppOf(konane.getLastPlayerPlayed()));
            makeMove(move_cpu);
            repaint();
        }*/


    }

    public JLabel getImgWithKonanePawn(int x, int y, Konane konane) {
        JLabel img = null;
        Pawn pawn = konane.getBoard().getPawn(x, y);
        if (pawn == null) {
        } else if (pawn.getColor() == Color.BLACK_PAWN) {
            img = new JLabel(new ImageIcon(getClass().getResource("icons/pionN.png")));
        } else {
            img = new JLabel(new ImageIcon(getClass().getResource("icons/pionB.png")));
        }
        return img;
    }
}
