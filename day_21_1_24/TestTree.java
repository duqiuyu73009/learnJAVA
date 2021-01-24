package day_21_1_24;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {
    public static Node build(){
        //手动把一颗树构造出来
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        //返回根节点
        return a;
    }

    //先序遍历
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    //后序遍历
    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    //求二叉树节点个数
    //使用后序遍历
    public static int size(Node root){
        if (root == null){
            return 0;
        }
        //访问根节点，此处的访问操作就是计数器+1
        //整个树的节点个数 = 根节点个数 + 左子树节点的个数 + 右子树节点个数
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树叶子节点的个数
    //root叶子节点的个数 = root.left的叶子节点的个数 + root.right叶子节点的个数
    public static int leafSize(Node root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //求二叉树第k层节点的个数
    public static int kSize(Node root,int k){
        if (k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return kSize(root.left, k-1)+kSize(root.right, k-1);
    }

    //在二叉树中查找指定的元素
    public static Node search(Node root, char toFind){
        if (root == null){
            return null;
        }
        if (root.val == toFind){
            return root;
        }
        Node result = search(root.left, toFind);
        if (result != null){
            return result;
        }
        return search(root.right, toFind);
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.print("先序遍历：");
        preOrder(root);
        System.out.println();

        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();

        System.out.print("后序遍历：");
        postOrder(root);
        System.out.println();

    }
}
