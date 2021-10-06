package com.rec;

public class FindFirstIndex {

	public static void main(String[] args) {
		int ar[]= {2,7,4,2,8,3};
		System.out.println(find(ar,9,0));

	}
	static int find(int ar[],int ele,int i) {
		if(i==ar.length) {
			return -1;
		}
		if(ar[i]==ele) {
			return i;
		}
		return find(ar,ele,i+1);
	}

}
