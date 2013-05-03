
import dao.PlayerDAO;
import model.Player;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Romain
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1 = new Player("Romain");
        Player p2 = new Player("Etienne");
        
        PlayerDAO pdao1 = new PlayerDAO();
        PlayerDAO pdao2 = new PlayerDAO();
        
        pdao1.create(p1);
        pdao2.create(p2);
        
        p1 = pdao1.find("etienne");
        p2 = pdao2.find("romain");
        
        
        
        
    }
}
