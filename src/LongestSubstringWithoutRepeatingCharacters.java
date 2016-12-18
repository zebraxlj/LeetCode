package src;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        int l=0, r=l;
        int longest=0;
        Set<Character> letters = new HashSet<Character>();
        for(l=0; l<s.length(); ++l){
            if(s.length()-l < longest)
                break;
            letters.add(s.charAt(l));
            if(r == l)
                ++r;
            while(r<s.length() && !letters.contains(s.charAt(r))){
                letters.add(s.charAt(r));
                ++r;
            }
            if(longest < r-l)
                longest = r-l;
            if(r == s.length())
                break;
            letters.remove(s.charAt(l));
        }
        return longest;
    }
}
