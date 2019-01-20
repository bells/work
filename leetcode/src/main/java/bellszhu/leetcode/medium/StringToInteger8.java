package bellszhu.leetcode.medium;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author bells
 */
public class StringToInteger8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("233"));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int startIndex = 0;
        char firstChar = str.charAt(0);
        long result = 0;
        if (firstChar == '+') {
            sign = 1;
            startIndex++;
        } else if (firstChar == '-') {
            sign = -1;
            startIndex++;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) result * sign;
            }
            result = result * 10 + str.charAt(i) - '0';
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && result > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)result * sign;

    }
}
