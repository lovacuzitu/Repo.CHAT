/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import Storages.PublicMessageStorage;
import java.util.LinkedList;

/**
 *
 * @author Nikola
 */
public class pom {
    public static void main(String[] args){
        PublicMessageStorage pms = PublicMessageStorage.getPublicMessageStorage();
        if(!(pms==null)) System.out.println("blablabla");
        for(int i=0; i<5;i++){
           System.out.println(pms.getPublicMessage(i));
        }
}
}
