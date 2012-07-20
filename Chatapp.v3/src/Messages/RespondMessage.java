/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.Serializable;

/**
 *
 * @author Nikola
 */
public class RespondMessage  implements Serializable {
    
    private String status;
    private String messages;

    public RespondMessage(String status) {
        this.status = status;
    }

    public RespondMessage(String status, String messages) {
        this.status = status;
        this.messages = messages;
    }

    
    
    

    public String getStatus() {
        return status;
    }

    public String getMessages() {
        return messages;
    }
    
    
    
    
    
}
