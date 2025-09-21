class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;     
            if (slow == fast) {        
                return true;
            }
        }
        return false;  
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycle obj = new LinkedListCycle();
        boolean result = obj.hasCycle(head);

        System.out.println("Cycle exists? " + result); 
    }
}
