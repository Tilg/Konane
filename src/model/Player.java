/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Caedes
 */
public class Player {

    private String name = "Player";
    private int nb_wins = 0;
    private int nb_loose = 0;
    private int tmp_color = -1;
    
    //Constructors
    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int nb_wins ,int nb_loose) {
        this.name = name;
        this.nb_wins = nb_wins;
        this.nb_loose = nb_loose;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getNbwins() {
        return nb_wins;
    }

    public int getNbloose() {
        return nb_loose;
    }

    public int getTmp_color() {
        return tmp_color;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNbwins(int nbwins) {
        this.nb_wins = nbwins;
    }

    public void setNbloose(int nbloose) {
        this.nb_loose = nbloose;
    }
    
    public void setTmp_color(int tmp_color) {
        this.tmp_color = tmp_color;
    }
    //Fonctions
}
