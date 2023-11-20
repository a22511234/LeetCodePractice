package practice;

public class LeetCode_21_MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 != null && list2 != null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode node = new ListNode(0);
		ListNode head = node;//一開始的頭
		while (list1 != null && list2 != null) {
			if (list2==null||(list1.val <= list2.val)) {
				node.next=list1;
				list1=list1.next;
				
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			node = node.next;
		}
		return head.next;//因為一開始val 是 0 next 才是list1 or list2 開始
	}
}
