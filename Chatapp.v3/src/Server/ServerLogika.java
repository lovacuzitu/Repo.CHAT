/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import Messages.RequestMessage;
import Messages.RespondMessage;
import Other.User;
import Storages.LoggedUsersStorage;
import Storages.PublicMessageStorage;
import Storages.RegisteredUsers;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
class ServerLogika extends Thread{
    
    Socket s;
    PublicMessageStorage pms = PublicMessageStorage.getPublicMessageStorage();
    RegisteredUsers ru = RegisteredUsers.getRegisteredUsers();
    LoggedUsersStorage lgu = LoggedUsersStorage.getLoggedUsers();
    

    public ServerLogika(Socket s) {
        
        this.s = s;
    }
    
    public void run(){
        try {
            InputStream is = s.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            RequestMessage mess =(RequestMessage) ois.readObject();  
            RespondMessage msgR = null;
            if(mess.getCommand().equals("connect")){
                msgR = new RespondMessage("ok_connect");
                
            }
            
            
            else if(mess.getCommand().equals("register")){
                if((ru.registerUser(mess.getUsr()))){
                    msgR = new RespondMessage(("ok_register"));
                    
                }
                else{
                    msgR = new RespondMessage("error_register");
                }
            }
            
            else if(mess.getCommand().equals("loggin")){
                if(lgu.loggInUser(mess.getUsr())==true){
                   msgR = new RespondMessage("ok_loggin");
     
                }else{
                   msgR = new RespondMessage("error_loggin");
                }
            }
            
           else if(mess.getCommand().equals("public")){
                pms.addPublicMessage(mess.getUsr().getUsername()+"$"+ mess.getMessage());
                msgR = new RespondMessage("ok_public",pms.getAllPublicMessages());
            }
           
           
           else if(mess.getCommand().equals("getpublic")){
               msgR = new RespondMessage("ok_getpublic",pms.getAllPublicMessages());
               
           }
           
           
           else if (mess.getCommand().equals("logout")){
                if(lgu.removeUserByName(mess.getUsr().getUsername())){
                    msgR = new RespondMessage("ok_loggout");
                   
                }
                else   msgR = new RespondMessage("error_loggout");
           }
           else if(mess.getCommand().equals("private")){
              
               String name = mess.getTo();
                
               User usr = ru.getUserByName(name);
               usr.getName();
               usr.addPrivateMessage(mess.getUsr().getUsername()+"$"+mess.getMessage());
                
               String poruka;
               poruka = usr.getPrivateMessages();
               msgR = new RespondMessage("ok_private");
           }
            
           else if(mess.getCommand().equals("users")){
             
                msgR = new RespondMessage("ok_users",ru.getAllregisteredUsers());
               
           }
            
            else if(mess.getCommand().equals("getprivate")){
                User usr = ru.getUserByName(mess.getUsr().getUsername());
                msgR = new RespondMessage("ok_getprivate", usr.getPrivateMessages());
            }
            
           
            
            else {
                
            }
            
            OutputStream os = s.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(msgR);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerLogika.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerLogika.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
