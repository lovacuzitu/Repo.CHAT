package Other;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikola
 */
public class User implements Serializable {
    
    private String name = null;
    private String surname = null;
    private String username;
    private String password = null;
    
    public String privateMessages = "";

   
public User(String username){
    this.username= username;
}
  
    
    public User(String name, String surname, String ussername, String password) {
        this.name = name;
        this.surname = surname;
        this.username = ussername;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPrivateMessages() {
        return privateMessages;
    }

    public void setPrivateMessages(String privateMessages) {
        this.privateMessages = privateMessages;
    }

    
    
    

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public boolean equals(User usr){
        if(this.getUsername().equals(usr.getUsername())&&this.getPassword().equals(usr.getPassword()))
            return true;
        return false;
    }

    public void addPrivateMessage(String message) {
        this.setPrivateMessages(this.getPrivateMessages().concat(message));
        
    }
    
    
}
