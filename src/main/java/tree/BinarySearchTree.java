package tree;

/**
 * <h1>二叉搜索树</h1>
 * <p>
 *  又: 二叉查找树/二叉排序树
 * </p>
 *
 * @author jian.li on 2023/3/23 0:58
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        int data[] = {0,5,9,1,2,3,10};
        BinarySearchTree root = new BinarySearchTree(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insert(root, data[i]);
        }
        System.out.println("中序遍历");
        root.in(root);
        System.out.println();

        boolean delete = root.delete(root, 3);
        System.out.println("删除成功:" + delete);
        System.out.println("中序遍历");
        root.in(root);
    }

    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // 插入的时候每次都是和根节点比较, 一直找到它应该插入的位置
    // 肯定会插在叶子节点, 那么其实大家可以看到插入其实就是查找, 默认root不会为空

    public void insert(BinarySearchTree root, int data){
        // if(root == null)
        if (root.data < data){// 根节点小, 要放到右边
            if (root.right == null){
                root.right = new BinarySearchTree(data);
            }else {
                insert(root.right,data);
            }
        }else if (root.data > data){
            if (root.left == null){
                root.left = new BinarySearchTree(data);
            }else {
                insert(root.left, data);
            }
        } else {
            throw new RuntimeException("二叉搜索树没有相等的值");
        }
    }

    public void find(BinarySearchTree root, int data){
        if (root != null){
            if (root.data < data){
                find(root.right, data);
            }else if(root.data > data){
                find(root.left,data);
            }else {
                System.out.println("找到了");
                System.out.println(root.data);
                return;
            }
        }
    }

    /**
     * 中序遍历
     */
    public void in(BinarySearchTree root){
        if(root != null){
            in(root.left);
            System.out.print(root.data + " ");
            in(root.right);
        }
    }

    public boolean delete(BinarySearchTree root, int data){
        // 树为空, 直接return false
        if(root == null){
            return false;
        }

        // 先循环找到要删除的元素
        BinarySearchTree cur = root;
        BinarySearchTree curPre = null;
        while(cur != null){
            if (cur.data < data){
                // 右侧找
                curPre = cur;
                cur = cur.right;
            }else if (cur.data > data){
                // 左侧找
                curPre = cur;
                cur = cur.left;
            }else {
                // 找到了, 删除节点
                removeNode(root,curPre,cur);
                return true;
            }
        }
        return false; // 没有找到该节点
    }

    private void removeNode(BinarySearchTree root, BinarySearchTree parent, BinarySearchTree cur){
        // 分情况
        // 1.被删节点的左子树为null
        if(cur.left == null){
            //1.1 删除节点为根节点
            if( cur == root){
                parent = cur.right;
                // 1.2 删除节点为根节点的右子树
            }else if(parent.right == cur){
                parent.right = cur.right;
                // 1.3 删除节点为根节点的左子树
            }else {
                parent.left = cur.right;
            }
            // 2.被删节点的右子树为null
        }else if (cur.right == null){
            // 2.1
            if (cur == root){
                parent = cur.left;
                // 2.2 删除节点为根节点的右子树
            }else if(parent.right == cur){
                parent.right = cur.left;
                // 2.3 删除节点为根节点的左子树
            }else {
                parent.left = cur.left;
            }
            // 3.被删节点的左右子树都不为null, 我使用被删节点的右子树中找最小值, 也可用被删节点的左子树中找最大值
        }else {
            BinarySearchTree curParent = cur; // 记录cur的前一个
            BinarySearchTree curr = cur.right; // 右子树找min
            // 被删节点的右子树下的左子树如果存在, 那最小值肯定就在左子树
            while(cur.left != null){
                curParent = curr;
                curr = curr.left;
            }
            // 此时有两种情况, 一种压根没进while(无左子树), 一种是进了(有左子树)
            // 找到最小值并覆盖被删节点的值
            cur.data = curr.data;
            // 连接跳过最小值
            if (curr == curParent.left){ // 有左子树
                curParent.left = curr.right; // 此时curr是最小, 连接curr的右子树
            }else { // 无左子树
                curParent.right = curr.right;
            }

        }
    }
}
