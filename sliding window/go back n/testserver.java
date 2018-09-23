import java.io.*;
import java.net.*;
import java.util.*;

class testserver
{
public static void main(String args[])throws IOException
{
System.out.println("server Waiting for connection....");
ServerSocket ss=new ServerSocket(5000);

Socket client=new Socket();
client=ss.accept();

Scanner scr=new Scanner(System.in);

BufferedInputStream in=new BufferedInputStream(client.getInputStream());
DataOutputStream out=new DataOutputStream(client.getOutputStream());

System.out.println("Received request for sending frames");
int c=in.read();  //read no of frames sent by client   c=no of frames to send

int max=in.read();

boolean f[]=new boolean[c];

int choice=in.read();  //read choice sent by client
System.out.println("Sending....");

if(choice==0)
{

for(int i=0;i<c;++i)
{
System.out.println("sending frame number "+(i%max));
out.write(i); //send frame on server socket
out.flush();
System.out.println("Waiting for acknowledgement");

int a=in.read(); //read ack on servers socket from client
System.out.println("received acknowledgement for frame "+(i%max)+" as "+(a%max));
}
out.flush();
}



else
{
int er=in.read();

for(int i=0;i<c;++i)
{


if(i==er)
{
System.out.println("into error in sending frame no "+(i%max));  //sent frame 2
}
else
{
System.out.println("sending frame no "+(i%max));
out.write(i);  //write 0 and 1 and 3 frame
out.flush();
System.out.println("Waiting for acknowledgement ");

int a=in.read(); //read NACK

if(a!=255)
{
System.out.println("received ack for frame no: "+(i%max)+" as "+(a%max));
f[i]=true;
}
}// end of inner else
}// end of for

// check which frames have not been ack
for(int a=0;a<c;++a)
{
if(f[a]==false)
{
System.out.println("Resending frame "+(a%max));
out.write(a);
out.flush();
System.out.println("Waiting for ack ");
/*try
{
Thread.sleep(5000);
}
catch(Exception e){}
*/
int b=in.read();
System.out.println("received ack for frame no: "+(a%max)+" as "+(b%max));
f[a]=true;
}
}
out.flush();
}// end of else which is for error 

in.close();
out.close();
client.close();
ss.close();
System.out.println("Quiting");

}// end main method
}// end main class
