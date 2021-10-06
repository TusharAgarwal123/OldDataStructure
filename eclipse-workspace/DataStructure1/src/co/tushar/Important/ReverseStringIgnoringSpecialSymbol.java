package co.tushar.Important;

public class ReverseStringIgnoringSpecialSymbol {

	/*
	 * you have a string containing special symbol ,you have to reverse that
	 * ignoring special symbol.
	 */

	public static void main(String[] args) {

		String str = "#hd@kh&d%k$";

		char ch[] = str.toCharArray();
		int l = 0;
		int r = ch.length - 1;

		while (l < r) {
			if (!Character.isAlphabetic(ch[l])) {
				l++;
			} else if (!Character.isAlphabetic(ch[r])) {
				r--;
			} else {
				char t = ch[l];
				ch[l] = ch[r];
				ch[r] = t;
				l++;
				r--;
			}
		}

		String rev = new String(ch);
		System.out.println(rev);

	}

}
