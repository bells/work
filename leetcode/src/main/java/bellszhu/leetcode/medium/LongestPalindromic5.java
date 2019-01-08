package bellszhu.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author bells
 */
public class LongestPalindromic5 {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(longestPalindrome(s));
    }

    /**
     * time: O(n^2)
     * space: O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int start = 0;
        int length = 0;
        // 奇数情况
        for (int i = 0; i < s.length(); i++) {
            int oddStart = i;
            int oddEnd = i;
            while ( oddStart > 0 && oddEnd < s.length() - 1 && s.charAt(oddStart - 1) == s.charAt(oddEnd + 1)) {
                oddStart -= 1;
                oddEnd += 1;
            }
            if (oddEnd - oddStart + 1 > length) {
                start = oddStart;
                length = oddEnd - oddStart + 1;
            }
        }
        // 偶数情况
        for (int i = 0; i < s.length(); i++) {
            int evenStart = i;
            int evenEnd = Math.min(i + 1, s.length() - 1);
            while (evenStart > 0 && evenEnd < s.length() - 1
                    && s.charAt(evenStart - 1) == s.charAt(evenEnd + 1) && s.charAt(evenStart) == s.charAt(evenEnd)) {
                evenStart -= 1;
                evenEnd += 1;
            }
            if (evenEnd - evenStart + 1 > length && s.charAt(evenStart) == s.charAt(evenEnd)) {
                start = evenStart;
                length = evenEnd - evenStart + 1;
            }

        }
        return s.substring(start, start + length);
    }

    /**
     * 用后缀树处理
     * @param s
     * @return
     */
    public static String longestPalindromeSuffixTree(String s) {
        // TODO
        return s;
    }
}
