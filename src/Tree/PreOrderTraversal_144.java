package Tree;

/**
 * Created by yu7rin on 4/27/2018.
 */
public class PreOrderTraversal_144 {
//很常规 用stack进行PreOrederT，注意最后两个压入stack条件的顺序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);

        }
        return list;
    }
}
