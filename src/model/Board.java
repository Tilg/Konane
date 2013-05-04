/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Caedes
 */
public class Board {

    private String game_name;
    private int nb_case;
    private Pawn squares[][];

    //Constructeur: nouveau plateau
    public Board(String game_name, int nb_case) {

        this.game_name = game_name;
        this.nb_case = nb_case;
        this.squares = new Pawn[nb_case][nb_case];
        for (int i = 0; i < nb_case; i++) {
            for (int j = 0; j < nb_case; j++) {
                if ((i + j) % 2 == 1) {
                    this.squares[i][j] = new Pawn(i, j, Color.WHITE_PAWN);
                } else {
                    this.squares[i][j] = new Pawn(i, j, Color.BLACK_PAWN);
                }
            }
        }
    }

    //Constructeur: plateau deja existant
    public Board(String game_name, int nb_cases, Pawn[][] squares) {
        this.game_name = game_name;
        this.nb_case = nb_cases;
        this.squares = squares;
    }

    //Getter
    public String getGame_name() {
        return game_name;
    }

    public Pawn[][] getSquares() {
        return squares;
    }

    public int getNb_case() {
        return nb_case;
    }

    public Pawn getPawn(int x, int y) {
        return this.getSquares()[x][y];
    }

    public void setPawn(Pawn pawn, int x, int y) {
        this.getSquares()[x][y] = pawn;
    }

    /**
     * Somme des occurences d'une couleur sur le plateau (blanc, noir, pas de
     * pion)
     *
     * @param color: Couleur recherchée
     * @return nombre de fois où la couleur apparait
     */
    public int countColor(Color color) {
        int count = 0;

        for (int i = 0; i < this.getNb_case(); i++) {
            for (int j = 0; j < this.getNb_case(); j++) {
                if (this.getPawn(i, j).getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * On vérifie si la case existe bien
     *
     * @param x Numéro de la colonne correspondant à la case recherchée
     * @param y Numéro de la ligne correspondant à la case recherchée
     * @return Case existante ou non
     */
    public boolean isValid(int x, int y) {
        return ((y < 0 || y >= nb_case) || (x < 0 || x >= nb_case)) ? false : true;
    }

    /**
     *
     * @param x Numéro de la colonne correspondant à la case recherchée
     * @param y Numéro de la ligne correspondant à la case recherchée
     * @param color Couleur recherché
     * @return Si un pion de couleur spécifique est contenu dans une case donnée
     */
    public boolean contains(int x, int y, Color color) {
        boolean contain = false;

        if (this.isValid(x, y)) {
            if (this.getPawn(x, y).getColor().equals(color)) {
                contain = true;
            }
        }

        return contain;
    }

    /**
     * Distance entre 2 points
     *
     * @param x1 An int giving the row of the origin
     * @param y1 An int giving the column of the origin
     * @param x2 An int giving the column of the destination
     * @param y2 An int giving the column of the destination
     * @return An int giving the distance between two points
     */
    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(((x2 - x1) + (y2 - y1)));
    }

    public void makeMove(KonaneMove move) {
        
        int x1 = move.getFromX();
        int x2 = move.getToX();
        int y1 = move.getFromY();
        int y2 = move.getToY();
        
        int distance = distance(x1, y1, x2, y2);
        Pawn pawn = this.getPawn(x1, y1);

        this.setPawn(null, x1, y1);
        
        if (distance != 0) {
            int jumps = distance / 2;
            int dx, dy;
            dx = (x2 - x1) / distance;
            dy = (y2 - y1) / distance;
            // for each jump
            for (int i = 0; i < jumps; i++) {
                this.setPawn(null, x1, y1);
                this.setPawn(null, x1 + dx, y1 + dy);
                x1 += 2 * dx;
                y1 += 2 * dy;
                this.setPawn(pawn, x1, y1);
            }
        }
    }
}
