package co.tushar.Important;

public class NumberAndReverseAreDivisibleBySum {

	/*
	 * find n numbers such that a number and it's reverse are divisible by sum of
	 * it's digits.
	 */

	public static void main(String[] args) {

		int n = 12;

		find(n);

	}

	public static void find(int n) {

		int c = 1;
		int i = 1;

		while (c <= n) {

			int a = reverse(i);
			int b = findSum(i);

			if ((i % b == 0) && (a % b == 0)) {
				System.out.print(i + " ");
				c++;
				i++;
			} else {
				i++;
			}
		}

	}

	public static int reverse(int n) {

		int rev = 0;
		int rem = 0;
		while (n != 0) {
			rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}

		return rev;

	}

	public static int findSum(int n) {

		int sum = 0;
		while (n != 0) {
			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}

		return sum;

	}

}
