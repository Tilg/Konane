/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    protected int nb_pawns_white_player;
    protected int nb_pawns_black_player;
    //private ArrayList<Pawn> list_white_pawn;
    //private ArrayList<Pawn> list_black_pawn;
    protected Player last_player_played = null;

    //Constructors
    public Konane() {
    }
    
    public Konane(Player p1, Player p2, int nbCase, int type_white_player, int type_back_player) {
        this.board = new Board(save_name,nbCase);
        this.player_white = p1;
        this.player_black = p2;
        //Faire l'affectation des niveaux d'IA selon le type
        this.nb_pawns_white_player = (nbCase*nbCase)/2;
        this.nb_pawns_black_player = (nbCase*nbCase)/2;
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

    public int getNbPawnRemainingJ1() {
        return nb_pawns_white_player;
    }

    public int getNbPawnRemainingJ2() {
        return nb_pawns_black_player;
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
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setNbPawnRemainingJ1(int nbPawnRemainingJ1) {
        this.nb_pawns_white_player = nbPawnRemainingJ1;
    }

    public void setNbPawnRemainingJ2(int nbPawnRemainingJ2) {
        this.nb_pawns_black_player = nbPawnRemainingJ2;
    }

    public void setLastPlayerPlayed(Player lastPlayerPlayed) {
        this.last_player_played = lastPlayerPlayed;
    }
    
    
    //Fonctions
    public boolean isGameLost(){
        if((this.nb_pawns_white_player == 0) || (this.nb_pawns_black_player == 0)){
            return true;
        }
        /**else if plus aucuns coups possibles
         * 
         * */
        return false;
    }
       
    /*
    
    public void makeSaveLocal(String nameFile) {
        
	String localFile = nameFile;

	try {
            FileWriter fw = new FileWriter(localFile, true);
            BufferedWriter output = new BufferedWriter(fw);

            /**
             * Schema 
             * l1 : nameWhitePlayer
             * l2 : nameBlackPlayer
             * l3 : b-n-b-n-b-n-b
             * l4 : n-b-n-b-0-b-n
             * l10 : nameLastPlayer
             * 
             */
            //Name white and black player
            /*output.write(this.player_white.getName());
            output.newLine();
            output.write(this.player_black.getName());
            output.newLine();
            
            String line;
            Pawn squares [][] = this.board.getSquares();
            //List of Square composition
            for(int i = 0; i < squares.length ; i++){
                line = "";
                for(int j = 0; j < squares.length ; j++){
                    if(squares[i][j] == null){
                        line += "0";
                    }
                    else {
                        if(squares[i][j].getColor() == 0) {
                            line += "n";
                        }
                        else if(squares[i][j].getColor() == 1) {
                            line += "b";
                        }
                    }
                    line += "-";
                }
                output.newLine();
            }
            
            
            //Name of the last player
            output.write(this.last_player_played.getName());
            
            //closing file
            output.flush();
            output.close();
	}
	catch(IOException ioe){
            ioe.printStackTrace();
	}

    }*/
    
}
