/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Storages;

import Other.User;
import java.util.LinkedList;

/**
 *
 * @author Nikola
 */
public class LoggedUsersStorage{

    private static LinkedList<User> lista = null;
    private static LoggedUsersStorage loggedUsers = null;
    public static RegisteredUsers regUsers = RegisteredUsers.getRegisteredUsers();
    
    private LoggedUsersStorage(){
        lista = new LinkedList<User>();
    }
    
    public static LoggedUsersStorage getLoggedUsers(){
        if(loggedUsers==null){
            return loggedUsers = new LoggedUsersStorage();
        }
        return loggedUsers;
    }
    
    public boolean loggInUser(User usr){
        if(regUsers.checkIfRegistered(usr)==true){
        for(int i =0 ; i< lista.size(); i++){
            if(usr.equals(lista.get(i))) return true;
            }
            lista.add(usr);
            return true;
        }
        return false;
            
        
    }
    
    public boolean loggOutUser(User usr){
        return true;
    }
    
    public User getFirstUser(){
        return lista.getFirst();
    }

    public String getLoggedInUsers() {
        String listaUsera="";
        for(int i=0; i < lista.size(); i++){
            listaUsera+=lista.get(i).getUsername()+"\n";
        }
        return listaUsera;
    }
    
     public boolean  removeUserByName(String name){
        
        for(int i =0; i < lista.size(); i ++ ){
            String getname=lista.get(i).getUsername();
            if(getname.equals(name)){
                lista.remove(i);
                return true;
            
            }
        }
        return false;
    }
    
    
}
