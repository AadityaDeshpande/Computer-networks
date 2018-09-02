
import java.util.Scanner;
import java.net.InetAddress;

class subnet2
{

public static void main(String args[]) 
{
Scanner sc= new Scanner(System.in);
System.out.print("Enter the ip address=");
String ip=sc.nextLine();


//----Split the Ip Address-------

String split_ip[] = ip.split("\\.");
		

//----- Converting the Ip Address to binary----

String split_bip[]= new String[4];

String bip = "";

for(int i=0;i<4;i++)
{
split_bip[i]=appendZeroes(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
bip+=split_bip[i];
}
System.out.println("The binary IpAddress is="+bip);

//----- Finding the Subent mask-----

System.out.println("Enter the number of address");
int n=sc.nextInt();

int bits=(int)Math.ceil(Math.log(n)/Math.log(2));
System.out.println("The number of bits required="+bits);

int mask=32-bits;
int total_address=(int)Math.pow(2,bits);
System.out.println("Subnet mask is "+mask);

//---- Finding the first and last address----

//---- First address Calculation--------
int fbip[]=new int[32];

for(int i=0;i<32;i++)
{
//Convert to the character 1,0 to integer 1,0

fbip[i]=(int)bip.charAt(i)-48;

}

for(int i=31;i>31-bits;i--)
{
//Get first address by anding the last bits with 0

fbip[i] &=0;
}

String fip[]={"","","",""};
for(int i=0;i<32;i++)
{
fip[i/8]=new String(fip[i/8]+fbip[i]);
} 
int first_offset=0;
int ipAddr[]=new int[4];  	;
System.out.println("Range \nThe First Address is:");
for(int i=0;i<4;i++)
{
System.out.print(ipAddr[i]=first_offset=Integer.parseInt(fip[i],2));
if(i!=3)
System.out.print(".");
}
System.out.println();


//--- Last address Calculation----
int lbip[]=new int [32];

for(int i=0;i<32;i++)
{
// Convert the character 1,0 to integer 1,0

lbip[i]=(int)bip.charAt(i)-48;
}

for(int i=31;i>31-bits;i--)
{

// Get last address by oring with last bits with 1

lbip[i]|= 1;
}
 String lip[]={"","","",""};
for(int i=0;i<32;i++)
{
lip[i/8]=new String(lip[i/8]+lbip[i]);
}
int ipLast[]=new int[4]; 
System.out.println("The Last Address is:");
for(int i=0;i<4;i++)
{
System.out.print(ipLast[i]=Integer.parseInt(lip[i],2));
if(i!=3)
System.out.print(".");
}
System.out.println();
System.out.println("How many subnets do you want to form?");
int scount=sc.nextInt();
int incrm=0;
for(int j=0;j<scount;j++)
{
System.out.println("How many customers do you want to form? in group "+j);
incrm=sc.nextInt();
System.out.println(" GROUP "+ (j+1)+" FIRST ADDRESS:");
for(int i=0;i<4;i++)
{
if(i<3)
{
System.out.print(ipAddr[i]+".");
}
else
System.out.println(ipAddr[i]);
}
System.out.println(" GROUP "+ (j+1)+" LAST ADDRESS:");
for(int i=0;i<4;i++)
{
if(i<3)
{
System.out.print(ipLast[i]+".");
}
else
{
	if((ipAddr[i]+incrm)>=ipLast[i])
	{
		System.out.print(ipLast[i]);
	}
	else
	{
		System.out.println(ipAddr[i]=ipAddr[i]+incrm-1);
	}
}

}
ipAddr[3]++;
System.out.println();
}
try
{

System.out.println("Enter the Ip address to ping=");
Scanner s=new Scanner(System.in);
String ip_add=s.nextLine();
 InetAddress inet = InetAddress.getByName(ip_add);
if(inet.isReachable(5000))
{
System.out.println("The ip address is reachable"+ip_add);
}
else
{
System.out.println("The ip address is not reachable"+ip_add);
}
}
 catch( Exception e)
{
System.out.println("Exception:"+e.getMessage());
}
}

static String appendZeroes(String s)
{
String temp= new  String("00000000");
return temp.substring(s.length())+ s;
}
}
 
/*output:
aaditya@aaditya-inspiron-5559:~/Downloads$ javac subnet2.java
aaditya@aaditya-inspiron-5559:~/Downloads$ java subnet2
Enter the ip address=200.2.1.0     
The binary IpAddress is=11001000000000100000000100000000
Enter the number of address
8
The number of bits required=3
Subnet mask is 29
Range 
The First Address is:
200.2.1.0
The Last Address is:
200.2.1.7
How many subnets do you want to form?
2
How many customers do you want to form? in group 0
2
 GROUP 1 FIRST ADDRESS:
200.2.1.0
 GROUP 1 LAST ADDRESS:
200.2.1.1

How many customers do you want to form? in group 1
6
 GROUP 2 FIRST ADDRESS:
200.2.1.2
 GROUP 2 LAST ADDRESS:
200.2.1.7
Enter the Ip address to ping=
200.2.1.9
The ip address is not reachable200.2.1.9
aaditya@aaditya-inspiron-5559:~/Downloads$ 
      */



