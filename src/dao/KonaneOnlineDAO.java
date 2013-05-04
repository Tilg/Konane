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
import model.KonaneOnline;

/**
 *
 * @author Romain
 */
public class KonaneOnlineDAO extends DAO<KonaneOnline> {

    @Override
    public KonaneOnline find(String id) {
        KonaneOnline konane = null;

        try {
            String statement = "SELECT * FROM game WHERE game_name = ? ";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, id);
            ResultSet result = ps.executeQuery();

            if (result.first()) {
                
                // Récupération du tableau de jeu
                Board board = new BoardDAO().find(id);
                
                // Récupération des informations de la partie
                konane = new KonaneOnline(id
                        ,new HumanDAO().find(result.getString("game_white_player"))
                        ,new HumanDAO().find(result.getString("game_black_player"))
                        ,new HumanDAO().find(result.getString("game_last_player"))
                        ,board
                        ,result.getInt("game_ia_white_player")
                        ,result.getInt("game_ia_black_player")
                        ,result.getBoolean("game_help")
                        ,result.getBoolean("game_start"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return konane;
    }

    @Override
    public KonaneOnline create(KonaneOnline object) {
        try {
            String statement = "INSERT INTO game (game_name, game_white_player, game_black_player, game_last_player"
                    + " ,game_ia_white_player, game_ia_black_player , game_help, game_start) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connexion.prepareStatement(statement);

            ps.setString(1, object.getSaveName());
            ps.setString(2, object.getPlayerWhite().getName());
            ps.setString(3, object.getPlayerBlack().getName());
            ps.setString(4, (object.getLastPlayerPlayed() == null) ? null : object.getLastPlayerPlayed().getName());
            ps.setInt(5, object.getType_ia_white_player());
            ps.setInt(6, object.getType_ia_black_player());
            ps.setBoolean(7, object.isHelp());
            ps.setBoolean(8, object.isStart());
            ps.executeUpdate();
            
            // Création du plateau de jeu pour la partie
            Board board = new BoardDAO().create(object.getBoard());
            
            object = this.find(object.getSaveName());
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public KonaneOnline update(KonaneOnline object) {
        try {
            // Mise à jour des infos de partie
            String statement = "UPDATE game SET game_last_player = ?, game_help = ?, game_start = ? WHERE game_name = ?";
            PreparedStatement ps = connexion.prepareStatement(statement);
            
            ps.setString(1, (object.getLastPlayerPlayed() == null) ? null : object.getLastPlayerPlayed().getName());
            ps.setBoolean(2, object.isHelp());
            ps.setBoolean(3, object.isStart());
            ps.setString(4, object.getSaveName());
            
            ps.executeUpdate();   
            
            // Mise à jour du plateau de jeu
            Board board = new BoardDAO().update(object.getBoard());
            
            object = this.find(object.getSaveName());
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return object;
    }

    @Override
    public void delete(KonaneOnline object) {
        try {
            String statement = "DELETE FROM game WHERE game_name = ?";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, object.getSaveName());
            ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
