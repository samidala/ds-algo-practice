package dsa.easy;

public class MergeSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
      public ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return list1;
        }

        if(list1 != null && list2 == null){
            return list1;
        }

        if(list1 == null && list2 != null){
            return list2;
        }

        ListNode head = null;
        if(list1.val  < list2.val){
            head = new ListNode(list1.val);
            list1 = list1.next;
        }else{
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode next = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                next.next = list1;
                list1 = list1.next;
            }else{
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }

        next.next = (list1 == null ?  list2 : list1);
        return head;

    }
    public ListNode mergeTwoListsUsingDummay(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                next.next = list1;
                list1 = list1.next;
            }else{
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        next.next = (list1 == null ?  list2 : list1);
        return head.next;

    }
}
