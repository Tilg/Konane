/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caedes
 */
public class TCPServer extends Thread{
    
    private ServerSocket srv1;
    private ServerSocket srv2;
    private PrintWriter out;
    private BufferedReader in;
    private TCPClient j1;
    private TCPClient j2;
    private Socket socket1;
    private Socket socket2;
    
    public TCPServer(TCPClient j1, TCPClient j2) {
        this.j1 = j1;
        this.j2 = j2;
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run(){
        try {
            startRelation();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void startServer() throws IOException{
        this.srv1 = new ServerSocket(1100);
        j1.initialisation(1);
        socket1  = srv1.accept();
        this.srv2 = new ServerSocket(1101);
        j2.initialisation(2);
        socket2  = srv2.accept();
    }
    
    public void startRelation() throws IOException{
        out = new PrintWriter(new OutputStreamWriter(socket1.getOutputStream()));
        out.println("OK");
        out.flush();
        while(true){
            System.out.println("En attente de message");
            //Phase Joueur 1
            System.out.println("Attente de msg de J1");
            playerRelation(socket1, socket2);
            //Phase Joueur 2
            System.out.println("Attente de msg de J2");
            playerRelation(socket2, socket1);
        }
    }
    public void endRelation() throws IOException{
        socket1.close();
        socket2.close();
    }
    
    public void playerRelation(Socket s1, Socket s2) throws IOException{
        String msg_return = "";
        in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        msg_return = in.readLine();
        out = new PrintWriter(new OutputStreamWriter(s2.getOutputStream()));
        out.println(msg_return);
        out.flush();
    }
}
