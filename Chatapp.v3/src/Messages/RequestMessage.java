/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import Other.User;
import java.io.Serializable;

/**
 *
 * @author Nikola
 */
public class RequestMessage implements Serializable {
    String command;
    User usr;
    String serverName;
    String portNumber;
    String message;
    String to;

    public RequestMessage(String command, User usr, String serverName, String portNumber, String message, String to) {
        this.command = command;
        this.usr = usr;
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.message = message;
        this.to = to;
    }
    
    
    
    public RequestMessage(String mess, String command, User usr, String serverName, String portNumber) {
        this.message = mess;
        this.command = command;
        this.usr = usr;
        this.serverName = serverName;
        this.portNumber = portNumber;
    }
    
    
    

    
    public RequestMessage(String to, String mess) {
        this.message = mess;
        this.command = to;
    }
    
    

    public String getCommand() {
        return command;
    }

    public User getUsr() {
        return usr;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public String getServerName() {
        return serverName;
    }

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return to;
    }

   
    

    
    
    
    
    
    
    
    
    
    
    
    
}
