/**
 * @description
 * @date 2019/11/21
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(13);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode2.left = treeNode6;
        treeNode2.right = treeNode7;
        treeNode7.right = treeNode8;
        System.out.println(hasPathSum(treeNode, 23));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {

        while(root != null) {
            if (root.getVal() <= sum) {
                return root.getVal() == sum ? true : hasPathSum(root.left, sum-root.getVal()) ||  hasPathSum(root.right, sum-root.getVal());
            }
            break;
        }
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
