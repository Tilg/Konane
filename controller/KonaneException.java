/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Caedes
 */
public class KonaneException extends Exception {
    
    private int error_num;
    private String error_message;
    
    //Constructor
    public KonaneException() {
        super();
    }

    public KonaneException(int error_num, String error_message) {
        super();
        this.error_num = error_num;
        this.error_message = error_message;        
    }
    
    
}
