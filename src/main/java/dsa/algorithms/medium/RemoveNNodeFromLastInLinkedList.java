package dsa.algorithms.medium;

import dsa.algorithms.medium.Add2NumsInLinkedList.ListNode;

public class RemoveNNodeFromLastInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = removeNthFromEnd(head,1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;

        for(int i=1;i<=n;i++)
            fast=fast.next;

        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return dummy.next;
    }
}
