package list;

public class MyLinkedList {

    private ListNode head;
    private int size = 0;

    // 头插
    public void insertHead(int data){
        ListNode newNode = new ListNode(data);

        newNode.next = head;
        head = newNode;
    }

    // 空指针问题?
    public void insertNth(int data, int position){
        if(position == 0){
            insertHead(data);
        }else {
            ListNode cur = head;
            for (int i = 1; i < position; i++) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(data);

            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public void deleteHead(){
        head = head.next;
    }

    public void deleteNth(int position){
        if(position == 0){
            deleteHead();
        }else {
            ListNode cur = head;
            for (int i = 1; i < position; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next; //cur.next 表示的是删除的点，后一个next就是我们要指向的
        }
    }

    public void print(){
        ListNode cur = head;
        while(null != cur){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.insertHead(5);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.print();
        myList.deleteNth(0);
        myList.print();
        myList.deleteHead();
        myList.print();
        myList.insertNth(11,1);
        myList.print();
        myList.deleteNth(1);
        myList.print();
//        myList.insertNth(12,4); 空指针异常
    }
}
