package Tree;

/**
 * Created by yu7rin on 4/29/2018.
 */
public class BinaryTreeZigZagLevelOrderTraversal_103
    /////在level Traversal上加入了boolean x进行方向判断， 注意方向改变可在输出时改变 不一定在于程序中
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean x = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (x) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            x = x ? false : true;
        }
        return result;

    }
}
