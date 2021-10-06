package com.rec;

//find path in n*m grid.
public class PathInNXM {

	public static void main(String[] args) {
		
		System.out.println(findPath(3,3));

	}
	static int findPath(int n,int m) {
		if(n==1 || m==1) {
			return 1;
		}
		return findPath(n,m-1)+findPath(n-1, m);
	}

}
