import java.util.Arrays;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		str1 = removeSpaces(str1);
		str2 = removeSpaces(str2);

		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if (str1.length() != str2.length()){
			return false;
		}

	    char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
    
		
		for(int i = 0; i < charArray1.length; i++){
				if(charArray1[i] != charArray2[i]){
					return false;
				}
			}
			return true;
		}	
	

	public static String removeSpaces(String str) {

		String proStr = "";

		for(int i = 0; i < str.length(); i++){
	   if(str.charAt(i) != ' '){
		proStr = proStr + str.charAt(i);
	   }
	 }
	 return proStr;
	}
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String proStr = ""; 
        String lowerCase = str.toLowerCase();
	

		for(int i = 0; i < lowerCase.length(); i++){
                if(lowerCase.charAt(i) != '?' && lowerCase.charAt(i) != '!'  && lowerCase.charAt(i) != ','  ){
					proStr = proStr + lowerCase.charAt(i);
				}
		}
		return proStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		char [] anagram = str.toCharArray();
        int x = 0;
		int y = 0;
		char temp = ' ';
        
		for (int i = 0; i < 100;i ++){

			x = (int)(Math.random()*anagram.length);
			y = (int)(Math.random()*anagram.length);
            
             temp = anagram[x];
			 anagram[x] = anagram[y];
			 anagram[y] = temp;
            
		}
		String randomAnagram = new String(anagram);
	
		
		return randomAnagram;
	}
}
