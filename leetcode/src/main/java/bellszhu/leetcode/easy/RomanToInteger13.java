package bellszhu.leetcode.easy;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author bells
 */
public class RomanToInteger13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
                result += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                result += toNumber(s.charAt(i));
            }
        }

        return result;
    }

    public static int toNumber(char c) {
        int result = 0;
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return result;
    }
}
