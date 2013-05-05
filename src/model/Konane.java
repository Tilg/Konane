/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Classe abstraite implémentant une partie de Konane
 *
 * @author Caedes
 */
public abstract class Konane implements java.io.Serializable {

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
        //  p_white.setTmp_color(Color.WHITE_PAWN);
        // p_black.setTmp_color(Color.BLACK_PAWN);
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
        this.board.setGame_name(save_name);
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    /**
     * On recherche le joueur opposé au joueur passé en paramètre
     *
     * @param p Player: joueur donné
     * @return objet Player, adversaire de player dans la partie courante
     */
    public Player getOppOf(Player p) {
        if (p.getTmp_color() == Color.BLACK_PAWN) {
            return this.player_white;
        } else {
            return this.player_black;
        }
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
        if (board.getPawn(0, 0).getColor() == Color.NO_PAWN) {
            // 2 mouvements possibles
            secondMoves.add(new KonaneMove(0, 1));
            secondMoves.add(new KonaneMove(1, 0));
        } // Si le deuxieme coup est en bas à droite 
        else if (board.getPawn(size - 1, size - 1).getColor() == Color.NO_PAWN) {
            // 2 mouvements possibles
            secondMoves.add(new KonaneMove(size - 1, size - 2));
            secondMoves.add(new KonaneMove(size - 2, size - 1));
        } // Si le premier coup est au milieu 
        else if (board.getPawn((size / 2) - 1, (size / 2) - 1).getColor() == Color.NO_PAWN) {
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

        // Tableaux représentant des directions
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int size = board.getNb_case();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getPawn(i, j).getColor() == player.getTmp_color()) {
                    for (int k = 0; k < 4; k++) {
                        moves.addAll(check(i, j, dx[k], dy[k], 1, player.getTmp_color().getOppponent()));
                    }
                }
            }
        }

        // Suppression des éventuels mouvements vides
        while (moves.lastIndexOf(null) != -1) {
            moves.remove(moves.lastIndexOf(null));
        }

        return moves;

    }

    /**
     * Vérifie si un saut est possible depuis une case donnée et allant dans une 
     * direction donnée. La fonction est utilisée récursivement avec le paramètre 
     * factor pour tous les sauts possibles dans une direction. On retourne tous
     * les sauts possibles dans une direction.
     *
     * @param x Integer représentant la position du pion à l'origine du mouvement (ligne)
     * @param y Integer représentant la position du pion à l'origin du mouvement (colonne)
     * @param dr Integer représentant la position du pion à la fin du mouvement (ligne)
     * @param dc Integer représentant la position du pion à la fin du mouvement (colonne)
     * @param factor Integer représentant le facteur par lequel on va multiplier les coordonnées ( dans le cas d'un saut)
     * @param opponent Color repérésentant la couleur de l'adversaire
     * @return ArrayList de KonaneMove possibles dans la direction donnée
     */
    private ArrayList<KonaneMove> check(int x, int y, int dr, int dc, int factor, Color opponent) {

        ArrayList<KonaneMove> moves = new ArrayList<KonaneMove>();

        if (board.contains((x + (factor * dr)), (y + (factor * dc)), opponent)
                && board.contains((x + ((factor + 1) * dr)), (y + ((factor + 1) * dc)), Color.NO_PAWN)) {
            // Si le mouvement est possible, on l'ajoute
            KonaneMove move = new KonaneMove(x, y, (x + ((factor + 1) * dr)), (y + ((factor + 1) * dc)));
            moves.add(move);
            // On vérifie si il y a d'autres sauts
            moves.addAll(check(x, y, dr, dc, factor + 2, opponent));
        }
        return moves;
    }

    public void setLastPlayerPlayed(Player lastPlayerPlayed) {
        this.last_player_played = lastPlayerPlayed;
    }

    @Override
    public String toString() {
        return "Konane{" + "save_name=" + save_name + ", board=" + board + ", player_white=" + player_white + ", player_black=" + player_black + ", type_ia_white_player=" + type_ia_white_player + ", type_ia_black_player=" + type_ia_black_player + ", help=" + help + ", start=" + start + ", last_player_played=" + last_player_played + '}';
    }
}
