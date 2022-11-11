package dsa.algorithms.medium;

import dsa.algorithms.medium.Add2NumsInLinkedList.ListNode;

public class FindStartNodeOfCycle {

    public ListNode detectCycle(ListNode head) {

        if(head == null ){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;


        while(fast != null && fast.next != null && slow != fast){

            slow = slow.next;
            fast = fast.next.next;

        }

        if(slow == fast){
            slow = head;
            while(slow != fast.next){
                slow = slow.next;
                fast = fast.next;

            }
            return slow;
        }
        return null;

    }
}
