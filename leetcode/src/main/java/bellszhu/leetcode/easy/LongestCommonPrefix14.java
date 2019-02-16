package bellszhu.leetcode.easy;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) { // 最长公共前缀
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}
