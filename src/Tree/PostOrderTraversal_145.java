package Tree;

/**
 * Created by yu7rin on 4/27/2018.
 */
public class PostOrderTraversal_145 {

    ////关于后序遍历 利用linkedlist的addFirst的方法成功反转结果
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        ////！！！此处必须声明为LinkedList<Integer> 因为addFirst 方法为LinkedList独有 List接口并没有
        Stack<TreeNode> stack = new Stack();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return list;
    }
}
