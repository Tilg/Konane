/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caedes
 */
public final class Singleton {

    private static Singleton singleton = null;
    private static Connection connexion = null;
    
    private static String driver = "jdbc:mysql://";
    private static String host = "localhost";
    private static String db = "db_konane";
    private static String port = "3306";
    private static String login = "root";
    private static String password = "";

    private Singleton() throws SQLException {
        if (connexion == null) {
            try {
                connexion = (Connection) DriverManager.getConnection(
                        Singleton.driver + Singleton.host + ":" + Singleton.port + "/" + Singleton.db,
                        Singleton.login,
                        Singleton.password);
            } catch (SQLException e) {
                System.out.println("Base de données indisponible");
            }
        }
    }

    public synchronized Connection getConnexion() {
        return Singleton.connexion;

    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            try {
                singleton = new Singleton();
            } catch (SQLException ex) {
                System.err.println("Base de données indisponible");
                System.exit(0);
            }
        }
        return singleton;
    }
}
