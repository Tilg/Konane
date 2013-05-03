/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;

/**
 *
 * @author romain
 */
public abstract class DAO<T> {
    
    protected Connection connexion = Singleton.getInstance().getConnexion();
    
    public abstract T find(String id);
    public abstract T create(T object);
    public abstract T update(T object);
    public abstract void delete(T object);
    
}
