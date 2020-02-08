package Tree;

/**
 * Created by yu7rin on 5/5/2018.
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    /////sorted Array转换成balance BST的标准二分转换法 记住
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0 , nums.length - 1);
    }
    private TreeNode helper(int[] nums, int min, int max) {
        if(min > max) return null;
        int mid = min + (max - min)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, min, mid - 1);
        node.right = helper(nums, mid + 1, max);
        return node;
    }
}
