package assignments;

public class Palindrome {
	public static boolean isPalindrome(String x) {
		for (int i = 0; i <= x.length() / 2; i++) {
			if (x.charAt(i) != x.charAt(x.length() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("mom"));
		System.out.println(isPalindrome("dad"));
	}
}
