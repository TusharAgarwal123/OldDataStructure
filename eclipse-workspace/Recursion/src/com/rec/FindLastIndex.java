package com.rec;

public class FindLastIndex {

	public static void main(String[] args) {
		int ar[]= {2,4,6,2,6,3};
		System.out.println(find(ar,6,0));

	}
	static int find(int []ar,int ele,int i) {
		if(i==ar.length) {
			return -1;
		}
		int ind=find(ar, ele, i+1);
		
		if(ind==-1) {
			
		if(ar[i]==ele) {
			return i;
		}else {
			return -1;
		}
			
		
		}else {
			return ind;
		}
	}

}
