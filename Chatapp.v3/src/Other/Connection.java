/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Messages.RequestMessage;
import Messages.RespondMessage;
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
public class Connection {
    
   Socket s;
    OutputStream os;
    RequestMessage to;
    ObjectOutputStream oos;
    private Connection connection = null;
    InputStream is;
    ObjectInputStream ois;
    String serverName;
    String portNo;
    
    
    public Connection(){}
    
    
//    public static Connection getConnection(){
//        if(connection == null) return connection = new Connection();
//        return connection;
//    }
    
    
    
    public void connect(RequestMessage m)throws Exception{
            
            s = new Socket(m.getServerName(), Integer.parseInt(m.getPortNumber())); 
            os = s.getOutputStream();  
            
            oos = new ObjectOutputStream(os); 
            
            to = m;  
                 
        
    }
    
    public void writeToServer(){
        try{
            oos.writeObject(to); 
        }catch(Exception e){System.out.println(e);}
    }
    
    public RespondMessage getServerResponse()throws Exception{
        is=s.getInputStream();
        ois = new ObjectInputStream(is);
        RespondMessage m = (RespondMessage) ois.readObject();
        return m;
    }

    public void close() {
        try {
            is.close();
            os.close();
            oos.close();
            ois.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
    
    
    
    
    
}
