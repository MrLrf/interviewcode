package leetcode;

/**
 * Created by Li on 2017/2/23.
 */
public class AddTwoNumbers {

    public static void addNode(int x, ListNode head) {
        ListNode next_ = new ListNode(x);

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = next_;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;
        while (l1next != null || l2next != null) {
            if (l1next == null) {
                addNode(l2next.val, result);
                l2next = l2next.next;
                continue;
            }
            if (l2next == null) {
                addNode(l1next.val, result);
                l1next = l1next.next;
                continue;
            }
            addNode(l1next.val + l2next.val, result);
            l1next = l1next.next;
            l2next = l2next.next;
        }
        ListNode listnext = result;
        while (listnext != null) {
            if (listnext.val >= 10) {
                listnext.val -= 10;
                if (listnext.next == null){
                    listnext.next = new ListNode(1);
                } else {
                    listnext.next.val++;
                }
            }
            listnext = listnext.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        addNode(4, l1);
//        addNode(3, l1);
        ListNode l2 = new ListNode(5);
//        addNode(6, l2);
//        addNode(4, l2);
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.print(sum.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
