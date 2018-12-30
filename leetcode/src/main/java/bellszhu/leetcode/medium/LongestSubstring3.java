package bellszhu.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * time: O(n)
 * space: O(n)
 * @author bells
 */
public class LongestSubstring3 {

    public static void main(String[] args) {
        String s = "abcabcbbb";
        System.out.println(lengthOfLongestSubstringMap(s));
        System.out.println(lengthOfLongestSubstringSet(s));
    }

    /**
     * 用map来实现
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringMap(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        // i: index, j: pointer
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // j 不能往前移
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            result = Math.max(i - j + 1, result);

        }

        return result;
    }

    /**
     * 用set来实现
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringSet(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length();) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i++));
                result = Math.max(set.size(), result);
            }
        }

        return result;
    }

}
