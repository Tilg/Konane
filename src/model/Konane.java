/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Caedes
 */
public abstract class Konane {

    protected String save_name = "default"; //The name of the save
    protected Board board;
    protected Player player_white;
    protected Player player_black;
    protected int type_ia_white_player;
    protected int type_ia_black_player;
    protected boolean help = true;                //If the player wants to see colored-square at his turn
    protected boolean start = false;          //If the game has started
    protected Player last_player_played = null;

    //Constructors
    public Konane() {
    }

    public Konane(Player p_white, Player p_black, int nbCase, int type_white_player, int type_back_player) {
        this.board = new Board(save_name, nbCase);
        this.player_white = p_white;
        this.player_black = p_black;
        this.last_player_played = p_black;
        p_white.setTmp_color(Color.WHITE_PAWN);
        p_black.setTmp_color(Color.BLACK_PAWN);
        this.type_ia_white_player = type_white_player;
        this.type_ia_black_player = type_back_player;
    }

    //Getters
    public Board getBoard() {
        return board;
    }

    public Player getPlayerWhite() {
        return player_white;
    }

    public Player getPlayerBlack() {
        return player_black;
    }

    public String getSaveName() {
        return save_name;
    }

    public boolean isHelp() {
        return help;
    }

    public boolean isStart() {
        return start;
    }

    /*public int getNbPawnRemainingJ1() {
     return nb_pawns_white_player;
     }

     public int getNbPawnRemainingJ2() {
     return nb_pawns_black_player;
     }*/
    public Player getLastPlayerPlayed() {
        return last_player_played;
    }

    public int getType_ia_white_player() {
        return type_ia_white_player;
    }

    public int getType_ia_black_player() {
        return type_ia_black_player;
    }

    //Setters
    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayerWhite(Player playerWhite) {
        this.player_white = playerWhite;
    }

    public void setPlayerBlack(Player playerBlack) {
        this.player_black = playerBlack;
    }

    public void setSaveName(String saveName) {
        this.save_name = saveName;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    /**
     * Si on va jouer le premier coup
     *
     * @return
     */
    public boolean isFirstShot() {
        return (board.countColor(Color.NO_PAWN) == 0);
    }

    /**
     * Si on va jouer le second coup
     *
     * @return
     */
    public boolean isSecondShot() {
        return (board.countColor(Color.NO_PAWN) == 1);
    }
    
    /**
     * Liste des mouvements possibles pour le premier coup (joueur noir)
     *
     * @return ArrayList de KonaneMove possibles pour le premier coup
     */
    private ArrayList<KonaneMove> generateFirstMoves() {

        int size = board.getNb_case();

        ArrayList<KonaneMove> first_moves = new ArrayList<KonaneMove>();
        first_moves.add(new KonaneMove(0, 0));
        first_moves.add(new KonaneMove((size - 1), (size - 1)));
        first_moves.add(new KonaneMove((size / 2), (size / 2)));
        first_moves.add(new KonaneMove((size / 2 - 1), (size / 2 - 1)));

        return first_moves;

    }

    /**
     * Liste des mouvements possibles pour le second coup (joueur blanc)
     *
     * @return ArrayList de KonaneMove possibles pour le second coup
     */
    private ArrayList<KonaneMove> generateSecondMoves() {

        int wPos;
        int size = this.board.getNb_case();
        ArrayList<KonaneMove> secondMoves = new ArrayList<KonaneMove>();

        // Si le premier mouvement est en haut à gauche
        if (board.getPawn(0, 0) == null) {
            // 2 mouvements possibles
            secondMoves.add(new KonaneMove(0, 1));
            secondMoves.add(new KonaneMove(1, 0));
        } // Si le deuxieme coup est en bas à droite 
        else if (board.getPawn(size - 1, size - 1) == null) {
            // 2 mouvements possibles
            secondMoves.add(new KonaneMove(size - 1, size - 2));
            secondMoves.add(new KonaneMove(size - 2, size - 1));
        } // Si le premier coup est au milieu 
        else if (board.getPawn((size / 2) - 1, (size / 2) - 1) == null) {
            wPos = (size / 2) - 1;
            // 4 mouvements possibles
            secondMoves.add(new KonaneMove(wPos, wPos + 1));
            secondMoves.add(new KonaneMove(wPos + 1, wPos));
            secondMoves.add(new KonaneMove(wPos - 1, wPos));
            secondMoves.add(new KonaneMove(wPos, wPos - 1));
        } // 4 mouvements possibles 
        else {
            wPos = (size / 2);
            secondMoves.add(new KonaneMove(wPos, wPos + 1));
            secondMoves.add(new KonaneMove(wPos + 1, wPos));
            secondMoves.add(new KonaneMove(wPos - 1, wPos));
            secondMoves.add(new KonaneMove(wPos, wPos - 1));
        }
        return secondMoves;
    }

    /**
     * Fonction générant une liste des coups jouables
     *
     * @param player Joueur jouant le coup
     * @return ArrayList de type KonaneMove avec tous les coups possbiles
     */
    public ArrayList<KonaneMove> generateMoves(Player player) {

        if (this.isFirstShot()) {
            return generateFirstMoves();
        }
        if (this.isSecondShot()) {
            return generateSecondMoves();
        }

        ArrayList<KonaneMove> moves = new ArrayList<KonaneMove>();

        // These are the integer arrays specifying direction
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int size = board.getNb_case();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getPawn(j, j).getColor() == player.getTmp_color()) {
                    for (int k = 0; k < 4; k++) {
                        moves.addAll(check(i, j, dr[k], dc[k], 1, player.getTmp_color().getOppponent()));
                    }
                }
            }
        }

        // some housekeeping. May not be necessary, but you never know
        while (moves.lastIndexOf(null) != -1) {
            moves.remove(moves.lastIndexOf(null));
        }

        return moves;

    }

    /**
     * Checks whether a jump is possible starting at (r,c) and going in the
     * direction determined by the row delta, rd, and the column delta, cd. The
     * factor is used to recursively check for multiple jumps in the same
     * direction. Returns all possible jumps in the given direction in an
     * ArrayList
     *
     * @param x An int describing the row of the origin of the move
     * @param y An int describing the column of the origin of the move
     * @param dr An int describing the delta of the row
     * @param dc An int describing the delta of the column
     * @param factor An int which is the factor by which the move should be
     * multiplied
     * @param opponent A char describing the opponent
     * @return An ArrayList of KonaneMove objects.
     */
    private ArrayList<KonaneMove> check(int x, int y, int dr, int dc, int factor, Color opponent) {

        ArrayList<KonaneMove> moves = new ArrayList<KonaneMove>();

        if (board.contains((x + (factor * dr)), (y + (factor * dc)), opponent)
                && board.contains((x + ((factor + 1) * dr)), (y + ((factor + 1) * dc)), Color.NO_PAWN)) {
            // if the move is valid, add it
            moves.add(new KonaneMove(x, y, (x + ((factor + 1) * dr)), (y + ((factor + 1) * dc))));
            // check if there's a further jump
            moves.addAll(check(x, y, dr, dc, factor + 2, opponent));
        }
        return moves;
    }
    
    

    public void setLastPlayerPlayed(Player lastPlayerPlayed) {
        this.last_player_played = lastPlayerPlayed;
    }
}
