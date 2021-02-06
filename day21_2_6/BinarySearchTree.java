package day21_2_6;

//二叉搜索树
public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node root = null;

    //1.查找
    public Node find(int key){
        //查找key是否存在，如果存在就返回对应的Node
        Node cur = root;
        while (cur != null){
            if (key < cur.key){
                //就去左子树中找
                cur = cur.left;
            }else if (key > cur.key){
                //就去右子树中找
                cur = cur.right;
            }else {
                //相等就是找到了
                return cur;
            }
        }
        //循环结束了也没找到
        return null;
    }

    //2.插入
    //如果发现插入的元素重复了，就插入失败，返回false
    //插入成功返回true
    public boolean insert(int key){
        if (root == null){
            //当前为空树，直接让root指向key对应的节点即可
            root = new Node(key);
            return true;
        }
        //需要先找到合适的位置
        Node cur = root;
        Node parent = null;//parent始终指向cur的父节点
        while (cur != null){
            if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if (key > cur.key){
                parent = cur;
                cur = cur.right;
            }else {
                //插入失败
                return false;
            }
        }
        //循环结束的时候，cur就指向了null,当前元素就要插入到parent的子树位置上
        if (key < parent.key){
            //插入到 parent 的左侧
            parent.left = new Node(key);
        }else {
            parent.right = new Node(key);
        }
        return true;
    }

    //删除
    //指定值进行删除，删除成功返回true，删除失败返回false
    //key在树中存在，就删除成功
    //key在树中不存在，就删除失败
    public boolean remove(int key){
        //先找到要删除的节点的位置，在进行具体的删除
        //找到这个待删除元素，再去判定是哪种情况
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if (key > cur.key){
                parent = cur;
                cur = cur.right;
            }else {
                //找到了
                //在这个方法中判定是哪一种情况，
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null){
            //1.要删除的元素没有左子树
            if (cur == root){
                //1.1如果要删除节点为root
                root = cur.right;
            }else if (cur == parent.left){
                //1.2 对应情况1）
                parent.left = cur.right;
            }else {
                //1.3对应情况2）
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            //2.要删除的元素没有右子树
            if (cur == root){
                //2.1 如果要删除节点为root
                root = cur.left;
            }else if (cur == parent.left){
                //2.2 对应情况3）
                parent.left = cur.left;
            }else {
                //2.3 对应情况4）
                parent.right = cur.left;
            }
        }else {
            //当前要删除节点有两个子树，对应的情况5）
            //1.先找到 右子树中最小的元素（替罪羊）
            Node goatParent = cur;
            Node scapeGoat = cur.right;
            while (scapeGoat.left != null){
                goatParent = scapeGoat.left;
                scapeGoat = scapeGoat.left;
            }
            //循环结束的时候，就已经找到了最小值
            //2.把刚才找到的元素的值赋给待删除元素
            cur.key = scapeGoat.key;
            //3.删除替罪羊节点
            //替罪羊没有左子树，和情况1）和2）一样
            if (scapeGoat == goatParent.left){
                goatParent.left = scapeGoat.right;
            }else {
                goatParent.right = scapeGoat.right;
            }
        }
    }

    public void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.key +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key +" ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);

        //打印先序遍历和中序遍历
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);

    }
}
