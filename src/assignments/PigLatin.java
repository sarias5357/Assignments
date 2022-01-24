package assignments;

public class PigLatin {
	
		public static String toPigLatin(String str) {
			StringBuilder build = new StringBuilder(str);
			String ans = str;
			if (isConsonant(str.charAt(0))) {
				if (isConsonant(str.charAt(1))) {
					if (isConsonant(str.charAt(2))) {
						build.append(str.charAt(0) + "" + str.charAt(1) + "" + str.charAt(2) + "ay");
						ans = build.substring(3);
					}
					else {
						build.append(str.charAt(0) + "" + str.charAt(1) + "ay");
						ans = build.substring(2);
					}
				}
				else {
					build.append(str.charAt(0) + "ay");
					ans = build.substring(1);
				}
			}
			else {
				build.append("yay");
				ans = build.toString();
			}
			return ans;
		}
		
		public static boolean isConsonant(char x) {
			if (x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') {
				return false;
			}

			return true;
		}
		
		public static void main(String[] args) {
			System.out.println(toPigLatin("pig"));
			System.out.println(toPigLatin("latin"));
			System.out.println(toPigLatin("smile"));
			System.out.println(toPigLatin("string"));
			System.out.println(toPigLatin("apple"));
		}
}
	
