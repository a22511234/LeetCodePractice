package practice;
public class LeetCode_206_ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}

