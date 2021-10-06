package co.tushar.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class extra {

	 public  static void  main(String s[]){
		    
		
		    Scanner sc=new Scanner(System.in);
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    
		   if(a==b) {
			   System.out.println(0);
			   return;
		   }
		   if(a<b) {
			   int temp=a;
			   a=b;
			   b=temp;
		   }
		    
		   HashMap<Integer,Integer> map=new HashMap<>();
		   
		   int c=0;
		    while(a!=1)
		    {
		        c++;
		        a=findFactor(a);
		        map.put(a, c);
		    } 
		    c=0;
		    while(!map.containsKey(b))
		    {
		        c++;
		        b=findFactor(b);
		    }
		    System.out.println(c+map.get(b));
		   
		    
		  }
		  
		
		  
		 
		  
		  public static int findFactor(int n){
		    
		    if(n==1){
		      return 1;
		      }
		    
		    
		    List<Integer> l=new ArrayList<>();
		    
		    for(int i=2;i<=n/2;i++){
		      
		      if(n%i==0){
		        l.add(i);
		      }
		      
		    }
		    
		    if(l.size()==0){
		     
		      return 1;
		    }
		    
		    return l.remove(l.size()-1);
		    
		  }
		  
		 

}


