package com.series;

//you have to print 53124
public class Series {

	public static void main(String[] args) {
		print2(5);

	}
	static void print1(int n) {
		if(n==0) {
			return;
		}
		if(n%2==1) {
			System.out.print(n+" ");
		}
		print1(n-1);
		if(n%2==0) {
			System.out.print(n+" ");
		}
	}
	
	static void print2(int n) {
		if(n==0) {
			return;
		}
		if(n%2==0) {
			System.out.print(n+" ");
		}
		print2(n-1);
		if(n%2==1) {
			System.out.print(n+" ");
		}
	}

}
