package dsa.algorithms.medium;

import dsa.algorithms.medium.Add2NumsInLinkedList.ListNode;

public class DeleteAllDuplicatesInSortedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next = new ListNode(6);
        node = deleteDuplicates(node);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy.next;
        ListNode prev = dummy;
        while (current.next != null){
            boolean isFound = false;

            while (current.next != null && current.val == current.next.val){
                current = current.next;
                isFound = true;
            }
            if(!isFound){
                prev = prev.next;
            }else{
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;


    }
}
