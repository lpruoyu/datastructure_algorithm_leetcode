package code.lp.链表;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	/*
	 * liuyubobobo老师的思路
	 */
	
	public ListNode(int[] arr) {
		if (arr != null && arr.length > 0) {
			this.val = arr[0];
			ListNode current = this;
			for (int i = 1; i < arr.length; i++) {
				current.next = new ListNode(arr[i]);
				current = current.next;
			}
		} else {
			throw new IllegalArgumentException("arr must not be empty.");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode current = this;
		while(null != current) {
			sb.append(current.val);
			sb.append("->");
			current = current.next;
		}
		sb.append("NULL");
		return "ListNode [ " + sb.toString() + " ]";
	}

}