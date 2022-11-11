package dsa.easy;

import dsa.algorithms.medium.Add2NumsInLinkedList;
import dsa.algorithms.medium.Add2NumsInLinkedList.ListNode;

public class IsCyclePresentInLinkedList {

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }
        //    System.out.println("fast "+fast);
        if(fast == null || fast.next == null){
            return false;
        }
        return true;

    }
}
