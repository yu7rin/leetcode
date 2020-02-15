package Tree;

/**
 * Created by yu7rin on 4/27/2018.
 */
public class PathSum2_113 {
    ///dfs的递归顺序一定要搞清楚了 不要混淆。
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        helper(root , sum, new ArrayList(), result);
        return result;

    }

    ////每次递归后回到上层都应该注意在参数中所传值的还原，以至于不影响下一次计算
    ////例如本题中的sum变量，最好不要直接赋值sum-= 而是通过修改该if的对比congdition和在传参时进行修正
    ////在if中的判断从 sum == 0 变成 sum == root.val,传参数sum进入下一递归时变为 sum - root.val
    ////注意像这种修改传入refrence类型时 加入result时一定要使用new OBJ！！！
    public void helper(TreeNode root ,  int sum ,ArrayList<Integer> list, List<List<Integer>> result) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) result.add(new ArrayList(list));
        helper(root.left , sum - root.val, list, result);
        helper(root.right , sum - root.val, list, result);
        list.remove(list.size() - 1);

    }
}
