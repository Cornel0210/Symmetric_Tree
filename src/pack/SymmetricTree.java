package pack;
import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode three2 = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode two2 = new TreeNode(2, four2, three2);
        TreeNode root = new TreeNode(1, two, two2);
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        traverseLeft(root.left, left);
        traverseRight(root.right, right);
        if (left.size() != right.size() || left.size() == 0){
            return false;
        }
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != null && right.get(i) == null){
                return false;
            }
            if (left.get(i) == null && right.get(i) != null){
                return false;
            }
            if (left.get(i) != null && right.get(i) != null){
                if (!left.get(i).equals(right.get(i))){
                    return false;
                }
            }

        }
        return true;
    }
    private static void traverseLeft(TreeNode root, LinkedList<Integer> list){
        if (root == null){
            list.add(null);
            return;
        }
        list.add(root.val);
        traverseLeft(root.left, list);
        traverseLeft(root.right, list);
    }

    private static void traverseRight(TreeNode root, LinkedList<Integer> list){
        if (root == null){
            list.add(null);
            return;
        }
        list.add(root.val);
        traverseRight(root.right, list);
        traverseRight(root.left, list);
    }
}