package co.tushar.Important;

public class CheckSumOfNoIsDivisibleByAllDigit {

	// check if the sum of digits of number is divisible by all of it's digit.

	public static void main(String[] args) {

		int n = 27;
		System.out.println(check(n));

	}

	private static boolean check(int n) {

		int temp = n;

		int sum = 0;
		while (n != 0) {
			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}

		n = temp;
		while (n != 0) {
			int rem = n % 10;
			if (temp % rem != 0) {
				return false;
			}
			n = n / 10;
		}
		return true;

	}

}
