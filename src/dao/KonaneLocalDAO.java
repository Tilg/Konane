/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KonaneLocal;

/**
 *
 * @author Romain
 */
public class KonaneLocalDAO extends DAO<KonaneLocal> {

    @Override
    public KonaneLocal find(String id) {
        KonaneLocal konane = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(id);
            ois = new ObjectInputStream(fis);

            try {
                konane = (KonaneLocal) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ois.close();
                fis.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return konane;
    }

    @Override
    public KonaneLocal create(KonaneLocal object) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(object.getSaveName());
            oos = new ObjectOutputStream(fos);

            try {
                oos.writeObject(object);
            } catch (IOException ex) {
                Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                oos.close();
                fos.close();
            }
            
            object = this.find(object.getSaveName());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return object;
    }

    @Override
    public KonaneLocal update(KonaneLocal object) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(object.getSaveName());
            oos = new ObjectOutputStream(fos);

            try {
                oos.writeObject(object);
            } catch (IOException ex) {
                Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                oos.close();
                fos.close();
            }
            
            object = this.find(object.getSaveName());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KonaneLocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return object;
    }

    @Override
    public void delete(KonaneLocal object) {
        boolean is_delete;
        is_delete = new File(object.getSaveName()).delete();
    }
}
