import java.io.*;
import java.net.*;
import java.util.*;
  /**
  * Inicialização do servidor
  *
  * @author           Rodrigo
  * @author           Pedro
  * @author           Leonardo
  */ 
public class Servidor {
    public static void main(String args[]) throws Exception {
        String clientSentence;
        String clientNome;
        ServerSocket welcomeSocket = new ServerSocket(6789);
    
    while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            clientNome = inFromClient.readLine();
            outToClient.writeBytes("online");
               
        }
    }
}