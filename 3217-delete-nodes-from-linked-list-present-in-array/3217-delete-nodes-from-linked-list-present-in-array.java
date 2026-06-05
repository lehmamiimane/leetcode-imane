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
    public ListNode modifiedList(int[] nums, ListNode head) {
         
         int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            max = nums[i] > max ? nums[i] : max;
        }
        boolean fast[] = new boolean[max + 1];
        for(int i = 0 ; i < nums.length ; i++){
            fast[nums[i]] = true;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next!= null){
            if( temp.next.val <= max && fast[temp.next.val]){
                // temp.next.val <= max we need to write this becuase if list elemnt is 32 and max array element is 20 if( temp.next.val <= max && freq[temp.next.val] > 0)
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
    
}