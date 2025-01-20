
public class MaxPathSumBT {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public static int max = Integer.MIN_VALUE;
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int computeMaxPathAndGetMaxDepth() {
            int leftMaxPath = this.left != null ? this.left.computeMaxPathAndGetMaxDepth() : 0;
            int rightMaxPath = this.right != null ? this.right.computeMaxPathAndGetMaxDepth() : 0;
            int maxPathVia1Child = Math.max(rightMaxPath, leftMaxPath);
            max = Math.max(max, leftMaxPath + rightMaxPath + this.data);
            return Math.max(maxPathVia1Child, this.data);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t3 = new TreeNode(-3, null, null);
        t3.computeMaxPathAndGetMaxDepth();
        System.out.println(TreeNode.max);
    }
}
