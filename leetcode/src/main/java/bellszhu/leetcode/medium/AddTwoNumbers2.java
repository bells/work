package bellszhu.leetcode.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author bells
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode L1N3 = new ListNode(3);
        ListNode L1N4 = new ListNode(4, L1N3);
        ListNode L1N1 = new ListNode(2, L1N4);
        System.out.println(L1N1);

        ListNode L2N4 = new ListNode(9);
        ListNode L2N6 = new ListNode(6, L2N4);
        ListNode L2N5 = new ListNode(5, L2N6);
        System.out.println(L2N5);

        System.out.println(addTwoNumbers(L1N1, L2N5));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 后面返回dummy.next，因为curr会跟着移动
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 进位符
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            int val = sum + carry;
            curr.next = new ListNode(val % 10);
            carry = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("" + val);
        ListNode curr = next;
        while (curr != null) {
            sb.append(curr.val);
            curr = curr.next;
        }
        return sb.reverse().toString();
    }
}
