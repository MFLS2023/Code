package class010_MergeTwoLists;

public class Main {

}


//class Solution {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1==null||list2==null){
//            return list1==null?list2:list1;
//        }
//        ListNode list = list1.val>list2.val?list2:list1;
//        ListNode pre=list;
//        ListNode cur1=list.next;
//        ListNode cur2= list==list1?list2:list1;
//        while(cur1!=null&&cur2!=null){
//            if(cur1.val<cur2.val){
//                pre.next=cur1;
//                pre=cur1;
//                cur1=cur1.next;
//            }
//            else{
//                pre.next=cur2;
//                pre=cur2;
//                cur2=cur2.next;
//            }
//        }
//        pre.next= cur1==null?cur2:cur1;
//        return list;
//    }
//
//}