package BackTracking;

/**
 * Created by yu7rin on 8/6/2018.
 *
 *
 * 经典的backtracking题目 先选择一个剩下的继续选 backtracking天然配合递归，对于for loop如何
 * 选择之前的element的方法是用list的contains的方式避免重复添加元素
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> chosen = new ArrayList();
        helper(result , chosen , nums);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> chosen, int[] nums) {
        if(chosen.size() == nums.length) {
            result.add(new ArrayList(chosen));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(chosen.contains(nums[i])) continue;
            chosen.add(nums[i]);
            helper(result , chosen , nums);
            chosen.remove(chosen.size() - 1);
        }

    }
}
