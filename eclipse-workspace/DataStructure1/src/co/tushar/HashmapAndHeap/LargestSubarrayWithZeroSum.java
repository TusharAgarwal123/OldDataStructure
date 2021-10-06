package co.tushar.HashmapAndHeap;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {

	/*
	 * 1. You are given an array(arr) of integers. 2. You have to find the length of
	 * the largest subarray with sum 0.
	 */

	public static void main(String[] args) {

		int ar[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = ar.length;

		HashMap<Integer, Integer> map = new HashMap<>();

		int sum=0;
		map.put(sum, -1);
		int max=0;
		
		for (int i = 0; i < ar.length; i++) {
			
			sum+=ar[i];
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}else {
				int len=i-map.get(sum);
				if(len>max) {
					max=len;
				}
			}
			
		}
		
		System.out.println(max);
		

	}

}
