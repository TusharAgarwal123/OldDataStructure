package co.tushar.Important;

public class NextBiggerString {

	// given a string convert it into the next greater string
	// and it must be smallest of greater string.

	public static void main(String[] args) {

		String str = "acdb";

		System.out.println(findNextGreater(str));

	}

	private static String findNextGreater(String str) {

		char ch[] = str.toCharArray();
		int i = ch.length - 1;

		while (i > 0 && ch[i - 1] >= ch[i]) {
			i--;
		}

		if (i <= 0) {
			return "no answer";
		}

		int j = ch.length - 1;

		while (ch[j] <= ch[i - 1]) {
			j--;
		}

		char temp = ch[i - 1];
		ch[i - 1] = ch[j];
		ch[j] = temp;

		j = ch.length - 1;

		while (i < j) {
			temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}

		String ans = "";
		for (char c : ch) {
			ans += c;
		}

		return ans;

	}

}
