package assignments;

public class StringReverse {
	
	public static String reverse(String str) {
		String newString = "";
		
		for (int i = 0; i < str.length(); i++) {
			newString += str.charAt(str.length() - 1 - i);
		}
		
		return newString;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("hello"));
		System.out.println(reverse("olleh"));
		System.out.println(reverse("goodbye"));
	}
}
