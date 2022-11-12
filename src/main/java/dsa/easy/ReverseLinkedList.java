package dsa.easy;

import dsa.easy.MergeSortedLists.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {


        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
        // return reverse(head, null);


    }
    ListNode reverse(ListNode head,ListNode newHead){
        if(head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverse(next,head);
    }
    public ListNode reverseListStack(ListNode head) {

        if(head == null) return null;

        Stack<ListNode> st = new Stack();

        while(head != null){
            st.push(head);
            head = head.next;
        }

        head = st.pop();
        ListNode temp = head;

        while(!st.isEmpty()){
            ListNode node = st.pop();
            temp.next = node;

            temp= temp.next;
        }
        temp.next = null;

        //temp = head;

        // while(temp != null){
        //   System.out.println(temp.val);
        //    temp = temp.next;
        // }

        /*ListNode prev = head;
        reverseList(head.next);
        head.next = prev;*/
        return head;

    }
}
