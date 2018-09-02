//udp server java
import java.io.*; 
import java.net.*; 
  
class UDPServer { 
  public static void main(String args[]) throws Exception 
    { 
  
      DatagramSocket serverSocket = new DatagramSocket(9876); 
       BufferedReader outFromser = 
        new BufferedReader(new InputStreamReader(System.in)); 
  
      byte[] receiveData = new byte[1024]; 
      byte[] sendData  = new byte[1024]; 
  
      while(true) 
        { 
  
          DatagramPacket receivePacket = 
             new DatagramPacket(receiveData, receiveData.length); 
           serverSocket.receive(receivePacket); 
           
          String sentence = new String(receivePacket.getData()); 
  
          //System.out.print(sentence);

          InetAddress IPAddress = receivePacket.getAddress(); 
 
          System.out.print(" from ip =" +IPAddress+" msg is = " +sentence +"\n" );
  
          int port = receivePacket.getPort(); 
        
          String word = outFromser.readLine();
  
         // String capitalizedSentence = sentence.toUpperCase(); 

          sendData = word.getBytes(); 
        
         
  
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port); 
        

          serverSocket.send(sendPacket);
  //   DatagramPacket sendPacket2 = new DatagramPacket(sendData, sendData.length, IPAddress,port); 
 
        } 
    } 
}  
