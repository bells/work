package bellszhu.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * @author bells
 */
public class TwoSum1 {

    public static void main(String[] args) {

        int[] nums = {3, 4, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indies.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (indies.containsKey(left) && indies.get(left) != i) {
                return new int[]{i, indies.get(left)};
            }
        }

        return new int[]{};
    }

}
