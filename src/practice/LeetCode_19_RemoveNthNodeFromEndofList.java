package practice;

import java.util.Stack;

public class LeetCode_19_RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		while (n != 0) {
			stack.pop();
			n--;
		}

		if (stack.empty()) {
			return head.next;
		} else {
			temp = stack.peek();
			temp.next = temp.next.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
