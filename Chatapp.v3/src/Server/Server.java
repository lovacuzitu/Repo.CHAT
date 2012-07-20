/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Storages.LoggedUsersStorage;
import Storages.PublicMessageStorage;
import Storages.RegisteredUsers;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class Server {
    
    public static void main(String[] args){
        
            ServerSocket ss=null;
            try {
                ss = new ServerSocket(8090);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(true){
            try {
                
                Socket s = ss.accept();
                ServerLogika sl = new ServerLogika(s);
                sl.start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        
    }
}
