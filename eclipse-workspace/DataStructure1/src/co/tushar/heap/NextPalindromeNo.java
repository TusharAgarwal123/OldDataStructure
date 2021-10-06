package co.tushar.heap;

public class NextPalindromeNo {

	public static void main(String[] args) {

		int n = 123;

		while (true) {
			int t = n;
			int rev = 0, rem;
			while (t != 0) {
				rem = t % 10;
				rev = rev * 10 + rem;
				t = t / 10;
			}
			if (rev == n) {
				System.out.println("Next Palindrome is:" + rev);
				break;
			} else {
				n++;
			}
		}

	}

}
