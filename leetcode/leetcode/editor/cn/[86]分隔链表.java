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