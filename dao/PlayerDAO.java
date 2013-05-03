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
import model.Player;

public class PlayerDAO extends DAO<Player> {

    @Override
    public Player find(String id) {
        Player player = null;

        try {
            String statement = "SELECT * FROM player WHERE player_name = ? ";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, id);
            ResultSet result = ps.executeQuery();

            if (result.first()) {
                player = new Player(id, result.getInt("player_nb_wins"), result.getInt("player_nb_losses"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }

    @Override
    public Player create(Player object) {
        try {
            String statement = "INSERT INTO player (player_name, player_nb_wins, player_nb_losses) VALUES (?,?,?)";
            PreparedStatement ps = connexion.prepareStatement(statement);
            
            ps.setString(1, object.getName());
            ps.setInt(2, object.getNbwins());
            ps.setInt(3, object.getNbloose());
            
            ps.executeUpdate();   
            object = this.find(object.getName());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public Player update(Player object) {
        try {
            String statement = "UPDATE player SET player_nb_wins = ?, player_nb_losses = ? WHERE player_name = ?";
            PreparedStatement ps = connexion.prepareStatement(statement);
 
            ps.setInt(1, object.getNbwins());
            ps.setInt(2, object.getNbloose());
            ps.setString(3, object.getName());
            
            ps.executeUpdate();   
            object = this.find(object.getName());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    @Override
    public void delete(Player object) {
        try {
            String statement = "DELETE FROM player WHERE player_name = ?";
            PreparedStatement ps = connexion.prepareStatement(statement);
            ps.setString(1, object.getName());
            ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
