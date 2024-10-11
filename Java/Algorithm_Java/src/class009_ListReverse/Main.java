package class009_ListReverse;

public class Main {
    public static void main(String[]args){

    }
    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode next= null;
            while(head!=null){
                next=head.next;
                prev=head;
                next.next=prev;
                head=next;
            }
            return prev;
        }
    }

    //双链表的反转
//    class shuanglianbiao{
//
//        ListNode prev;
//        ListNode next;
//        while(head!=null){
//            next=head.next;
//            head.next=last;
//            head.last=next;
//            pre=head;
//            head=next;
//        }


    }


