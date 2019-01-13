package bellszhu.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author bells
 */
public class LongestPalindromic5 {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome2(s));
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
     * time: O(n^2)
     * space: O(1)
     * 这里把奇数，偶数情况合起来处理
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String result1 = helper(s, i, i);
            if (result1.length() >= result.length()) {
                result = result1;
            }
            int next = Math.min(i + 1, s.length() - 1);
            if (s.charAt(i) == s.charAt(next)) {
                String result2 = helper(s, i, Math.min(i + 1, s.length() - 1));
                if (result2.length() >= result.length()) {
                    result = result2;
                }
            }

        }
        return result;
    }
    private static String helper(String s, int left, int right) {
        while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        return s.substring(left, right+1);
    }

    /**
     * DP
     * time: O(n^2)
     * space: O(n^2)
     */
    public static String longestPalindromeDp(String s) {
        // TODO
        return s;
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
