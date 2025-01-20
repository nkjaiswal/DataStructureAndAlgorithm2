import java.util.List;

class TreeNodeSerializable {
    public TreeNodeSerializable(int data) {
        this.data = data;
    }
    int data;
    TreeNodeSerializable left;
    TreeNodeSerializable right;
    public int build(List<String> tree, int index) {
        String leftItem = tree.get(index);
        if("#".equals(leftItem)) {
            this.left = null;
            index++;
        } else {
            this.left = new TreeNodeSerializable(Integer.parseInt(leftItem));
            index = this.left.build(tree, index+1);
        }
        String rightItem = tree.get(index);
        if("#".equals(rightItem)) {
            this.right = null;
            index++;
        } else {
            this.right = new TreeNodeSerializable(Integer.parseInt(rightItem));
            index = this.right.build(tree, index+1);
        }
        return index;
    }

    @Override
    public String toString() {
        return this.data + "," + (this.left != null ? this.left.toString() : "#,") +  (this.right != null ? this.right.toString() : "#,");
    }
}
public class DeSerializeTree {
    public static void main(String[] args) {
        TreeNodeSerializable tree = new TreeNodeSerializable(1);
        tree.build(List.of("2","#","#","3","4","#","#","5","#","#"), 0);
        System.out.println(tree);
    }
}
