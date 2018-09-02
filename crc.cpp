#include<iostream>
using namespace std;


int main()
{
  int inp[30],res[30],tm[30],ns,nd,div[30],temp[30],rs,i,j,k;
  

  cout<<"\n Enter number of bits of sender side message :";
  cin>>ns;
  
  cout<<"\n Enter sender side message (bit by bit) :"<<endl;
  
  	for(int i=0;i<ns;i++)
  	{
  		cin>>inp[i];
  		temp[i]=inp[i];
  	}
	
  cout<<"\n Enter number of bits of divisor :";
  cin>>nd;
  
  cout<<"\n Enter divisor (bit by bit) :"<<endl;
  
  	for(int i=0;i<nd;i++)
  	{
  		cin>>div[i];
  	}
  
  rs=nd-1;
  
  cout<<"\n Number of zeros to be appended :"<<rs;
  
  cout<<"\n\n Sender side message after appending zeros:"<<endl;
  
  	for(int i=ns;i<ns+rs;i++)
  	{
  		temp[i]=0;
  	}
  
  	for(int i=0;i<ns+rs;i++)
  	{
  		cout<<" "<<temp[i];
  	}
  
  	
  
  for( i=0;i<ns;i++)
  {
  	j=0,k=i;
  	if(temp[k]>=div[j])
  	{
  		for(j=0,k=i;j<nd;j++,k++)
  		{
  			if((temp[k]==1 && div[j]==1) || (temp[k]==0 && div[j]==0))
  			{
  				temp[k]=0;
  			}
  			else
  			{
  				temp[k]=1;
  			}
  		}
  	
  	
  	}
  	
  
  }
	
	cout<<"\n\n CRC bits are :"<<endl;
	for(i=ns;i<ns+rs;i++)
	{
		cout<<" "<<temp[i];
	}
	
		
		
	cout<<"\n\n Transmitted message :"<<endl;
	
	for(i=0;i<ns;i++)
	{
		tm[i]=inp[i];
	
	}
	
	for(i=ns;i<ns+rs;i++)
	{
		tm[i]=temp[i];
	}

	
	for(i=0;i<ns+rs;i++)
	{
	   if(i==ns)
	   cout<<" ";
	   cout<<" "<<tm[i];
	}


	cout<<"\n\n Enter received message :"<<endl;
	
	for(i=0;i<ns+rs;i++)
	{
		
		cin>>res[i];
		temp[i]=res[i];
	}
	
	
	for(i=0;i<ns;i++)
 	 {
 	 	j=0,k=i;
 	 	if(temp[k]>=div[j])
 	 	{
 	 		for(j=0,k=i;j<nd;j++,k++)
 	 		{
 	 			
 	 					
 	 			if((temp[k]==1 && div[j]==1) || (temp[k]==0 && div[j]==0))
 	 			{
 	 				temp[k]=0;
 	
 	 			}
 	 			else
 	 			{
 	 				temp[k]=1;
 	 			}
 	 			
 	 		}
  		}
  	}		
	
	
	
	
	int flag=0;
	
	
	cout<<"\n\n Remainder :"<<endl;
	for(i=ns;i<ns+rs;i++)
	{
		cout<<" "<<temp[i];
		if(temp[i]!=0)
		{
			flag=1;
		}
	}	
	
	if(flag==1)
	cout<<"\n There must be an error in message transmitted from sender to receiver!!";

	else
	cout<<"\n No error in message transmitted from sender to receiver";



	cout<<endl;
  return 0;
  
}  

