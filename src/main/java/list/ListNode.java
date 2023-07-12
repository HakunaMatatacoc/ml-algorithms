package list;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print (ListNode head){
        ListNode tmp = head;
        do {
            System.out.print(tmp.val);
            tmp = tmp.next;
        }while (null != tmp);
        System.out.println();
    }

}
