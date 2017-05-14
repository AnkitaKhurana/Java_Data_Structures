import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Array_DS {

	
	private int a[];
	private int size ;
	private int max;
	private int min ;
	private Scanner s;
	Array_DS()
	{
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		s = new Scanner(System.in);
		System.out.println("Enter Array Size ");
		size = s.nextInt();
		a = new int[size];
		System.out.println("Now Enter Array ");
		for(int i = 0 ; i < size; i ++)
			{
			
			a[i]=s.nextInt(); 
			if(a[i]<min)
				min = a[i];
			if(a[i]>max)
				max = a[i];
			}
	}
	public void funs()
	{
		System.out.println("1. Check if sum of two array elements = NUM");
		System.out.println("2. Find the Majority Element (appears more than n/2 times) - Counting sort");
		System.out.println("3. Find the Majority Element (appears more than n/2 times) - Moore’s Voting Algorithm");
		System.out.println("4. Find the only number Occuring Odd number Of times");
		System.out.println("5. Find Missing Number in Consecutive Numbers");
		int ans = s.nextInt();
		switch(ans)
		{
		case 1 : 	find_pair(); 
					break;
		case 2 : 	majority();
					break;
		case 3 : 	majority1();
					break;
		case 4 : 	find_odd();
					break;
		case 5 : 	missing();
					break;
					
		}
		
		
	}
	public void find_pair()
	{
		System.out.println("Enter the sum you want to find");
		int sum = s.nextInt(),var;
		int range = max - min +1;
		int flag = 0 ;
		System.out.println("Range : "+range);
		ArrayList<Boolean> temp = new ArrayList<Boolean>(range);
		for(int i = 0 ; i < range ; i ++)
			temp.add(i,false);
		
		for(int i = 0 ; i < size ; i ++)
		{
			 var = sum - a[i] ;
			 if((var >= 0 )&&(temp.get(var)==true ))
						{System.out.println(a[i]+","+(sum-a[i]));
			 			flag++;
			 			
			 			}
			
				temp.set(a[i], true);
		}
		if(flag == 0 )
			System.out.println("No such Pair Found ");
	}
	
	public void majority()
	{
		
		int range = max - min +1;
		int flag = 0 ;
		System.out.println("Range : "+range);
		int[] temp = new int[range];
		
		//ArrayList<Integer> temp = new ArrayList<Integer>(range);
		
		for(int i = 0 ; i < range ; i ++)
			temp[i]=0;
			//temp.add(i,0);
		
		for(int j = 0 ; j < size ; j ++)
		{
			temp[a[j]]++;
			
			//int val = temp.get(j);
			//temp.set(j, val+1);
		}
		for(int h = 0 ; h < range ; h ++)
		{
			if(temp[h]>size/2)
				{System.out.println(h);
			flag =1 ;}
		}
		if(flag == 0 )
			System.out.println("No Such Number Found ");
		
	}
	
	public void majority1()
	{
		int count = 0 ;
		int temp = a[0];
		for(int i = 0 ; i < size ; i ++)
		{
			if(a[i]==temp)
			{
				count ++;
				
			}
			else
				count -- ;
			if(count == 0 )
			
			{
				count = 1 ;
				temp = a[i];
			}
		}
		count = 0 ;
		for(int h = 0 ; h < size ; h ++)
		{
			if(a[h]==temp)
				count ++;
		}
		
		if(count>size/2)
		{
			System.out.println(temp);
		}
		else
			System.out.println("No Such Element Found");
		
	}
	
	
	public void find_odd()
	{
		int ans = 0 ;
		if(size % 2 ==0)
		{
			System.out.println("No such Element ");
			return;
		}
		for(int h = 0 ; h < size ; h ++)
		{
			ans = ans^a[h];
		}
		
		System.out.println(ans);
	
		
	}
	
	
	public void missing()
	{
		  int i;
		    int x1 = a[0]; /* For xor of all the elements in array */
		    int x2 = 1; /* For xor of all the elements from 1 to n+1 */
		     
		    for (i = 1; i< size; i++)
		        x1 = x1^a[i];
		            
		    for ( i = 2; i <= size+1; i++)
		        x2 = x2^i;         
		    
		   System.out.println(x1^x2);
		
		
	}
	
	
	public static void main(String arg[])
	{
		
		Array_DS ads = new Array_DS();
		ads.funs();
		
		
	}
	
}
