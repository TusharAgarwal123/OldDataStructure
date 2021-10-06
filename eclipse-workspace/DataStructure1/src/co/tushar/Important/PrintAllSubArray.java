package co.tushar.Important;

public class PrintAllSubArray {

	public static void main(String[] args) {
		
		int ar[]= {3,6,8,7};
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				for (int j2 = i; j2 <= j; j2++) {
					System.out.print(ar[j2] + "\t");
				}
				System.out.println();
			}
		}

	}

}
