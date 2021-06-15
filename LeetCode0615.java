/**
 *给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 *
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-quad-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
public class LeetCode0615 {
    public Node construct(int[][] grid) {
        return initQuadTreeNode(grid, 0, 0, grid.length);
    }

    public Node initQuadTreeNode(int[][] data, int xStart, int yStart, int length) {
        int formatData = data[yStart][xStart];
        boolean poison = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (formatData != data[i + yStart][j + xStart]) {
                    poison = true;
                    break;
                }
            }
            if (poison) {
                break;
            }
        }

        if (!poison) {
            return new Node(formatData == 1, true, null, null, null, null);
        } else {
            Node currentNode = new Node();
            currentNode.isLeaf = false;
            currentNode.topLeft = initQuadTreeNode(data, xStart, yStart, length / 2);
            currentNode.topRight = initQuadTreeNode(data, xStart + length / 2, yStart, length / 2);
            currentNode.bottomLeft = initQuadTreeNode(data, xStart, yStart + length / 2, length / 2);
            currentNode.bottomRight = initQuadTreeNode(data, xStart + length / 2, yStart + length / 2, length / 2);
            return currentNode;
        }
    }
}
