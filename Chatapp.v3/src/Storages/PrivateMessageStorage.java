/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Storages;

import java.util.LinkedList;

/**
 *
 * @author Nikola
 */
public class PrivateMessageStorage {
    
    private static LinkedList<String> lista;
    private static PrivateMessageStorage pms=null;
    
    private PrivateMessageStorage(){
        lista = new LinkedList<String>();
    }
    
    public static PrivateMessageStorage getPrivateMessageStorage(){
        if(pms==null) return pms = new PrivateMessageStorage();
        return pms;
    }

    public LinkedList<String> getAllPrivateMessages() {
        return lista;
    }
    
    public void addPrivateMessage(String s){
        lista.add(s);
    }
    
    public String getFirstPrivateMessage(){
        return lista.getFirst();
    }
    
    public String getLastPrivateMessage(){
        return lista.getLast();
    }
    
    public String getPublicMessage(int i){
        return lista.get(i);
    }
    
    
}
