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
public class PublicMessageStorage {
    
    public static LinkedList<String> lista;
    private static PublicMessageStorage pms=null;
    
    private PublicMessageStorage(){
        lista = new LinkedList<String>();
    }
    
    public static PublicMessageStorage getPublicMessageStorage(){
        if(pms==null) return pms = new PublicMessageStorage();
        return pms;
    }

    public String getAllPublicMessages() {
        String listaPoruka="";
        for(int i=0; i < lista.size(); i++){
            listaPoruka+=lista.get(i)+"\n";
        }
        return listaPoruka;
    }
    
    public void addPublicMessage(String s){
        lista.add(s);
    }
    
    public String getFirstPublicMessage(){
        return lista.getFirst();
    }
    
    public String getLastPublicMessage(){
        return lista.getLast();
    }
    
    public String getPublicMessage(int i){
        return lista.get(i);
    }
    
    
}
