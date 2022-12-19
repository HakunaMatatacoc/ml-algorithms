package List;

/**
 * <h1>环形链表</h1>
 * <p>
 *  给你一个链表的头节点 head ，判断链表中是否有环
 * </p>
 *
 * @author jian.li on 2022/12/20 0:46
 */
public class ListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow= head;
        while(null != fast && null != slow && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListCycle util = new ListCycle();

        ListNode node05 = new ListNode(5,null);
        ListNode node04 = new ListNode(4, node05);
        ListNode node03 = new ListNode(3, node04);
        ListNode node02 = new ListNode(2, node03);
        ListNode node01 = new ListNode(1, node02);
        node05.next = node03;

        System.out.println(util.hasCycle(node01));
    }
}
