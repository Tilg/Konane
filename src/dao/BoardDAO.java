/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Board;
import model.Color;
import model.Pawn;

/**
 *
 * @author Romain
 */
public class BoardDAO extends DAO<Board> {

    @Override
    public Board find(String id) {
        Board board = null;
        Pawn[][] squares = null;

        try {
            // Récupération du plateau de jeu
            String statement = "SELECT * FROM board WHERE game_name = ? ";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, id);
            ResultSet result = ps.executeQuery();

            if (result.first()) {
                
                int nb_cases = result.getInt("board_nb_cases");

                // Récupération des pions du plateau
                statement = "SELECT * FROM square WHERE game_name = ? ";
                ps = connexion.prepareStatement(statement);
                ps.setString(1, id);
                result = ps.executeQuery();
                
                squares = new Pawn[nb_cases][nb_cases];

                while (result.next()) {
                    Pawn pawn = null;
                    // Si la case est vide ( color = -1), on ne crée pas le pion
                    if (result.getInt("square_pawn") != Color.NO_PAWN.getValue()) {
                        pawn = new Pawn(result.getInt("square_x"), result.getInt("square_y"), Color.getColor(result.getInt("square_pawn")));
                    }
                    squares[result.getInt("square_x")][result.getInt("square_y")] = pawn;
                }

                board = new Board(id, nb_cases, squares);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return board;
    }

    @Override
    public Board create(Board object) {
        try {
            // Création du pokateau de jeu
            String statement = "INSERT INTO board (game_name, board_nb_cases) VALUES (?,?)";
            PreparedStatement ps = connexion.prepareStatement(statement);

            ps.setString(1, object.getGame_name());
            ps.setInt(2, object.getNb_case());

            ps.executeUpdate();

            // Création des cases, contenant les pions
            for (int i = 0; i < object.getNb_case(); i++) {
                for (int j = 0; j < object.getNb_case(); j++) {
                    Pawn pawn = object.getSquares()[i][j];

                    statement = "INSERT INTO square (square_x,square_y,game_name,square_pawn) VALUES (?,?,?,?)";
                    ps = connexion.prepareStatement(statement);
                    ps.setInt(1, i);
                    ps.setInt(2, j);
                    ps.setString(3, object.getGame_name());
                    ps.setInt(4, (pawn == null) ? Color.NO_PAWN.getValue() : pawn.getColor().getValue());
                    ps.executeUpdate();
                }
            }

            object = this.find(object.getGame_name());
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public Board update(Board object) {
        try {

            // Mise à jour des cases, contenant les pions
            for (int i = 0; i < object.getNb_case(); i++) {
                for (int j = 0; j < object.getNb_case(); j++) {
                    Pawn pawn = object.getSquares()[i][j];

                    String statement = "UPDATE square SET square_pawn = ? WHERE game_name = ? "
                            + "AND square_x = ? AND square_y = ?";
                    PreparedStatement ps = connexion.prepareStatement(statement);
                    ps.setInt(1, (pawn == null) ? Color.NO_PAWN.getValue() : pawn.getColor().getValue());
                    ps.setString(2, object.getGame_name());
                    ps.setInt(3, i);
                    ps.setInt(4, j);
                    ps.executeUpdate();
                }
            }

            object = this.find(object.getGame_name());
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public void delete(Board object) {
        try {
            String statement = "DELETE FROM board WHERE game_name = ?";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, object.getGame_name());
            ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
