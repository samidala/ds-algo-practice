package dsa.easy;

import dsa.algorithms.medium.Add2NumsInLinkedList.ListNode;

public class FindAndRemoveDuplicatesInList {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;
        ListNode list = head;
        while( list.next != null){

            if(list.val == list.next.val){
                list.next = list.next.next;

            } else{
                list = list.next;
            }


        }
        return head;

    }

}
