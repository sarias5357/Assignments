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
			char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k' ,'l', 'm', 'n', 'p', 'q'
					,'r', 's', 't', 'v', 'w','x', 'y', 'z' };
			
			for (int i = 0; i < consonants.length; i++) 
				if (x == consonants[i])
					return true;

			return false;
		}
}
	
