
import dao.KonaneLocalDAO;
import model.Human;
import model.KonaneLocal;
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
        Player p1 = new Human("Romain");
        Player p2 = new Human("Hadrien");
        
        KonaneLocal konane = new KonaneLocal(p1,p2,8,0,0);
        konane.setSaveName("test");
        konane = new KonaneLocalDAO().create(konane); 
    }
}
