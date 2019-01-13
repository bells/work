package bellszhu.leetcode.medium;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author bells
 */
public class ZigZag6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder("");
        }

        // 一个周期的字母个数，V字形的周期
        int cycleCount = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int index = i % cycleCount;
            index = index < numRows ? index : cycleCount - index;
            sbs[index].append(s.charAt(i));
        }

        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
