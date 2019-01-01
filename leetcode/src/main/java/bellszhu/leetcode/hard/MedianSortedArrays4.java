package bellszhu.leetcode.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * O(log(m+n))  主要用二分查找
 */
public class MedianSortedArrays4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // 这个公式很重要，确定另一个数组的partition
        int k = (m + n + 1) / 2;
        int low = 0;
        int high = m; // 注意这里是m，长度
        while (low <= high) {
            int partitionM = (low + high) / 2;
            int partitionN = k - partitionM;

            int maxLeftM = (partitionM == 0) ? Integer.MIN_VALUE : nums1[partitionM - 1];
            int minRightM = (partitionM == m) ? Integer.MAX_VALUE : nums1[partitionM];

            int maxLeftN = (partitionN == 0) ? Integer.MIN_VALUE : nums2[partitionN - 1];
            int minRightN = (partitionN == n) ? Integer.MAX_VALUE : nums2[partitionN];

            if (maxLeftM <= minRightN && minRightM >= maxLeftN) {
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeftM, maxLeftN) + Math.min(minRightM, minRightN)) / 2;
                } else {
                    return (double)Math.max(maxLeftM, maxLeftN);
                }
            } else if (maxLeftM > minRightN) {
                high = partitionM - 1;
            } else {
                low = partitionM + 1;
            }
        }

        throw new IllegalArgumentException();

    }

}
