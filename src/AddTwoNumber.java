package src;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 *	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	Output: 7 -> 0 -> 8
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    int carry = 0;
	    int sum = l1.val + l2.val;
	    if (sum>=10){
	        sum -= 10;
	        carry = 1;
	    }
	    ListNode ret = new ListNode(sum);
	    ListNode iter = ret;
	    while(l1.next != null && l2.next != null){
	        l1 = l1.next;
	        l2 = l2.next;
	        
	        sum = l1.val + l2.val + carry;
	        if (sum>=10){
	            sum -= 10;
	            carry = 1;
	        }else{
	            carry = 0;
	        }
	        iter.next = new ListNode(sum);
	        iter = iter.next;
	    }
	    while(l1.next != null){
	        l1 = l1.next;
	        sum = l1.val + carry;
	        if (sum >= 10){
	            sum -= 10;
	            carry = 1;
	        }else{
	            carry = 0;
	        }
	        iter.next = new ListNode(sum);
	        iter = iter.next;
	    }
	    while(l2.next != null){
	        l2 = l2.next;
	        sum = l2.val + carry;
	        if (sum >= 10){
	            sum -= 10;
	            carry = 1;
	        }else{
	            carry = 0;
	        }
	        iter.next = new ListNode(sum);
	        iter = iter.next;
	    }
	    if(carry != 0){
	        iter.next = new ListNode(carry);
	    }
	    return ret;
	}
    public static void main(String [] args){
    	
    }
}
