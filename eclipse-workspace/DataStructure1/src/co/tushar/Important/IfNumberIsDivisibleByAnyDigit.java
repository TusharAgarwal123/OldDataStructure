package co.tushar.Important;

public class IfNumberIsDivisibleByAnyDigit {

	// check if no is divisible by any of it's digit.

	public static void main(String[] args) {

		int n=27;
		System.out.println(check(n));
		
	}

	private static boolean check(int n) {
		
		int temp=n;
		int rem=0;
		
		while(n!=0) {
			rem=n%10;
			if(temp%rem==0) {
				return true;
			}
			n=n/10;
		}
		return false;
		
	}

}
