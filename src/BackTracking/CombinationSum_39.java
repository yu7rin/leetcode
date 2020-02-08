package BackTracking;

/**
 * Created by yu7rin on 8/6/2018.
 * 此题目是比较标准的backing Tracking 但是由于元素可以重复使用
 * 所以可以把i传到下一层的循环时不用加一
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        helper(nums, target, result, list, 0);
        return result;

    }
    public void helper(int[] nums, int target, List<List<Integer>> result, List<Integer> list, int i) {
        int sum = sum(list);
        if(sum == target) {
            result.add(new ArrayList(list));
            return;
        }
        if(sum > target) {
            return;
        }
        for(;i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, target, result, list, i);
            list.remove(list.size() - 1);
        }
    }
    public int sum(List<Integer> list) {
        int sum = 0;
        for(int a : list) {
            sum += a;
        }
        return sum;
    }
}
