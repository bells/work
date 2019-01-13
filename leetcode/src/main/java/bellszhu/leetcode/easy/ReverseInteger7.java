package bellszhu.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author bells
 */
public class ReverseInteger7 {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        long result = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }

        while (x > 0) {
            int remainder = x % 10;
            result = result * 10 + remainder;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)result * sign;
    }
}
