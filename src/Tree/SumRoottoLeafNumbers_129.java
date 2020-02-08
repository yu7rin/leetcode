package Tree;

/**
 * Created by yu7rin on 5/7/2018.
 */
public class SumRoottoLeafNumbers_129 {
    ///很直观的解法但是比较复杂 应少使用
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        List<String> str = new ArrayList();
        helper(root , "", str);
        for(String s : str) {
            sum += Integer.parseInt(s);
        }
        return sum;

    }
    public void helper(TreeNode root, String s, List<String> list) {
        if(root == null) return;
        //System.out.println("root = "+ root.val);
        if(root.left == null && root.right == null) {
            // System.out.println(s);
            list.add(s + root.val);
        }
        helper(root.left , s + root.val, list);
        helper(root.right, s + root.val, list);

    }

    /////转换思路 每次传递到下一节点都为root.val + sum*10；
    public int sumNumbers(TreeNode root) {
        return helper(root , 0);
    }
    public int helper(TreeNode root , int sum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum*10 + root.val;
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);

    }


}
