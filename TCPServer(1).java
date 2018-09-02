import java.io.*; 
import java.net.*;

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String capitalizedSentence; 
	String ServerSentence;
      
      

      ServerSocket welcomeSocket = new ServerSocket(6789); 
     
  
      while(true) { 
  
            Socket connectionSocket = welcomeSocket.accept(); 
            System.out.println("Connection established...");
           BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
	   
		DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 

           clientSentence = inFromClient.readLine();
	System.out.println("from client :"+clientSentence);
	


	BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
	BufferedReader inFromServer=new BufferedReader(new InputStreamReader(System.in));

	    

	ServerSentence = inFromServer.readLine();
    	System.out.println("from server :"+ServerSentence);


       //    capitalizedSentence = ServerSentence.toUpperCase() + '\n'; 

           outToClient.writeBytes(ServerSentence + '\n'); 
        } 
    } 
} 
