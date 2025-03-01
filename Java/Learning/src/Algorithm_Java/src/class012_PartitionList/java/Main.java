package class012_PartitionList.java;

public class Main {

}
//法一
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lefthead=null,lefttail=null;
        ListNode righthead=null,righttail=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=null;
            if(head.val<x){
                if(lefthead==null){
                    lefthead=head;
                }else{
                    lefttail.next=head;
                }
                lefttail=head;
            }else{
                if(righthead==null){
                    righthead=head;
                }else{
                    righttail.next=head;
                }
                righttail=head;
            }
            head=next;
        }
        if(lefthead==null){
            return righthead;
        }else{
            lefttail.next=righthead;
        }
        return lefthead;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//法二：
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}