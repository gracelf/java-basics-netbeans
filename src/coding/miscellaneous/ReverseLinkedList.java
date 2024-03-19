package coding.miscellaneous;

/**
 *https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
 * https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution/59714
 * https://leetcode.com/problems/reverse-linked-list/discuss/1449712/Easy-C%2B%2BJavaPythonJavaScript-Explained%2BAnimated
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        
        // e.g. A=>B=>C=>D
        //implemenation: 
        //if we are at Node A, A.next is B, B.next sent to A and A. next set to Null, node move to B
        //if we are at B Node, need to set C.next is B
        // need to store previous node A, and move to the next Node

        //before the start, prevHead is null
        ListNode prevHead = null;

        while (head != null) {
            ListNode recordNext = head.next;
            //set current head's next to previous head, all you need to set
            head.next = prevHead;
            // ready for the next set
            // current head, A, will be previous head for the next node
            prevHead = head;
            //iterate head to the next node, B
            head = recordNext;

        }

        return prevHead;

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("result:" + listNode);

    }

}
