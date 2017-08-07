package ap.structures;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }


}
