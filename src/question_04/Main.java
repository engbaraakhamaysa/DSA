package question_04;

import java.util.HashMap;

class Solution {
    
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
    
    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character,Integer> map =new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {

            if (!map.containsKey(t.charAt(i))) {
                return false;
            }

            int count = map.get(t.charAt(i)) - 1;

            if (count == 0) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), count);
            }
        }

        return map.size() == 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.isAnagram("baraa", "aarab");

        System.out.println("slution 01 = " + result);

        boolean result2 = solution.isAnagram02("baraa", "araab");
        System.out.println("slution 02 = " + result2  );
    }
    
}
