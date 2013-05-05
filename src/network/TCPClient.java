/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caedes
 */
public class TCPClient extends Thread{
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private int player_number;      //1 si joueur 1 Et 2 si joueur 2
    private String msg = "";

    public TCPClient() {
    }
        
    public void run(){
        try {
            sendMessage();
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initialisation(int player_numb) throws IOException{
        this.player_number = player_numb;
        if(player_number == 1){
            socket = new Socket("localhost",1100);
        }
        else if(player_number == 2){
            socket = new Socket("localhost",1101);
        }
    }
    
    public void sendMessage() throws IOException{
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg_return = in.readLine();
        if("END".equals(msg_return)){
            socket.close();
        }
        else {
            action(msg_return);
            System.out.println("Envoie du message : " + msg);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.println(msg);
            out.flush();
        }
        System.out.println("Fin d'envoie\n");
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void action(String msg){
        System.out.println("Message recu chez le joueur " + this.player_number + " : " + msg);
    }
}

