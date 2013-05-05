package model;

import java.util.ArrayList;

/**
 * Implémentation de l'algorithme Minimax.
 * La classe CPU est un joueur dirigé par le programme
 * Plus d'info sur l'algorithme sur:
 *  http://fr.wikipedia.org/wiki/Algorithme_minimax
 *
 * @author Hadrien
 */
public class CPU extends Player {

    /**
     * Niveau de difficulté de l'IA
     */
    private int level = 2; 
    
    /**
     * Par défaut l'IA analyse uniquement un coup à l'avance
     */
    public CPU() {
        super("CPU_Player");
    }

    /**
     * Le niveau de l'IA correspond à la profondeur de l'arbre Minimax Plus le
     * niveau est élevé, plus l'IA analysera le jeu
     *
     * @param level
     */
    public CPU(int level) {
        super("CPU");
        if (level >= 2) {
            this.level = level;
        }
    }

    /**
     * Constructeur avec uniquement le nom du joueur
     *
     * @param nom
     */
    public CPU(String nom) {
        super("CPU_" + nom);
    }

    /**
     * Constructeur avec uniquement le nom du joueur.
     *
     * @param nom
     * @param level
     */
    public CPU(String nom, int level) {
        super("CPU_" + nom);
        if (level >= 0) {
            this.level = level;
        }
    }

    /**
     * Minimax: But de la fonction min - Minimiser le score de l'adversaire.
     * 
     * @param game 
     * @param depth
     */
    public double min(KonaneLocal game, int depth) {

        double min = (+100), val; // au départ, le score min est initiaisé avec un gros entier positif

        int i, j;

        // On récupère l'ensemble des coups possibles de l'opposant... 
        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>(game.generateMoves(game.getOppOf(this)));

        
        if (depth == 0 || possibleMoves.isEmpty()) {
            return heuristic_evaluation(game);
        }

        // ...et on simule ses coups sur des copies du tableau de jeu     
        for (i = 0; i < possibleMoves.size(); i++) {

            KonaneLocal gameCopy = new KonaneLocal(game);
            gameCopy.getBoard().makeMove(possibleMoves.get(i));
            val = max(gameCopy, depth - 1);

            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    /**
     * Minimax: But de la fonction max - Maximiser le score de l'IA
     *
     * @param game 
     * @param depth
     */
    public double max(KonaneLocal game, int depth) {

        double max = (-100), val; // ¨par défaut on initialise max, à une très petite valeur

        int i, j;

        // Génération de tous les coups possibles pour l'IA...
        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>(game.generateMoves(this));

        if (depth == 0 || possibleMoves.isEmpty()) {
            return heuristic_evaluation(game);
        }

        // ...et simulation de ses coups sur des copies du tableau de jeu
        for (i = 0; i < possibleMoves.size(); i++) {

            KonaneLocal gameCopy = new KonaneLocal(game);

            gameCopy.getBoard().makeMove(possibleMoves.get(i));

            val = min(gameCopy, depth - 1);

            if (val > max) {
                max = val;
            }

        }

        return max;

    }

    /**
     * Evaluation de l'heuristique pour un tableau donné.
     * Soit:
     *  - n l'état du jeu Konane à un instant donné
     *  - H(n) l'évaluation heuristique
     *  - O(n) Le nombre de coups possibles pour l'adersaire (opposant)
     *  - P(n) Le nombre de coups possibles pour l'IA
     * Alors H(n) = P(n) - O(n)
     * On privéligie un H(n) > 
     * 
     * @param game 
     */
    public double heuristic_evaluation(KonaneLocal game) {

        double heuristic_value;

        // Récupération des mouvements de l'IA et de l'opposant
        ArrayList<KonaneMove>  AI_possibleMoves = new ArrayList<KonaneMove>(game.generateMoves(this));
        ArrayList<KonaneMove> O_possibleMoves = new ArrayList<KonaneMove>(game.generateMoves(game.getOppOf(this)));


        if (AI_possibleMoves.isEmpty()) // Pire cas: l'IA perd 
        {
            heuristic_value = (-100);
        } else {
            if (O_possibleMoves.isEmpty()) // Meilleur cas: l'IA gagne
            {
                heuristic_value = (+100);
            } else {
                heuristic_value = AI_possibleMoves.size() - O_possibleMoves.size();
            }
        }

        return heuristic_value;

    }

    /**
     * Mouvement fait par l'IA suite à Minimax
     * 
     * @param game 
     */
    public KonaneMove makeMove(KonaneLocal game) {

        // récupration de l'ensembles des coups possibles pour l'IA
        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>(game.generateMoves(this));

        // Cas du game over à traiter
        if (possibleMoves.isEmpty()) {
            // TODO: Programmer le GAME OVER
        }

        int DEPTH = level; // plus le niveau est élevé, plus l'IA sera précise
        double max = (-100), val; // on minimise max au début de l'algotithme

        // création du meilleur coup possible (par défaut le premier coup)
        KonaneMove bestMove = new KonaneMove(possibleMoves.get(0));

        // Test de tous les coups
        for (int i = 0; i < possibleMoves.size(); i++) {
            KonaneMove m = new KonaneMove(possibleMoves.get(i));
            KonaneLocal gameCopy = new KonaneLocal(game);

            gameCopy.getBoard().makeMove(m);

            // simulation via minimax
            val = min(gameCopy, DEPTH);

            if (val > max) {
                max = val; // un coup plus interressant a été trouvé
                bestMove = m; // on le sauvegarde
            }

        }
        return bestMove;
    }
}
