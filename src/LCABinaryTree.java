class LCABinaryTreeNodeFound {
    int foundCount;
    LCABinaryTreeNode node;

    public LCABinaryTreeNodeFound(int fc, LCABinaryTreeNode node) {
        this.foundCount = fc;
        this.node = node;
    }
    @Override
    public String toString() {
        if(this.foundCount != 2) {
            return "Not found";
        }
        return String.valueOf(node.data);
    }
}
class LCABinaryTreeNode {
    int data;
    LCABinaryTreeNode left;
    LCABinaryTreeNode right;
    public LCABinaryTreeNode(int data, LCABinaryTreeNode left, LCABinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public LCABinaryTreeNodeFound find(int data1, int data2) {
        int foundCount = 0;
        if(this.left != null) {
            LCABinaryTreeNodeFound leftFound = this.left.find(data1, data2);
            if(leftFound.foundCount == 2) {
                return leftFound;
            }
            foundCount += leftFound.foundCount;
        }
        if(this.right != null) {
            LCABinaryTreeNodeFound rightFound = this.right.find(data1, data2);
            if(rightFound.foundCount == 2) {
                return rightFound;
            }
            foundCount += rightFound.foundCount;
        }

        if(this.data == data1 || this.data == data2) {
            foundCount++;
        }
        return new LCABinaryTreeNodeFound(foundCount, this);

    }
}
public class LCABinaryTree {

    public static void main(String[] args) {
        LCABinaryTreeNode n1 = new LCABinaryTreeNode(1, null, null);
        LCABinaryTreeNode n2 = new LCABinaryTreeNode(2, null, null);
        LCABinaryTreeNode n3 = new LCABinaryTreeNode(3, null, null);
        LCABinaryTreeNode n4 = new LCABinaryTreeNode(4, null, null);
        LCABinaryTreeNode n5 = new LCABinaryTreeNode(5, null, null);
        LCABinaryTreeNode n6 = new LCABinaryTreeNode(6, n1, n2);
        LCABinaryTreeNode n7 = new LCABinaryTreeNode(7, null, null);
        LCABinaryTreeNode n8 = new LCABinaryTreeNode(8, n3, n4);
        LCABinaryTreeNode n9 = new LCABinaryTreeNode(9, n5, n6);
        LCABinaryTreeNode n10 = new LCABinaryTreeNode(10, n7, n8);
        LCABinaryTreeNode n11 = new LCABinaryTreeNode(11, n9, n10);
        System.out.println(n11.find(1,3));
    }
}
