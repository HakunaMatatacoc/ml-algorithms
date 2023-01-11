package list;

/**
 * <h1>反转链表</h1>
 * <p>
 *
 * </p>
 *
 * @author jian.li on 2022/12/19 18:24
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (null != cur){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList util = new ReverseLinkedList();

        ListNode node05 = new ListNode(5,null);
        ListNode node04 = new ListNode(4, node05);
        ListNode node03 = new ListNode(3, node04);
        ListNode node02 = new ListNode(2, node03);
        ListNode node01 = new ListNode(1, node02);

        ListNode.print(node01);
        ListNode.print(util.reverseList(node01));

    }
}
