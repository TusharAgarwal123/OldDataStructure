package co.tushar.Important;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {


		String ss="Each chapter should be included in the main chapter and should in separate file";
		String str[]=ss.split(" ");
		Set<String> set=new LinkedHashSet<String>();
		for(String s:str) {
			set.add(s);
		}
		for(String s:set) {
			System.out.print(s+" ");
		}
		

	}

}
