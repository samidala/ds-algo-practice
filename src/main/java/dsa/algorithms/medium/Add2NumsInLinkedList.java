package dsa.algorithms.medium;

import lombok.Data;

import java.util.List;

@Data
public class Add2NumsInLinkedList {


    public static class ListNode {
     public int val;
     public ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int c = 0;
        ListNode d = new ListNode(0);
        ListNode n = d;

        while(l1 != null && l2 != null){
            int s = l1.val + l2.val + c;
            if(s > 9 ){
                c = 1;
                s = s - 10;
            }else{
                c = 0;
            }
            n.next = new ListNode(s);
            n = n.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int s = l1.val + c;
            if(s > 9 ){
                c = 1;
                s = s % 10;
            }else{
                c = 0;
            }
            n.next = new ListNode(s);
            n = n.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int s = l2.val + c;
            if(s > 9 ){
                c = 1;
                s = s - 10;
            }else{
                c = 0;
            }
            n.next = new ListNode(s);
            n = n.next;
            l2 = l2.next;
        }

        return d.next;

    }

    public ListNode addTwoNumbersEnhanced(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int c = 0;
        ListNode d = new ListNode(0);
        ListNode n = d;

        while(l1 != null || l2 != null || c == 1){
            int s = (l1 != null? l1.val : 0) + (l2 != null? l2.val : 0) + c;
            if(s > 9 ){
                c = 1;
                s = s % 10;
            }else{
                c = 0;
            }
            n.next = new ListNode(s);
            n = n.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }



        return d.next;

    }
}
