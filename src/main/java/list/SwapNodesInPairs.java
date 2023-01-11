package list;

/**
 * <h1>两两交换链表中的节点</h1>
 * <p>
 *
 * </p>
 *
 * @author jian.li on 2022/12/19 18:24
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs util = new SwapNodesInPairs();

        ListNode node05 = new ListNode(5,null);
        ListNode node04 = new ListNode(4, node05);
        ListNode node03 = new ListNode(3, node04);
        ListNode node02 = new ListNode(2, node03);
        ListNode node01 = new ListNode(1, node02);

        ListNode.print(node01);
        ListNode.print(util.swapPairs(node01));

    }


}
