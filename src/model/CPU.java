package model;

import controller.KonaneException;
import java.util.ArrayList;

/**
 * Implémentation de l'algorithme Minimax La classe CPU est un joueur dirigé par
 * le programme
 *
 * @author Hadrien
 */
public class CPU extends Player {

    private int level = 1; // Niveau de difficulté de l'IA

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
        if (level >= 0) {
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
     * Constructeur avec uniquement le nom du joueur
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
     * Minimax: But de la fonction min - Minimiser le score de l'adversaire
     */
    public double min(KonaneLocal game, int depth) {

        double min = (+100), val; // au départ, le score min est initiaisé avec un gros entier positif

        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>();

        int i, j;

        // On récupère l'ensemble des coups possibles de l'opposant... 
        possibleMoves = game.generateMoves(game.getOppOf(this));

        if (depth == 0 || possibleMoves.size() == 0) {
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
     */
    public double max(KonaneLocal game, int depth) {

        double max = (-100), val; // ¨par défaut on initialise max, à une très petite valeur

        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>();

        int i, j;

        // Génération de tous les coups possibles pour l'IA...
        possibleMoves = game.generateMoves(this);

        if (depth == 0 || possibleMoves.size() == 0) {
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
     * Evaluation de l'heuristique pour un tableau donné:
     * Soit H(n) l'évaluation heuristique
     * O(n) Le nombre de coups possibles pour l'adersaire (opposant)
     * et P(n) Le nombre de coups possibles pour l'IA
     * 
     * Alors H(n) = P(n) - O(n)
     * On privéligie un H(n) > 0
     */
    public double heuristic_evaluation(KonaneLocal game) {


        ArrayList<KonaneMove> AI_possibleMoves = new ArrayList<KonaneMove>(),
                O_possibleMoves = new ArrayList<KonaneMove>();

        double heuristic_value;

        // Récupération des mouvements de l'IA et de l'opposant
        AI_possibleMoves = game.generateMoves(this);
        O_possibleMoves = game.generateMoves(game.getOppOf(this));


        if (AI_possibleMoves.size() == 0) // Pire cas: l'IA perd 
        {
            heuristic_value = (-100);
        } else {
            if (O_possibleMoves.size() == 0) // Meilleur cas: l'IA gagne
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
     */
    public KonaneMove makeMove(KonaneLocal game) {


        ArrayList<KonaneMove> possibleMoves = new ArrayList<KonaneMove>();

        // récupration de l'ensembles des coups possibles pour l'IA
        possibleMoves = game.generateMoves(this);

        // Cas du game over à traiter
        if (possibleMoves.size() == 0) {
            // TODO: Programmer le GAME OVER
        }


        int DEPTH = level; // plus le niveau est élevé, plus l'IA sera précise
        double max = (-100), val; // on minimise max au début de l'algotithme


        // création du meilleur coup possible (pard défaut le premier coup)
        KonaneMove bestMove = new KonaneMove(possibleMoves.get(0));

        // Test de tous les coups
        for (int i = 0; i < possibleMoves.size(); i++) {
            KonaneMove m = new KonaneMove(possibleMoves.get(i));
            KonaneLocal gameCopy = new KonaneLocal(game);

            gameCopy.getBoard().makeMove(m);


            // simulation via minimax
            val = min(gameCopy, DEPTH);

            if (val > max) {
                max = val; // un couip plus interressant a été trouvé
                bestMove = m; // on le sauvegarde
            }

        }

        return bestMove;

    }
}
