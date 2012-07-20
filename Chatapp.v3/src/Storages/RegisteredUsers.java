/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Storages;

import java.util.LinkedList;
import Other.User;
/**
 *
 * @author Nikola
 */
public class RegisteredUsers {
    
    public static LinkedList<User> lista = null;
    private static RegisteredUsers regUsers = null;
    private static LoggedUsersStorage loggUsers = LoggedUsersStorage.getLoggedUsers();
    
    
    private RegisteredUsers(){
        lista = new LinkedList<User>();
    }
    
    public static RegisteredUsers getRegisteredUsers(){
        if(regUsers==null) return regUsers = new RegisteredUsers();
        return regUsers;
    }
    
    public boolean  registerUser(User usr){
        for(int i =0 ; i< lista.size(); i++){
            if(usr.getUsername().equals(lista.get(i).getUsername())) return false;
        }
        lista.add(usr);
        loggUsers.loggInUser(usr);
        return true;
       
    }
    
    public User getFirstUser(){
        return lista.getFirst();
    }
    
    public  boolean checkIfRegistered(User usr){
        if(regUsers == null) return false;
        for(int i = 0 ; i<lista.size();i++){
            if(usr.equals(lista.get(i))){
            return true;
            }
        
        }  
        return false;
    }
    
    
    public User getUserByName(String name){
        
        for(int i =0; i < lista.size(); i ++ ){
            String getname=lista.get(i).getUsername();
            if(getname.equals(name)){
                return lista.get(i);
            
            }
        }
        return null;
    }
    
    public String getAllregisteredUsers(){
        String listaUsera="";
        for(int i=0; i < lista.size(); i++){
            listaUsera+=lista.get(i).getUsername()+"\n";
        }
        return listaUsera;
    }
    
}
