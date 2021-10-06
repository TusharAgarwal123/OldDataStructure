package co.tushar.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		List<List<Integer>> list=new ArrayList<List<Integer>>();
        
		List<Integer> ll=new ArrayList<Integer>();
		List<Integer> lr=new ArrayList<Integer>();
		ll.add(53);
		ll.add(23);
		lr.add(67);
		lr.add(12);
		list.add(ll);
		list.add(lr);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		list.clear();
		System.out.println(list);
		Collections.sort(ll,Collections.reverseOrder());
		System.out.println(ll);
		
		HashMap<Integer,Integer> map=new HashMap<>();
		System.out.println("_______");
		System.out.println(map.get(0));
		
		map.put(1, 1);
		
		int i=1;
		
		if(map.containsKey(i)) {
			map.put(i, map.get(i)+1);
		}
		
		System.out.println(map.size());
		map.put(2, 5);
		System.out.println(map.size());
		System.out.println(map);
		
		String ss="hello";
		String sl="hel";
		System.out.println(ss.indexOf(sl));
		
		int ar[]=new int[8];
		ar=new int[210];
		System.out.println(ar.length);
		
		
	}

}
