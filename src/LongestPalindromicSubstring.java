package src;
public class LongestPalindromicSubstring {
	public boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	// expanding from center
	public String longestPalindrome(String s) {
		int m = 0;
		int len = 0;
		String ret = s.substring(0, 1);
		while (m < s.length()) {
			// case1: even length Palindrome. EX. ->aa<-bcdefg
			len = ret.length()/2;
			while (m - len >= 0 && m + 1 + len < s.length()
					&& this.isPalindrome(s.substring(m - len, m + 1 + len + 1))) {
//				System.err.println(s.substring(m - len, m + 1 + len + 1));
				if (2 + 2 * len > ret.length()) {
					ret = s.substring(m - len, m + 1 + len + 1);
				}
				++len;
			}
			// case2: odd length Palindrome. EX. ->aba<-bcdefg
			len = ret.length()/2;
			while (m - len >= 0 && m + len < s.length() && this.isPalindrome(s.substring(m - len, m + len + 1))) {
//				System.err.println(s.substring(m-len, m+len+1));
				if (1 + 2 * len > ret.length()) {
					ret = s.substring(m - len, m + len + 1);
				}
				++len;
			}
			++m;
		}
		return ret;
	}

	// too slow
	// brute force
	public String longestPalindrome1(String s) {
		int l = 0, r = 0;
		String ret = s.substring(0, 1);
		StringBuilder temp;
		String tempString;
		while (l < s.length()) {
			for (r = l + ret.length(); r < s.length(); ++r) {
				tempString = s.substring(l, r + 1);
				if (tempString.length() > ret.length()) {
					if (tempString.equals(new StringBuilder(tempString).reverse().toString())) {
						ret = tempString;
					}
				}
			}
			++l;
		}
		return ret;
	}

	// StringBuilder is not working for some reason
	// without printing something in the for loop, the if is never entered.
	// Should because of the StringBuilder
	public String longestPalindrome2(String s) {
		int l = 0, r = 0;
		String ret = s.substring(0, 1);
		StringBuilder temp;
		while (l < s.length()) {
			temp = new StringBuilder();
			temp.append(s.charAt(l));
			for (r = l + 1; r < s.length(); ++r) {
				temp.append(s.charAt(r));
				if (temp.length() > ret.length()) {
					System.err.println("temp.length()>ret.length() -- " + temp.toString() + "\t"
							+ temp.toString().equals(temp.reverse().toString()));
					if (temp.toString().equals(temp.reverse().toString())) {
						ret = temp.toString();
						System.err.println(ret.toString());
					}
				}
			}
			++l;
		}
		return ret;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		System.out.println("result:" + sol.longestPalindrome("bb") + "\n");
		System.out.println("result:" + sol.longestPalindrome("babad") + "\n");
		System.out.println("result:" + sol.longestPalindrome(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth") + "\n");
		System.out.println("result:" + sol.longestPalindrome(
				"jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel") + "\n");
	}
}
