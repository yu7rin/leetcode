package Tree;

/**
 * Created by yu7rin on 4/30/2018.
 */
public class UniqueBinarySearchTrees_96 {
    ////这是一道dp题目
    ////可由前向后推，前后有紧密联系并且问是否以及数量是大多为dp
    ////画图推到bst 前后关系
    ///推出公式f(n) = f（0）*f（n - 1） .....f(n - 1) *f(0);n
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        return count[n];
    }
}
