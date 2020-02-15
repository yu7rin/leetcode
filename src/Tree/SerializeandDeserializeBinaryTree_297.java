package Tree;

public class SerializeandDeserializeBinaryTree_297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //使用了preorder进行遍历 同时使用preorder进行解析
            //亮点 使用了 private static final String 设置常量
            //要点 使用Integer.valueOf(val)解析string -》 int
            //使用 node.addAll(Arrays.asList(data.split(Spliter)))解析String
        private static final String Null = "x";
        private static final String Spliter = ",";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            helper(sb , root);
            System.out.print(sb);
            return sb.toString();
        }
        private void helper(StringBuffer sb , TreeNode root) {
            if(root == null) {
                sb.append(Null + Spliter);
                return;
            }

            sb.append(root.val + Spliter);
            helper(sb , root.left);
            helper(sb, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> node = new LinkedList();
            node.addAll(Arrays.asList(data.split(Spliter)));
            return  createTree(node);
        }
        public TreeNode createTree(LinkedList<String> list){
            String val = list.poll();
            if(val.equals(Null)) return null;
            int nodeVal = Integer.valueOf(val);
            TreeNode node = new TreeNode(nodeVal);
            TreeNode left =  createTree(list);
            TreeNode right =  createTree(list);
            node.left = left;
            node.right = right;
            return node;
        }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
