import java.io.*;
import java.net.*;
import java.util.*;

public class Inet
{
public static void main (String args[]) throws Exception
{
int ch;
Scanner sc = new Scanner(System.in);
do
{
System.out.println("--------------Menu---------------");
System.out.println("1) HostName to IP Address" );
System.out.println("2) IP Address to HostName" );
System.out.println("3) Exit" );

ch = sc.nextInt();

switch(ch)
  {
     case 1:
            System.out.print("Enter the Hostname : ");
            String name = sc.next();
            InetAddress ip1=InetAddress.getByName(name);  
            System.out.println("IP Address: "+ip1.getHostAddress());  
            break;

     case 2:
            System.out.print("Enter the IP Address : ");
            String i = sc.next();
	    InetAddress ip2=InetAddress.getByName(i);
            System.out.println("HostName : "+ip2.getHostName());
            break;
     case 3:
            return;
            //break;


}
}while(ch!=4);
}
}
