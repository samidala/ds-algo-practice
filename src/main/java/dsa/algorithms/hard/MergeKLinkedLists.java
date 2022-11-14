package dsa.algorithms.hard;

import dsa.easy.MergeSortedLists;
import dsa.easy.MergeSortedLists.ListNode;

public class MergeKLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==1 ) return lists[0];
        int n = lists.length;
        ListNode newHead = null;
        for(ListNode node : lists){
            newHead = merge(newHead,node);
        }
        return newHead;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists != null && lists.length ==1 ) return lists[0];
        int n = lists.length;
        return mergeKLists(lists,0,n-1);
    }
    public ListNode mergeKLists(ListNode[] lists,int low, int high) {
        if(low > high) return null;
        if(low == high) return lists[low];

        int mid = (low + high) / 2;

        ListNode left =  mergeKLists(lists,low,mid);
        ListNode right = mergeKLists(lists,mid+1,high);
        return merge(left,right);
    }

    ListNode merge(ListNode h1,ListNode h2){

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                temp.next = h1;
                h1 = h1.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        if(h1 != null){
            temp.next = h1;
        }
        if(h2 != null){
            temp.next = h2;
        }
        return dummy.next;
    }
}
