class DataNode {
    Integer max;
    Integer min;
    boolean isValid;
    public DataNode(boolean isValid) {
        this.isValid = isValid;
    }
    public DataNode(boolean isValid, Integer max, Integer min) {
        this.isValid = isValid;
        this.max = max;
        this.min = min;
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }
}
public class ValidateBinarySearchTree {
    public static DataNode isValidBST(TreeNode node) {
        if (node == null) {
            return new DataNode(true);
        }
        DataNode left = isValidBST(node.left);
        if(!left.isValid) {
            return new DataNode(false);
        }
        if((left.max != null) && (node.data <= left.max)) {
            return new DataNode(false);
        }
        DataNode right = isValidBST(node.right);
        if(!right.isValid) {
            return new DataNode(false);
        }
        if((right.min != null) && (node.data >= right.min)) {
            return new DataNode(false);
        }
        Integer min = left.min == null ? node.data : left.min;
        Integer max = right.max == null ? node.data : right.max;
        return new DataNode(true, max, min);
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(8, treeNode3, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode1, treeNode4);

        System.out.println(isValidBST(treeNode5).isValid);
    }
}
