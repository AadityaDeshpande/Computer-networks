import java.io.*; 
import java.net.*; 
class TCPClient { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        
        String modifiedSentence; 
      while(true){
        System.out.print("FROM CLIENT : ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

        Socket clientSocket = new Socket("10.30.74.219", 6789); 

        DataOutputStream outToServer =new DataOutputStream(clientSocket.getOutputStream()); 
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

        sentence = inFromUser.readLine(); 

        outToServer.writeBytes(sentence + '\n'); 

        modifiedSentence = inFromServer.readLine(); 

         

        if(modifiedSentence.equals("bye"))   
         {
         clientSocket.close();
           break;
          } 
     System.out.println("FROM SERVER: " + modifiedSentence);
      }             
    } 
} 
