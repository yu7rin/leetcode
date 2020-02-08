package Tree;

/**
 * Created by yu7rin on 5/4/2018.
 */
public class UniqueBinarySearchTreesII_95 {
    ////第一种方法 DP
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList();
        if(n == 0) return result[0];
        result[0].add(null);
        for(int i = 1; i <= n; i++) {
            result[i] = new ArrayList();
            for(int j = 0; j < i; j++) {
                List<TreeNode> left = result[j];
                List<TreeNode> right = result[i - j - 1];
                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = l;
                        root.right = clone(r , j + 1);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }
    public TreeNode clone(TreeNode root, int i) {
        if(root == null) return null;
        TreeNode newNode = new TreeNode(root.val + i);
        newNode.left = clone(root.left, i);
        newNode.right = clone(root.right, i);
        return newNode;
    }


    ///第二种方法recersive
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList();
        if(n == 0) return list;
        return helper(1, n);
    }
    public List<TreeNode> helper(int min, int max) {
        List<TreeNode> list = new ArrayList();
        if(min > max) {
            list.add(null);
            return list;
        }
        for(int i = min; i <= max; i++) {
            List<TreeNode> left = helper(min, i - 1);
            List<TreeNode> right = helper(i + 1, max);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
